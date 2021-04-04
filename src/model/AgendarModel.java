package model;

public class AgendarModel {
    private int idAgen;
    private int idCliente;
    private int idServ;
    private float valor;
    private String data;
    private String obs;
    
    public AgendarModel(int idAgen, int idCliente, int idServ, float valor, String data, String obs){
        this.idAgen = idAgen;
        this.idCliente = idCliente;
        this.idServ = idServ;
        this.valor = valor;
        this.data = data;
        this.obs = obs;
    }
    
    public AgendarModel(int idCliente, int idServ, float valor, String data, String obs){
        
        this.idCliente = idCliente;
        this.idServ = idServ;
        this.valor = valor;
        this.data = data;
        this.obs = obs;
    }
    
    public AgendarModel(int idAgen){
        this.idAgen = idAgen;   
    }
    
    public AgendarModel(int idAgen, String data){
        
        this.idAgen = idAgen;
        this.data = data;
    
    }
    

    public int getIdAgen() {
        return idAgen;
    }

    public void setIdAgen(int idAgen) {
        this.idAgen = idAgen;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdServ() {
        return idServ;
    }

    public void setIdServ(int IdServ) {
        this.idServ = IdServ;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public String getObs(){
        return obs;
    }
    
    public void setObs(String obs){
        this.obs = obs;
    }
    
}
