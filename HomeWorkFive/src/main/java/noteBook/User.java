package noteBook;

public class User {
    private int id;
    private String username;
    private String telNumber;

    public User(int id, String username, String telNumber) {
        this.id = id;
        this.username = username;
        this.telNumber = telNumber;
    }

    public User(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    @Override
    public String toString() {
        return getUsername() + " " + getTelNumber();
    }
}
