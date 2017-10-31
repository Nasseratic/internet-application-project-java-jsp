/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
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
@WebServlet(urlPatterns = {"/auth"})
public class auth extends HttpServlet {

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
        HashMap<String, HttpSession> map;
        HttpSession currSession = request.getSession();

        String sessionId = searchSession(request.getCookies());
        System.out.println(sessionId);
        map = new HashMap<>();

        if (request.getServletContext().getAttribute("sessionManegar") == null) {
            currSession = request.getSession();
            map.put("5" , currSession);
            request.getServletContext().setAttribute("sessionManegar", map);
        } else {
            currSession = ((HashMap<String, HttpSession>) request.getServletContext().getAttribute("sessionManegar")).get(sessionId);
        }
        System.out.println( currSession + "   -----   " +  sessionId);
        if (sessionId != null && currSession.getAttribute(sessionId) != null) {
            
            System.out.println("NICE");
            System.out.println(  currSession.getAttribute(sessionId));
        } else {
            System.out.println("OHHH");
            int length = 10;
            boolean useLetters = true;
            boolean useNumbers = false;
            response.addCookie(new Cookie("sessionId", "5" ));
            request.getSession().setAttribute("userNme", "Mohamed");
            currSession.setAttribute(sessionId, "Mohamed" );
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

    public String searchSession(Cookie cookies[]) {
        Cookie cookie;
        if (cookies != null) {
            System.out.println("fe cook");
            for (Cookie cookie1 : cookies) {
                cookie = cookie1;
                String cookieName = cookie.getName();
                String cookieValue = cookie.getValue();
                if (cookieName.equals("sessionId")) {
                    return cookieValue;
                }
            }
        }
        return null;
    }

}
