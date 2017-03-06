package servlet;

import database.AppartementDAO;
import database.ChambreDAO;
import database.MaisonDAO;
import database.ProprietaireDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.Proprietaire;

public class ControleurServlet extends HttpServlet {

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

        if (action != null) {
            if (action.equals("Enregistrer")) {
                System.out.println("servlet.ControleurServlet.doPost()");
                try {
                    p.setNom(request.getParameter("nom"));
                    System.out.println(p.getMail());
                    p.setPrenom(request.getParameter("prenom"));
                    p.setAddress(request.getParameter("address"));
                    p.setMail(request.getParameter("mail"));
                    p.setTel(request.getParameter("telephone"));
                    p.setPassword(request.getParameter("password"));
                    p.setNumProprietaire(12);

                    implProprietaire.addProprietaire(p);

                } catch (Exception e) {
                    e.getMessage();
                }

            }

        }
        request.getRequestDispatcher("../index.jsp").forward(request,
                response);

    }
}
