import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class cadastroMateriais{
    private static long tempoInicio;
    private static ArrayList <Material> listaMateriais = new ArrayList<>();
    private static ArrayList <Movel> listaMovel = new ArrayList<>();
    private Scanner entrada  = new Scanner(System.in);


    public static void main(String [] args){

        tempoInicio = System.currentTimeMillis();
        System.out.println("\n Bem-vindo ao sistema de gerenciamento de estoque!\n");
        int opcao;
        Scanner entrada = new Scanner(System.in);

        do{
            System.out.println("\n====== Gerenciador de Estoque ======\n");
            System.out.println("\n Escolha uma opção: \n");
            System.out.println("0 -> Encerrar");
            System.out.println("1 -> Cadastrar Materiais");
            System.out.println("2 -> Checagem de materiais");
            System.out.println("3 -> Buscar um material");
            System.out.println("4 -> Atualzação dos Materiais");
            System.out.println("5 -> Preço Final");
            System.out.println("6 -> Criar um novo Móvel");
            System.out.println("7 -> Gerar um relatório");
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1: 
                    cadastrarMateriais();
                    break;
                case 2:
                    checagem();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    atualizar();
                    break;
                case 5:
                    precoUnitario();
                    break;
                case 6:
                    cadastrarMoveis();
                    break;
                case 7:
                    gerarRelatorioFinal(tempoInicio);
                    break;
                case 0:
                    System.out.println("Encerrando....");
                    break;
            
                default:
                    break;
            }
        }while(opcao != 0);
    }
    private static void cadastrarMateriais() {
    Scanner entrada = new Scanner(System.in);

    System.out.println("Quantos materiais você deseja cadastrar? ");
    int n = entrada.nextInt();
    entrada.nextLine();
    

    for (int i = 0; i < n; i++) {
        if (i == 0) {
            System.out.print("-> Informe o tipo de material: ");
        } else {
            System.out.print("-> Informe o tipo do outro material: ");
        }
        
        String tipo = entrada.nextLine();

        System.out.print("-> Informe o custo unitário de" + " " + tipo + ": ");
        double custoUnitario = entrada.nextDouble();

        System.out.print("-> Informe a quantidade de" + " " + tipo + ": ");
        int quantidade = entrada.nextInt();
        entrada.nextLine();

        Material m = new Material(tipo, custoUnitario, quantidade);
        listaMateriais.add(m);

        System.out.println("\nMaterial cadastrado com sucesso!\n");
    }
}
private static boolean reservarMaterial(String tipo, int quantidade){
    for(Material m : listaMateriais){
        if(m.getTipo().equalsIgnoreCase(tipo)){
            if(m.getQuantidade() >= quantidade){
                m.setQuantidade(m.getQuantidade() - quantidade);
                System.out.println("Reserva realizada com sucesso!");
                return true;
            } else {
                System.out.println("\nReserva não realizada. A quantidade pedida não corresponde ao estoque!");
                return false;
            }
        }
    }
    System.err.println("Material não encontrado!");
    return false;
}
private static void cadastrarMoveis(){
    Scanner entrada = new Scanner(System.in);
    System.out.print("--> Informe a quantidade de móveis que deseja cadastrar: ");
    int n = entrada.nextInt();
    entrada.nextLine();
    
    for(int i = 0; i < n; i++){
        System.out.println("1. Informe o nome do móvel: ");
        String nome = entrada.nextLine();
        
        System.out.print("2. Informe a quantidade de materiais necessária: ");
        int num = entrada.nextInt();
        entrada.nextLine();
        
        boolean encontrado = true;
        for(int j = 0; j < num; j++){
            if (j == 0) {
                System.out.print("3. Informe o tipo do material: ");
            } else {
                System.out.print("-> Informe o tipo do outro material: ");
            }
            String tipo = entrada.nextLine();
            
            System.out.print("4. Informe a quantidade de" + " " + tipo + ": " );
            int quantidade2 = entrada.nextInt();
            entrada.nextLine();
            
            if(!reservarMaterial(tipo, quantidade2)){
                encontrado = false;
                break;
            }
        }
        
        if(encontrado){
            System.out.print("5. Informe o tempo de produção: ");
            double tempoProducao = entrada.nextDouble();
            entrada.nextLine();
            
            Movel b = new Movel(nome, tempoProducao);
            listaMovel.add(b);
            System.out.println("\nNova tarefa Salva!\n");
        }
    }
}
    private static void checagem(){
        if(listaMateriais.isEmpty()){
            System.err.print("\nNenhum material foi registrado!\n");
        }
        else{
            System.out.println("\n     Lista de materiais    \n");
            for(Material m: listaMateriais){
                System.out.println(m);
            }
        }
    }
    private static void buscar(){
        Scanner entrada = new Scanner(System.in);
        System.out.print("--> Informe o tipo de material: ");
        String tipo = entrada.nextLine();
        for(Material m : listaMateriais){
            if(m.getTipo().equalsIgnoreCase(tipo)){
                System.err.println(m);
                return;
            }
        }
        System.out.println("Material não existente!");

    }
    private static void atualizar(){
        Scanner entrada = new Scanner(System.in);
        System.out.print("--> Informe o tipo de material a ser atualizado: ");
        String tipo = entrada.nextLine();
        boolean encontrado = false;
        for(Material m: listaMateriais){
            if(m.getTipo().equalsIgnoreCase(tipo)){
                System.out.print("--> Informe o novo custo unitário de" + " " + tipo + ": ");
                m.setCustoUnitario(entrada.nextDouble());
                System.out.print("--> Informe a nova quantidade de" + " " + tipo + ": ");
                double NewQuantity = entrada.nextDouble();
                m.setQuantidade(m.getQuantidade() + NewQuantity);
                System.out.println("\nAtualização realizada com sucesso!\n");
                encontrado = true;
                break;
            }

        }
        if(!encontrado){
            System.err.println("Material não encontrado!");
        }
    }
    private static void precoUnitario(){
    if(listaMateriais.isEmpty()){
        System.out.println("Lista vazia!");
        return;
    }
    Scanner entrada = new Scanner(System.in);
    System.out.print("--> Informe a quantidade de material usado: ");
    int n = entrada.nextInt();
    entrada.nextLine();

    try {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHora = agora.format(formato);

        FileWriter arquivo = new FileWriter("relatorio.txt", true);
        PrintWriter gravar = new PrintWriter(arquivo);

        gravar.println("<=====> RELATÓRIO DE MATERIAIS <=====>");
        gravar.println("Operação realizada em: " + dataHora);

        double somaTudo = 0.0;

        for(int i = 0; i < n; i++){
            System.out.print("--> Qual é o tipo de material: ");
            String tipo = entrada.nextLine();

            Material encontrado = null;
            for(Material m: listaMateriais){
                if(m.getTipo().equalsIgnoreCase(tipo)){
                    encontrado = m;
                    break;
                }
            }
            if(encontrado != null){
                System.out.print("--> Informe a quantidade usada: ");
                double q = entrada.nextDouble();
                entrada.nextLine();

                if(q > encontrado.getQuantidade()){
                    System.out.println("Estoque insuficiente! Restam apenas " 
                                       + encontrado.getQuantidade() + " unidades.");
                    gravar.println("Material " + tipo + " com estoque insuficiente! Restam apenas " 
                                   + encontrado.getQuantidade());
                    continue;
                }
                encontrado.reduzirQuantidade(q);

                System.out.print("--> Informe o tempo de produção: ");
                int tempoProducao = entrada.nextInt();
                entrada.nextLine();
                double vhora = 10;
                
                double precoMaterial = q * encontrado.getCustoUnitario();
                double maoDeObra = tempoProducao*vhora;
                double custoIndireto = 0.15*(precoMaterial+maoDeObra);
                double custoTotal = (precoMaterial + custoIndireto + maoDeObra);
                double PV = custoTotal*(1.50);
                somaTudo += PV;

                System.out.println("Custo final de " + tipo + ": R$" + PV);
                gravar.println("Material: " + tipo + " || Quantidade: " + q + " || Custo: R$" + PV);
                System.out.println("Custo total do brinquedo: R$" + somaTudo);
            }
            else{
                System.out.println("Material " + tipo + " não encontrado!");
                gravar.println("Material " + tipo + " não encontrado!");
            }
        }

        gravar.println("----------------------------------");
        gravar.println("Custo total do brinquedo: R$" + somaTudo);
        gravar.println();

        gravar.close();
        arquivo.close();

        System.out.println("--------------------------------------------------");
        System.out.println("Relatório salvo em relatorio.txt");

    } catch (IOException e) {
        System.out.println("Erro ao gerar relatório: " + e.getMessage());
    }
}
private static void gerarRelatorioFinal(long tempoInicio) {
    try {
        FileWriter writer = new FileWriter("Relatorio_Final.txt");
        writer.write(" \n<<<<<<<< RELATÓRIO DE PRODUÇÃO >>>>>>>> \n\n");
        writer.write("Estoque Atualizado:\n");

        double custoTotal = 0;
        double somaCustos = 0;
        int contador = 0;

        for (Material m : listaMateriais) {
            double subtotal = m.getCustoUnitario() * m.getQuantidade();
            writer.write(String.format("Tipo: %s || Custo: R$%.2f || Quantidade: %.2f || Subtotal: R$%.2f\n",
                    m.getTipo(), m.getCustoUnitario(), m.getQuantidade(), subtotal));
            custoTotal += subtotal;
            somaCustos += m.getCustoUnitario();
            contador++;
        }

        double custoMedio = (contador > 0) ? (somaCustos / contador) : 0;
        long tempoFim = System.currentTimeMillis();
        long duracaoMs = tempoFim - tempoInicio;

        long horas = TimeUnit.MILLISECONDS.toHours(duracaoMs);
        long minutos = TimeUnit.MILLISECONDS.toMinutes(duracaoMs) % 60;
        long segundos = TimeUnit.MILLISECONDS.toSeconds(duracaoMs) % 60;

        writer.write("\n-----------------------------\n");
        writer.write(String.format("Tempo total de produção: %02d:%02d:%02d (h:m:s)\n", horas, minutos, segundos));
        writer.write(String.format("Custo médio por produto: R$%.2f\n", custoMedio));
        writer.write(String.format("Custo total da produção: R$%.2f\n", custoTotal));
        writer.close();

        System.out.println("\nRelatório gerado com sucesso em 'Relatorio_Final.txt'!\n");

    } catch (IOException e) {
        System.out.println("Erro ao gerar o relatório: " + e.getMessage());
    }
}




}