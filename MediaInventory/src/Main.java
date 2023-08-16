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
        Midia ReasonsWhy = new Serie("13ReasonWhy", "serie", "drama", 2, 892, "DVD");
        Midia Lost = new Serie("Lost", "serie", "drama", 1, 892, "DVD");
        Midia Shrek = new Filme("Shrek1", "filme", "fantasia", 243, "DVD", "MikeMiers");
        Midia Shrek2 = new Filme("Shrek2", "filme", "fantasia", 242, "DVD", "MikeMiers");
        Shrek2.registrarPreco(45);
        
        Elias.addMidia(PercyJackson, "a", true);
        Elias.addMidia(MagnusChase, "b", true);
        Elias.addMidia(ReasonsWhy, "b", true);
        Elias.addMidia(Shrek, "c", true);
        Elias.addMidia(Lost, "b", true);
        Elias.addMidia(Shrek2, "c", true);

        Elias.estatisticasGerais();
        Elias.listarPorDirigente("MikeMiers");
        
        Emprestimo emp1 = new Emprestimo(Herick, PercyJackson, "2022-08-10", "2023-03-07");
        Emprestimo emp2 = new Emprestimo(Herick, MagnusChase, "2023-08-10", "2023-09-11");
        Elias.addEmprestimo(emp1);
        Elias.addEmprestimo(emp2);
        
        Elias.listarEmprestimos(20230815);
        
        Elias.addDesejo(Shrek2);
        Elias.mostrarWishList();
    }
}
