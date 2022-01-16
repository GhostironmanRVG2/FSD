package ops;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;
public class Identification {
    String msg;
  public Identification(String msg){this.msg=msg;}

  public List go()throws IOException{
  //CRIAR LISTA
  List<String> l=new ArrayList<String>();
  String ip_txt=null;    
  //IP A QUE NOS VAMOS CONECT NESTE CASO É O NOSSO SI
  try {
    File myObj = new File("ips_list.txt");
    Scanner myReader = new Scanner(myObj);
    while (myReader.hasNextLine()) {
      String data = myReader.nextLine();
      //IR BUSCAR IP CORRESPONDENTE
      if(data.substring(0,2).equals("SI")){
      ip_txt=data.substring(data.lastIndexOf(":")+1);
      }
    }
    myReader.close();
  } catch (FileNotFoundException e) {
    System.out.println("An error occurred.");
    e.printStackTrace();
  }
  //LIGACAO 
  Socket ligacao=new Socket(ip_txt,25562);
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
   //ADICIONAR NA LISTA
   l.add(resposta);
   l.add(ip_si);
   l.add(porta_si);
  //FECHAR LIGACAO
  ligacao.close();

  return l;
 
  }


}
