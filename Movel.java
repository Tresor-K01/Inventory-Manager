import java.util.HashMap;
import java.util.Map;

class Movel {
    private String nome;
    private double tempoProducao;
    private double precoFinal;
<<<<<<< HEAD
    private Map<String, Double> materiais = new HashMap<>();

    public Movel(String nome) { this.nome = nome; }
=======
    private Map<Material, Double> materiais = new HashMap<>();

    public Movel(String nome, double tempoProducao) {
        this.nome = nome;
        this.tempoProducao = tempoProducao;
    }
>>>>>>> f953b6b603b428aa575b34779c3fea6140b5d9cc

    public String getNome() { return nome; }
    public double getTempoProducao() { return tempoProducao; }
    public double getPrecoFinal() { return precoFinal; }

<<<<<<< HEAD
    public void setTempoProducao(double tempoProducao) { this.tempoProducao = tempoProducao; }

    public void adicionarMaterial(Material m, double q) {
        materiais.put(m.getTipo(), q);
    }

    public double calcularPrecoFinal(double vHora) {
        double custoMateriais = 0;
        for (Map.Entry<String, Double> entry : materiais.entrySet()) {
            custoMateriais += entry.getValue(); // apenas referência
        }
        double maoDeObra = tempoProducao * vHora;
        double custoIndireto = 0.15 * (custoMateriais + maoDeObra);
        precoFinal = (custoMateriais + maoDeObra + custoIndireto) * 1.5;
        return precoFinal;
    }

    @Override
    public String toString() {
        return "Móvel: " + nome + " | Tempo: " + tempoProducao + "h | Preço: R$" + precoFinal;
=======
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
>>>>>>> f953b6b603b428aa575b34779c3fea6140b5d9cc
    }
}
