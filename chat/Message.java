package chat;

public class Message {
    private int sender_id_account_1;
    private int  receve_id_account_2;
    private String text;

    private String date;

    public Message(int sender_id_account_1, int receve_id_account_2, String text, String date) {
        this.sender_id_account_1 = sender_id_account_1;
        this.receve_id_account_2 = receve_id_account_2;
        this.text = text;
        this.date = date;
    }

    public int getSender_id_account_1() {
        return sender_id_account_1;
    }

    public void setSender_id_account_1(int sender_id_account_1) {
        this.sender_id_account_1 = sender_id_account_1;
    }

    public int getReceve_id_account_2() {
        return receve_id_account_2;
    }

    public void setReceve_id_account_2(int receve_id_account_2) {
        this.receve_id_account_2 = receve_id_account_2;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sender_id_account_1=" + sender_id_account_1 +
                ", receve_id_account_2=" + receve_id_account_2 +
                ", text='" + text + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
