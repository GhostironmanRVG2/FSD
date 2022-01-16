import java.io.IOException;
import java.net.UnknownHostException;
import java.time.Instant;
import java.util.List;
import java.util.Scanner;

import ops.Midle;
import ops.ServiceSocket;
import ops.Three;

/**
 * ClientConsole
 */
public class ClientConsole {

    public static void main(String[] args) {
    String optipo=null;
    String ServicoValido=null;
    String NomeServico=null;    
    String timestampas=null;
    int instantveri=0;
    System.out.println("BEM-VINDO AO MAIN DE TESTE PARA O CORE");
    Scanner scan=new Scanner(System.in);
    String ip_TICKET=null;
    while(true){
    System.out.println("O Servico que deseja aceder é RMI OU SOCKET?1 RMI , 2 SOCKET");
    optipo=scan.nextLine();
    if(optipo.equals("1")||optipo.equals("2")){
    break;
    }
    }
    
    while(true){
    System.out.println("DIGITE O NOME DO SERVICO:");
    NomeServico =scan.nextLine();
    
    Three t=new Three("GOAL",NomeServico);
                
                try {
                    ip_TICKET = t.go();
                } catch (UnknownHostException e2) {
                    // TODO Auto-generated catch block
                    e2.printStackTrace();
                } catch (IOException e2) {
                    // TODO Auto-generated catch block
                    e2.printStackTrace();
                }
                int porta=-1;
                System.out.println(ip_TICKET);
                try {
                    //IR BUSCAR A PORTA
                    Integer.valueOf(ip_TICKET.substring(ip_TICKET.lastIndexOf(":")));
                } catch (Exception exeptionporta) {porta=0;}

                if(ip_TICKET.equals("NOPE")){
                    porta=-1;}

    
    if(porta==-1){
    System.out.println("Nao existe nenhum servico com esse nome");
    System.exit(0);
    }else{
    System.out.println("Servico existe");    
      break;  
    }

    }

    while(true){
    System.out.println("DIGITE UMA TIMESTAMP:");
    timestampas=scan.nextLine();

    try{
    Instant.parse(timestampas);
    instantveri=1;
    }catch(Exception e){
    instantveri=-1;
    }

    if(instantveri==1){
    System.out.println("Instant Valido");
    break;
    }else{
    
    System.out.println("Instant invalido");
         
    }

    }







    //SERVICO EM SI
    if(optipo.equals("1")){


     //INVOCAR OBJETO
     Midle m=new Midle("192.168.1.78",timestampas,ip_TICKET);
     String resp=null;
     try {
         resp = m.go();
     } catch (IOException e1) {
         // TODO Auto-generated catch block
         e1.printStackTrace();
     }
     System.out.println(resp);
     }else if(optipo.equals("2")){

     
        // FAZER A CONEXAO PARA O SOCKET
        ServiceSocket S = new ServiceSocket(ip_TICKET.substring(0, ip_TICKET.lastIndexOf(":")),2000,Instant.parse(timestampas));
        try {
            //REPOSTA
            List resp=S.go();
            //SE ENTROU COM SUCESSO ENTAO..
            if(resp.get(0).equals("200 OK")){
                //SETTAR O TEXTO COM A RESPOSTA
                System.out.println((String)resp.get(1));
            }else{
                //A TIMESTAMP NAO É VALIDA/PASSOU DO TEMPO
                System.out.println("A sua timestamp passou de tempo");
            }
     

     }catch(Exception ei){
         System.out.println("Algo deu errado");
     }







    }






    







    }

   
}