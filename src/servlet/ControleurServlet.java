package servlet;

import database.AppartementDAO;
import database.ChambreDAO;
import database.MaisonDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.Logement;

public class ControleurServlet extends HttpServlet {

    private AppartementDAO implAppartement;
    private MaisonDAO implMaison;
    private ChambreDAO implChambre;

    @Override
    public void init() throws ServletException {
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
        LogementModel model = new LogementModel();

        String action = request.getParameter("action");
        request.setAttribute("model", model);

        if (action != null) {
            if (action.equals("batiment")) {
                List<Logement> lBatiment = impl.listBatiments();
                model.setLogements(lBatiment);
            } else if (action.equals("appartement")) {
                List<Logement> lAppartement = impl.listAppartement();
                model.setLogements(lAppartement);
            } else if (action.equals("tout")) {
                List<Logement> logement = impl.listlogements();
                model.setLogements(logement);
            } else if (action.equals("Enregistrer")) {
                try {
                    model.getLogement().setType(
                            request.getParameter("type"));
                    model.getLogement().setPrix(
                            Integer.parseInt(request.getParameter("prix")));
                    model.getLogement().setNombreSalon(
                            Integer.parseInt(request.getParameter("salon")));
                    model.getLogement().setNombreChambre(
                            Integer.parseInt(request.getParameter("chambre")));
                    model.getLogement().setNombreBain(
                            Integer.parseInt(request.getParameter("bain")));
                    model.getLogement().setLatitude(
                            request.getParameter("latitude"));
                    model.getLogement().setLongitude(
                            request.getParameter("longitude"));

                    impl.addLogement(model.getLogement());

                    model.setLogements(impl.listlogements());
                } catch (Exception e) {
                    model.setErrors(e.getMessage());
                }

            }

        }
        request.getRequestDispatcher("index.jsp").forward(request,
                response);

    }
}
