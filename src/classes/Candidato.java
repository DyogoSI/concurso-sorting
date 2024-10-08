
package classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Candidato implements Comparable<Candidato> {
    private String id;
    private String nome;
    private LocalDate dataNascimento;
    private double nota;

    public Candidato(String id, String nome, String dataNascimento, double nota) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.id = id;
        this.nome = nome;
        this.dataNascimento = LocalDate.parse(dataNascimento, formatter);
        this.nota = nota;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public int compareTo(Candidato outro) {
        if (this.nota != outro.nota) {
            return Double.compare(outro.nota, this.nota);  // Maior nota primeiro
        } else {
            return this.dataNascimento.compareTo(outro.dataNascimento);  // Mais velho primeiro
        }
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "ID: " + id + ", Nome: " + nome + ", Data de Nascimento: " + dataNascimento.format(formatter) + ", Nota: " + nota;
    }
}
