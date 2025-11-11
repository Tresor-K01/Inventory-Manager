<<<<<<< HEAD
class Material {
=======
import java.util.regex.MatchResult;

class Material{
>>>>>>> f953b6b603b428aa575b34779c3fea6140b5d9cc
    private String tipo;
    private double custoUnitario;
    private double quantidade;

<<<<<<< HEAD
    public Material(String tipo, double custoUnitario, double quantidade) {
=======
    public  Material(String tipo, double custoUnitario, double quantidade){
>>>>>>> f953b6b603b428aa575b34779c3fea6140b5d9cc
        this.tipo = tipo;
        this.custoUnitario = custoUnitario;
        this.quantidade = quantidade;
    }
<<<<<<< HEAD
 
    public String getTipo() { return tipo; }
    public double getCustoUnitario() { return custoUnitario; }
    public double getQuantidade() { return quantidade; }

    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setCustoUnitario(double custoUnitario) { this.custoUnitario = custoUnitario; }
    public void setQuantidade(double quantidade) { this.quantidade = quantidade; }

    public void reduzirQuantidade(double q) {
        if (q <= quantidade) quantidade -= q;
        else System.out.println("Estoque insuficiente para " + tipo);
    }

    @Override
    public String toString() {
        return String.format("Tipo: %-10s | Custo: R$ %.2f | Quantidade: %.2f",
                tipo, custoUnitario, quantidade);
    }
}
=======

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
>>>>>>> f953b6b603b428aa575b34779c3fea6140b5d9cc
