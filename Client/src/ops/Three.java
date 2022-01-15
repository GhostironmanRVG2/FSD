package ops;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Three {
    String hash,designacao;
    //CONSTRUTOR
    public Three(String hash ,String designacao ){
      this.hash=hash;
      this.designacao=designacao;
    }
    //FUNCAO GET IP
    public String go() throws UnknownHostException, IOException{
     
      //CRIAR A SOCKET QUE VAI LIGAR
      Socket ligacao=new Socket("localhost",25563);
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
