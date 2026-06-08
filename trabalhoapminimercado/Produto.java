/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhoapminimercado;

import java.util.Scanner;

/**
 *
 * @author Pedro
 */
public class Produto {
    public int codigo;
    public String nome;
    public float preco;
    public int qtdeEstoque;
    
    public Produto(){
        
    }

    public void imprime() {
        System.out.println("========================");
        System.out.println("Codigo: " + codigo);
        System.out.println("Nome do Produto: " + nome);
        System.out.printf("Preco do produto: %.2f", preco);
        System.out.print("\n");
        System.out.println("Quantidade em estoque: " + qtdeEstoque);
        System.out.println("========================");
    }
  
    public static Produto[] cadastrarProduto(Produto listaProdutos[]) {
        Scanner entrada = new Scanner(System.in);

        Produto p = new Produto();

        System.out.println("Codigo do produto:");
        p.codigo = entrada.nextInt();
        entrada.nextLine();
        
        System.out.println("Nome do produto:");
        p.nome = entrada.nextLine();
        
        System.out.println("Preco do produto:");
        p.preco = entrada.nextFloat();

        System.out.println("Quantidade em estoque:");
        p.qtdeEstoque = entrada.nextInt();

        Produto listaNovaP[] = new Produto[listaProdutos.length + 1];

        for(int i = 0; i < listaProdutos.length; i++) {

            listaNovaP[i] = listaProdutos[i];

        }

        listaNovaP[listaProdutos.length] = p;
        
        CsvUtil.salvar(listaNovaP, "produtos.csv");
        
        System.out.print("\n");
        System.out.println("===============================");
        System.out.println("Produto cadastrado com sucesso!");
        System.out.println("===============================");
        System.out.print("\n");
        
        return listaNovaP;
    }
    
    public static void listarProdutos (Produto listaProdutos[]) {
    for (int i = 0; i < listaProdutos.length; i++) {
            listaProdutos[i].imprime();      
       }
    }

    public static void buscarProdutos (Produto listaProdutos[]) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe o codigo do produto:");
        int busca = entrada.nextInt();
        
        for (int i = 0; i<listaProdutos.length; i++)
       if (busca == listaProdutos[i].codigo) {
           listaProdutos[i].imprime();
           System.out.println("\n");
       }
        else {
           System.out.print("Codigo nao encontrado");
           System.out.println("\n");
       }  
    }
    
    public static void alterarProduto (Produto listaProdutos[]) {
     Scanner entrada = new Scanner(System.in); 
     System.out.println("Digite o codigo do produto que deseja alterar:");
     int alter = entrada.nextInt();
     
      for (int i = 0; i<listaProdutos.length; i++)
       if (alter == listaProdutos[i].codigo) {
           Produto pNovo = new Produto();
           System.out.println("===Insira os novos dados===");
           System.out.print("\n");
           System.out.println("Novo codigo: ");
           pNovo.codigo = entrada.nextInt();
           entrada.nextLine();
           System.out.println("Novo nome: ");
           pNovo.nome = entrada.nextLine();
           System.out.println("Novo preco: ");
           pNovo.preco = entrada.nextFloat();
           System.out.println("Nova quantidade: ");
           pNovo.qtdeEstoque = entrada.nextInt();
           
           
           listaProdutos[i] = pNovo;
           CsvUtil.salvar(listaProdutos, "produtos.csv");
           
           System.out.println("============================");
           System.out.println("Alteracao concluida");
           System.out.println("============================");
       }
       else {
           System.out.print("Codigo nao encontrado!");
           System.out.println("\n");
       } 
    }
    
    public static Produto[] removerProduto (Produto listaProdutos[]) {
     Scanner entrada = new Scanner(System.in);
     System.out.println("Digite o codigo do produto que deseja remover:");
     int remover = entrada.nextInt();
     int indR = -1;
     
     for (int i = 0; i < listaProdutos.length; i++) 
        if (listaProdutos[i].codigo == remover) {
            indR = i; 
        }
        
        if (indR == -1) {
        System.out.println("Produto não encontrado!");
        return listaProdutos;  
    }
        Produto listaNovaPR[] = new Produto[listaProdutos.length - 1];
        
        int pN = 0;
    for (int i = 0; i < listaProdutos.length; i++) {
        
        if (i != indR) {
            listaNovaPR[pN] = listaProdutos[i];
            pN++;
        }
    }
    
    CsvUtil.salvar(listaNovaPR, "produtos.csv");
    
    System.out.print("\n");
    System.out.println("============================");
    System.out.println("Produto removido com sucesso!");
    System.out.println("============================");
    System.out.print("\n");
   
    return listaNovaPR;
     
        
    }   
}