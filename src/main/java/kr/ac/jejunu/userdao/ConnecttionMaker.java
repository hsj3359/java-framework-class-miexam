package kr.ac.jejunu.userdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 public interface ConnecttionMaker {

    public Connection getConnection() throws ClassNotFoundException, SQLException;
}