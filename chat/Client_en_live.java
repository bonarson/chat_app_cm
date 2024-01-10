package chat;

public class Client_en_live {
    private String  account_type;
    private  String   id_client_live;

    public Client_en_live(String account_type, String id_client_live) {
        this.account_type = account_type;
        this.id_client_live = id_client_live;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public String getId_client_live() {
        return id_client_live;
    }

    public void setId_client_live(String id_client_live) {
        this.id_client_live = id_client_live;
    }

    @Override
    public String toString() {
        return "Client_en_live{" +
                "account_type='" + account_type + '\'' +
                ", id_client_live='" + id_client_live + '\'' +
                '}';
    }
}
