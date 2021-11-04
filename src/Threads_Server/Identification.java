package Threads_Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Identification {
  Socket ligacao;
  BufferedReader in;
  PrintWriter out;
  //CRIAR OBJ PARA ESSA THREAD SABER A QUE LIGACAO LIGAR  
   public Identification(Socket ligacao) throws IOException{
       //LIGACAO
       this.ligacao=ligacao;
       //BUFFER PARA RECEBER OS DADOS
       this.in=new BufferedReader(new InputStreamReader(ligacao.getInputStream()));
       //BUFFER PARA ENVIAR PARA FORA OS DADOS
       this.out=new PrintWriter(ligacao.getOutputStream());


   }

   public void run() throws IOException{

   System.out.println("User Connected");
   //RECEBER PEDIDO
   String pedido=in.readLine();
   System.out.println(pedido);
   //RESPONDER
   out.print("ALO");
   //PREENCHER A BOX DA MSG
   out.flush();
   //FECHAR O BUFFER
   in.close();
   //FECHAR O BUFFER
   out.close();
   //FECHAR A LIGACAO
   ligacao.close();


   }



}
