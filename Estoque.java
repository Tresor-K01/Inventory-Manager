import java.util.*;
import java.io.*;
import java.time.*;

public class Estoque {
    private final List<Material> listaMateriais = new ArrayList<>();
    private final List<Movel> listaMoveis = new ArrayList<>();

    public Material encontrarMaterial(String tipo) {
        for (Material m : listaMateriais)
            if (m.getTipo().equalsIgnoreCase(tipo)) return m;
        return null;
    }

    public void cadastrarMateriais(Scanner entrada) {
        System.out.print("Quantos materiais deseja cadastrar? ");
        int n = entrada.nextInt(); entrada.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Tipo do material: ");
            String tipo = entrada.nextLine();

            System.out.print("Custo unitário de " + tipo + ": ");
            double custo = entrada.nextDouble();

            System.out.print("Quantidade: ");
            double qtd = entrada.nextDouble();
            entrada.nextLine();

            listaMateriais.add(new Material(tipo, custo, qtd));
            System.out.println("Material cadastrado com sucesso!\n");
        }
    }

    public void listarMateriais() {
        if (listaMateriais.isEmpty()) {
            System.out.println("Nenhum material cadastrado!");
            return;
        }
        System.out.println("\n--- Lista de Materiais ---");
        listaMateriais.forEach(System.out::println);
    }

    public void buscarMaterial(Scanner entrada) {
        System.out.print("Tipo do material: ");
        String tipo = entrada.nextLine();
        Material m = encontrarMaterial(tipo);
        System.out.println((m != null) ? m : "Material não encontrado!");
    }

    public void atualizarMaterial(Scanner entrada) {
        System.out.print("Tipo do material a atualizar: ");
        String tipo = entrada.nextLine();
        Material m = encontrarMaterial(tipo);
        if (m == null) {
            System.out.println("Material não encontrado!");
            return;
        }

        System.out.print("Novo custo unitário: ");
        m.setCustoUnitario(entrada.nextDouble());
        System.out.print("Quantidade adicional: ");
        m.setQuantidade(m.getQuantidade() + entrada.nextDouble());
        entrada.nextLine();

        System.out.println("Material atualizado com sucesso!");
    }

    public void cadastrarMoveis(Scanner entrada) {
        System.out.print("Quantos móveis deseja cadastrar? ");
        int n = entrada.nextInt(); entrada.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Nome do móvel: ");
            String nome = entrada.nextLine();

            Movel movel = new Movel(nome);
            System.out.print("Quantidade de materiais necessários: ");
            int q = entrada.nextInt(); entrada.nextLine();

            for (int j = 0; j < q; j++) {
                System.out.print("Tipo de material: ");
                String tipo = entrada.nextLine();
                Material m = encontrarMaterial(tipo);

                if (m == null) {
                    System.out.println("Material não encontrado!");
                    continue;
                }

                System.out.print("Quantidade usada: ");
                double qtd = entrada.nextDouble(); entrada.nextLine();

                if (qtd > m.getQuantidade()) {
                    System.out.println("Estoque insuficiente!");
                    continue;
                }

                m.reduzirQuantidade(qtd);
                movel.adicionarMaterial(m, qtd);
            }

            System.out.print("Tempo de produção (horas): ");
            movel.setTempoProducao(entrada.nextDouble());
            entrada.nextLine();

            movel.calcularPrecoFinal(10.0); // R$10 por hora
            listaMoveis.add(movel);
            System.out.println("Móvel cadastrado com sucesso!\n");
        }
    }

    public void calcularPrecoUnitario(Scanner entrada) {
        System.out.print("Tipo do material: ");
        String tipo = entrada.nextLine();
        Material m = encontrarMaterial(tipo);
        if (m == null) {
            System.out.println("Material não encontrado!");
            return;
        }

        System.out.print("Quantidade usada: ");
        double q = entrada.nextDouble();
        entrada.nextLine();

        if (q > m.getQuantidade()) {
            System.out.println("Estoque insuficiente!");
            return;
        }

        m.reduzirQuantidade(q);
        double preco = q * m.getCustoUnitario();
        System.out.printf("Preço total de %s: R$ %.2f\n", tipo, preco);

        Relatorio.salvarMovimentacao(tipo, q, preco);
    }

    public List<Material> getMateriais() { return listaMateriais; }
    public List<Movel> getMoveis() { return listaMoveis; }
}
