import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
     
   public static void main(String[] args) throws IOException {
       //INFORMAR AO UTILIZADOR QUE INPUT QUEREMOS DA PARTE DELE E GUARDAR
       System.out.println("Please write your name and press enter: \n");
       Scanner scan=new Scanner(System.in);
       String nome=scan.nextLine();
       System.out.println("Please Write down your card IDENTIFICATION number: \n");
       String bi=scan.nextLine();
       //Extrair IP DATA e passar para uma String e juntar ao nome
       InetAddress ipi=InetAddress.getLocalHost();
       String ip= ipi.toString();
       //Juntar nome+ip
       String msg="["+nome+"/"+ip+"/"+bi+"]";
       
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
       System.out.println("Resposta do servidor: "+resposta + " Ip do servidor: " + ip_si + " Porta do servidor: " + porta_si);
       //FECHAR LIGACAO
       ligacao.close();
       
   }


}
