
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ellia
 */
class FichaTecnica {
    private Midia midia;
    private ArrayList <String> generos;

    public FichaTecnica(Midia midia) {
        this.midia = midia;
        this.generos = new ArrayList<>();
    }
    
    public void setGenero(String genero) {
        generos.add(genero);
    }
}
