/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author ellia
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Usuario Elias = new Usuario("Elias Gabriel");
        Usuario Herick = new Usuario("Herick Sales");
        
        Midia PercyJackson = new Livro("PercyJackson", "livro", "acao", 245, "RickRiordan");
        Midia MagnusChase = new Livro("MagnusChase", "livro", "suspense", 1000, "RickRiordan");
        
        //Midia 13ReasonsWhy = new Serie("13ReasonWhy", "serie", "drama", 2, 892, "DVD");
        Elias.addMidia(PercyJackson, "a", true);
        Elias.addMidia(MagnusChase, "b", true);
        
        Elias.estatisticasGerais();
        Elias.listarPorDirigente("RickRiordan");
        
        Emprestimo emp1 = new Emprestimo(Herick, PercyJackson, 20230810, 20230820);
        Emprestimo emp2 = new Emprestimo(Herick, MagnusChase, 20230810, 20230920);
        Elias.addEmprestimo(emp1);
        Elias.addEmprestimo(emp2);
        
        Elias.listarEmprestimos(20230815);
    }
}
