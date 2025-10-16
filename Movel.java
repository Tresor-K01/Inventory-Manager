import java.util.HashMap;
import java.util.Map;

class Movel {
    private String nome;
    private double tempoProducao;
    private double precoFinal;
    private Map<Material, Double> materiais = new HashMap<>();

    public Movel(String nome, double tempoProducao) {
        this.nome = nome;
        this.tempoProducao = tempoProducao;
    }

    public String getNome() { return nome; }
    public double getTempoProducao() { return tempoProducao; }
    public double getPrecoFinal() { return precoFinal; }

    public void setNome(String nome) {
        this.nome = nome; }
    public void setTempoProducao(double tempoProducao) { this.tempoProducao = tempoProducao; }

    public void adicionarMaterial(Material m, double q) {
        materiais.put(m, q);
    }

    public double calcularPrecoFinal() {
        double total = 0;
        for (Map.Entry<Material, Double> entry : materiais.entrySet()) {
            total += entry.getKey().getCustoUnitario() * entry.getValue();
        }
        precoFinal = total;
        return total;
    }
     @Override
    public String toString() {
        return "Móvel: " + nome + " (feito de " + materiais.keySet() + ")";
    }
}
