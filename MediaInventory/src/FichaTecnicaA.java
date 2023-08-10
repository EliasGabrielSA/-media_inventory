
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ellia
 */

class FichaTecnicaA extends FichaTecnica {
    
    private ArrayList <String> autores;
    private int nmr_paginas;
    
    public FichaTecnicaA(Midia midia, String tipo, int nmr_paginas) {
        super(midia, tipo);
        this.autores = new ArrayList<>();
        this.nmr_paginas = nmr_paginas;
    }

    public void setAutores(String autor) {
        autores.add(autor);
    }
}
