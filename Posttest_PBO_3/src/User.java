public class User extends Account {
    private String previlege;

    User(String username, String password) {
        super(username, password);
        this.previlege = "user";
    }

    public String getPrevilege() {
        return previlege;
    }
}
