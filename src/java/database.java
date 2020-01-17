
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NKAZIMULO
 */
public class database {
    private Connection con;
    private Statement statement;
    
    public loginP checkLogin(String username, String password) throws SQLException, ClassNotFoundException{
    
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/doctordb?zeroDateTimeBehavior=convertToNull", "root","");
        String sql = "Select * FROM  tbldoc WHERE username = ? and password = ?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);
        
        ResultSet result = statement.executeQuery();
        
        loginP login = null;
        
        if(result.next()){
            login = new loginP();
            login.setSurname(result.getString("username"));
            login.setPassword(password);
        }
        con.close();
        return login;
    }
    
    public sendMail email(String email) throws ClassNotFoundException, SQLException{
       Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/doctordb?zeroDateTimeBehavior=convertToNull", "root",""); 
        String sql = "Select * FROM  tbldoc WHERE email = ?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, email);
        
        ResultSet rs = statement.executeQuery();
        
        sendMail em = null;
        
        if(rs.next()){
           em = new sendMail();
           em.setEmail(email);
        }
        con.close();
        
        return em;
    }
    public int insert(register reg) throws SQLException, ClassNotFoundException{   
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/doctordb?zeroDateTimeBehavior=convertToNull", "root",""); 
        statement = con.createStatement();
        String sql = "INSERT INTO tblreg VALUES('"+reg.getName()+"', '"+reg.getSurname()+"','"+reg.getEmail()+"', '"+reg.getPhone()+"', '"+reg.getIdentity()+"', '"+reg.getTime()+"', '"+reg.getMessage()+"')";
        statement.executeUpdate(sql);
        int num = 0;
        con.close();
        return num;
    }
    
    public update updates(String password) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/doctordb?zeroDateTimeBehavior=convertToNull", "root",""); 
        statement = con.createStatement();
        String sql = "update tbldoc set password = ?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, password);
        
        ResultSet rs = statement.executeQuery();
        
        update pass = null;
        
        if(rs.next()){
           pass = new update();
           pass.setPassword(password);
        }
        con.close();
        return pass;
    }
}
