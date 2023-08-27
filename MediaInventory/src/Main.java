class Usuario {
    private String nome;
    private java.util.ArrayList<Midia> midias;
    private java.util.ArrayList<String> relacoes;
    private java.util.ArrayList<Boolean> possui;
    private java.util.ArrayList<Emprestimo> emprestimos;
    private java.util.ArrayList<Midia> wishlist;

    Usuario(String nome) {
        this.nome = nome;
        this.midias = new java.util.ArrayList<>();
        this.relacoes = new java.util.ArrayList<>();
        this.wishlist = new java.util.ArrayList<>();
        this.emprestimos = new java.util.ArrayList<>();
        this.possui = new java.util.ArrayList<>();
    }

    void addMidia(Midia midia, String relacao, Boolean possui) {
        midias.add(midia);
        relacoes.add(relacao);
        this.possui.add(possui);
    }

    void addDesejo(Midia midia_desejada) {
        this.wishlist.add(midia_desejada);
    }

    void addEmprestimo(Emprestimo emprestimo) {
        this.emprestimos.add(emprestimo);
    }

    String getNomeUsuario() {
        return nome;
    }

    void listarEmprestimos(int data_atual) {
        if(emprestimos.size() < 1) {
            System.out.println("Nao ha midias emprestadas");
            System.out.println("---------------------------------");
        } else {
            System.out.println("Lista das midias emprestadas: ");
            System.out.println("---------------------------------");
            for(int i = 0; i < emprestimos.size(); i++) {
                emprestimos.get(i).exibirEmprestimo();
            }
        } 
    }

    void listarPorDirigente(String dirigente) {
        System.out.println("Listagem das obras de " + dirigente + " :");
        for(int i = 0; i < midias.size(); i++) {
            if(dirigente.equals(midias.get(i).getDirigente(dirigente))){
                System.out.println("* " + midias.get(i).getNome() + ";");
            }
        }
        System.out.println("---------------------------------");
    }

    void mostrarWishList() {
        System.out.println("Minha lista de desejos:");
        System.out.println("---------------------------------");
        for(int i = 0; i < wishlist.size(); i ++) {
            System.out.println("* " + wishlist.get(i).getNome() + ", R$" + wishlist.get(i).getPreco());
        }
        System.out.println("---------------");
    }

    void estatisticasGerais() {
        System.out.println("Midias consumidas: ");
        for(int i = 0; i < midias.size(); i++) {
            if(possui.get(i) == true) {
                System.out.println("* " + midias.get(i).getNome());
            }
        }
        System.out.println("---------------------------------");

        float horas_gastas = 0;
        for(int i = 0; i < midias.size(); i++){
            if (possui.get(i) == true) {
                horas_gastas += midias.get(i).getHoras();
            }
        }
        System.out.printf("Horas totais gastas com midias consumidas : %.2f horas\n", horas_gastas);

        float horas_gastas_outros = 0;
        for(int i = 0; i < midias.size(); i++){
            if(possui.get(i) == false) {
                horas_gastas_outros += midias.get(i).getHoras();
            }
        }
        System.out.printf("Horas necessarias para consumir as demais midias: %.2f horas\n", horas_gastas_outros);

        System.out.println("---------------------------------");
        java.util.HashMap<String, Integer> generoTotals = new java.util.HashMap<>();

        for (Midia midia : midias) {
            String genero_aux = midia.getGenero();

            if (!generoTotals.containsKey(genero_aux)) {
                generoTotals.put(genero_aux, 0);
            }

            generoTotals.put(genero_aux, generoTotals.get(genero_aux) + 1);
        }

        for (String genero : generoTotals.keySet()) {
            float total = generoTotals.get(genero);
            System.out.println("Total por genero (" + genero + "): " + total);
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

        System.out.println("Lista de temporadas consumidas : ");
        System.out.println("");
        //("a".equals(relacoes.get(i)) && possui.get(i) == true) && (midias.get(i).getTipo().equals("serie")) && (("DVD".equals(midias.get(i).getFormato())) && ("Blu-Ray".equals(midias.get(i).getFormato())))
        for(int i = 0; i < midias.size(); i++) {
            if(midias.get(i) instanceof Serie && possui.get(i) == true) {
                int quant_temp = midias.get(i).getNmrTemp();

                System.out.println("* Serie: " + midias.get(i).getNome() + ", temporada: " + quant_temp);
            }
        }
        System.out.println("---------------------------------");
    }
}
class Midia {
    private String nome;
    private String genero;
    private String tipo;
    private float preco;

    Midia(String nome, String genero, String tipo) {
        this.nome = nome;
        this.preco = 0;
        this.genero = genero;
        this.tipo = tipo;
    }

    void registrarPreco(float preco) {
        this.preco = preco;
    }

    void setDirigentesPrincipais(String dirigente) {
    }

    String getDirigente(String dirigente) {
        return null;
    }

    public String getNome() {
        return nome;
    }

    float getPreco() {
        return preco;
    }

    float getHoras() {
        return 0;
    }

    String getGenero() {
        return genero;
    }

    String getTipo() {
        return tipo;
    }

    int getNmrTemp() {
        return 0;
    }

    String getFormato() {
        return null;
    }
}

class Emprestimo {
    private Midia midia;
    private Usuario mutuario;
    private java.time.LocalDate dt_emprestimo;
    private java.time.LocalDate dt_devolucao; 

    Emprestimo(Usuario mutuario, Midia midia, String dt_emprestimo, String dt_devolucao) {
        this.mutuario = mutuario;
        this.midia = midia;

        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.dt_emprestimo = java.time.LocalDate.parse(dt_emprestimo,formatter);
        this.dt_devolucao = java.time.LocalDate.parse(dt_devolucao,formatter);
    }   

    java.time.LocalDate getDtEmprest(){
        return dt_emprestimo;
    }
    java.time.LocalDate getDtDev(){
        return dt_devolucao;
    }

    private boolean isAtrasado(){
        java.time.LocalDate atual = java.time.LocalDate.now();

        return !atual.isBefore(dt_devolucao);
    }

    int calcDevolucao(){
        int ret;
        java.time.LocalDate atual = java.time.LocalDate.now();
        java.time.Period periodo = java.time.Period.between(this.dt_devolucao, atual);
        ret = periodo.getDays()+ periodo.getMonths()*30 + periodo.getYears()*365;
        return ret;
    }

    void exibirEmprestimo() {
        System.out.println("Mutuario: " + mutuario.getNomeUsuario());
        System.out.println("Midia emprestada: " + midia.getNome());
        if(isAtrasado()) {
            int dias_expirados = calcDevolucao();

            System.out.println("");
            System.out.println("Data de devolucao expirou...");
            System.out.println("Dias de atraso: " + dias_expirados);
        } else {
            System.out.println("");
            System.out.println("Data de devolucao ainda nao expirou...");
        }
        System.out.println("----------------");
    }
}

class Filme extends Midia{
    private String diretor;
    private java.util.ArrayList<String> atrs_principais;
    private float duracao;
    private String formato;
    private String tipo;


    Filme(String nome, String tipo, String genero, float duracao, String formato, String atr_principal) {
        super(nome, genero, "filme");
        this.atrs_principais = new java.util.ArrayList<>();
        this.atrs_principais.add(atr_principal);
        this.duracao = duracao;
        this.formato = formato;
    }

    @Override
    void setDirigentesPrincipais(String dirigente) {
        this.atrs_principais.add(dirigente);
    }

    @Override 
    String getDirigente(String dirigente) {
        for(int i = 0; i < atrs_principais.size(); i++) {
            if(atrs_principais.get(i).equals(dirigente)) {
                return atrs_principais.get(i);
            } 
        }
        return null;
    }

    @Override
    float getHoras() {
        return duracao / 60;
    }
}

class Livro extends Midia{
    private String tipo;
    private java.util.ArrayList <String> autores;
    private int nmr_paginas;

    Livro(String nome, String tipo, String genero, int nmr_paginas, String autor) {
        super(nome, genero, tipo);
        this.autores = new java.util.ArrayList<>();
        this.autores.add(autor);
        this.nmr_paginas = nmr_paginas;
    }

    @Override
    void setDirigentesPrincipais(String dirigente) {
        this.autores.add(dirigente);
    }

    @Override
    String getDirigente(String dirigente) {
        for(int i = 0; i < autores.size(); i++) {
            if(autores.get(i).equals(dirigente)) {
                return autores.get(i);
            }
        }
        return null;
    }

    @Override
    float getHoras() {
        return nmr_paginas / 60;
    }
}

class Serie extends Midia{
    private java.util.ArrayList <String> atrs_principais;
    private float duracao;
    private int nmr_temporada;
    private String formato;
    private String tipo;

    Serie(String nome, String tipo, String genero, int nmr_temporada, float duracao, String formato) {
        super(nome, genero, "serie");
        this.atrs_principais = new java.util.ArrayList<>();
        this.nmr_temporada = nmr_temporada;
        this.duracao = duracao;
        this.formato = formato;
    }

    @Override
    void setDirigentesPrincipais(String dirigente) {
        this.atrs_principais.add(dirigente);
    }

    @Override 
    String getDirigente(String dirigente) {
        for(int i = 0; i < atrs_principais.size(); i++) {
            if(atrs_principais.get(i).equals(dirigente)) {
                return atrs_principais(i);
            } 
        }
        return null;
    }

    @Override
    float getHoras() {
        return duracao / 60;
    }

    @Override
    int getNmrTemp() {
        return nmr_temporada;
    }

    @Override
    String getFormato() {
        return formato;
    }

    String atrs_principais(int i) {
        return atrs_principais.get(i);
    }
}

class Main {
    public static void main(String[] args) {
        Usuario Elias = new Usuario("Elias Gabriel");
        Usuario Herick = new Usuario("Herick Sales");
        
        Midia PercyJackson = new Livro("PercyJackson", "livro", "acao", 245, "RickRiordan");
        Midia MagnusChase = new Livro("MagnusChase", "livro", "suspense", 1000, "RickRiordan");
        Midia ReasonsWhy = new Serie("13ReasonWhy", "serie", "drama", 2, 892, "DVD");
        Midia Lost = new Serie("Lost", "serie", "drama", 1, 892, "DVD");
        Midia Shrek = new Filme("Shrek1", "filme", "fantasia", 243, "DVD", "MikeMiers");
        Midia Shrek2 = new Filme("Shrek2", "filme", "fantasia", 242, "DVD", "MikeMiers");
        Shrek2.registrarPreco(45);
        
        Elias.addMidia(PercyJackson, "a", true);
        Elias.addMidia(MagnusChase, "b", true);
        Elias.addMidia(ReasonsWhy, "b", true);
        Elias.addMidia(Shrek, "c", true);
        Elias.addMidia(Lost, "b", true);
        Elias.addMidia(Shrek2, "c", true);

        Elias.estatisticasGerais();
        Elias.listarPorDirigente("MikeMiers");
        
        Emprestimo emp1 = new Emprestimo(Herick, PercyJackson, "2022-08-10", "2023-03-07");
        Emprestimo emp2 = new Emprestimo(Herick, MagnusChase, "2023-08-10", "2023-09-11");
        Elias.addEmprestimo(emp1);
        Elias.addEmprestimo(emp2);
        
        Elias.listarEmprestimos(20230815);
        
        Elias.addDesejo(Shrek2);
        Elias.mostrarWishList();
    }
}
