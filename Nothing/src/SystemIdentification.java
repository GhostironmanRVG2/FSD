


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import Threads.Identification;

public class SystemIdentification {
        public static void main(String[] args) throws IOException {
    //CRIAR UMA SOCKET PARA ESTABLECER LIGACAO
    ServerSocket ligacao=new ServerSocket(25562);
    System.out.println("Server has been create at port number: "+25562);
 

    //ESPERAR UMA CONEXAO
    while(true){
   
     //ACEITAR LIGACAO     
     Socket receber=ligacao.accept();
     
     //criar obj
     Identification obj=new Identification(receber);
     obj.run();

     
  





    }









    }
    
}
