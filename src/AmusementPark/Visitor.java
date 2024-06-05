/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AmusementPark;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author sabde
 */
public class Visitor extends Account {
//    private Ticket ticketsReserved;
      private int balance;
//      public void setTicket(){
//
//}
//        public Ticket getTicket(){
 public Visitor(){
    database=new DB();
}
public Visitor(String Email){
    database=new DB();
this.email=Email;
  System.out.println(this.email);
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
public String createAccount(String name,String email,String password){
   try {
            Statement stmt = database.con.createStatement();
            stmt.executeUpdate("insert into account values('"+(++this.counter) +"','"+ name + "', '" + email +"','"+password+ "')");
            return"Account added";

        } catch (Exception e) {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        }
return "";
}

    public boolean login(String email,String pass){
  try {
            Statement stmt = database.con.createStatement();
            String sql="select * from account where Email = '" + email + "' and Password = '" + pass +"'";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
               return true;
               } else{
         return false;
} 
        } catch (Exception e) {
            System.err.println("DATABASE QUERY ERROR: " + e.toString());
        }
return false;
}
}

