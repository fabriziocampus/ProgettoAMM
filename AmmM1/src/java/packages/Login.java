/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packages;

import amm.UtenteRegistrato;
import amm.UtenteRegistratoFactory;
import amm.Post;
import amm.PostFactory;
import amm.Gruppi;
import amm.GruppoFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Fabrizio
 */
@WebServlet(name = "Login", urlPatterns = {"/login.jsp"}, loadOnStartup = 0)
public class Login extends HttpServlet {

    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db-definition/ammdb";
    private static final String DB_BUILD_PATH = "WEB-INF/db-definition/ammdb";
    
       @Override
    public void init() {
        String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_BUILD_PATH;
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        //IMPOSTO LA CONNECTION STRING PER OGNI FACTORY
        UtenteRegistratoFactory.getInstance().setConnectionString(dbConnection);
        PostFactory.getInstance().setConnectionString(dbConnection);
        GruppoFactory.getInstance().setConnectionString(dbConnection);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        
         HttpSession session = request.getSession();
         
          if(request.getParameter("logout")!=null)
        {
            session.invalidate();
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
          if (session.getAttribute("loggedIn") != null &&
            session.getAttribute("loggedIn").equals(true)) {

            request.getRequestDispatcher("Bacheca").forward(request, response);
            return;
        
        } else {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
        
            
           
            if (username != null &&
                password != null) 
            {
                int loggedUserID = UtenteRegistratoFactory.getInstance().getIdByUserAndPassword(username, password);
                 UtenteRegistrato utente = UtenteRegistratoFactory.getInstance().getUtenteById(loggedUserID);
                
                if(loggedUserID!=-1)
                {
                    session.setAttribute("loggedIn", true);
                    session.setAttribute("loggedUserID", loggedUserID);
                    if(utente.getNome()!= null && utente.getCognome()!=null && utente.getData()!=null && utente.getEmail()!=null && utente.getFrase()!=null && utente.getUrlimg()!=null){
                         request.getRequestDispatcher("Bacheca").forward(request, response);
                         return;
                    }else{
                        request.getRequestDispatcher("Profilo").forward(request, response);
                        return;
                    }
                } else { 
                    request.setAttribute("invalidData", true);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    return;
                }
                
                
            }
        }
        
      
        request.getRequestDispatcher("login.jsp").forward(request, response);
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