/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AmusementPark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author sabde
 */
public class Account implements CreateAccountROI {
    protected int id;
    protected String name;
    protected String email;
    protected String password;
    protected DB database;
    protected static int counter=1;
    public Account(){
    database=new DB();
}
String mail;
  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


      @Override
  public boolean editAccount(String name,String email,String password){
try {
            Statement stmt = database.con.createStatement();
    System.out.println(this.getEmail());
String sql="update account set Name = '" + name + "',Email= '"+email+"',Password= '"+password+"' where Name= '"+this.getEmail()+"'";
            stmt.executeUpdate(sql);
              return true;
          
        } catch (Exception e) {
            System.err.println("DATABASE UPDATE ERROR: " + e.toString());
        }
return false;
    }

        @Override
    public boolean deleteAccount(String Email){
try {
            Statement stmt = database.con.createStatement();
            stmt.executeUpdate("delete from account where Name = '" + Email + "'");
             if(this.counter>0){
               this.counter--;
}
            System.out.println("Account deleted");
return true;
        } catch (Exception e) {
            System.err.println("DATABASE DELETION ERROR: " + e.toString());
        }
return false;
}
       
   

}

