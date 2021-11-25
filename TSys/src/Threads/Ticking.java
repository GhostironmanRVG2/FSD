package Threads;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import Lists.*;
public class Ticking {
    Hash h=new Hash();
    Socket ligacao;
    BufferedReader in;
    PrintWriter out;
 //CRIAR OBJ PARA ESSA THREAD SABER A QUE LIGACAO LIGAR    
 public  Ticking(Socket ligacao) throws IOException{
   //LIGACAO
   this.ligacao=ligacao;
   //BUFFER PARA RECEBER OS DADOS
   this.in=new BufferedReader(new InputStreamReader(ligacao.getInputStream()));
   //BUFFER PARA ENVIAR PARA FORA OS DADOS
   this.out=new PrintWriter(ligacao.getOutputStream());
 }

 public void run() throws IOException{

    System.out.println("User Connected");
    //LER PRIMEIRA LINHA(VAI DIZER TIPO DE PEDIDO)
    String tipoDePedido=in.readLine();
    //LER SEGUNDA LINHA QUE É O PEDIDO
    String pedido=in.readLine();
    //VERIFICAR TIPO DE PEDIDO , CASO SEJA DE TIPO IDENTIFICACAO , GUARDAR HASH NO VECTOR CASO CONTRARIO APENAS RESPONDER POIS É DE TIPO CLIENTE
    if(tipoDePedido.equals("I")){
      
      h.addHash(pedido);
      
    }else if(tipoDePedido.equals("C")){

    
    //RESPONDER
    out.print("alo");
    out.print("k");
    //PREENCHER A BOX DA MSG
    out.flush();
    //FECHAR O BUFFER
    in.close();
    //FECHAR O BUFFER
    out.close();

    }
    
   
    
    //FECHAR A LIGACAO
    ligacao.close();
   
    }
 



}
