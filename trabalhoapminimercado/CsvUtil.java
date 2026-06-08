package com.mycompany.trabalhoapminimercado;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class CsvUtil {
   


 
    public static void salvar(Object[] objetos, String nomeArquivo) {
        if (objetos == null || objetos.length == 0)
            return;

        try (FileWriter writer = new FileWriter(nomeArquivo)) {

            Class<?> clazz = objetos[0].getClass();
            
            List<Field> camposValidos = new ArrayList<>();
            for (Field f : clazz.getDeclaredFields()) {
                if (!f.isSynthetic() && !Modifier.isStatic(f.getModifiers())) {
                    camposValidos.add(f);
                }
            }

           
            for (int i = 0; i < camposValidos.size(); i++) {
                writer.append(camposValidos.get(i).getName());
                if (i < camposValidos.size() - 1)
                    writer.append(";");
            }
            writer.append("\n");

            // Dados
            for (Object obj : objetos) {
                for (int i = 0; i < camposValidos.size(); i++) {
                    Field field = camposValidos.get(i);
                    field.setAccessible(true);
                    Object valor = field.get(obj);
                    writer.append(String.valueOf(valor));
                    if (i < camposValidos.size() - 1)
                        writer.append(";");
                }
                writer.append("\n");
            }

        } catch (Exception e) {
            System.err.println("Erro ao salvar o arquivo CSV:");
            e.printStackTrace();
        }
    }

  
    public static <T> T[] ler(String nomeArquivo, Class<T> entity) {
        List<T> lista = new ArrayList<>();

        File arquivo = new File(nomeArquivo);
        if (!arquivo.exists()) {
            System.out.println("[Sistema] Base " + nomeArquivo + " nao encontrada. Iniciando lista vazia.");
            @SuppressWarnings("unchecked")
            T[] arrayVazio = (T[]) Array.newInstance(entity, 0);
            return arrayVazio;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {

            String header = reader.readLine();
            if (header == null)
                return null;

            String[] nomesCampos = header.split(";");

            String linha;
            while ((linha = reader.readLine()) != null) {
                
                if (linha.trim().isEmpty()) continue;

                String[] valores = linha.split(";");
                T obj = entity.getDeclaredConstructor().newInstance();

                
                int limite = Math.min(nomesCampos.length, valores.length);

                for (int i = 0; i < limite; i++) {
                    try {
                        Field field = entity.getDeclaredField(nomesCampos[i]);
                        field.setAccessible(true);

                        Class<?> tipo = field.getType();
                        String valor = valores[i];

                       
                        if (tipo == int.class || tipo == Integer.class) {
                            field.set(obj, Integer.parseInt(valor));
                        } else if (tipo == float.class || tipo == Float.class) {
                            field.set(obj, Float.parseFloat(valor));
                        } else if (tipo == double.class || tipo == Double.class) {
                            field.set(obj, Double.parseDouble(valor));
                        } else if (tipo == boolean.class || tipo == Boolean.class) {
                            field.set(obj, Boolean.parseBoolean(valor));
                        } else {
                            field.set(obj, valor);
                        }
                    } catch (NoSuchFieldException e) {
                       
                    }
                }

                lista.add(obj);
            }

        } catch (Exception e) {
            System.err.println("Erro ao ler o arquivo CSV:");
            e.printStackTrace();
        }

        
        @SuppressWarnings("unchecked")
        T[] array = (T[]) Array.newInstance(entity, lista.size());
        return lista.toArray(array);
    }
}  

 

