/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.college.dao;

import com.college.config.SingletonDBConnection;
import com.college.entity.StudentDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author Devendra
 */
public class PRNDao {

    private DataSource dataSource;

    public PRNDao() {
        dataSource = SingletonDBConnection.getInstance().getDataSource();
    }

    public List findPRNByID(String prnNo) {
        List<StudentDetails> list = new ArrayList();
        try {
            String query = "SELECT PRN_NO, ROLL_NO, EXAM_YEAR, EXAM_RESULT FROM STUDENT WHERE PRN_NO like ?";
            Connection conn = dataSource.getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, "%"+prnNo+"%");
            ResultSet resultSet = statement.executeQuery();

            list = studentResultRowMapper(resultSet);
            
        } catch (SQLException ex) {
            Logger.getLogger(PRNDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }

        return list;
    }

    private List<StudentDetails> studentResultRowMapper(ResultSet result) {

        List<StudentDetails> list = new ArrayList();
        try {
            while (result.next()) {
                StudentDetails student = new StudentDetails();

                student.setPrnNo(result.getString(1));
                student.setRollNo(result.getString(2));
                student.setPassYear(result.getString(3));
                student.setResult(result.getString(4));
                
                list.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PRNDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
