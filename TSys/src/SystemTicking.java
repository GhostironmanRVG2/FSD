


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import Threads.Ticking;
import Lists.*;
public class SystemTicking {
    public static void main(String[] args) throws IOException {
        //INICIALIZAR Os VETORES CASO CONTRARIO A MEMORIA E PERDIDA
        Hash h=new Hash();
        ServicesVector sv=new ServicesVector();
    
        //CRIAR UMA SOCKET PARA ESTABLECER LIGACAO
        ServerSocket ligacao=new ServerSocket(25563);
        
        //ESPERAR UMA CONEXAO
        while(true){
    
        
         //ACEITAR LIGACAO     
         Socket receber=ligacao.accept();
         
    
        //ENVIAR LIGACAO PARA THREAD
        Ticking t=new Ticking(receber,h,sv);
        t.run();
        
    

        }
    
    
    
    
    
    
    
    
    
        }
}
