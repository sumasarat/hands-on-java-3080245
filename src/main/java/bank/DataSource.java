package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

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
  Customer customer = getCustomer("telloy3x@bigcartel.com");
  System.out.println(customer.getName());
}

public static Customer getCustomer (String username){
  String sql = "select * from customers where username =?";
  Customer customer = null;
  try(Connection connection = connect(); 
   PreparedStatement statement =connection.prepareStatement(sql)){
    statement.setString(1, username);
    try(ResultSet resultSet = statement.executeQuery()){
      customer = new Customer(resultSet.getInt("id"), resultSet.getString("name"),
      resultSet.getString("username") , resultSet.getString("password"),
       resultSet.getInt("Account_id"));

    }
  }
  catch(SQLException e){
    e.printStackTrace();
  }
  return customer;
}
}
