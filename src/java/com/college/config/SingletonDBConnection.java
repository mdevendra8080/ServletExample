/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.college.config;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Devendra
 */
public class SingletonDBConnection {

    private static SingletonDBConnection singleInstance;
    private static DataSource dataSource;
    private static Connection dbConnect;

    private SingletonDBConnection() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/collegeDB");

            try {
                dbConnect = dataSource.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public static SingletonDBConnection getInstance() {
        if (singleInstance == null) {
            synchronized (SingletonDBConnection.class) {
                if (singleInstance == null) {
                    singleInstance = new SingletonDBConnection();
                }
            }
        }

        return singleInstance;
    }

    public static SingletonDBConnection getSingleInstance() {
        return singleInstance;
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static Connection getDbConnect() {
        return dbConnect;
    }
    
    
}
