package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
     
   public static void main(String[] args) throws IOException {
       //IP A QUE NOS VAMOS CONECT
       InetAddress serveAddress=InetAddress.getByName("localhost");
       //LIGACAO 
       Socket ligacao=new Socket(serveAddress,25562);

       //BUFFER READER
       BufferedReader in=new BufferedReader(new InputStreamReader(ligacao.getInputStream()));
       //PrintWriter
       PrintWriter out=new PrintWriter(ligacao.getOutputStream(),true);
       //CRIAR MSG PARA ENVIAR
       String pedido="Hello Server";
       //ENVIAR MSG
       out.println(pedido);
       //PREENCHER BLOCO
       out.flush();
       //LER A RESPOSTA DO SERVIDOR
       String resposta= in.readLine();
       System.out.println("Resposta do servidor: "+resposta);
       //FECHAR LIGACAO
       ligacao.close();
       
   }


}
