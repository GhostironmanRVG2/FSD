import java.io.IOException;
import java.net.UnknownHostException;

public class ServerApp {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		ServicesServer serv = new ServicesServer();
		serv.createServices();
	}
}
