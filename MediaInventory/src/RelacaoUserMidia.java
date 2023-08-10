
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ellia
 */

class RelacaoUserMidia {
    private Usuario usuario;
    private ArrayList<Midia> midias;
    private ArrayList<String> relacoes;
    private String data_emprestimo;
    private String data_devolucao;
    
    RelacaoUserMidia(Usuario usuario) {
        this.usuario = usuario;
        this.midias = new ArrayList<>();
        this.relacoes = new ArrayList<>();
        this.data_emprestimo = null;
        this.data_devolucao = null;
    }

    public void setMidias(Midia midia) {
        midias.add(midia);
    }

    public void setRelacoes(String relacao) {
        relacoes.add(relacao);
    }
    
    public void registrarEmprestimo(String data){
        this.data_emprestimo = data;
    }
    
    public void registrarDevolucao(String data) {
        this.data_devolucao = data;
    }
    
    
    
    
    
    
}
