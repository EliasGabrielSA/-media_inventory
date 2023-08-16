import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ellia
 */
public class Emprestimo {
    private Midia midia;
    private Usuario mutuario;
    private LocalDate dt_emprestimo;
    private LocalDate dt_devolucao; 
    
    Emprestimo(Usuario mutuario, Midia midia, String dt_emprestimo, String dt_devolucao) {
        this.mutuario = mutuario;
        this.midia = midia;
        
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.dt_emprestimo = LocalDate.parse(dt_emprestimo,formatter);
        this.dt_devolucao = LocalDate.parse(dt_devolucao,formatter);
    }
    
    public LocalDate getDtEmprest(){
        return dt_emprestimo;
    }
    public LocalDate getDtDev(){
        return dt_devolucao;
    }

    private boolean isAtrasado(){
        LocalDate atual=LocalDate.now();

        return !atual.isBefore(dt_devolucao);
    }

    public int calcDevolucao(){
        int ret;
        LocalDate atual = LocalDate.now();
        Period periodo = Period.between(this.dt_devolucao, atual);
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