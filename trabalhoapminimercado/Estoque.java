package com.mycompany.trabalhoapminimercado;

import java.util.Scanner;

public class Estoque {
    
    public Estoque(){
        
    }
  
    public static void alterarEstoque(Produto listaProdutos[]) {
        Scanner entrada = new Scanner(System.in); 
        
        System.out.println("Digite o código do produto em que deseja alterar o estoque:");
        
        int alter = entrada.nextInt();
        
        for (int i = 0; i<listaProdutos.length; i++) {
            if (alter == listaProdutos[i].codigo) {              
                System.out.println("Produto: " + listaProdutos[i].nome);
                System.out.println("Estoque atual: " + listaProdutos[i].qtdeEstoque);                
                
                System.out.println("Digite a nova quantidade do estoque:");
                 listaProdutos[i].qtdeEstoque = entrada.nextInt();                
                
                System.out.println("============================");
                System.out.println("Alteração concluída");
                System.out.println("============================");
            }
            else {
                System.out.println("Produto não encontrado!");
            }
        }
    }

}