package CRUD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Crud {
    public void insert_users(Connection conn, String account_type, String name, String email, String password) {
        Statement statement;
        try {
            String query = String.format("insert into client(account_type,name,email,password) values('%s','%s','%s','%s');", account_type, name, email, password);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("compte created sucess !!! ");
        } catch (Exception e) {
            System.out.println(e);

        }

    }



    public int id_client(Connection conn,String account_type){
        Statement statement;
        ResultSet rs =null;
        int id =0;
        try {
            String query =String.format("select id from client where account_type='%s';",account_type);
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
            while (rs.next()){
                id=rs.getInt("id");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return id;

    }
    public String read_message(Connection conn, int sender_id_account_1, int receve_id_account_2,int id_account_1, int id_account_2){
        Statement statement;
        ResultSet rs=null;
        String name="";
        try {
            String query =String.format("select name , texte , date from message inner join client on client.id = message.sender_id_account_1 where sender_id_account_1=%s and  receve_id_account_2=%s or sender_id_account_1=%s and  receve_id_account_2=%s ;",sender_id_account_1,receve_id_account_2,id_account_1,id_account_2);
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
            while (rs.next()){

                name += rs.getString("name")+" : "+rs.getString("texte")+"  "+rs.getString("date")+"\n";
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return name;
    }

    public int id_client_receve(Connection conn,String name){
        Statement statement;
        ResultSet rs =null;
        int id =0;
        try {
            String query =String.format("select id from client where name='%s';",name);
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
            while (rs.next()){
                id=rs.getInt("id");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return id;

    }

    public ArrayList<String> list_client_en_live(Connection conn){
        Statement statement;
        ResultSet rs =null;
        ArrayList<String> client = new ArrayList<>();
        try {
            String query = String.format("select client.name from client inner join client_live on client.id=client_live.id_client_live;");
            statement=conn.createStatement();
            rs= statement.executeQuery(query);
            while (rs.next()){
               client.add(rs.getString("name"));
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return client;
    }
    public String date(Connection conn){
        Statement statement;
        ResultSet rs=null;
        String date ="";
        try {
            String query = String.format("select now();");
            statement=conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()){
               date = rs.getString("now");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return  date;
    }

    public int id_client_live(Connection conn,String account_type){
        Statement statement;
        ResultSet rs =null;
        int id =0;
        try {
            String query =String.format("select id from client_live where account_type='%s';",account_type);
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
            while (rs.next()){
                id=rs.getInt("id");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return id;

    }


    public void insert_client_live(Connection conn,String account_type , int id_client_live){
        Statement statement;
        try {
            String query = String.format("insert into client_live (account_type,id_client_live) values('%s','%s');",account_type,id_client_live);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("vous ete en ligne maintenant ");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void insert_message(Connection conn,int sender_id_account_1,int receve_id_account_2,String texte,String date){
        Statement statement;
        try {
            String query = String.format("insert into message(sender_id_account_1,receve_id_account_2,texte,date) values('%s','%s','%s','%s');",sender_id_account_1,receve_id_account_2,texte,date);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println(" message a ete envoyer ");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void delete_client_live(Connection conn,String  account_type){
        Statement statement;
        try {
            String query =String.format(" delete from client_live where  account_type='%s';", account_type);
            statement= conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("vous ete deconnecter ");
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
