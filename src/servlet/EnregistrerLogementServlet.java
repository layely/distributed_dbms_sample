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
import metier.Appartement;
import metier.Chambre;
import metier.Maison;

/**
 *
 * @author garmy
 */
public class EnregistrerLogementServlet extends HttpServlet {

    private AppartementDAO implAppartement;
    private MaisonDAO implMaison;
    private ChambreDAO implChambre;
    private ProprietaireDAO implProprietaire;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
        Chambre c;
        Appartement a;
        Maison m;
        int lastIdLogement = SingletonConnection.getIntValue(SingletonConnection.KEY_LAST_ID_LOGEMENT);
        response.getOutputStream().print("hello");
        return;
//        try {
//            if (request.getParameter("type").equals("maison")) {
//                m = new Maison();
//                m.setAddress("dakar");
//                m.setDateConstruction("22/12/1993");
//                m.setDescription(request.getParameter("desription"));
//                if (request.getParameter("ville").equals("dakar")) {
//                    m.setNumVille(1);
//                }
//                if (request.getParameter("ville").equals("thies")) {
//                    m.setNumVille(2);
//                }
//                m.setNombreBalcon(Integer.parseInt(request.getParameter("balcon")));
//                m.setNombreChambre(Integer.parseInt(request.getParameter("chambre")));
//                m.setNombreCuisine(Integer.parseInt(request.getParameter("cuisine")));
//                m.setNombreEtage(Integer.parseInt(request.getParameter("nombreEtage")));
//                m.setNombreParking(Integer.parseInt(request.getParameter("nombreParking")));
//                m.setNombreToilette(Integer.parseInt(request.getParameter("toilette")));
//                m.setNumLogement(lastIdLogement + 1);
//                m.setNumProprietaire(1);
//                m.setPrix(Integer.parseInt(request.getParameter("prix")));
//                m.setSurface(Integer.parseInt(request.getParameter("surface")));
//                implMaison.addMaison(m, request.getParameter("ville"));
//
//            }
//            if (request.getParameter("type").equals("appartement")) {
//                a = new Appartement();
//                a.setAddress("dakar");
//
//                a.setDescription(request.getParameter("desription"));
//                if (request.getParameter("ville").equals("dakar")) {
//                    a.setNumVille(1);
//                }
//                if (request.getParameter("ville").equals("thies")) {
//                    a.setNumVille(2);
//                }
//                a.setNombreBalcon(Integer.parseInt(request.getParameter("balcon")));
//                a.setNombreChambre(Integer.parseInt(request.getParameter("chambre")));
//                a.setNombreCuisine(Integer.parseInt(request.getParameter("cuisine")));
//                a.setEtage(Integer.parseInt(request.getParameter("numeroEtage")));
//                a.setNombreToilette(Integer.parseInt(request.getParameter("toilette")));
//                a.setNumLogement(lastIdLogement + 1);
//                a.setNumProprietaire(1);
//                a.setPrix(Integer.parseInt(request.getParameter("prix")));
//                a.setSurface(Integer.parseInt(request.getParameter("surface")));
//                implAppartement.addAppartement(a, request.getParameter("ville"));
//            }
//            if (request.getParameter("type").equals("chambre")) {
//                c = new Chambre();
//                c.setAddress("dakar");
//
//                c.setDescription(request.getParameter("desription"));
//                if (request.getParameter("ville").equals("dakar")) {
//                    c.setNumVille(1);
//                }
//                if (request.getParameter("ville").equals("thies")) {
//                    c.setNumVille(2);
//                }
//                c.setNombreBalcon(Integer.parseInt(request.getParameter("balcon")));
//
//                c.setNombreToilette(Integer.parseInt(request.getParameter("toilette")));
//                c.setNumLogement(lastIdLogement + 1);
//                c.setNumProprietaire(1);
//                c.setPrix(Integer.parseInt(request.getParameter("prix")));
//                c.setSurface(Integer.parseInt(request.getParameter("surface")));
//                implChambre.addChambre(c, request.getParameter("ville"));
//                request.getRequestDispatcher("ajout.jsp").forward(request,
//                        response);
//
//            }
//            request.getRequestDispatcher("ajout.jsp").forward(request,
//                    response);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

}
