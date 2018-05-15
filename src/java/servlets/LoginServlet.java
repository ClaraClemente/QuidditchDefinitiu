/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.QuidditchEJB;
import exceptions.QuidditchException;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JOSEP Mª
 */
public class LoginServlet extends HttpServlet {

    @EJB
    QuidditchEJB miEjb;

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

        String nombre = request.getParameter("nombre");
        String passwd = request.getParameter("passwd");

        try {
            miEjb.loginPlayer(nombre, passwd);
            request.getSession(true).setAttribute("user", nombre);

            response.sendRedirect(request.getContextPath() + "/menuJudgador.jsp");

        } catch (QuidditchException ex) {
            request.setAttribute("status", ex.getMessage());
            request.getRequestDispatcher("/final.jsp").forward(request, response);
        }

        // try {
        //if (tipoUser.equals("escuela")) {
        //   miEjb.loginSchool(nombre, passwd);
        //  } else if (tipoUser.equals("jugador")) {
        //  miEjb.loginPlayer(nombre, passwd);
        //  } else if (tipoUser.equals("entrenador")) {
        //      miEjb.loginCoach(nombre, passwd);
        // }
        // Si el alta ha ido bien devolvemos msg ok
        //   request.getSession(true).setAttribute("user", nombre);

        /*  if (tipoUser.equals("escuela")) {
                response.sendRedirect(request.getContextPath() + "/menuEscuela.jsp");
            } else if (tipoUser.equals("entrenador")) {
                response.sendRedirect(request.getContextPath() + "/menuEntrenador.jsp");
            } else if (tipoUser.equals("jugador")) {*/
        //        response.sendRedirect(request.getContextPath() + "/menuJugador.jsp");
        // }
        // } catch (QuidditchException ex) {
        // Devolvemos mensaje de la excepción a la vista
//            request.setAttribute("status", ex.getMessage());
//            // Redirigimos a la vista (final.jsp en este caso)
//            request.getRequestDispatcher("/final.jsp").forward(request, response);
//        }
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
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
