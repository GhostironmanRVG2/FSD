package Threads;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import Hash.PasswordUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

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
   //TRANSFORMAR NUMA HASH OS DADOS
   PasswordUtils p=new PasswordUtils();
   //GERAR CARACTERES PARA O HASH
   String salt=p.getSalt(10);
   //GERAR O ENCRYPT
   String resposta=p.generateSecurePassword(pedido, salt);
   String ip_txt=null;    
  //IP A QUE NOS VAMOS CONECT NESTE CASO É O NOSSO SI
  try {
    File myObj = new File("ips_list.txt");
    Scanner myReader = new Scanner(myObj);
    while (myReader.hasNextLine()) {
      String data = myReader.nextLine();
      //IR BUSCAR IP CORRESPONDENTE
      if(data.substring(0,1).equals("ST")){
      ip_txt=data.substring(data.lastIndexOf(":")+1);
      }
    }
    myReader.close();
  } catch (FileNotFoundException e) {
    System.out.println("An error occurred.");
    e.printStackTrace();
  }
   //FAZER LIGACAO AO SERVER DE TICKING E ENVIAR A HASH
   //LIGACAO
   Socket l=new Socket(ip_txt,25563); 
   //BUFFER READER
   BufferedReader entrada=new BufferedReader(new InputStreamReader(l.getInputStream()));
   //PrintWriter
   PrintWriter saida=new PrintWriter(l.getOutputStream(),true);
   //TIPO DE SERVICO
   String tipo_servico = "I";
   //PRINT DO TIPO DE SERVICO
   saida.println(tipo_servico);
   //ENVIAR HASH
   saida.println(resposta);
   //ENCHER O BUFFER
   saida.flush();
   //FECHAR A LIGACAO COM O ST
   l.close();

   //RECEBER A HASH
   out.println(resposta);
   //ENVIAR IP
   out.println(ip_txt);
   //ENVIAR porta
   out.println("25563");
   //ENCHER O BUFFER
   out.flush();
   //FECHAR O BUFFER
   in.close();
   //FECHAR O BUFFER
   out.close();
   //FECHAR A LIGACAO
   ligacao.close();


   }






}
