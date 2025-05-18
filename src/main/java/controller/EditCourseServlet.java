/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.CourseDAO;
import model.Course;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 *
 * @author fakhr
 */

public class EditCourseServlet extends HttpServlet {

    private CourseDAO courseDAO;

    @Override
    public void init() {
        courseDAO = new CourseDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Course course = courseDAO.getCourseById(id);

            if (course != null) {
                request.setAttribute("course", course);
                RequestDispatcher dispatcher = request.getRequestDispatcher("edit-course.jsp");
                dispatcher.forward(request, response);
            } else {
                response.sendRedirect("CourseServlet?error=notfound");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("CourseServlet?error=invalidid");
        }
    }
}
