
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ellia
 */
class Usuario {
    private String nome;
    private ArrayList<Midia> midias;
    private ArrayList<String> relacoes;
    private ArrayList<Emprestimo> emprestimos;
    private ArrayList<Midia> wishlist;
    
    public Usuario(String nome) {
        this.nome = nome;
        this.midias = new ArrayList<>();
        this.relacoes = new ArrayList<>();
        this.wishlist = new ArrayList<>();
    }
    
    public void addMidia(Midia midia, String relacao) {
        midias.add(midia);
        relacoes.add(relacao);
    }
    
    public void addDesejo(Midia midia_desejada) {
        this.wishlist.add(midia_desejada);
    }
    
    public void addEmprestimo(Emprestimo emprestimo) {
        this.emprestimos.add(emprestimo);
    }
    
    
    public void listarEmprestimos(int data_atual) {
        if(emprestimos.size() < 1) {
            System.out.println("---------------------------------");
            System.out.println("Não há midias emprestadas");
            System.out.println("---------------------------------");
        } else {
            for(int i = 0; i < emprestimos.size(); i++) {
                System.out.println("---------------------------------");
                System.out.println("Lista das mídias emprestadas: ");
                emprestimos.get(i).exibirEmprestimo(data_atual);
            }
        }
            
    }
    
    public void listarPorDirigente(String dirigente) {
        System.out.println("---------------------------------");
        System.out.println("Listagem das obras de " + dirigente + " :");
        for(int i = 0; i < midias.size(); i++) {
            if(dirigente.equals(midias.get(i).getDirigente(dirigente))){
                System.out.println("* " + midias.get(i).getNome() + ";");
            }
        }
        System.out.println("---------------------------------");
    }
    
    public void mostrarWishList() {
        System.out.println("Minha lista de desejos:");
        System.out.println("---------------------------------");
        for(int i = 0; i < wishlist.size(); i ++) {
            System.out.println(wishlist.get(i).getNome() + ", R$" + wishlist.get(i).getPreco());
        }
        System.out.println("---------------------------------");
    }
    
    public void estatisticasGerais() {
        System.out.println("---------------------------------");
        float horas_gastas = 0;
        for(int i = 0; i < midias.size(); i++){
            if ("b".equals(relacoes.get(i))) {
                horas_gastas += midias.get(i).getHoras();
            }
        }
        
        System.out.println("Horas totais gastas com mídias consumidas : " + horas_gastas);
        
        System.out.println("---------------------------------");
         
        for(int i = 0; i < midias.size(); i++){
            String genero_aux = midias.get(i).getGenero();
            String genero_aux_anterior = null;
            
            if(genero_aux.equals(genero_aux_anterior)) {
                while(!genero_aux.equals(genero_aux_anterior)) {
                    genero_aux = midias.get(i).getGenero();
                    i++;
                }
            }
            
            float total = 0;
            for(int j  = 0; j < midias.size(); j++) {
                if(midias.get(j).getGenero().equals(genero_aux)) {
                    total += 1;
                } 
            }
            System.out.println("Total por gênero (" + genero_aux + "): +" + total);
            
            genero_aux_anterior = genero_aux;
        }
        
        System.out.println("---------------------------------");
        
        int total_livro = 0;
        int total_serie = 0;
        int total_filme = 0;
        
        for(int i = 0; i < midias.size(); i++) {
            if ("livro".equals(midias.get(i).getTipo())) total_livro += 1;
            if ("serie".equals(midias.get(i).getTipo())) total_serie += 1;
            if ("filme".equals(midias.get(i).getTipo())) total_filme += 1;
        }
        
        System.out.println("Total de livros: " + total_livro);
        System.out.println("Total de series: " + total_serie);
        System.out.println("Total de filmes: " + total_filme);
        
        System.out.println("---------------------------------");
    }
}
