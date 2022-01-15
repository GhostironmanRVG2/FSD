import java.io.IOException;
import java.lang.SecurityManager;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ServicesServer {
	
	String SERVICE_NAME="/TemperatureService";

	private void bindRMI(Sources sources) throws UnknownHostException, IOException {
    
       ask a=new ask();
	   a.askToTheServer("localhost",SERVICE_NAME);

		try { 
			LocateRegistry.createRegistry(1099);
		} catch( RemoteException e) {
			
		}
		try {
		  LocateRegistry.getRegistry("127.0.0.1",1099).rebind(SERVICE_NAME, sources);
		  } catch( RemoteException e) {
		  	System.out.println("Registry not found");
		  }
	}

	public ServicesServer() {
		super();
	}
	
	public void createServices() throws UnknownHostException, IOException {
		
		Sources sources = null;
		try {
			sources = new Sources();
		} catch (RemoteException e1) {
			System.err.println("unexpected error...");
			e1.printStackTrace();
		}
		
		try {
			bindRMI(sources);
		} catch (RemoteException e1) {
			System.err.println("erro ao registar o stub...");
			e1.printStackTrace();
		}
		
	}
}
