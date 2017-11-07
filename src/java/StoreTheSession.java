/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(urlPatterns = {"/StoreTheSession"})
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
            database db = new database();
           if (request.getServletContext().getAttribute("sessionManegar") == null) {
               HttpSession session = request.getSession();
               ArrayList<user> users =  db.selectAll();
               for(int i=0; i<users.size();i++){
                   session.setAttribute("username", users.get(i).name);
                   session.setAttribute("email", users.get(i).mail);
                   session.setAttribute("phone", users.get(i).phone);
                   map.put(users.get(i).id, session);
               }
               request.getServletContext().setAttribute("sessionManegar", map);
               request.getServletContext().setAttribute("nextId" , map.size() );

           } else {
               map = ((HashMap<String, HttpSession>) request.getServletContext().getAttribute("sessionManegar"));
           }
           
            HttpSession newSession = request.getSession(true);
            newSession.setAttribute("username", request.getParameter("username"));
            newSession.setAttribute("email", request.getParameter("email"));
            newSession.setAttribute("phone", request.getParameter("phone"));
            
            request.setAttribute("username", request.getParameter("username"));
            request.setAttribute("email", request.getParameter("email"));
            request.setAttribute("phone", request.getParameter("phone"));
        
            String  nextId =  request.getServletContext().getAttribute("nextId").toString();
            map.put( nextId , newSession);
            Cookie cookie = new Cookie("sessionId", nextId);
            cookie.setMaxAge(3*60);
            response.addCookie(cookie);
            request.getServletContext().setAttribute("nextId", Integer.parseInt(nextId) + 1 );
            db.insert(nextId, newSession.getAttribute("username").toString(), 
            newSession.getAttribute("phone").toString(),
            newSession.getAttribute("email").toString());
            RequestDispatcher dis = request.getRequestDispatcher("welcome.jsp");
            dis.forward(request, response);
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
