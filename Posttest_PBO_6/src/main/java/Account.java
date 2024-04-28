public abstract class Account {
    protected String username;
    protected String password;

    Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public abstract String getUsername();

    public abstract String getPassword();
}