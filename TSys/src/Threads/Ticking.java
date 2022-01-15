package Threads;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import Lists.*;
public class Ticking {
    ServicesVector sv;
    Hash h;
    Socket ligacao;
    BufferedReader in;
    PrintWriter out;
 //CRIAR OBJ PARA ESSA THREAD SABER A QUE LIGACAO LIGAR    
 public  Ticking(Socket ligacao,Hash h,ServicesVector sv) throws IOException{
   //VECTOR HASH
   this.h=h;
   //VECTOR SERVICES
   this.sv=sv;
   //LIGACAO
   this.ligacao=ligacao;
   //BUFFER PARA RECEBER OS DADOS
   this.in=new BufferedReader(new InputStreamReader(ligacao.getInputStream()));
   //BUFFER PARA ENVIAR PARA FORA OS DADOS
   this.out=new PrintWriter(ligacao.getOutputStream());
 }

 public void run() throws IOException{

    System.out.println("User Connected");
    //LER PRIMEIRA LINHA(VAI DIZER TIPO DE PEDIDO)
    String tipoDePedido=in.readLine();
    
    //VERIFICAR TIPO DE PEDIDO , CASO SEJA DE TIPO IDENTIFICACAO , GUARDAR HASH NO VECTOR CASO CONTRARIO APENAS RESPONDER POIS É DE TIPO CLIENTE
    if(tipoDePedido.equals("I")){
      //LER SEGUNDA LINHA QUE É O PEDIDO
    String pedido=in.readLine();
     //ADICIONAR A HASH
    h.addHash(pedido);
      
    }else if(tipoDePedido.equals("C")){
    
    //EXTRAIR A HASH
    String hash=in.readLine();
    //EXTRAIR ETAPA
    String etapa=in.readLine();
    //VERIFICAR O LOGIN ,ISTO É , PRIMEIRA LIGACAO ANTES DE SE APRESENTAR SERVICOS
    if(etapa.length()==0){
    //VERIFICAR SE EXISTE A HASH
      if(h.existHash(hash)){
      //SE EXISTIR MANDA CODIGO 200
      out.println("200");  
      }else{
        //SE NAO EXISTIR MANDA CODIGO 400
      out.println("400");
      }
    
      //OPCAO 1 DO CLIENTE EM QUE SO É PESSIVEL EFETUAR CASO A HASH CONTINUE A SER PARTE DO SISTEMA(LISTA DE SERVICOS)
    }else if(etapa.equals("1")&&h.existHash(hash)){
      
      //VERIFICAR A NOSSA DECISAO
      String decisao=in.readLine();
      //ITERAR O NOSSO VETOR DE SERVICOS
      //UM TRY E UM CATCH CASO NAO HAJA SERVICOS
      try{
       //ITERAR
      for (int i = 0; i <= sv.getVect().size(); i++) {
        //COLOCAR NUMA LINHA DO BUFFER
        if(sv.getVect().get(i).getTipo_servico().equals(decisao)){
        out.println("ID: "+sv.getVect().get(i).getId_servico()+"name: "+sv.getVect().get(i).getDesignacao()+" ip: "+sv.getVect().get(i).getIp()+" tipo: "+sv.getVect().get(i).getTipo_servico());
        }
      }
       }catch(Exception e){
      //INFORMAR QUE NAO HA MAIS SERVICOS QUANDO DER OUT OF RANGE EM CASO DE NAO HAVER SERVICOS
      //CRIAR TIMESTAMP PARA O CLIENTE ???
      out.println("#####No more services available#####");
      }

      //OPCAO 2 DO CLIENTE EM QUE SO É PESSIVEL EFETUAR CASO A HASH CONTINUE A SER PARTE DO SISTEMA(CRIACAO DE SERVICOS)
    }else if(etapa.equals("2")&&h.existHash(hash)){
    //LER DESIGNACAO DO SERVICO
    String designacao_Servico=in.readLine();
    //LER IP DO SERVICO
    String ip_Servico=in.readLine();
    //LER TIPO DE SERVICO
    String tipo_servico=in.readLine();
    //CRIAR SERVICO E ADICIONA-LO AO VETOR
    sv.addService(new Service(designacao_Servico,ip_Servico,tipo_servico,hash));
    System.out.println("Criacao");
    out.println("Servico criado");
    }else if(etapa.equals("3")&&hash.equals("GOAL")){
    //LER DESIGNACAO
    String designacao=in.readLine();
    //IR BUSCAR O SIZE
    int lenght=sv.getVect().size();
    int index=-1;
    //ITERAR O VECTOR  
    for(int i=0;i<lenght;i++){
    //VERIFICAR SE O IP É IGUAL OU NAO ,SE FOR PARA A ITERACAO COM O BREAK
    if(sv.getVect().get(i).getDesignacao().equals(designacao)){
      index=i;
      break;
    }
    }
    String ip;
    //FAZER UM IF CONSOANTE A RESPOSTA
    if(index!=-1){
    //IR BUSCAR IP
    ip=sv.getVect().get(index).getIp();  
    }else{
    //NON IP 
    ip="NOPE";  
    }
    //ENVIAR RESPETIVO IP
    out.println(ip);
      
    }
    //ENCHER BUFFER OUT
    out.flush();
    //FECHAR IN
    in.close();
    //FECHAR OUT
    out.close();
    //FECHAR A LIGACAO
    ligacao.close();
   
    }

  }

}