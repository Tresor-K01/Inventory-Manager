import java.util.regex.MatchResult;

class Material{
    private String tipo;
    private double custoUnitario;
    private double quantidade;

    public  Material(String tipo, double custoUnitario, double quantidade){
        this.tipo = tipo;
        this.custoUnitario = custoUnitario;
        this.quantidade = quantidade;
    }

    public String getTipo(){
        return tipo;
    }
    public double getCustoUnitario(){
        return custoUnitario;
    }
    public double getQuantidade(){
        return quantidade;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public void setCustoUnitario(double custoUnitario){
        this.custoUnitario  = custoUnitario;
    }
    public void setQuantidade(double quantidade){
        this.quantidade = quantidade;
    }
    public void reduzirQuantidade(double q){
        if(q <= quantidade){
            quantidade -= q;
        } 
        else {
            System.out.println("Estoque insuficiente para " + tipo);
        }
    }
     @Override
    public String toString() {
        return "Tipo: " + tipo +
               " | Custo: R$" + custoUnitario +
               " | Quantidade: " + quantidade;
    }

}