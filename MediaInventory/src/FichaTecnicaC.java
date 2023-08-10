
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ellia
 */

public class FichaTecnicaC extends FichaTecnica{
    private ArrayList <String> atrs_principais;
    private float duracao;
    private int nmr_temporadas;
    
    public FichaTecnicaC(Midia midia, String genero, float duracao, int nmr_temporadas) {
        super(midia, genero);
        this.atrs_principais = new ArrayList<>();
        this.duracao = duracao;
        this.nmr_temporadas = nmr_temporadas;
    }

    public void setAtrsPrincipais(String ator) {
        atrs_principais.add(ator);
    }
}
