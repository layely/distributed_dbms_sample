/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import database.AppartementDAO;
import database.ChambreDAO;
import database.MaisonDAO;
import database.ProprietaireDAO;
import database.SingletonConnection;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import metier.Appartement;
import metier.Chambre;
import metier.Maison;
import metier.Proprietaire;

/**
 *
 * @author garmy
 */
public class EnregistrerLogementServlet extends HttpServlet {

    private AppartementDAO implAppartement;
    private MaisonDAO implMaison;
    private ChambreDAO implChambre;
    private ProprietaireDAO implProprietaire;

    public EnregistrerLogementServlet() {
        implAppartement = new AppartementDAO();
        implMaison = new MaisonDAO();
        implChambre = new ChambreDAO();
        implProprietaire = new ProprietaireDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Chambre c;
        Appartement a;
        Maison m;
        int lastIdLogement = SingletonConnection.getIntValue(SingletonConnection.KEY_LAST_ID_LOGEMENT);
//        response.getOutputStream().println("IN the doPost");
        log("in the doPost of EnregLogement ...... ");
        try {
            if (request.getParameter("type").equals("maison")) {
                m = new Maison();
                m.setAddress("dakar");
                m.setDateConstruction("22/12/1993");
                m.setDescription(request.getParameter("desription"));
                if (request.getParameter("ville").equals("dakar")) {
                    m.setNomVille("DAKAR");
                }
                if (request.getParameter("ville").equals("thies")) {
                    m.setNomVille("THIES");
                }
                m.setNombreBalcon(Integer.parseInt(request.getParameter("balcon")));
                m.setNombreChambre(Integer.parseInt(request.getParameter("chambre")));
                m.setNombreCuisine(Integer.parseInt(request.getParameter("cuisine")));
                m.setNombreEtage(Integer.parseInt(request.getParameter("nombreEtage")));
                m.setNombreParking(Integer.parseInt(request.getParameter("nombreParking")));
                m.setNombreToilette(Integer.parseInt(request.getParameter("toilette")));
                m.setNumLogement(lastIdLogement + 1);
                m.setNumProprietaire(1);
                m.setPrix(Integer.parseInt(request.getParameter("prix")));
                m.setSurface(Integer.parseInt(request.getParameter("surface")));
                implMaison.addMaison(m, request.getParameter("ville"));

            }
            if (request.getParameter("type").equals("appartement")) {
                a = new Appartement();
                a.setAddress(request.getParameter("ville"));

                a.setDescription(request.getParameter("desription"));
                if (request.getParameter("ville").equals("dakar")) {
                    a.setNomVille("DAKAR");
                }
                if (request.getParameter("ville").equals("thies")) {
                    a.setNomVille("THIES");
                }
                a.setNombreBalcon(Integer.parseInt(request.getParameter("balcon")));
                a.setNombreChambre(Integer.parseInt(request.getParameter("chambre")));
                a.setNombreCuisine(Integer.parseInt(request.getParameter("cuisine")));
                a.setEtage(Integer.parseInt(request.getParameter("numeroEtage")));
                a.setNombreToilette(Integer.parseInt(request.getParameter("toilette")));
                a.setNumLogement(lastIdLogement + 1);
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
                    c.setNomVille("DAKAR");
                }
                if (request.getParameter("ville").equals("thies")) {
                    c.setNomVille("DAKAR");
                }
                c.setNombreBalcon(Integer.parseInt(request.getParameter("balcon")));

                c.setNombreToilette(Integer.parseInt(request.getParameter("toilette")));
                c.setNumLogement(lastIdLogement + 1);
                HttpSession session = request.getSession(false);
                Proprietaire p = (Proprietaire) session.getAttribute("proprietaire");
                c.setNumProprietaire(p.getNumProprietaire());
                c.setPrix(Integer.parseInt(request.getParameter("prix")));
                c.setSurface(Integer.parseInt(request.getParameter("surface")));
                implChambre.addChambre(c, request.getParameter("ville"));
//                request.getRequestDispatcher("ajout.jsp").forward(request,
//                        response);

            }

            SingletonConnection.setValue(SingletonConnection.KEY_LAST_ID_LOGEMENT, lastIdLogement + 1 + "");
            request.getRequestDispatcher("/jsp/ajout.jsp").forward(request,
                    response);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getOutputStream().print("hello");
    }

}
