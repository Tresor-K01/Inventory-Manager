import java.io.*;
import java.time.*;
import java.time.format.*;

public class Relatorio {
    public static void salvarMovimentacao(String tipo, double qtd, double preco) {
        try (PrintWriter gravar = new PrintWriter(new FileWriter("relatorio.txt", true))) {
            String data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            gravar.printf("[%s] Material: %s | Quantidade: %.2f | Custo: R$ %.2f%n", data, tipo, qtd, preco);
        } catch (IOException e) {
            System.out.println("Erro ao salvar relatório: " + e.getMessage());
        }
    }

    public static void gerarRelatorioFinal(Estoque estoque, long inicio) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("Relatorio_Final.txt"))) {
            writer.println("====== RELATÓRIO FINAL ======\n");
            double total = 0;
            for (Material m : estoque.getMateriais()) {
                double subtotal = m.getCustoUnitario() * m.getQuantidade();
                writer.printf("Material: %-10s | Quantidade: %.2f | Subtotal: R$ %.2f%n",
                        m.getTipo(), m.getQuantidade(), subtotal);
                total += subtotal;
            }

            long duracao = System.currentTimeMillis() - inicio;
            writer.printf("%nCusto total: R$ %.2f%n", total);
            writer.printf("Tempo total: %.2f segundos%n", duracao / 1000.0);
            System.out.println("Relatório final salvo em 'Relatorio_Final.txt'");
        } catch (IOException e) {
            System.out.println("Erro ao gerar relatório: " + e.getMessage());
        }
    }
}
