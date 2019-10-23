/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Journal;
import entity.People;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.JournalFacade;
import session.PeopleFacade;
import session.SubjectFacade;

/**
 *
 * @author pupil
 */
@WebServlet(name = "StudentController", urlPatterns = {
    "/StudentController",
    "/StudentGrades"
})
public class StudentController extends HttpServlet {

    @EJB
    SubjectFacade subjectFacade;
    @EJB
    PeopleFacade peopleFacade;
    @EJB
    JournalFacade journalFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String path = request.getServletPath();
        HttpSession session = request.getSession(false);
        if (null == session){
            request.setAttribute("info", "У вас нет прав доступа, войдите в систему");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;   
            }
            if(null == session.getAttribute("user")){
                request.setAttribute("info", "У вас нет прав доступа, войдите в систему");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                return; 
            }
        switch (path) {
            
            case "/StudentGrades":
                User user = (User) session.getAttribute("user");
                int stdid = user.getPeople().getId();
                People std = peopleFacade.find(stdid);
                ArrayList<Journal> listJournals = new ArrayList<Journal>();
                for (Journal i : journalFacade.findAll()) {
                    if (i.getStudent().equals(std)) {
                        listJournals.add(i);
                    }
                }
                request.setAttribute("listJournals", listJournals);
                request.getRequestDispatcher("/WEB-INF/StudentGrades.jsp").forward(request, response);
                break;
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
