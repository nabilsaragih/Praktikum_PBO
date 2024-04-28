import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Server {
    public static boolean connectionStatus = false;
    private static Handler handler;

    public static void start() throws IOException {
        int port = 8000;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        handler = new Handler("Initial response");
        String path = "/chat";
        server.createContext(path, handler);
        server.start();
        connectionStatus = true;
    }

    public boolean isConnected() {
        return connectionStatus;
    }

    public static void setResponse(String response) {
        handler.setResponse(response);
    }

    static class Handler implements HttpHandler {
        private String response;

        public Handler(String response) {
            this.response = response;
        }

        public void setResponse(String response) {
            this.response = response;
        }

        @Override
        public void handle(HttpExchange t) throws IOException {
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
