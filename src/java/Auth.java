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
@WebServlet(urlPatterns = {"/auth"})
public class Auth extends HttpServlet {
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
        HashMap<String, HttpSession> map;
        HttpSession currSession = request.getSession();

        String sessionId = searchSession(request.getCookies());
        map = new HashMap<>();
        if (request.getServletContext().getAttribute("sessionManegar") == null) {
            // TODO go get it from the DB
            request.getServletContext().setAttribute("sessionManegar", map);
            request.getServletContext().setAttribute("nextId" , map.size() );
        } else {
            map = ((HashMap<String, HttpSession>) request.getServletContext().getAttribute("sessionManegar"));
            currSession = map.get(sessionId);
        }

        RequestDispatcher dis = request.getRequestDispatcher("sign.jsp");
        if (sessionId != null && map.get(sessionId) != null) {
            dis = request.getRequestDispatcher("welcome.jsp");
            System.out.println("WELCOME BACK USER");
            dis.forward(request, response);
        }else if (sessionId != null){
            eraseCookie("sessionId" , "/");
            System.out.println("GET OUT");
            dis.forward(request, response);

        }else{
            dis.forward(request, response);  
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
public static Cookie eraseCookie(String strCookieName, String strPath) {
        Cookie cookie = new Cookie(strCookieName, "");
        cookie.setMaxAge(0);
        cookie.setPath(strPath);

        return cookie;
    }

}
