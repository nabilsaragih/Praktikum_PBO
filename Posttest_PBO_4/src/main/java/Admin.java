public class Admin extends Account{
    private String previlege;

    Admin(String username, String password) {
        super(username, password);
        this.previlege = "admin";
    }

    public String getPrevilege() {
        return previlege;
    }
}
