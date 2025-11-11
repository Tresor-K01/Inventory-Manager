import java.util.HashMap;
import java.util.Map;

class Movel {
    private String nome;
    private double tempoProducao;
    private double precoFinal;
    private Map<String, Double> materiais = new HashMap<>();

    public Movel(String nome) { this.nome = nome; }

    public String getNome() { return nome; }
    public double getTempoProducao() { return tempoProducao; }
    public double getPrecoFinal() { return precoFinal; }

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
    }
}
