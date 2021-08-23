package com.theopentutorials.jdbc.main;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.theopentutorials.jdbc.db.JDBCMySQLConnection;

 
public class JDBCMySQLDemo {
    public static void main(String[] args) throws IOException {        

         
     
        try {
            
            JDBCMySQLDemo demo = new JDBCMySQLDemo();
       
                      
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }    
        
        ResultSet rs = null;
        Connection connection = null;
        Statement statement = null; 
         
    
        //String query = "SELECT * FROM usuarios";
        try {           
            connection = JDBCMySQLConnection.getConnection();
            //statement = connection.createStatement();
            Students student = new Students();					// metodo de students creado por mi
            student.setNombre("sandra");
            student.setApellido("Benjumea");
            
			PreparedStatement ps = connection.prepareStatement(prepareInsertUsuario(student) , Statement.RETURN_GENERATED_KEYS);// protocolo para entregar un estudiante y poder hacer acciones en BD
			//								.prepareStatement prepara el query segun la base de datos que se este usando
			ps.executeUpdate();
			
            rs = ps.getGeneratedKeys();
             
            if(rs.next()) {
            	student.setNumeroIdentificacion(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
     
    }
    
    public static String prepareInsertUsuario(Students student) {
    	StringBuilder insertQuery = new StringBuilder();
    	insertQuery.append("INSERT INTO usuarios(nombre,apellido) VALUES(");
    	insertQuery.append("'").append(student.getNombre()).append("', '").append(student.getApellido()).append("');");
    	return insertQuery.toString();
    	
    }
   }
 
