/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Journal;
import entity.People;
import entity.Subject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.JournalFacade;
import session.PeopleFacade;
import session.SubjectFacade;

/**
 *
 * @author pupil
 */
@WebServlet(name = "SchoolServlet", urlPatterns = {
    "/SchoolServlet",
    "/newPeople",
    "/teacher",
    "/student",
    "/subject",
    "/newSubject",
    "/newJournal"
    //"/",
})
public class SchoolServlet extends HttpServlet {
    @EJB SubjectFacade subjectFacade;
    @EJB PeopleFacade peopleFacade;
    @EJB JournalFacade journalFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String path = request.getServletPath();
        switch (path) {
            
            case "/newPeople":
                if(request.getParameter("role") != null & request.getParameter("peopleName") != null){
                    String name = request.getParameter("peopleName");
                    Integer role = Integer.parseInt(request.getParameter("role"));
                    People people = new People(role, name);
                    peopleFacade.create(people);
                    request.setAttribute("people", people);
                }
                request.getRequestDispatcher("/WEB-INF/newPeople.jsp").forward(request, response);
                break;
                
            case "/teacher":
                request.getRequestDispatcher("/WEB-INF/teacher.jsp").forward(request, response);
                break;
                
            case "/student":
                request.getRequestDispatcher("/WEB-INF/student.jsp").forward(request, response);
                break;
                
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
                subjectFacade.create(subject);
                request.getRequestDispatcher("/WEB-INF/newSubject.jsp").forward(request, response);
                break;
                
            case "/newJournal":
                List<Subject> listSubjects = subjectFacade.findAll();
                
                List<People> listStudents = new ArrayList<People>();
                for(People i : peopleFacade.findAll()){
                   if(i.getRole() == 0){
                       listStudents.add(i);
                   }
                }
                List<People> listTeachers = new ArrayList<People>();
                for(People i : peopleFacade.findAll()){
                   if(i.getRole() == 1){
                       listTeachers.add(i);
                   }
                }
                
                Date date = new Date();
                String gradeid = request.getParameter("grade");

                String teacherid = request.getParameter("teacher");
                String studentid = request.getParameter("student");
                String subjectid = request.getParameter("subject");
                if(!teacherid.isEmpty() & !studentid.isEmpty() & !subjectid.isEmpty()){
                    People teacherj = peopleFacade.find(Integer.parseInt("teacherid"));
                    Subject subjectj = subjectFacade.find(Integer.parseInt("subjectid"));
                    People studentj = peopleFacade.find(Integer.parseInt("studentid"));
                    Journal journal = new Journal(subjectj, studentj, gradeid, teacherj, date);

                    request.setAttribute("journal", journal);
                    request.setAttribute("listTeachers", listTeachers);
                    request.setAttribute("listStudents", listStudents);
                    request.setAttribute("listSubjects", listSubjects);

                    journalFacade.create(journal);
                }
                request.getRequestDispatcher("/WEB-INF/newJournal.jsp").forward(request, response);
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
