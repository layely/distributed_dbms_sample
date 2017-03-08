package servlet;

import database.AppartementDAO;
import database.ChambreDAO;
import database.IdLogement;
import database.MaisonDAO;
import database.ProprietaireDAO;
import database.SingletonConnection;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.Appartement;
import metier.Chambre;
import metier.Maison;
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
        Chambre c;
        Appartement a;
        Maison m;

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

                    SingletonConnection.setValue(String.valueOf(lastIdProprietaire));

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
            if (action.equals("ajoutLogement")) {
                try {
                    if (request.getParameter("type").equals("maison")) {
                        m = new Maison();
                        m.setAddress("dakar");
                        m.setDateConstruction("22/12/1993");
                        m.setDescription(request.getParameter("desription"));
                        if (request.getParameter("ville").equals("dakar")) {
                            m.setNumVille(1);
                        }
                        if (request.getParameter("ville").equals("thies")) {
                            m.setNumVille(2);
                        }
                        m.setNombreBalcon(Integer.parseInt(request.getParameter("balcon")));
                        m.setNombreChambre(Integer.parseInt(request.getParameter("chambre")));
                        m.setNombreCuisine(Integer.parseInt(request.getParameter("cuisine")));
                        m.setNombreEtage(Integer.parseInt(request.getParameter("nombreEtage")));
                        m.setNombreParking(Integer.parseInt(request.getParameter("nombreParking")));
                        m.setNombreToilette(Integer.parseInt(request.getParameter("toilette")));
                        m.setNumLogement(new IdLogement().getId());
                        m.setNumProprietaire(1);
                        m.setPrix(Integer.parseInt(request.getParameter("prix")));
                        m.setSurface(Integer.parseInt(request.getParameter("surface")));
                        implMaison.addMaison(m, request.getParameter("ville"));

                    }
                    if (request.getParameter("type").equals("appartement")) {
                        a = new Appartement();
                        a.setAddress("dakar");

                        a.setDescription(request.getParameter("desription"));
                        if (request.getParameter("ville").equals("dakar")) {
                            a.setNumVille(1);
                        }
                        if (request.getParameter("ville").equals("thies")) {
                            a.setNumVille(2);
                        }
                        a.setNombreBalcon(Integer.parseInt(request.getParameter("balcon")));
                        a.setNombreChambre(Integer.parseInt(request.getParameter("chambre")));
                        a.setNombreCuisine(Integer.parseInt(request.getParameter("cuisine")));
                        a.setEtage(Integer.parseInt(request.getParameter("numeroEtage")));
                        a.setNombreToilette(Integer.parseInt(request.getParameter("toilette")));
                        a.setNumLogement(new IdLogement().getId());
                        a.setNumProprietaire(1);
                        a.setPrix(Integer.parseInt(request.getParameter("prix")));
                        a.setSurface(Integer.parseInt(request.getParameter("surface")));
                        implAppartement.addAppartement(a, request.getParameter("ville"));
                    }
                    if (request.getParameter("type").equals("chambre")) {
                        c = new Chambre();
                        c.setAddress("dakar");

                        c.setDescription(request.getParameter("desription"));
                        if (request.getParameter("ville").equals("dakar")) {
                            c.setNumVille(1);
                        }
                        if (request.getParameter("ville").equals("thies")) {
                            c.setNumVille(2);
                        }
                        c.setNombreBalcon(Integer.parseInt(request.getParameter("balcon")));

                        c.setNombreToilette(Integer.parseInt(request.getParameter("toilette")));
                        c.setNumLogement(new IdLogement().getId());
                        c.setNumProprietaire(1);
                        c.setPrix(Integer.parseInt(request.getParameter("prix")));
                        c.setSurface(Integer.parseInt(request.getParameter("surface")));
                        implChambre.addChambre(c, request.getParameter("ville"));
                        request.getRequestDispatcher("ajout.jsp").forward(request,
                                response);

                    }
                    request.getRequestDispatcher("ajout.jsp").forward(request,
                            response);

                } catch (Exception e) {
                    e.getMessage();
                }

            }

        }

    }
}
