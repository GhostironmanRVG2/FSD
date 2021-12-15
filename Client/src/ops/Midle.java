package ops;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Midle {
    String ip,inst,ip_rmi;
    public Midle(String ip,String inst,String ip_rmi){
        this.ip=ip;
        this.inst=inst;
        this.ip_rmi=ip_rmi;
    }



    public String go()throws IOException{
        String resp=null;
        //CRIAR A SOCKET QUE VAI LIGAR
        Socket ligacao=new Socket(ip,1000);
        //BUFFER READER
        BufferedReader in=new BufferedReader(new InputStreamReader(ligacao.getInputStream()));
        //PrintWriter
        PrintWriter out=new PrintWriter(ligacao.getOutputStream(),true);
        //MENSAGEM 
        out.println(ip_rmi);
        //SEGUDNA MSG
        out.println(inst);
        //ENCHER BUFFER
        out.flush();
        //RESPOSTA
        resp= in.readLine();
        
        //FECHAR O IN
        in.close();
        //FECHAR O OUT
        out.close();
        //FECHAR LIGACAO
        ligacao.close();
        return resp;
        }
    
}
