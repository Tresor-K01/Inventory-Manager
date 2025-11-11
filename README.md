
# Gerenciamento de Estoque de Móveis (Inventory Manager)

Um sistema simples de linha de comando (CLI) desenvolvido em Java para gerenciar materiais de estoque, cadastrar móveis e calcular seus custos de produção e preço final.

## Funcionalidades

O sistema permite realizar as seguintes operações através de um menu interativo:

* **Cadastrar Materiais:** Adicionar novos materiais ao estoque (tipo, custo unitário e quantidade inicial).
* **Listar Materiais:** Exibir todos os materiais atualmente em estoque.
* **Buscar e Atualizar Material:** Encontrar um material pelo tipo e modificar seu custo ou adicionar quantidade.
* **Cadastrar Móveis:** Registrar um novo móvel, especificando os materiais necessários (e reduzindo a quantidade do estoque) e o tempo de produção.
* **Calcular Preço Final:** Calcula o preço final de venda de um móvel com base no custo dos materiais, mão de obra (R$10/hora) e custos indiretos (15%).
* **Relatórios:**
    * `relatorio.txt`: Salva o registro de movimentação de materiais usados nos cálculos de preço.
    * `Relatorio_Final.txt`: Gera um relatório final com o custo total do estoque e a duração do uso do sistema.

## Tecnologias Utilizadas

* **Linguagem de Programação:** Java
* **Estrutura de Dados:** `ArrayList` para listas de materiais e móveis, `HashMap` para armazenar materiais em móveis.
* **I/O:** `Scanner` para entrada de dados e `PrintWriter`/`FileWriter` para geração de relatórios em arquivo.

## Como Executar o Projeto

Para rodar este projeto na sua máquina, siga os passos abaixo:

### Pré-requisitos

Certifique-se de ter o **Java Development Kit (JDK) 8** ou superior instalado.

### Compilação e Execução

1.  **Navegue** até o diretório raiz do projeto no seu terminal.
2.  **Compile** os arquivos `.java`:
    ```bash
    javac Main.java Estoque.java Material.java Movel.java Relatorio.java
    ```
3.  **Execute** o programa principal:
    ```bash
    java Main
    ```

O menu principal será exibido, permitindo que você interaja com o sistema.

##  Estrutura do Projeto

O projeto é composto pelas seguintes classes:

* `Main.java`: Contém o loop principal do programa e o menu de interação.
* `Estoque.java`: Gerencia as listas de `Material` e `Movel` e implementa a maior parte da lógica de negócios (cadastro, busca, atualização e cálculo).
* `Material.java`: Define a estrutura dos materiais (tipo, custo unitário, quantidade).
* `Movel.java`: Define a estrutura dos móveis (nome, tempo de produção, preço final) e calcula o custo.
* `Relatorio.java`: Contém métodos estáticos para salvar logs de movimentação e gerar o relatório final de custos.

---

Este README é uma documentação viva. Fique à vontade para expandi-lo com detalhes específicos sobre a lógica de cálculo ou novos recursos!
