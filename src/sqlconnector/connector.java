/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sqlconnector;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Shreyash
 */
public class connector {
    public static Connection getCon(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/a","root","SSRahinj@48");
        return con;
   
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
