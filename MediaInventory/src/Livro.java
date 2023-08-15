
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ellia
 */

class Livro extends Midia{
    private String tipo;
    private ArrayList <String> autores;
    private int nmr_paginas;

    public Livro(String nome, String tipo, String genero, int nmr_paginas, String autor) {
        super(nome, genero, tipo);
        this.autores = new ArrayList<>();
        this.autores.add(autor);
        this.nmr_paginas = nmr_paginas;
    }
    
    @Override
    public void setDirigentesPrincipais(String dirigente) {
        this.autores.add(dirigente);
    }
    
    @Override
    public String getDirigente(String dirigente) {
        for(int i = 0; i < autores.size(); i++) {
            if(autores.get(i).equals(dirigente)) {
                return autores(i);
            }
        }
        return null;
    }
    
    @Override
    public float getHoras() {
        return nmr_paginas / 60;
    }

    private String autores(int i) {
        return autores.get(i);
    }
}
