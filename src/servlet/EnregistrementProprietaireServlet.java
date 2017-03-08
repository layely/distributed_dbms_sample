package servlet;

import database.AppartementDAO;
import database.ChambreDAO;
import database.MaisonDAO;
import database.ProprietaireDAO;
import database.SingletonConnection;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.Proprietaire;

public class EnregistrementProprietaireServlet extends HttpServlet {

    private AppartementDAO implAppartement;
    private MaisonDAO implMaison;
    private ChambreDAO implChambre;
    private ProprietaireDAO implProprietaire;

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

                    implProprietaire.addProprietaire("dakar", p);
                    implProprietaire.addProprietaire("thies", p);

                    SingletonConnection.setValue(String.valueOf(lastIdProprietaire + 1));

                } catch (Exception e) {
                    e.printStackTrace();
                }
                request.getRequestDispatcher("ajout.jsp").forward(request,
                        response);
            }
            if (action.equals("Connection")) {
                try {
                    int nombre = 0;
                    ArrayList<Proprietaire> list = new ProprietaireDAO().getProprietaire();
                    for (int i = 0; i < list.size(); i++) {
                        if (request.getParameter("email_authentification") == list.get(0).getMail() && request.getParameter("password_authentification") == list.get(0).getPassword()) {
                            nombre = 1;
                        }
                    }
                    if (nombre == 1) {
                        request.getRequestDispatcher("ajout.jsp").forward(request,
                                response);
                    } else {
                        request.getRequestDispatcher("connection.jsp").forward(request,
                                response);
                    }

                } catch (Exception e) {
                    e.getMessage();
                }

            }

        }

    }
}
