package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataSource {
  public static Connection connect(){
    String db_file = "jdbc:sqlite:resources/bank.db";
    Connection connection = null;
   try{
        connection = DriverManager.getConnection(db_file);
        System.out.println("we are connected");
   }catch(SQLException e){
      e.printStackTrace();
   }
   return connection;
  }
public static void main(String[] args){
  connect();
}

public static Customer getCustomer (String username){
  String sql = "select * from customers where username =?";
  try(Connection Connection = connect();PreparedStatement){
    
  }
  catch(SQLException e){
    e.printStackTrace();
  }
}
}
