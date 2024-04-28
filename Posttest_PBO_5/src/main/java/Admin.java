public class Admin extends Account{
    private String previlege;

    Admin(String username, String password) {
        super(username, password);
        this.previlege = "admin";
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
