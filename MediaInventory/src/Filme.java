
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ellia
 */

class Filme extends Midia{
    private String diretor;
    private ArrayList <String> atrs_principais;
    private float duracao;
    private String formato;
    private String tipo;
    
    
    public Filme(String nome, String tipo, String genero, float duracao, String formato, String atr_principal) {
        super(nome, genero, "filme");
        this.atrs_principais = new ArrayList<>();
        this.atrs_principais.add(atr_principal);
        this.duracao = duracao;
        this.formato = formato;
    }
    
    @Override
    public void setDirigentesPrincipais(String dirigente) {
        this.atrs_principais.add(dirigente);
    }
    
    @Override 
    public String getDirigente(String dirigente) {
        for(int i = 0; i < atrs_principais.size(); i++) {
            if(atrs_principais.get(i).equals(dirigente)) {
                return atrs_principais.get(i);
            } 
        }
        return null;
    }
    
    @Override
    public float getHoras() {
        return duracao / 60;
    }
}
