package db_conf;

import java.sql.Connection;
import java.sql.DriverManager;

public class db_connect {
    private String user;
    private String password;
    private String url ;

    public db_connect() {
        this.user = System.getenv("user");
        this.password = System.getenv("password");
        this.url = System.getenv("url");
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }

    public Connection conn_db(String dbname) {


        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url+dbname, user, password);
            if (conn != null) {
                System.out.println("connection donne ! ");
            } else {
                System.out.println("error path");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }
}
