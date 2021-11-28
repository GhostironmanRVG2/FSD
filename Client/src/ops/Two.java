package ops;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Two {

        String ip ,hash,designacao_servico,ip_servico;
        int porta;
        //CONSTRUTOR DA NOSSA THREAD QUE VAI COMUNICAR COM O NOSSO SERVIDOR
        public Two(String ip , int porta, String hash,String designacao_servico,String ip_servico){
        //IP DO SERVER
        this.ip=ip;
        //PORTA DO SERVER
        this.porta=porta;
        //HASH DO CLIENTE
        this.hash=hash;
        //DESIGNACAO DO SERVICO
        this.designacao_servico=designacao_servico;
        //IP DO SERVICO
        this.ip_servico=ip_servico;   
        }
        
        
        public void go()throws IOException{
        
        //CRIAR A SOCKET QUE VAI LIGAR
        Socket ligacao=new Socket(ip,porta);
        //BUFFER READER
        BufferedReader in=new BufferedReader(new InputStreamReader(ligacao.getInputStream()));
        //PrintWriter
        PrintWriter out=new PrintWriter(ligacao.getOutputStream(),true);
        //ENVIAR MSG COM O TIPO DE SERVICO
        out.println("C");
        //ENVIAR HASH
        out.println(hash);
        //ENVIAR TIPO DE SERVICO
        out.println("2");
        //ENVIAR DESIGNACAO
        out.println(designacao_servico);
        //ENVIAR IP DO SERVICO
        out.println(ip_servico);
        //PREENCHER BLOCO
        out.flush();
        //LER A RESPOSTA DO SERVIDOR
        String msgRecebida=in.readLine();
        System.out.println("[SERVER]->"+msgRecebida);
        //FECHAR LIGACAO
        ligacao.close();
        }





    }

