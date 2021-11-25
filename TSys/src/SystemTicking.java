


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import Threads.Ticking;

public class SystemTicking {
    public static void main(String[] args) throws IOException {
        //CRIAR UMA SOCKET PARA ESTABLECER LIGACAO
        ServerSocket ligacao=new ServerSocket(25563);
        
        //ESPERAR UMA CONEXAO
        while(true){
    
        
         //ACEITAR LIGACAO     
         Socket receber=ligacao.accept();
         
    
        //ENVIAR LIGACAO PARA THREAD
        Ticking t=new Ticking(receber);
        t.run();
        
    

        }
    
    
    
    
    
    
    
    
    
        }
}
