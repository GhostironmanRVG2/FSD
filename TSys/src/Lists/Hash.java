package Lists;
import java.util.Vector;
public class Hash {
//CRIAR UM VECTOR QUE ARMAZENA AS HASH`S DENTRO    
Vector<String> HashVec = new Vector<String>();     
public Hash(){}
//FUNCAO PARA ADICIONAR UMA HASH AO NOSSO VECTOR
public void addHash(String hash){
HashVec.add(hash);
}
//FUNCAO PARA VERIFICAR SE A HASH EXISTE DENTRO DO VECTOR OU NAO
public boolean existHash(String hash){
    //SE EXISTIR RETORNA TRUE SE NAO EXISTIR RETORNA FALSE
    if(HashVec.contains(hash)){
        return true;
    }else{
        return false;
    }
}

public Vector getVec(){
    return HashVec;
}


}
