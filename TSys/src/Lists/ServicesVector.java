package Lists;
import java.util.Vector;
import Lists.Service;
public class ServicesVector {
 //CRIAR UM VECTOR QUE ARMAZENA AS HASH`S DENTRO    
Vector<Service> ServicesVec = new Vector<Service>();
//CRIAR UM CONSTRUTOR PARA O NOSSO SERVICEVECTOR
public ServicesVector(){}

//CRIAR UMA FUNCAO PARA ADICIONAR OBJETOS DENTRO DO VECTOR
public void addService(Service service){
    //ADICIONAR O SERVICO AO NOSSO VECTOR
    ServicesVec.add(service);
}

//METODO PARA IR BUSCAR O 
public Vector<Service> getVect(){
    return ServicesVec;
}
//VERIFICAR SE EXISTE UM OBJETO COM O IP DADO , RETORNA -1 CASO NAO , RETORNA O NUMERO DA INDEX CASO SIM
public int DoesContain(String ip){
    //IR BUSCAR O SIZE
 int lenght=ServicesVec.size();
 int index=-1;
 //ITERAR O VECTOR  
 for(int i=0;i<lenght;i++){
  //VERIFICAR SE O IP É IGUAL OU NAO ,SE FOR PARA A ITERACAO COM O BREAK
  if(ServicesVec.get(i).ip.equals(ip)){
      index=i;
      break;
  }
 }
//RETORNA O INDEX QUE CASO NAO EXISTA UM IP IGUAL RETORNA -1
return index;
}

    
}
