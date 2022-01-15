import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.time.Instant;
public class App {
    public static void main(String[] args) throws Exception {

          //CRIAR UMA SOCKET PARA ESTABLECER LIGACAO
          ServerSocket ligacao=new ServerSocket(1000);
        
          //ESPERAR UMA CONEXAO
          while(true){
           Socket rececao= ligacao.accept();
  
           //CRIAR UM ALOCADOR DE MEMORIA PARA RECEBER
           BufferedReader in= new BufferedReader(new InputStreamReader(rececao.getInputStream()));
  
           //CRIAR UM ALOCADOR DE MEMORIA PARA ENVIAR UMA RESPOSTA
           PrintWriter out= new PrintWriter(rececao.getOutputStream(),true);
  
           //LER A MENSAGEM RECEBIDA
           String msgip= in.readLine();
           String msgInst=in.readLine();
           System.out.println(msgip);
           //INVOCAR OBJ RMI
           ServicesInterface presences = (ServicesInterface) LocateRegistry.getRegistry(msgip).lookup("/TemperatureService");
           float resp=presences.getTemp(Instant.parse(msgInst));

           //PASSAR A MSG
           out.println(resp);

    

           out.flush();
  
           //FECHAR A LIGACAO
           rececao.close();
        
    }
}
}
