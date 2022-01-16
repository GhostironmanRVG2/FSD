package ops;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Three {
    String hash,designacao;
    //CONSTRUTOR
    public Three(String hash ,String designacao){
      this.hash=hash;
      this.designacao=designacao;
    }
    //FUNCAO GET IP
    public String go() throws UnknownHostException, IOException{
      String ip_txt=null;    
      //IP A QUE NOS VAMOS CONECT NESTE CASO É O NOSSO SI
      try {
        File myObj = new File("ips_list.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
          String data = myReader.nextLine();
          //IR BUSCAR IP CORRESPONDENTE
          if(data.substring(0,2).equals("ST")){
          ip_txt=data.substring(data.lastIndexOf(":")+1);
          }
        }
        myReader.close();
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
      //CRIAR A SOCKET QUE VAI LIGAR
      Socket ligacao=new Socket(ip_txt,25563);
      //BUFFER READER
      BufferedReader in=new BufferedReader(new InputStreamReader(ligacao.getInputStream()));
      //PrintWriter
      PrintWriter out=new PrintWriter(ligacao.getOutputStream(),true);
      //ENVIAR MSG COM O TIPO DE SERVICO
      out.println("C");
      //ENVIAR HASH 
      out.println(hash);
      //ENVIAR TIPO DE SERVICO
      out.println("3");
      //ENVIAR DESIGNACAO
      out.println(designacao);
      out.flush();
      //LER A RESPOSTA DO SERVIDOR
      String msgRecebida=in.readLine();
  
      //FECHAR LIGACAO
      ligacao.close();

      return msgRecebida;
 




    }
    
}
