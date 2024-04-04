import java.io.IOException;

public class ChatTerminal {
    public static void start() throws IOException, InterruptedException {
        String[] commands = {"cmd", "/c", "start", "cmd", "/k", "ncat -l -p 8000/chat"};
        ProcessBuilder chatTerminalProcessBuilder = new ProcessBuilder(commands);
        Process process = chatTerminalProcessBuilder.start();
        process.waitFor();
    }
}
