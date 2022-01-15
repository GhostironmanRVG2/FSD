import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class CreateRegistry {
//ITENS
String designacao;
String ip;
String chave;
//CONSTRUTOR   
public CreateRegistry(String designacao,String ip , String chave){
this.ip=ip;
this.chave=chave;
this.designacao=designacao;    
}

//METODO PARA SIMPLESMENTE REGISTAR
void register() throws UnknownHostException, IOException{
    //CRIAR A SOCKET QUE VAI LIGAR
    Socket ligacao=new Socket("localhost",25563);
    //BUFFER READER
    BufferedReader in=new BufferedReader(new InputStreamReader(ligacao.getInputStream()));
    //PrintWriter
    PrintWriter out=new PrintWriter(ligacao.getOutputStream(),true);
    //ENVIAR MSG COM O TIPO DE SERVICO
    out.println("C");
    //ENVIAR HASH
    out.println(chave);
    //ENVIAR TIPO DE SERVICO
    out.println("2");
    //ENVIAR DESIGNACAO
    out.println(designacao);
    //ENVIAR IP DO SERVICO
    out.println(ip);
    int tem_porta;
    try{
        //VERIFICA SE TEM UMA PORTA.. SE TIVER PORTA RETORNA ERRO
        ip.substring(ip.lastIndexOf(":"));
        tem_porta=1;
        }catch(Exception error){
        tem_porta=0;
        }
    if(tem_porta==1){
    //TIPO DE SERVICO
    out.println("SOCKET");
    }else{
    out.println("RMI");
    }
    //PREENCHER BLOCO
    out.flush();
    //LER A RESPOSTA DO SERVIDOR
    String msgRecebida=in.readLine();
    System.out.println("[SERVER]->"+msgRecebida);
    //FECHAR LIGACAO
    ligacao.close();
    
}

}
