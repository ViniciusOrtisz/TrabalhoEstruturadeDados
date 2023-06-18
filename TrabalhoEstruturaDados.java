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
      public static void PesquisarLinear(){ 
        
        int[]vetor = {10,20,30,40,50,60,70,80,90,123,341,5432,1,2,3,4,5,6,7,133,566,77,12,13,14,15,16,17,18,19};
        
        int chave = Integer.parseInt(
                JOptionPane.showInputDialog(
                        "Informe o número a ser pesquisado"));
        
        int posicao = pesquisaLinear(chave, vetor);
        
        if(posicao >= 0){
        JOptionPane.showMessageDialog(null,"O Elemento "+chave+" está localizado na "
                + "posição: "+(posicao+1));
        }else{
            JOptionPane.showMessageDialog(null,"O Elemento "+chave+" não foi localizado na lista");
        }
        
        StringBuilder ordenado = new StringBuilder();
        for (int i = 0; i < vetor.length; i++) {
            ordenado.append((i + 1)).append("º Valor Vetor = ").append(vetor[i]).append("\n");
        }
        JOptionPane.showMessageDialog(null, ordenado.toString());
    }
    
    public static int pesquisaLinear(int chave, int[]vet){
        for (int i = 0; i < vet.length; i++) {
            if(chave == vet[i])
                return i;    
        }
        return -1;
        
        
    }
    
    
    public static void PesquisarBinario(){
        
         int[]vetor = {10,20,30,40,50,60,70,80,90,123,341,5432,1,2,3,4,5,6,7,133,566,77,12,13,14,15,16,17,18,19};
       
        
        int chave = Integer.parseInt(
                JOptionPane.showInputDialog(
                        "Informe o número que deseja pesquisar"));
        
        int posicao = pesquisaBinaria(chave, vetor);
        
        if(posicao >= 0){
        JOptionPane.showMessageDialog(null,"O Elemento "+chave+" está localizado na "
                + "posição: "+(posicao+1));
        }else{
            JOptionPane.showMessageDialog(null,"O Elemento "+chave+" não foi localizado na lista");
        }
        
        StringBuilder ordenado = new StringBuilder();
        for (int i = 0; i < vetor.length; i++) {
            ordenado.append((i + 1)).append("º Valor Vetor = ").append(vetor[i]).append("\n");
        }
        JOptionPane.showMessageDialog(null, ordenado.toString());
        
    }
    
    public static int pesquisaBinaria(int chave, int[]vet){
        int esquerda, meio, direita;
        esquerda = 0;
        direita = vet.length -1;
        
        while(esquerda <= direita){
            meio = (esquerda + direita) / 2;
            if(chave == vet[meio]){
                return meio;
            }
            if(chave > vet[meio]){
                esquerda = meio +1;
            }else{
                direita = meio -1;
            }
            
        }
        return -1;
        
    }

    private static void OrderByInsert() {
        int tamanhoVetor = Integer.parseInt(JOptionPane.showInputDialog("Digite o tamanho do vetor:"));
        int[] vetor = new int[tamanhoVetor];
        int chave, j;
        
        long inicio = System.currentTimeMillis();
        
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o " + (i + 1) + "º valor:"));
        }
         StringBuilder original = new StringBuilder();
        for (int i = 0; i < vetor.length; i++) {
            original.append((i + 1)).append("º Valor Vetor Original = ").append(vetor[i]).append("\n");
        }

        JOptionPane.showMessageDialog(null, original.toString());
        
        for(int i = 1; i < vetor.length; i++){
            chave = vetor[i];
            
            for(j = i - 1;  (j >= 0 && vetor[j] > chave) ; j-- ){
                
                vetor[j+1] = vetor[j];
                
            }
            vetor[j+1] = chave;
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
}
