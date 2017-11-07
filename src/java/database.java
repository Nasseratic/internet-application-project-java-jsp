
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class database {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/USER";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "";
   
   
   
   void createTable(){
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      stmt = conn.createStatement();
      //STEP 4: Execute a query
      System.out.println("Creating table in given database...");
      
      String sql = "CREATE TABLE user " +
                   "(id VARCHAR(255) not NULL, " +
                   " name VARCHAR(255), " + 
                   " mail VARCHAR(255), " + 
                   " phone VARCHAR(255), " + 
                   " PRIMARY KEY ( id ))"; 

      stmt.execute(sql);
      System.out.println("Created table in given database...");
   }catch(SQLException | ClassNotFoundException se){
       //Handle errors for JDBC

   }
       //Handle errors for Class.forName
       finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
   }
   
   
   //////////////////////////////////////////////////
   void delete(String id){
    Connection conn = null;
    Statement stmt = null;
    try{
       //STEP 2: Register JDBC driver
       Class.forName("com.mysql.jdbc.Driver");

       //STEP 3: Open a connection
       System.out.println("Connecting to a selected database...");
       conn = DriverManager.getConnection(DB_URL, USER, PASS);
       System.out.println("Connected database successfully...");

       stmt = conn.createStatement();
       //STEP 4: Execute a query

       String sql = "DELETE FROM user where id = \'" +
                    id+"\'"; 

       stmt.executeUpdate(sql);
       System.out.println("Deleted");
    }catch(SQLException | ClassNotFoundException se){
        //Handle errors for JDBC

    }
       //Handle errors for Class.forName
       finally{
       //finally block used to close resources
       try{
          if(stmt!=null)
             stmt.close();
       }catch(SQLException se){
       }// do nothing
       try{
          if(conn!=null)
             conn.close();
       }catch(SQLException se){
       }//end finally try
    }//end try
    System.out.println("Goodbye!");
   }
   /////////////////////////////////////////////////////////
   void insert(String id, String name, String phone, String mail ){
    Connection conn = null;
    Statement stmt = null;
    try{
       //STEP 2: Register JDBC driver
       Class.forName("com.mysql.jdbc.Driver");

       //STEP 3: Open a connection
       System.out.println("Connecting to a selected database...");
       conn = DriverManager.getConnection(DB_URL, USER, PASS);
       System.out.println("Connected database successfully...");

       stmt = conn.createStatement();
       //STEP 4: Execute a query

       String sql = "INSERT INTO user (id,name,mail,phone) " +"Values"+"(\'"+
                    id+"\',\'"+name+"\',\'"+mail+"\',\'"+phone+"\')"; 

       stmt.executeUpdate(sql);
       System.out.println("Inserted");
    }catch(SQLException | ClassNotFoundException se){
        //Handle errors for JDBC

    }
       //Handle errors for Class.forName
       finally{
       //finally block used to close resources
       try{
          if(stmt!=null)
             stmt.close();
       }catch(SQLException se){
       }// do nothing
       try{
          if(conn!=null)
             conn.close();
       }catch(SQLException se){
       }//end finally try
    }//end try
    System.out.println("Goodbye!");
   }
   ///////////////////////////////////////////////////////
   user select(Integer id){
    Connection conn = null;
    Statement stmt = null;
    user u = new user();
    try{
       //STEP 2: Register JDBC driver
       Class.forName("com.mysql.jdbc.Driver");

       //STEP 3: Open a connection
       System.out.println("Connecting to a selected database...");
       conn = DriverManager.getConnection(DB_URL, USER, PASS);
       System.out.println("Connected database successfully...");

       stmt = conn.createStatement();
       //STEP 4: Execute a query

       String sql = "SELECT name, phone, mail FROM user where id equal "
               +id.toString(); 

        try (ResultSet rs = stmt.executeQuery(sql)) {
            u.id = rs.getString("id");
            u.name = rs.getString("name");
            u.mail = rs.getString("mail");
            u.phone = rs.getString("phone");
            System.out.println("Selected");
        }
    }catch(SQLException | ClassNotFoundException se){
        //Handle errors for JDBC

    }
       //Handle errors for Class.forName
       finally{
       //finally block used to close resources
       
       try{
          if(stmt!=null)
             stmt.close();
       }catch(SQLException se){
       }// do nothing
       try{
          if(conn!=null)
             conn.close();
       }catch(SQLException se){
       }//end finally try
    }//end try
    System.out.println("Goodbye!");
       return u;
   }
   ////////////////////////////////////////
    ArrayList<user> selectAll(){
    Connection conn = null;
    Statement stmt = null;
    ArrayList<user> users = new ArrayList<>();
    try{
       //STEP 2: Register JDBC driver
       Class.forName("com.mysql.jdbc.Driver");

       //STEP 3: Open a connection
       System.out.println("Connecting to a selected database...");
       conn = DriverManager.getConnection(DB_URL, USER, PASS);
       System.out.println("Connected database successfully...");

       stmt = conn.createStatement();
       //STEP 4: Execute a query

       String sql = "SELECT * FROM user ; "; 

        try (ResultSet rs = stmt.executeQuery(sql)) {
            user u = new user();
            while(rs.next()){
                u.id = rs.getString("id");
                u.name = rs.getString("name");
                u.mail = rs.getString("mail");
                u.phone = rs.getString("phone");
                users.add(u);
                
            }}
       
    }catch(SQLException | ClassNotFoundException se){
        //Handle errors for JDBC

    }
       //Handle errors for Class.forName
       finally{
       //finally block used to close resources
       try{
          if(stmt!=null)
             stmt.close();
       }catch(SQLException se){
       }// do nothing
       try{
          if(conn!=null)
             conn.close();
       }catch(SQLException se){
       }//end finally try
    }//end try
    System.out.println("Goodbye!");
       return users;
    }
}