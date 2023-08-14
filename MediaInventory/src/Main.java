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
        Midia PercyJackson = new Livro("PercyJackson", "acao", "livro", 245, "RickRiordan");
        Elias.addMidia(PercyJackson, "a");
        
        Elias.estatisticasGerais();
        Elias.listarPorDirigente("RickRiordan");
        
    }
}
