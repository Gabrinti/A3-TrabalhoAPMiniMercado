/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhoapminimercado;

import java.util.Scanner;


class ItemCarrinho {
    public Produto produto;
    public int quantidade;
    public float subtotal;
}

public class Compra {
  
  public Compra() {
  
  }
  
  public static Cliente cadastroCompra (Cliente[] listaClientes) {
       Scanner entrada = new Scanner (System.in);
        Screen.clear();
        System.out.println("========COMPRA========");
        System.out.println("=====================");
        System.out.println("Sou cadastrado (S/N)");
        System.out.println("=====================");
        String op = entrada.next().toUpperCase();       
        entrada.nextLine();
        
        
        if(op.equals ("S")) {
            
            if (listaClientes == null || listaClientes.length == 0) {
            System.out.println("\n[Aviso] Não há nenhum cliente cadastrado no sistema!");
            System.out.println("Pressione ENTER para continuar...");
            entrada.nextLine(); 
            return null;
        }
         System.out.println("Informe o ID do cliente;");
         String busca = entrada.nextLine().trim();
         
         
            for(int i = 0; i<listaClientes.length; i++) {
                
               if(busca.equals(listaClientes[i].id)) {
               System.out.println("Cliente encontrado: " + listaClientes[i].nome);
               System.out.println("Pressione ENTER para ir para o carrinho...");
               entrada.nextLine();
               return listaClientes[i];
               } 
            }
            
        System.out.println("Cliente nao encontrado no sistema!");
        System.out.println("Pressione ENTER para continuar...");
        entrada.nextLine();                     
        }
          
        return null;
    }
  
  public static ItemCarrinho[] realizarCompra(Produto[] listaProdutos, Cliente[] listaClientes) {
  ItemCarrinho[] carrinho = new ItemCarrinho[0];
  Scanner entrada = new Scanner (System.in);
  int continuarAdicionando = 1;
  
  
  while (continuarAdicionando == 1) {
    boolean verif = false;
    Screen.clear();
   System.out.println("Informe o codigo do produto");
   int cod = entrada.nextInt();   
   System.out.println("Informe a quantidade de produtos");
   int qtde = entrada.nextInt();
   
   Produto prodE = null;
   for (int i = 0; i < listaProdutos.length; i++) {
     if (listaProdutos[i].codigo == cod && listaProdutos[i].qtdeEstoque >= qtde) {
        prodE = listaProdutos[i];
        verif = true;
        break;
     }    
   } 
   
   if (prodE == null) {
   System.out.println("Produto nao encontrado no sistema!");
     }
   else {
   System.out.println("Produto encontrado no sistema: "+prodE.nome);
   System.out.printf("Preco: R$ %.2f", prodE.preco);
   }
   
    if (verif == false) {
      System.out.println("Quantidade do estoque insuficiente!"); 
    }
    else {
        prodE.qtdeEstoque -= qtde;
        
        ItemCarrinho item = new ItemCarrinho();
                    item.produto = prodE;
                    item.quantidade = qtde;
                    item.subtotal = prodE.preco * qtde;
                    
        ItemCarrinho[] novoCarrinho = new ItemCarrinho[carrinho.length + 1];
                    for (int i = 0; i < carrinho.length; i++) {
                        novoCarrinho[i] = carrinho[i];
                    }
                    novoCarrinho[carrinho.length] = item;
                    carrinho = novoCarrinho;
                    
                    System.out.println("\nItem adicionado no carrinho com sucesso!");            
    }
            System.out.println("\nDeseja adicionar mais um produto? (1 - Sim / 2 - Nao)");
            continuarAdicionando = entrada.nextInt();
   }
  
    if (carrinho.length > 0) {
            CsvUtil.salvar(listaProdutos, "produtos.csv");
            System.out.println("[Sistema] Arquivo de produtos atualizado com o novo estoque!");
        }
    
     return carrinho;       
  }
  
  public static void imprimirCompra (ItemCarrinho[] carrinho) {
      Scanner entrada = new Scanner (System.in);
     if (carrinho.length > 0) {
       Screen.clear();
            System.out.println("===============================================");
            System.out.println("                TOTAL COMPRA                   ");
            System.out.println("==============================================="); 
            System.out.printf ("%-15s %-5s %-10s %-10s\n", "Item", "Qtd", "Unit", "Subtotal");    
            System.out.println("===============================================");
            
        float totalGeral = 0;
        
        for (int i = 0; i < carrinho.length; i++) {
                ItemCarrinho item = carrinho[i];
                System.out.printf("%-15s %-5d R$ %-7.2f R$ %-7.2f\n",item.produto.nome,item.quantidade,item.produto.preco,item.subtotal);
                totalGeral += item.subtotal;
            }
            
            System.out.println("===============================================");
            System.out.printf ("VALOR TOTAL DA COMPRA: R$ %.2f", totalGeral);
            System.out.println("\n===============================================");
     }
     else {
            System.out.println("Nenhum item no carrinho!");
        }
     
        
        System.out.println("\nPressione ENTER para voltar ao menu principal...");
        entrada.nextLine();
        entrada.nextLine();
  }
          
          
          
}
