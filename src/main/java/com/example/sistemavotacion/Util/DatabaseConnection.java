package com.example.sistemavotacion.Util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection databaseLink;

    public static Connection getConnection() {
        String databaseName="bc2hky8dpornvthdni1y";
        String databaseUser="upgfp6ned3m77ha4";
        String databasePassword="TdAsLKdnXx0XEHNwKFCB";
        String url="jdbc:mysql://bc2hky8dpornvthdni1y-mysql.services.clever-cloud.com/"+databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink=DriverManager.getConnection(url,databaseUser,databasePassword);
        }catch (Exception e){
            e.printStackTrace();
        }
        return databaseLink;
    }
}



