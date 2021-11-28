package ops;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
public class Identification {
    String msg;
  public Identification(String msg){this.msg=msg;}

  public void go()throws IOException{

  //IP A QUE NOS VAMOS CONECT
  InetAddress serveAddress=InetAddress.getByName("localhost");
  //LIGACAO 
  Socket ligacao=new Socket(serveAddress,25562);
  //BUFFER READER
  BufferedReader in=new BufferedReader(new InputStreamReader(ligacao.getInputStream()));
  //PrintWriter
  PrintWriter out=new PrintWriter(ligacao.getOutputStream(),true);
  //CRIAR MSG PARA ENVIAR
  String pedido=msg;
  //ENVIAR MSG
  out.println(pedido);
  //PREENCHER BLOCO
  out.flush();
  //LER A RESPOSTA DO SERVIDOR
  String resposta= in.readLine();
  //LER O IP DO SI
   String ip_si = in.readLine();
  //LER A PORTA DO SI
   String porta_si = in.readLine();
  System.out.println("[SERVER]-> HASH: "+resposta + " Ip do servidor: " + ip_si + " Porta do servidor: " + porta_si);
  //FECHAR LIGACAO
  ligacao.close();



  }


}
