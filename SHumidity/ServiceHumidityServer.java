import java.net.*;
import java.io.*;
import java.net.InetAddress;

public class ServiceHumidityServer {
	static int DEFAULT_PORT=2000;
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		//IR BUSCAR IP DO ROUTER EM QUE ME ENCONTRO
		Socket socket = new Socket();
        socket.connect(new InetSocketAddress("google.com", 80));
        String is=socket.getLocalAddress().toString();
		//PERGUNTAR AO USER
		ask a=new ask();
		//ENVIAR INFORMACAO PARA PERGUNTAR AO USER
		a.askToTheServer(is.substring(is.lastIndexOf("/")+1)+":"+DEFAULT_PORT,null);
		int port=DEFAULT_PORT;
		Sources source = new Sources();
		source.loadData();
		ServerSocket servidor = null; 
	
		try	{ 
			servidor = new ServerSocket(port);
		} catch (Exception e) { 
			System.err.println("erro ao criar socket servidor...");
			e.printStackTrace();
			System.exit(-1);
		}
				
		while(true) {
			try {
				
				Socket ligacao = servidor.accept();
				GetServicesRequestHandler t = new GetServicesRequestHandler(ligacao, source);
				t.start();
				
			} catch (IOException e) {
				System.out.println("Erro na execucao do servidor: "+e);
				System.exit(1);
			}
		}
	}
}
