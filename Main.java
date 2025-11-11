import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Estoque estoque = new Estoque();
        long inicio = System.currentTimeMillis();

        System.out.println("\nBem-vindo ao Sistema de Gerenciamento de Estoque!\n");
        int opcao;

        do {
            System.out.println("\n====== MENU PRINCIPAL ======");
            System.out.println("0 -> Encerrar");
            System.out.println("1 -> Cadastrar materiais");
            System.out.println("2 -> Listar materiais");
            System.out.println("3 -> Buscar material");
            System.out.println("4 -> Atualizar material");
            System.out.println("5 -> Calcular preço final");
            System.out.println("6 -> Cadastrar móvel");
            System.out.println("7 -> Gerar relatório final");
            System.out.print("Escolha uma opção: ");

            while (!entrada.hasNextInt()) {
                System.out.println("Entrada inválida! Digite um número:");
                entrada.next();
            }
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1 -> estoque.cadastrarMateriais(entrada);
                case 2 -> estoque.listarMateriais();
                case 3 -> estoque.buscarMaterial(entrada);
                case 4 -> estoque.atualizarMaterial(entrada);
                case 5 -> estoque.calcularPrecoUnitario(entrada);
                case 6 -> estoque.cadastrarMoveis(entrada);
                case 7 -> Relatorio.gerarRelatorioFinal(estoque, inicio);
                case 0 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        entrada.close();
    }
}
