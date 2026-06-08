package com.mycompany.trabalhoapminimercado;

import java.util.Scanner;

public class TrabalhoAPMiniMercado {

    public static Produto[] listaProdutos = new Produto[0];
    public static Cliente[] listaClientes = new Cliente[0];

    public static void main(String[] args) {
        listaProdutos = CsvUtil.ler("produtos.csv", Produto.class);
        listaClientes = CsvUtil.ler("clientes.csv", Cliente.class);
    
        imprimirMenuInicial();
        imprimirMenuPrincipal();

        int opcao = lerOpcao();

        while (opcao != 0) {
            Screen.clear();

            if (opcao == 1) {
                Screen.clear();

                int opcaoP = menuProdutos();

                while (opcaoP != 0) {
                    Screen.clear();

                    if (opcaoP == 1) {
                        listaProdutos = Produto.cadastrarProduto(listaProdutos);
                    }
                    else if (opcaoP == 2) {
                        Produto.listarProdutos(listaProdutos);
                    }
                    else if (opcaoP == 3) {
                        Produto.buscarProdutos(listaProdutos);
                    }
                    else if (opcaoP == 4) {
                        Produto.alterarProduto(listaProdutos);
                    }
                    else if (opcaoP == 5) {
                        listaProdutos = Produto.removerProduto(listaProdutos);
                    }
                    opcaoP = menuProdutos();
                }
            }

            else if (opcao == 2) {
                Screen.clear();

                int opcaoC = menuClientes();
                
                while (opcaoC != 0) {
                    Screen.clear();

                    if (opcaoC == 1) {
                        listaClientes = Cliente.cadastrarCliente(listaClientes);
                    }
                    else if (opcaoC == 2) {
                        Cliente.listarCliente(listaClientes);
                    }
                    else if (opcaoC == 3) {
                        Cliente.buscarCliente(listaClientes);
                    }
                    else if (opcaoC == 4) {
                        Cliente.alterarCliente(listaClientes);
                    }
                    else if (opcaoC == 5) {
                        listaClientes = Cliente.removerCliente(listaClientes);
                    }

                    opcaoC = menuClientes();
                }
            }

            else if (opcao == 3) {
                Screen.clear();
                Cliente clienteAtual = Compra.cadastroCompra(listaClientes);
                Screen.clear();
                
                ItemCarrinho[] meuCarrinho = Compra.realizarCompra(listaProdutos, listaClientes);
                Screen.clear();
                
                Compra.imprimirCompra(meuCarrinho);
            }

            else if (opcao == 4) {
                Screen.clear();

                int opcaoE = menuEstoque();

                while (opcaoE != 0) {
                    Screen.clear();

                    if (opcaoE == 1) {
                        Produto.listarProdutos(listaProdutos);
                    }
                    if (opcaoE == 2) {
                        Estoque.alterarEstoque(listaProdutos);
                        
                        CsvUtil.salvar(listaProdutos, "produtos.csv");
                    }
                    opcaoE = menuEstoque();
                }
            }
            imprimirMenuPrincipal();
            opcao = lerOpcao();
        }
    }

    public static void imprimirMenuInicial() {

        System.out.println("====================");
        System.out.println("====================");
        System.out.println("PROJETO MINI MERCADO");
        System.out.println("====================");
        System.out.println("====================");
        System.out.println();
    }

    public static void imprimirMenuPrincipal() {

        System.out.println("====================");
        System.out.println("========MENU========");
        System.out.println("====================");
        System.out.println("1. Produtos");
        System.out.println("2. Clientes");
        System.out.println("3. Realizar Compra");
        System.out.println("4. Controle de Estoque");
        System.out.println("0. Sair");
        System.out.println("====================");
    }

    public static int lerOpcao() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Informe um numero:");       
        int opcao = entrada.nextInt();

        return opcao;
    }

    public static int menuProdutos() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("========PRODUTOS========");
        System.out.println("1. Cadastrar Produtos");
        System.out.println("2. Listar Produtos");
        System.out.println("3. Buscar Produto");
        System.out.println("4. Alterar Produto");
        System.out.println("5. Remover Produto");
        System.out.println("0. Voltar");

        int opcaoP = entrada.nextInt();

        return opcaoP;
    }

    public static int menuClientes() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("========CLIENTES========");
        System.out.println("1. Cadastrar Cliente");
        System.out.println("2. Listar Clientes");
        System.out.println("3. Buscar Clientes");
        System.out.println("4. Alterar Clientes");
        System.out.println("5. Remover Cliente");
        System.out.println("0. Voltar");

        int opcaoC = entrada.nextInt();

        return opcaoC;
    }

    public static int menuEstoque() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("========ESTOQUE========");
        System.out.println("1. Listar Estoque");
        System.out.println("2. Alterar Estoque");
        System.out.println("0. Voltar");

        int opcaoE = entrada.nextInt();

        return opcaoE;
    }
}