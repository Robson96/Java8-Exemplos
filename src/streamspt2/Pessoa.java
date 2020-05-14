package streamspt2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Pessoa implements Comparable<Pessoa> {
    private int idade;
    private String nome;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() { return nome; }
    public int getIdade() {
        return idade;
    }

    @Override
    public int compareTo(Pessoa pessoa) {
        return Integer.compare(this.idade, pessoa.idade);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome="  + nome +
                ", idade=" + idade +
                '}';
    }

    public static List<Pessoa> getPessoas() {
        return Arrays.asList(
                new Pessoa("robson", 24),
                new Pessoa("Magno", 60),
                new Pessoa("Gomes", 27));
    }

    public static void main(String[] args) {
        Pessoa pessoa2 = new Pessoa("Magno", 43);
        Pessoa pessoa1 = new Pessoa("Magno", 30);

        var list = Arrays.asList(pessoa1, pessoa2);

        var resultado = pessoa1.compareTo(pessoa2);
        System.out.println(resultado > 0);
        Function<Pessoa, Integer> extrai =
                (pessoa) -> pessoa.getIdade();
        Comparator<Pessoa> comparator =
                Comparator.comparing(extrai);
        list.sort(comparator);
        System.out.println(list);
    }
}
