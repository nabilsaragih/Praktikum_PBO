import java.io.IOException;

public interface ServerInterface {
    public void start() throws IOException;

    public void setResponse(String response);
}
