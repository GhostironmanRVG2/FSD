package Lists;
import java.util.Vector;
import Lists.Service;
public class ServicesVector {
 //CRIAR UM VECTOR QUE ARMAZENA OS SERVICOS DENTRO    
Vector<Service> ServicesVec = new Vector<Service>();
//CRIAR UM CONSTRUTOR PARA O NOSSO SERVICEVECTOR
public ServicesVector(){}

//CRIAR UMA FUNCAO PARA ADICIONAR OBJETOS DENTRO DO VECTOR
public void addService(Service service){
    //VERIFICA SE O SERVICO COM ESSE IP EXISTE
    if(DoesContain(service.getChave())==-1){
    //ADICIONA O SERVICO
    if(ServicesVec.size()==0){
    service.setId_servico(1);
    }else{
    service.setId_servico(ServicesVec.lastElement().getId_servico()+1);
    }
    ServicesVec.add(service);
    }else{
        ServicesVec.get(DoesContain(service.getChave())).setDesignacao(service.getDesignacao());
        ServicesVec.get(DoesContain(service.getChave())).setTipo_servico(service.getTipo_servico());
        ServicesVec.get(DoesContain(service.getChave())).setIp(service.getIp());
    }
    
    
}

//METODO PARA IR BUSCAR O 
public Vector<Service> getVect(){
    return ServicesVec;
}
//VERIFICAR SE EXISTE UM OBJETO COM O IP DADO , RETORNA -1 CASO NAO , RETORNA O NUMERO DA INDEX CASO SIM
public int DoesContain(String chave){
    //IR BUSCAR O SIZE
 int lenght=ServicesVec.size();
 int index=-1;
 //ITERAR O VECTOR  
 for(int i=0;i<lenght;i++){
  //VERIFICAR SE O IP É IGUAL OU NAO ,SE FOR PARA A ITERACAO COM O BREAK
  if(ServicesVec.get(i).chave.equals(chave)){
      index=i;
      break;
  }
 }
//RETORNA O INDEX QUE CASO NAO EXISTA UM IP IGUAL RETORNA -1
return index;
}

    
}
