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
public class Cliente {
    public String cpf;
    public String nome;
    public String telefone;
    public String email;
    public String id;
    
    public Cliente(){
        
    }

    public void imprime() {
        System.out.println("========================");
        System.out.println("ID: " + id);
        System.out.println("CPF: " + cpf);
        System.out.println("Nome do Cliente: " + nome);
        System.out.println("Telefone do cliente: " + telefone);
        System.out.println("E-mail do cliente: " + email);
        System.out.println("========================");
    }
    
    public static Cliente[] cadastrarCliente(Cliente listaClientes[]) {
        Scanner entrada = new Scanner(System.in);
        
        Cliente c = new Cliente();
       
        System.out.println("ID do cliente:");
        c.id = entrada.nextLine();
        
        System.out.println("CPF do cliente:");
        c.cpf = entrada.nextLine();
        
        System.out.println("Nome do cliente:");
        c.nome = entrada.nextLine();
        
        System.out.println("Telefone do cliente:");
        c.telefone = entrada.nextLine();
        
        System.out.println("E-mail do cliente:");
        c.email = entrada.nextLine();
        
        Cliente listaNova[] = new Cliente[listaClientes.length + 1];
        for (int i = 0; i < listaClientes.length; i++) {
            listaNova[i] = listaClientes[i];
        }
        listaNova[listaClientes.length] = c;
        
        CsvUtil.salvar(listaNova, "clientes.csv");
        
        System.out.print("\n");
        System.out.println("===============================");
        System.out.println("Cliente cadastrado com sucesso!");
        System.out.println("===============================");
        System.out.print("\n");
        
        return listaNova;    
    }
    
    public static void listarCliente (Cliente listaClientes[]) {
    for (int i = 0; i < listaClientes.length; i++) {
            listaClientes[i].imprime();      
       }
    }
    
    public static void buscarCliente (Cliente listaClientes[]) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe o ID do cliente:");
        String busca = entrada.nextLine();
        
        for (int i = 0; i<listaClientes.length; i++){ 
            
       if (busca.equals(listaClientes[i].id)) {
           listaClientes[i].imprime();
           System.out.println("\n");
         }
       else {
           System.out.print("CPF nao encontrado!");
           System.out.println("\n");
       }
    }
        
   }
    
  public static void alterarCliente (Cliente listaClientes[]) {
    Scanner entrada = new Scanner(System.in); 
     System.out.println("Digite o ID do cliente que deseja alterar: ");
     String alter = entrada.nextLine();
     
      for (int i = 0; i<listaClientes.length; i++)
       if (alter.equals (listaClientes[i].id)) {
           Cliente cNovo = new Cliente();
           System.out.println("===Insira os novos dados===");
           System.out.print("\n");
           System.out.println("Novo ID: ");
           cNovo.id = entrada.nextLine();
           System.out.println("Novo Cpf: ");
           cNovo.cpf = entrada.nextLine();
           System.out.println("Novo Nome: ");
           cNovo.nome = entrada.nextLine();
           System.out.println("Novo Telefone: ");
           cNovo.telefone = entrada.nextLine();
           System.out.println("Novo Email: ");
           cNovo.email = entrada.nextLine();
           
           
           listaClientes[i] = cNovo;
           
           CsvUtil.salvar(listaClientes, "clientes.csv");
           
           System.out.print("\n");
           System.out.println("============================");
           System.out.println("Alteracao concluida");
           System.out.println("============================");
           System.out.print("\n");
       }
       else {
           System.out.print("ID nao encontrado!");
           System.out.println("\n");
       }   
    } 
      
  
     public static Cliente[] removerCliente (Cliente listaCliente[]) {
     Scanner entrada = new Scanner(System.in);
     System.out.println("Digite o ID do cliente que deseja remover:");
     String remover = entrada.nextLine();
     int indR = -1;
     
     for (int i = 0; i < listaCliente.length; i++) 
        if (remover.equals (listaCliente[i].id)) {
            indR = i; 
        }
        
        if (indR == -1) {
        System.out.println("Cliente nÃ£o encontrado!");
        return listaCliente;  
    }
        Cliente listaNovaC[] = new Cliente[listaCliente.length - 1];   
        int pN = 0;
        for (int i = 0; i < listaCliente.length; i++) {
        
        if (i != indR) {
            listaNovaC[pN] = listaCliente[i];
            pN++;
        }
    }
    
    CsvUtil.salvar(listaNovaC, "clientes.csv");
    
    System.out.print("\n");
    System.out.println("============================");
    System.out.println("Cliente removido com sucesso!");
    System.out.println("============================");
    System.out.print("\n");
   
    return listaNovaC;
     
        
    }
  
  } 
    
    
       

            


