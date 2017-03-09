package servlet;

import database.AppartementDAO;
import database.ChambreDAO;
import database.MaisonDAO;
import database.ProprietaireDAO;
import database.SingletonConnection;
import distribution_management.TransactionInscriptionProprietaire;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import metier.Proprietaire;

public class EnregistrementProprietaireServlet extends HttpServlet {

    private AppartementDAO implAppartement;
    private MaisonDAO implMaison;
    private ChambreDAO implChambre;
    private ProprietaireDAO implProprietaire;

    public static final String ATT_PROPRIETAIRE = "proprietaire";

    @Override
    public void init() throws ServletException {
        implProprietaire = new ProprietaireDAO();
        implAppartement = new AppartementDAO();
        implMaison = new MaisonDAO();
        implChambre = new ChambreDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Proprietaire p = new Proprietaire();

        String action = request.getParameter("action");
        request.setAttribute("model", p);
        int lastIdProprietaire = SingletonConnection.getIntValue(SingletonConnection.KEY_LAST_ID_PROPRIETAIRE);

        if (action != null) {
            if (action.equals("Enregistrer")) {
                try {
                    p.setNom(request.getParameter("nom"));
                    p.setPrenom(request.getParameter("prenom"));
                    p.setAddress(request.getParameter("address"));
                    p.setMail(request.getParameter("mail"));
                    p.setTel(request.getParameter("telephone"));
                    p.setPassword(request.getParameter("password"));
                    p.setNumProprietaire(lastIdProprietaire + 1);

                    TransactionInscriptionProprietaire transac = new TransactionInscriptionProprietaire(p);
                    transac.run();

                    HttpSession session = request.getSession();
                    session.setAttribute("proprietaire", p);
                    SingletonConnection.setValue(SingletonConnection.KEY_LAST_ID_PROPRIETAIRE, String.valueOf(lastIdProprietaire + 1));

                } catch (Exception e) {
                    e.printStackTrace();
                }
                request.getRequestDispatcher("jsp/ajout.jsp").forward(request,
                        response);
            }
            if (action.equals("Connection")) {
                try {
                    String email = request.getParameter("email_authentification");
                    String password = request.getParameter("password_authentification");

                    Proprietaire prop = implProprietaire.getProprietaire(email, password);
                    HttpSession session = request.getSession();
                    session.setAttribute("proprietaire", prop);

                    if (prop != null) {
//                        request.getRequestDispatcher("jsp/ajout.jsp").forward(request,
//                                response);
                        response.sendRedirect("jsp/ajout.jsp");
                    } else {
                        request.getRequestDispatcher("jsp/connection.jsp").forward(request,
                                response);
                    }

                } catch (Exception e) {
                    e.getMessage();
                }

            }

        }

    }
}
