/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LENOVO
 */
@WebServlet(urlPatterns = {"/signUser"})
public class StoreTheSession extends HttpServlet {

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
            HashMap<String, HttpSession> map = new HashMap<>();

           if (request.getServletContext().getAttribute("sessionManegar") == null) {
               // TODO go get it from the DB
               request.getServletContext().setAttribute("sessionManegar", map);
               request.getServletContext().setAttribute("nextId" , 0);
           } else {
               map = ((HashMap<String, HttpSession>) request.getServletContext().getAttribute("sessionManegar"));
           }
           
            HttpSession newSession = request.getSession(true);
            newSession = request.getSession();
            RequestDispatcher dis = request.getRequestDispatcher("sign.jsp");

            
            /*
            if ( no validation errors ) {
                dis = request.getRequestDispatcher("welcome.jsp");
                dis.forward(request, response);
            */
            
                String  nextId;
                nextId = request.getServletContext().getAttribute("nextId").toString();
                map.put( nextId , newSession);
                response.addCookie(new Cookie("sessionId", nextId ));
                request.getServletContext().setAttribute("nextId", Integer.parseInt(nextId) + 1 );
            // TODO insert the values to the database

            /*
            }else{
                dis.forward(request, response);
                dis = request.getRequestDispatcher("sign.jsp");
            }
            
            
            */
           
           
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
