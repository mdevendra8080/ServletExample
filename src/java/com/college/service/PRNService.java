/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.college.service;

import com.college.dao.PRNDao;
import com.college.entity.StudentDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Devendra
 */
public class PRNService {

    private PRNDao prnDao;

    public PRNService() {
        // Initialize the dao
        prnDao = new PRNDao();
    }

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void findPRNByID(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String prnNo = request.getParameter("prnNo");

            List<StudentDetails> list = prnDao.findPRNByID(prnNo);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
            //request
            if (list.isEmpty()) {
                request.setAttribute("message", "PRN No.&nbsp;" + prnNo + "&nbsp;does not exist!");
            }
            request.setAttribute("list", list);
            request.setAttribute("prnNo", prnNo);
            requestDispatcher.forward(request, response);


        } finally {
        }
    }
}
