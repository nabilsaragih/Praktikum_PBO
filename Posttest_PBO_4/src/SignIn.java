import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

public class SignIn {

    static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static String username;
    private static String password;


    static void login() throws IOException {
        if (Client.isLoggedIn) {
            Client.menuClient();
        } else {
            System.out.flush();
            System.out.println("Login");
            System.out.print("Masukkan username anda: ");
            username = in.readLine();
            System.out.print("Masukkan password anda: ");
            password = in.readLine();

            for (Account i : Client.accounts) {
                if (Objects.equals(i.getUsername(), username)) {
                    if (Objects.equals(i.getPassword(), password)) {
                        Client.isLoggedIn = true;
                        Client.username = username;
                        System.out.println(i instanceof Admin);
                        System.out.println(i instanceof User);
                        Client.menuClient();

                    }
                }
            }
        }
    }

    static void registerAdmin() throws IOException {
        System.out.flush();
        System.out.println("Register");
        System.out.print("Masukkan username anda: ");
        username = Client.in.readLine();
        System.out.print("Masukkan password anda: ");
        password = Client.in.readLine();

        Client.accounts.add(new Admin(username, password));
    }

     static void registerUser() throws IOException {
        System.out.flush();
        System.out.println("Register");
        System.out.print("Masukkan username anda: ");
        username = Client.in.readLine();
        System.out.print("Masukkan password anda: ");
        password = Client.in.readLine();

        Client.accounts.add(new User(username, password));
    }
}
