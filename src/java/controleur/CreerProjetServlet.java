/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Projet;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author CHAFFORT
 */
@WebServlet(name = "CreerProjetServlet", urlPatterns = {"/creerProjet"})
public class CreerProjetServlet extends HttpServlet {

    private EntityManager em;
    /*
    public CreerProjetServlet(){
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("Projet_Collaboratif");
		em = factory.createEntityManager();
    }*/
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
        request.getRequestDispatcher("WEB-INF/creerProjet.jsp").forward(request, response);
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
        String titre = request.getParameter("titre");
        String sujet = request.getParameter("sujet");
        String id_session = request.getParameter("id_session");
        String date_limite_rendu = request.getParameter("date_limite_rendu");
        try {
            //System.out.println("id promo : " + idPromotion);
            if (isEmpty(titre) || isEmpty(sujet) || isEmpty(id_session) || isEmpty(date_limite_rendu)) {
                
                    request.setAttribute("titreMsg", "Le titre est obligatoire");
                    request.getRequestDispatcher("WEB-INF/creerProjet.jsp").forward(request, response);
                
            } else {
                System.out.println("dans else");
                SimpleDateFormat df = new SimpleDateFormat("dd-mm-yyyy");
                Date dateLimite = df.parse(date_limite_rendu);
                Projet projet = new Projet(titre, sujet, new Date(), dateLimite);
                em.getTransaction().begin();
                em.persist(projet);
                em.getTransaction().commit();
                System.out.println("inséré");
                response.sendRedirect("WEB-INF/espacePersonnel.jsp");
            }
        } catch (ParseException | PersistenceException ex) {
            ex.printStackTrace();
            Logger.getLogger(CreerProjetServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("msg", ex.getMessage());
            request.getRequestDispatcher("WEB-INF/creerProjet.jsp").forward(request, response);
        }
    }
    
    public boolean isEmpty(String value) {
        return value == null || value.matches("^ *$");
    }
}
