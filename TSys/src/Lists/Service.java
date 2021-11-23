package Lists;
public class Service {
    String designacao,ip;
    int count=0;
    //CRIAR OBJETO DO TIPO SERVICO
    public Service(String designacao,String ip){
        this.designacao=designacao;
        this.ip=ip;
    }
    //GETS
    public String getDesignacao() {
        return designacao;
    }

    public int getCount() {
        return count;
    }
    
    public String getIp() {
        return ip;
    }
   
    //SETTERS
    public void setCount() {
        this.count = this.count+1;
    }
    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }


}
