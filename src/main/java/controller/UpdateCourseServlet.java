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

public class UpdateCourseServlet extends HttpServlet {

    private CourseDAO courseDAO;

    @Override
    public void init() {
        courseDAO = new CourseDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        Course updatedCourse = new Course();
        updatedCourse.setId(id);
        updatedCourse.setTitle(title);
        updatedCourse.setDescription(description);

        courseDAO.updateCourse(updatedCourse);

        response.sendRedirect("CourseServlet"); // Back to list
    }
}
