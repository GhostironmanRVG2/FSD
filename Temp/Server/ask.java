import java.io.BufferedReader;
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
