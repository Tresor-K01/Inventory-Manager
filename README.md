# Sistema de Gestão de Estoque e Custos

> Meu primeiro projeto pessoal em Java, desenvolvido para aplicar os conceitos de Programação Orientada a Objetos (POO) e estruturas de dados.

## Sobre o Projeto

Este projeto é um sistema de console (CLI) para auxiliar no gerenciamento de estoque de materiais e no cálculo de custo de produção de móveis.

A aplicação permite que o usuário cadastre novos materiais, consulte o estoque disponível e, o mais importante, defina a composição de um novo produto (Móvel) para calcular automaticamente seu preço final com base no custo unitário dos materiais utilizados.

O sistema simula um fluxo de produção simples, ideal para pequenas marcenarias ou produções artesanais.

## Funcionalidades

O sistema oferece as seguintes opções no menu principal:

1.  **Cadastrar Materiais:** Adiciona novos tipos de materiais (ex: madeira, tinta, cola) ao estoque, com seu custo unitário e quantidade inicial.
2.  **Checagem e Busca de Materiais:** Permite visualizar a lista completa de materiais em estoque e buscar um item específico pelo nome.
3.  **Atualização de Materiais:** Ajusta a quantidade de um material existente (simulando uma compra de novo estoque ou uma perda).
4.  **Criar um Novo Móvel:** Define um novo produto, especificando o tempo de produção e os materiais (com suas respectivas quantidades) que serão consumidos para sua fabricação.
5.  **Cálculo do Preço Final:** Calcula o custo total de um produto com base nos materiais cadastrados e usados na composição.
6.  **Gerar Relatório Final:** Exporta um arquivo contendo um resumo da produção, o custo total dos materiais e o tempo total de execução do programa (simulando o tempo de produção).

## Tecnologias Utilizadas

* **Linguagem:** Java
* **Conceitos:**
    * Programação Orientada a Objetos (POO) - Uso de classes (`Material`, `Movel`) com métodos, atributos e encapsulamento.
    * Estruturas de Dados Dinâmicas (`ArrayList` para listas de materiais e produtos, `HashMap/Map` para mapear materiais em cada produto).
    * Manipulação de I/O (Entrada/Saída) - Uso da classe `Scanner` para interação no console e `FileWriter`/`PrintWriter` para gerar o relatório em arquivo.

## Como Executar o Projeto

Para rodar este projeto em seu ambiente local, siga os passos abaixo:

1.  **Clone o repositório:**
    ```bash
    git clone 
    ```
2.  **Compile as Classes:**
    Navegue até o diretório `InventoryManager` e compile os arquivos `.java`:
    ```bash
    javac Material.java Movel.java cadastroMateriais.java
    ```
3.  **Execute o Programa:**
    Inicie a aplicação através da classe principal:
    ```bash
    java cadastroMateriais
    ```

## Próximos Passos e Melhorias

* [ ] Implementar persistência de dados (salvar e carregar listas de materiais e produtos em arquivos de texto ou banco de dados) para que os dados não sejam perdidos ao encerrar o programa.
* [ ] Adicionar uma interface gráfica simples (GUI) usando Swing ou JavaFX.


Conecte-se comigo!

| **LinkedIn** | https://www.linkedin.com/in/kitsari/ |
| **Email** | tresorkitsari@exemplo.com |

---
