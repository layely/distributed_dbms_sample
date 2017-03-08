/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import database.AppartementDAO;
import database.ChambreDAO;
import database.MaisonDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class Afficheservlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Afficheservlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Afficheservlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String action = request.getParameter("action");
        LogementModel model = new LogementModel();
        MaisonDAO implm = new MaisonDAO();
        AppartementDAO impla = new AppartementDAO();
        ChambreDAO implc = new ChambreDAO();

        request.setAttribute("model", model);

        if (action != null) {
            if (action.equals("maison")) {
                ArrayList<Maison> listm = implm.listMaisonD();
                model.setMaisons(listm);
            } else if (action.equals("appartement")) {
                ArrayList<Appartement> lisa = impla.listAppartementD();
                model.setAppartements(lisa);
            } else if (action.equals("chambre")) {
                ArrayList<Chambre> lista = implc.listChambreD();
                model.setChambres(lista);
            }/*else if (action.equals("tout")) {
                List<Logement> logement = impl.listlogements();
                model.setLogements(logement);
            }*/

        }
        request.getRequestDispatcher("index.jsp").forward(request,
                response);

    }
}
