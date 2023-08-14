
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ellia
 */

class Serie extends Midia{
    private ArrayList <String> atrs_principais;
    private float duracao;
    private int nmr_temporadas;
    private String formato;
    private String tipo;

    public Serie(String nome, String genero, String tipo, int nmr_temporadas, float duracao, String formato) {
        super(nome, genero, "serie");
        this.atrs_principais = new ArrayList<>();
        this.nmr_temporadas = nmr_temporadas;
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
                return getNome();
            } 
        }
        return null;
    }
    
    @Override
    public float getHoras() {
        return duracao / 60;
    }
}
