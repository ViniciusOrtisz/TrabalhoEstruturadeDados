package com.mycompany.trabalhoestruturadados;

import javax.swing.JOptionPane;
import com.mycompany.orderbyinsert;
import java.util.Random;
     

/**
 *
 * @author Vinicius & Ricardo
 */

public class TrabalhoEstruturaDados {
    
    public static void main(String[] args) {
        
        int opcao = -1;
        
        while(opcao != 0 ){
            
            opcao = Integer.parseInt(JOptionPane.showInputDialog(
                        "                                                            Menu\n" +
                    "===========================================================\n"+
                    "1 - Ordenação Por Inserção\n" +
                    "2 - Ordenação Por Seleção \n" +
                    "3 - Ordenação de Bolha \n" +
                    "4 - Pesquisa Linear\n" +
                    "5 - Pesquisa Binária\n" +
                    "0 - Sair\n" +
                    "===========================================================\n"));
                     
            switch (opcao) {
                case 1:
                    OrderByInsert();
                    break;
                case 2:
                    OrderBySelection();
                    break;    
                case 3: 
                    OrderByBubble();
                    break;    
                case 4:
                    PesquisarLinear();
                    break;
                case 5:
                    PesquisarBinario();
                    break;
                      
                default:
                    break;
            }
            
        }

    }
    
    
    public static void OrderBySelection(){
        
        int tamanhoVetor = Integer.parseInt(JOptionPane.showInputDialog("Digite o tamanho do vetor:"));
        int[] vetor = new int[tamanhoVetor];
        int j;
        
        long inicio = System.currentTimeMillis();
        
        
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o " + (i + 1) + "º valor:"));
        }
         StringBuilder original = new StringBuilder();
        for (int i = 0; i < vetor.length; i++) {
            original.append((i + 1)).append("º Valor Vetor Original = ").append(vetor[i]).append("\n");
        }

        JOptionPane.showMessageDialog(null, original.toString());
        
        for(int i = 0; i < vetor.length-1; i++){
            int posicaoMenor = i;
            
            for(j = i+1; j < vetor.length; j++){
                if(vetor[j] < vetor[posicaoMenor]){
                    posicaoMenor = j;
                }
            }
            
            if(posicaoMenor != i){
                int aux = vetor[i];
                vetor[i] = vetor[posicaoMenor];
                vetor[posicaoMenor] = aux;
            }
        }
        
        long fim = System.currentTimeMillis();
        long tempoExecucao = fim - inicio;
        
          StringBuilder ordenado = new StringBuilder();
        for (int i = 0; i < vetor.length; i++) {
            ordenado.append((i + 1)).append("º Valor Vetor Ordenado = ").append(vetor[i]).append("\n");
        }

        JOptionPane.showMessageDialog(null, ordenado.toString());
        JOptionPane.showMessageDialog(null,"Tempo de execução: "+tempoExecucao+"ms");
     
    }
    
    public static void OrderByBubble(){
        int tamanhoVetor = Integer.parseInt(JOptionPane.showInputDialog("Digite o tamanho do vetor:"));
        int[] vetor = new int[tamanhoVetor];
        boolean houveTroca = true;
        
        long inicio = System.currentTimeMillis();
        
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o " + (i + 1) + "º valor:"));
        }
         StringBuilder original = new StringBuilder();
        for (int i = 0; i < vetor.length; i++) {
            original.append((i + 1)).append("º Valor Vetor Original = ").append(vetor[i]).append("\n");
        }

        JOptionPane.showMessageDialog(null, original.toString());
        while(houveTroca){
            houveTroca = false;
            
            for(int i = 0; i < vetor.length - 1; i++){
                if(vetor[i] > vetor[i+1]){
                    int aux = vetor[i];
                    vetor[i] = vetor[i+1];
                    vetor[i+1] = aux;
                    houveTroca = true;
                }
            }
        }
        long fim = System.currentTimeMillis();
        long tempoExecucao = fim - inicio;
        
          StringBuilder ordenado = new StringBuilder();
        for (int i = 0; i < vetor.length; i++) {
            ordenado.append((i + 1)).append("º Valor Vetor Ordenado = ").append(vetor[i]).append("\n");
        }

        JOptionPane.showMessageDialog(null, ordenado.toString());
        
        JOptionPane.showMessageDialog(null,"Tempo de execução: "+tempoExecucao+"ms");
    }
