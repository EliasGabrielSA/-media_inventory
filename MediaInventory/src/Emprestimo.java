/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ellia
 */
public class Emprestimo {
    private Midia midia;
    private Usuario mutuario;
    private int dt_emprestimo;
    private int dt_devolucao; 
    
    Emprestimo(Usuario mutuario, Midia midia, int dt_emprestimo, int dt_devolucao) {
        this.mutuario = mutuario;
        this.midia = midia;
        this.dt_emprestimo = dt_emprestimo;
        this.dt_devolucao = dt_devolucao;
    }
    
    void exibirEmprestimo(int dt_atual) {
        System.out.println("---------------------------------");
        System.out.println("Mutuário: " + mutuario);
        if(dt_devolucao > dt_devolucao) {
            int dias_expirados = dt_atual - dt_emprestimo;
            
            System.out.println("");
            System.out.println("Data de devolução expirou...");
            System.out.println("Dias de atraso: " + dias_expirados);
        }
        System.out.println("---------------------------------");
    }
    
    
}