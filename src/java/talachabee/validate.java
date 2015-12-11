/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talachabee;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import java.util.UUID;
import util.sqlSelect;


/**
 *
 * @author ayarochkin
 */
public class validate extends HttpServlet {

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
        
        
//        if (request.getSession(false).getAttribute("authUser") != null)
//        {
//            RequestDispatcher rd = request.getRequestDispatcher("start");
//            rd.forward(request, response);
//        }
        if (request.getParameter("user") == null )
        {
            RequestDispatcher rd = request.getRequestDispatcher("/index.html");
            rd.forward(request, response);
        }

        
        try (PrintWriter out = response.getWriter()) {
            /* Get User and Pass from post */
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
//////////////////////////////////////
// AUTH and ASSIGN session Attribute
//////////////////////////////////////
            int hash;
              HttpSession session = request.getSession();
              sqlSelect myselect = new sqlSelect();
              String sqlPassword = myselect.obtainPassword(user);
              
              
              if (pass.equals(sqlPassword)) {

                session.setMaxInactiveInterval (30 * 60);
                Cookie userName = new Cookie ("user", user);
                userName.setMaxAge (30* 60);
                UUID myUuid = UUID.randomUUID();
                Cookie userUuid = new Cookie ("userUuid", String.valueOf(myUuid));
                response.addCookie(userName);
                response.addCookie(userUuid);
                session.setAttribute("user", user);
                session.setAttribute("userUuid", String.valueOf(myUuid));
                session.setAttribute("companyId", 1);
                
                response.sendRedirect("core/main.jsp");
                
            }
            else {
                session.setAttribute("attempted", "retry");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
            

            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet validate</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet validate at " + session.getAttribute("id") + "</h1>");
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
