public class User extends Account {
    private String previlege;

    User(String username, String password) {
        super(username, password);
        this.previlege = "user";
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getPrevilege() {
        return previlege;
    }
}
