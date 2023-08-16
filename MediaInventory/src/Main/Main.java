class Main {
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
            midias.java.util.ArrayList.add(midia);
            relacoes.java.util.ArrayList.add(relacao);
            this.possui.java.util.ArrayList.add(possui);
        }

        void addDesejo(Midia midia_desejada) {
            this.wishlist.java.util.ArrayList.add(midia_desejada);
        }

        void addEmprestimo(Emprestimo emprestimo) {
            this.emprestimos.java.util.ArrayList.add(emprestimo);
        }

        String getNomeUsuario() {
            return nome;
        }

        void listarEmprestimos(int data_atual) {
            if(emprestimos.java.util.ArrayList.size() < 1) {
                System.out.println("Nao ha midias emprestadas");
                System.out.println("---------------------------------");
            } else {
                System.out.println("Lista das midias emprestadas: ");
                System.out.println("---------------------------------");
                for(int i = 0; i < emprestimos.java.util.ArrayList.size(); i++) {
                    emprestimos.java.util.ArrayList.get(i).exibirEmprestimo();
                }
            } 
        }

        void listarPorDirigente(String dirigente) {
            System.out.println("Listagem das obras de " + dirigente + " :");
            for(int i = 0; i < midias.java.util.ArrayList.size(); i++) {
                if(dirigente.equals(midias.java.util.ArrayList.get(i).getDirigente(dirigente))){
                    System.out.println("* " + midias.java.util.ArrayList.get(i).getNome() + ";");
                }
            }
            System.out.println("---------------------------------");
        }

        void mostrarWishList() {
            System.out.println("Minha lista de desejos:");
            System.out.println("---------------------------------");
            for(int i = 0; i < wishlist.java.util.ArrayList.size(); i ++) {
                System.out.println("* " + wishlist.java.util.ArrayList.get(i).getNome() + ", R$" + wishlist.java.util.ArrayList.get(i).getPreco());
            }
            System.out.println("---------------");
        }

        void estatisticasGerais() {
            System.out.println("Midias consumidas: ");
            for(int i = 0; i < midias.java.util.ArrayList.size(); i++) {
                if(possui.java.util.ArrayList.get(i) == true) {
                    System.out.println("* " + midias.java.util.ArrayList.get(i).getNome());
                }
            }
            System.out.println("---------------------------------");

            float horas_gastas = 0;
            for(int i = 0; i < midias.java.util.ArrayList.size(); i++){
                if (possui.java.util.ArrayList.get(i) == true) {
                    horas_gastas += midias.java.util.ArrayList.get(i).getHoras();
                }
            }
            System.out.printf("Horas totais gastas com midias consumidas : %.2f horas\n", horas_gastas);

            float horas_gastas_outros = 0;
            for(int i = 0; i < midias.java.util.ArrayList.size(); i++){
                if(possui.java.util.ArrayList.get(i) == false) {
                    horas_gastas_outros += midias.java.util.ArrayList.get(i).getHoras();
                }
            }
            System.out.printf("Horas necessarias para consumir as demais midias: %.2f horas\n", horas_gastas_outros);

            System.out.println("---------------------------------");
            java.util.HashMap<String, Integer> generoTotals = new java.util.HashMap<>();

            for (Midia midia : midias) {
                String genero_aux = midia.getGenero();

                if (!java.util.HashMap.generoTotals.containsKey(genero_aux)) {
                    generoTotals.java.util.HashMap.put(genero_aux, 0);
                }

                generoTotals.java.util.HashMap.put(genero_aux, generoTotals.java.util.ArrayList.get(genero_aux) + 1);
            }
    
            for (String genero : generoTotals.java.util.HashMap.keySet()) {
                float total = generoTotals.java.util.ArrayList.get(genero);
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
            for(int i = 0; i < midias.java.util.ArrayList.size(); i++) {
                if(midias.java.util.ArrayList.get(i) instanceof Serie && possui.java.util.ArrayList.get(i) == true) {
                    int quant_temp = midias.java.util.ArrayList.get(i).getNmrTemp();

                    System.out.println("* Serie: " + midias.java.util.ArrayList.get(i).getNome() + ", temporada: " + quant_temp);
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
    
    public class Emprestimo {
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

            return !atual.java.time.LocalDate.isBefore(dt_devolucao);
        }

        int calcDevolucao(){
            int ret;
            java.time.LocalDate atual = java.time.LocalDate.now();
            java.time.Period periodo = java.time.Period.between(this.dt_devolucao, atual);
            ret = periodo.java.time.Period.getDays()+ periodo.java.time.Period.getMonths()*30 + periodo.java.time.Period.getYears()*365;
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
            this.atrs_principais.java.util.ArrayList.add(atr_principal);
            this.duracao = duracao;
            this.formato = formato;
        }

        @Override
        void setDirigentesPrincipais(String dirigente) {
            this.atrs_principais.java.util.ArrayList.add(dirigente);
        }

        @Override 
        String getDirigente(String dirigente) {
            for(int i = 0; i < atrs_principais.java.util.ArrayList.size(); i++) {
                if(atrs_principais.java.util.ArrayList.get(i).equals(dirigente)) {
                    return atrs_principais.java.util.ArrayList.get(i);
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
            this.autores.java.util.ArrayList.add(autor);
            this.nmr_paginas = nmr_paginas;
        }

        @Override
        void setDirigentesPrincipais(String dirigente) {
            this.autores.java.util.ArrayList.add(dirigente);
        }

        @Override
        String getDirigente(String dirigente) {
            for(int i = 0; i < autores.java.util.ArrayList.size(); i++) {
                if(autores.java.util.ArrayList.get(i).equals(dirigente)) {
                    return autores.java.util.ArrayList.get(i);
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
            this.atrs_principais.java.util.ArrayList.add(dirigente);
        }

        @Override 
        String getDirigente(String dirigente) {
            for(int i = 0; i < atrs_principais.java.util.ArrayList.size(); i++) {
                if(atrs_principais.java.util.ArrayList.get(i).equals(dirigente)) {
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
            return atrs_principais.java.util.ArrayList.get(i);
        }
    }
}
