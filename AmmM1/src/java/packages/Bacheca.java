
package packages;

/**
 *
 * @author Fabrizio
 */

import amm.UtenteRegistrato;
import amm.UtenteRegistratoFactory;
import amm.Post;
import amm.PostFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Bacheca extends HttpServlet{
    
      protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession(false);
        
        //se la sessione esiste ed esiste anche l'attributo loggedIn impostato a true
        if(session!=null && session.getAttribute("loggedIn")!=null && session.getAttribute("loggedIn").equals(true)){
        //Acquisizione utente di cui mostrare la bacheca da parametro get
        String user = request.getParameter("user");
        int userID;

        if(user != null){
            userID = Integer.parseInt(user);
        } else {
             Integer loggedUserID = (Integer)session.getAttribute("loggedUserID");
             userID = loggedUserID;
        }
        UtenteRegistrato utente = UtenteRegistratoFactory.getInstance().getUtenteById(userID);
        
        if(utente != null){
            //request.setAttribute("utente", utente);

            List<Post> posts = PostFactory.getInstance().getPostList(utente);
            request.setAttribute("posts", posts);
            
            request.getRequestDispatcher("bacheca.jsp").forward(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        }else{
            request.getRequestDispatcher("Login").forward(request, response);
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
