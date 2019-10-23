/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Journal;
import entity.People;
import entity.Subject;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
import util.EncriptPass;

/**
 *
 * @author pupil
 */
@WebServlet(name = "AdminServlet", urlPatterns = {
    "/AdminServlet",
    "/newSubject",
    "/StudentGradesAdmin",
    "/editPerson",
    "/changePerson",
    "/editSubject",
    "/changeSubject"
})
public class AdminServlet extends HttpServlet {
    @EJB SubjectFacade subjectFacade;
    @EJB PeopleFacade peopleFacade;
    @EJB JournalFacade journalFacade;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
        response.setContentType("text/html;charset=UTF-8");
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
        User user = (User) session.getAttribute("user");
        if(user.getPeople().getRole() == 0 || user.getPeople().getRole() == 1){
            request.setAttribute("info", "У вас нет прав доступа, войдите в систему");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return; 
        }
        String path = request.getServletPath();
        switch (path) {
            case "/newSubject":
                Integer hours = 0;
                String subjectName = request.getParameter("subjectName");
                
                 if (request.getParameter("subjectHours") != null) {
                    try
                    {
                        hours = Integer.parseInt(request.getParameter("subjectHours"));
                    }
                    catch (NumberFormatException nfe)
                    {
                        hours = 1;
                    }
                }
                Subject subject = new Subject(subjectName, hours);
                request.setAttribute("subject", subject);
                if(subject.getName()!= null){
                    subjectFacade.create(subject);
                }
                request.getRequestDispatcher("/WEB-INF/newSubject.jsp").forward(request, response);
                break;
            
            
                
            case "/editPerson":
                String personID = request.getParameter("id");
                People person = peopleFacade.find(Integer.parseInt(personID));
                request.setAttribute("person", person);
                request.getRequestDispatcher("/WEB-INF/editPerson.jsp").forward(request, response);
                break;
                
            case "/changePerson":
                personID = request.getParameter("id");
                String name = request.getParameter("name");
                String role = request.getParameter("role");
                person = peopleFacade.find(Integer.parseInt(personID));
                person.setName(name);
                person.setRole(Integer.parseInt(role));
                peopleFacade.edit(person);
                request.getRequestDispatcher("/WEB-INF/allPeople.jsp").forward(request, response);
                break;   
                
            case "/editSubject":
                String subjectID = request.getParameter("id");
                subject = subjectFacade.find(Integer.parseInt(subjectID));
                request.setAttribute("subject", subject);
                request.getRequestDispatcher("/WEB-INF/editSubject.jsp").forward(request, response);
                break;
                
            case "/changeSubject":
                String sid = request.getParameter("id");
                subject = subjectFacade.find(Integer.parseInt(sid));
                String sname = request.getParameter("name");
                String subhours = request.getParameter("hours");
                subject.setHours(Integer.parseInt(subhours));
                subject.setName(sname);
                subjectFacade.edit(subject);
                request.setAttribute("info", "Изменено.");
                request.getRequestDispatcher("/WEB-INF/allSubjects.jsp").forward(request, response);
                break;
            
            case "/StudentGradesAdmin":
                String stdid = request.getParameter("id");
                People std = peopleFacade.find(Integer.parseInt(stdid));
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
