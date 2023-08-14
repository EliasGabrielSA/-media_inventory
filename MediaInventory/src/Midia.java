/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ellia
 */

class Midia {
    private String nome;
    private String genero;
    private String tipo;
    private float preco;
    
    public Midia(String nome, String genero, String tipo) {
        this.nome = nome;
        this.preco = 0;
        this.genero = genero;
        this.tipo = tipo;
    }

    public void registrarPreco(float preco) {
        this.preco = preco;
    }
    
    public void setDirigentesPrincipais(String dirigente) {
    }
    
    public String getDirigente(String dirigente) {
        return null;
    }
    
    public String getNome() {
        return nome;
    }

    float getPreco() {
        return preco;
    }

    public float getHoras() {
        return 0;
    }

    public String getGenero() {
        return genero;
    }
    
    public String getTipo() {
        return tipo;
    }
}
