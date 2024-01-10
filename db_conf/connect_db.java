package db_conf;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class connect_db {
    private String url;
    private  String password;
    private  String user;

    public connect_db() {
        this.url = System.getenv("url");

        this.password = System.getenv("password");

        this.user = System.getenv("user");

    }
    public Connection connect_databse(){

        if (this.url !=null && this.password !=null && this.user !=null){
            try {
              Connection connection = DriverManager.getConnection(this.url,this.user,this.password);
              if (connection !=null){
                  System.out.println("connection done ");
              }else {
                  System.out.println("error");
              }
            }catch (Exception e){
                System.out.println(e);
            }
        }else {
            System.out.println("error path");
        }
        return  null;
    }
}
