package ops;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConVerify {
    String ip_Server,hash;
    int porta;
    //CONSTRUTOR DA VERIFICACAO DE CONEXAO
    public ConVerify(String ip_Server,int porta,String hash){
        //HASH
        this.hash=hash;
        //IP DO SERVIDOR
        this.ip_Server=ip_Server;
        //PORTA DO SERVER
        this.porta=porta;
    }

    public String go() throws UnknownHostException, IOException{

    //CRIAR A SOCKET QUE VAI LIGAR
    Socket ligacao=new Socket(ip_Server,porta);
    //BUFFER READER
    BufferedReader in=new BufferedReader(new InputStreamReader(ligacao.getInputStream()));
    //PrintWriter
    PrintWriter out=new PrintWriter(ligacao.getOutputStream(),true);
    //ENVIAR MSG COM O TIPO DE SERVICO
    out.println("C");
    //ENVIAR HASH
    out.println(hash);
    //ENVIAR MSG VAZIA
    out.println("");
    //PREENCHER BLOCO
    out.flush();
    //LER A RESPOSTA DO SERVIDOR
    String msgRecebida=in.readLine();
    //FECHAR LIGACAO
   ligacao.close();
   //ENVIAR A RESPOSTA DO SERVIDOR
   return msgRecebida;


    }


}
