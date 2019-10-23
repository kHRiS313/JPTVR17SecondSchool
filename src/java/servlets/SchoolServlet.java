///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package servlets;
//
//import entity.Journal;
//import entity.People;
//import entity.Subject;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import javax.ejb.EJB;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import session.JournalFacade;
//import session.PeopleFacade;
//import session.SubjectFacade;
//
///**
// *
// * @author pupil
// */
//@WebServlet(name = "SchoolServlet", urlPatterns = {
////    "/SchoolServlet",
////    "/teacher",
////    "/student",
////    "/subject",
////    "/newSubject",
////    "/newJournal",
////    "/allSubjects",
////    "/allGrades",
////    "/allPeople",
////    "/editSubject",
////    "/changeSubject",
////    "/changeJournal",
////    "/changePerson",
////    "/editGrade",
////    "/editPerson",
////    "/SubjectGrades",
////    "/StudentGrades"
//    //"/",
//})
//public class SchoolServlet extends HttpServlet {
//    @EJB SubjectFacade subjectFacade;
//    @EJB PeopleFacade peopleFacade;
//    @EJB JournalFacade journalFacade;
//    
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        String path = request.getServletPath();
//        switch (path) {
//               
//                
//            case "/newJournal":
//                
//                List<Subject> listSubjects = subjectFacade.findAll();
//                
//                List<People> listStudents = new ArrayList<People>();
//                for(People i : peopleFacade.findAll()){
//                   if(i.getRole() == 0){
//                       listStudents.add(i);
//                   }
//                }
//                List<People> listTeachers = new ArrayList<People>();
//                for(People i : peopleFacade.findAll()){
//                   if(i.getRole() == 1){
//                       listTeachers.add(i);
//                   }
//                }
//                
//                System.out.println(listStudents);
//                System.out.println(listSubjects);
//                System.out.println(listTeachers);
//                request.setAttribute("listTeachers", listTeachers);
//                request.setAttribute("listStudents", listStudents);
//                request.setAttribute("listSubjects", listSubjects);
//                try{
//                    Date date = new Date();
//                    
//                    String gradeid = request.getParameter("grade");
//                    String teacherid = request.getParameter("teacher");
//                    String studentid = request.getParameter("student");
//                    String subjectid = request.getParameter("subject");
//                    System.out.println("Parametres: gid:" + gradeid + " tid:" + teacherid + " studid:" + studentid + " subid:" + subjectid);
//                    People teacherj = peopleFacade.find(Integer.parseInt(teacherid));
//                    Subject subjectj = subjectFacade.find(Integer.parseInt(subjectid));
//                    People studentj = peopleFacade.find(Integer.parseInt(studentid));
//                    
//                    System.out.println("Names: " + teacherj.getName() + " " + studentj.getName() + " " + subjectj.getName());
//                    
//                    Journal journal = new Journal(subjectj, studentj, gradeid, teacherj, date);
//                    System.out.println(journal.toString());
//                    request.setAttribute("journal", journal);
//                    journalFacade.create(journal);
//
//                }
//                catch(Exception e){
//                    System.out.println("error "+ e);
//                }
//                request.getRequestDispatcher("/WEB-INF/newJournal.jsp").forward(request, response);
//                break;
//                
//                
//            case "/editGrade":
//                
//                listSubjects = subjectFacade.findAll();
//                
//                listStudents = new ArrayList<People>();
//                for(People i : peopleFacade.findAll()){
//                   if(i.getRole() == 0){
//                       listStudents.add(i);
//                   }
//                }
//                listTeachers = new ArrayList<People>();
//                for(People i : peopleFacade.findAll()){
//                   if(i.getRole() == 1){
//                       listTeachers.add(i);
//                   }
//                }
//                
//                System.out.println(listStudents);
//                System.out.println(listSubjects);
//                System.out.println(listTeachers);
//                
//                request.setAttribute("listTeachers", listTeachers);
//                request.setAttribute("listStudents", listStudents);
//                request.setAttribute("listSubjects", listSubjects);
//                
//                String JournalID = request.getParameter("id");
//                Journal journal = journalFacade.find(Integer.parseInt(JournalID));
//                request.setAttribute("journal", journal);
//                request.getRequestDispatcher("/WEB-INF/editGrade.jsp").forward(request, response);
//                break;
//                
//            case "/changeJournal":
//                Date jdate = new Date();
//                String id = request.getParameter("id");
//                String jgrade = request.getParameter("grade");
//                String jstudent = request.getParameter("student");
//                String jteacher = request.getParameter("teacher");
//                String jsubject = request.getParameter("subject");
//                journal = journalFacade.find(Integer.parseInt(id));
//                journal.setDate(jdate);
//                journal.setGrade(jgrade);
//                journal.setStudent(peopleFacade.find(Integer.parseInt(jstudent)));
//                journal.setTeacher(peopleFacade.find(Integer.parseInt(jteacher)));
//                journal.setSubject(subjectFacade.find(Integer.parseInt(jsubject))   );
//                journalFacade.edit(journal);
//                request.getRequestDispatcher("/WEB-INF/allGrades.jsp").forward(request, response);
//                break;
//                
//                
//                
//        }
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
