import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.lang.Thread;

public class Client {
    private static int choice;
    private static String username, password;
    private static ArrayList<Account> accounts = new ArrayList<>();
    private static boolean isLoggedIn = false;

    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException, InterruptedException {
        while (true) {
            System.out.flush();
            System.out.println("Menu Client");
            System.out.println("-----------");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("0. Exit");
            System.out.print("Masukkan pilihan anda: ");
            choice = Integer.parseInt(in.readLine());
            switch (choice) {
                case 1 -> login();
                case 2 -> register();
                case 0 -> exit();
                default -> System.out.println("Pilihan tidak ada, pilih menggunakan angka yang tertera!!!");
            }
        }
    }

    private static void menuClient() throws IOException {
        System.out.flush();
        System.out.println("Menu");
        System.out.println("1. Kirim pesan");
        System.out.println("2. Ubah username");
        System.out.println("3. Ubah password");
        System.out.println("4. Hapus akun");
        System.out.println("5. Logout");
        System.out.print("Masukkan pilihan anda: ");
        choice = Integer.parseInt(in.readLine());

        switch (choice) {
            case 1 -> {
                if (!Server.connectionStatus) {
                    Server.start();
                } else {
                    System.out.println("berhasil");
                }
            }
            case 2 -> {}
            case 3 -> {}
            case 4 -> {}
            case 5 -> {}
        }
    }

    private static void login() throws IOException {
        if (isLoggedIn) {
            menuClient();
        } else {
            System.out.flush();
            System.out.println("Login");
            System.out.print("Masukkan username anda: ");
            username = in.readLine();
            System.out.print("Masukkan password anda: ");
            password = in.readLine();

            for (Account i : accounts) {
                if (Objects.equals(i.getUsername(), username)) {
                    if (Objects.equals(i.getPassword(), password)) {
                        isLoggedIn = true;
                        menuClient();
                    }
                }
            }
        }
    }
    private static void register() throws IOException {
        System.out.flush();
        System.out.println("Register");
        System.out.print("Masukkan username anda: ");
        username = in.readLine();
        System.out.print("Masukkan password anda: ");
        password = in.readLine();

        accounts.add(new Account(username, password));

    }
    private static void exit() throws InterruptedException {
        System.out.flush();
        System.out.println("Terima kasih telah menggunakan program ini!");
        Thread.sleep(100);
        System.exit(0);
    }
}