public abstract class Account implements Validation {
    protected String username;
    protected String password;

    Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
}