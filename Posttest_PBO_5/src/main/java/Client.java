import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.lang.Thread;

public class  Client {
    private static int choice;
    static ArrayList<Account> accounts = new ArrayList<>();
    static boolean isLoggedIn = false;
    static String username;

    static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException, InterruptedException {
        if (!Server.connectionStatus) {
            Server.start();
        }

        ChatTerminal.start();

        while (true) {
            System.out.flush();
            System.out.println("Menu Client");
            System.out.println("-----------");
            System.out.println("1. Login");
            System.out.println("2. Register sebagai admin");
            System.out.println("3. Register sebagai user");
            System.out.println("0. Exit");
            System.out.print("Masukkan pilihan anda: ");
            choice = Integer.parseInt(in.readLine());
            switch (choice) {
                case 1 -> SignIn.login();
                case 2 -> SignIn.registerAdmin();
                case 3 -> SignIn.registerUser();
                case 0 -> exit();
                default -> System.out.println("Pilihan tidak ada, pilih menggunakan angka yang tertera!!!");
            }
        }
    }

    static void menuClient() throws IOException {
        while (isLoggedIn) {
            System.out.flush();
            System.out.println("Menu");
            System.out.println("1. Kirim pesan");
            System.out.println("2. Ubah username");
            System.out.println("3. Ubah password");
            System.out.println("4. Hapus akun");
            System.out.println("0. Logout");
            System.out.print("Masukkan pilihan anda: ");
            choice = Integer.parseInt(in.readLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Masukkan pesan anda: ");
                    String message = in.readLine();
                    Server.setResponse(STR."\{username}: \{message}");
                }
                case 2 -> {}
                case 3 -> {}
                case 4 -> {}
                case 0 -> {
                    isLoggedIn = false;
                }
            }
        }
    }

    private static final void exit() throws InterruptedException {
        System.out.flush();
        System.out.println("Terima kasih telah menggunakan program ini!");
        Thread.sleep(100);
        System.exit(0);
    }
}