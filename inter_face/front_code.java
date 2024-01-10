package inter_face;

import CRUD.Crud;
import chat.Message;
import chat.client;
import db_conf.db_connect;
import org.w3c.dom.Text;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class front_code {

    public static void main(String[] args) {
        db_connect db = new db_connect();
        Connection conn = db.conn_db("chat_app");

        Scanner scanner = new Scanner(System.in);
        String account_type ="";
        int id_client=0;
        while (true) {
            System.out.println("========= WELCOM IN CHAT APP ========");
            System.out.println("                 --------------------");
            System.out.println("                 1- Sing-up       ");
            System.out.println("                 --------------------");
            System.out.println("                 2- log-in        ");
            System.out.println("                 --------------------");
            System.out.println("                 3- User_connect  ");
            System.out.println("                 --------------------");
            System.out.println("                 4- Write_message ");
            System.out.println("                 --------------------");
            System.out.println("                 5- Log-out          ");
            System.out.println("                 --------------------");

            System.out.println("🖋 votre choix : ");
            int choix = scanner.nextInt();
            if (choix == 1) {

                System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
                System.out.print("             1- Sing-up          ");
                System.out.print("account_type : ");
                account_type = scanner.next();
                System.out.print("                                 name : ");
                String name = scanner.next();
                System.out.print("                                 email : ");
                String email = scanner.next();
                System.out.print("                                 password : ");
                String password = scanner.next();
                Crud crud = new Crud();
                crud.insert_users(conn, account_type, name, email, password);
                client user = new client(account_type, name, email, password);
                System.out.println(user);


                System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");

            } else if (choix == 2) {

                System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
                System.out.print("             2- log-in          ");
                System.out.print("account_type : ");
                account_type = scanner.next();
                System.out.print("                                email : ");
                String email = scanner.next();
                Crud crud = new Crud();
                id_client = crud.id_client(conn, account_type);
                crud.insert_client_live(conn, account_type, id_client);
                System.out.println("Vote votre id : " + id_client);
                System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");

            } else if (choix == 3) {

                System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
                System.out.println("             3- User_connect          ");
                Crud crud = new Crud();
                System.out.println(crud.list_client_en_live(conn));
                System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");

            } else if (choix == 4) {
                System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
                System.out.println("             4- Write_message");
                System.out.println("                User_connect          ");
                System.out.println(" ");
                Crud crud = new Crud();
                id_client = crud.id_client(conn, account_type);
                System.out.println(crud.list_client_en_live(conn));
                System.out.println(" ");
                String date = crud.date(conn);
                System.out.print("destinataire : ");
                String destinataire=scanner.next();
                int id_receve = crud.id_client_receve(conn,destinataire);
                System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
                System.out.println(crud.read_message(conn, id_client, id_receve,id_receve,id_client));
                System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");

                String separe =scanner.nextLine();
                System.out.println("🖋 : ");
                String Write_message = scanner.nextLine();
                crud.insert_message(conn,id_client,id_receve,Write_message,date);
                Message message =new Message(id_client,id_receve,Write_message,date);
                System.out.println(message);
                System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
            } else if (choix == 5) {
                System.out.println("             5- Log-out  ");
                Crud crud = new Crud();
                crud.delete_client_live(conn, account_type);
                return;
            }

        }
    }

}
