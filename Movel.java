import java.util.HashMap;
import java.util.Map;

class Movel {
    private String nome;
    private double tempoProducao;
    private double precoFinal;
    // Alterado para usar Material como chave para acessar o custo unitário
    private Map<Material, Double> materiais = new HashMap<>(); 

    public Movel(String nome) { this.nome = nome; } // Mantém construtor simples

    public String getNome() { return nome; }
    public double getTempoProducao() { return tempoProducao; }
    public double getPrecoFinal() { return precoFinal; }

    public void setTempoProducao(double tempoProducao) { this.tempoProducao = tempoProducao; }

    public void adicionarMaterial(Material m, double q) {
        materiais.put(m, q); // Armazena o objeto Material
    }

    public double calcularPrecoFinal(double vHora) {
        double custoMateriais = 0;
        // Agora calcula o custo real dos materiais usando o objeto Material
        for (Map.Entry<Material, Double> entry : materiais.entrySet()) {
            custoMateriais += entry.getKey().getCustoUnitario() * entry.getValue(); 
        }
        double maoDeObra = tempoProducao * vHora;
        double custoIndireto = 0.15 * (custoMateriais + maoDeObra);
        precoFinal = (custoMateriais + maoDeObra + custoIndireto) * 1.5;
        return precoFinal;
    }

    @Override
    public String toString() {
        return String.format("Móvel: %s | Tempo: %.2fh | Preço: R$ %.2f", nome, tempoProducao, precoFinal);
    }
}