import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
public class ask {
    public ask(){};
    public void askToTheServer(String ip,String designacao_if_RMI) throws UnknownHostException, IOException{

    //ESPERAR UMA RESPOSTA
    while(true){
    //PERGUNTAR SE JA TEM PARA FAZER UM REGISTO NOVO
    System.out.println("TEM CHAVE? Sim ou Nao");
    Scanner scan=new Scanner(System.in);
    String answer=scan.nextLine();
    if(answer.equals("Sim")){
    //ASK
    System.out.println("Introduza a chave:");
    //INTRODUZA A CHAVE
    String chave= scan.nextLine();
    //ASK
    if(designacao_if_RMI==null){
    System.out.println("Introduza a nova designacao:");
    String designacao=scan.nextLine();
    CreateRegistry r=new CreateRegistry(designacao,ip,chave);
    r.register();
    }else{
    //REGISTAR
    CreateRegistry r=new CreateRegistry(designacao_if_RMI,ip,chave);
    r.register();
    }
    //REGISTAR
    

    break;
    }else if(answer.equals("Nao")){
  //FRASE PARA CRIAR CHAVE
  System.out.println("INTRODUZA UMA FRASE PARA RECEBER UMA CHAVE:");
  String msg= scan.nextLine();
  String ip_txt=null;    
  //IP A QUE NOS VAMOS CONECT NESTE CASO É O NOSSO SI
  try {
    File myObj = new File("ips_list.txt");
    Scanner myReader = new Scanner(myObj);
    while (myReader.hasNextLine()) {
      String data = myReader.nextLine();
      //IR BUSCAR IP CORRESPONDENTE
      if(data.substring(0,1).equals("SI")){
      ip_txt=data.substring(data.lastIndexOf(":")+1);
      }
    }
    myReader.close();
  } catch (FileNotFoundException e) {
    System.out.println("An error occurred.");
    e.printStackTrace();
  }
  InetAddress serveAddress=InetAddress.getByName(ip_txt);
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
  System.out.println("A sua nova hash:"+resposta);
  //FECHAR LIGACAO
  ligacao.close();   
  //ASK
  if(designacao_if_RMI==null){
    System.out.println("Introduza a nova designacao:");
    String designacao=scan.nextLine();
    CreateRegistry r=new CreateRegistry(designacao,ip,resposta);
    r.register();
    }else{
    //REGISTAR
    CreateRegistry r=new CreateRegistry(designacao_if_RMI,ip,resposta);
    r.register();
    }


    break;
    }
}


    }
}
