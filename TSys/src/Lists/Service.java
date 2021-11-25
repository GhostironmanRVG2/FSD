package Lists;
public class Service {
    String designacao,ip,tipo_servico;
    int count=0;
    //CRIAR OBJETO DO TIPO SERVICO
    public Service(String designacao,String ip,String tipo_servico){
        this.designacao=designacao;
        this.ip=ip;
        this.tipo_servico=tipo_servico;
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
    public String getTipo_servico() {
        return tipo_servico;
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
    public void setTipo_servico(String tipo_servico) {
        this.tipo_servico = tipo_servico;
    }


}
