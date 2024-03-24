import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import static java.lang.StringTemplate.STR;

public class Server {
    public static boolean connectionStatus = false;
    private static int port = 8000;
    private static String path = "/test";

    public static void start() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        Handler handler = new Handler("Initial response");
        server.createContext(path, handler);
        server.start();
        System.out.println(STR."Server started on port \{port}");
        connectionStatus = true;
    }

    public boolean isConnected() {
        return connectionStatus;
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
