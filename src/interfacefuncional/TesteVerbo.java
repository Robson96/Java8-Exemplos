package interfacefuncional;

public class TesteVerbo {
    public static void main(String[] args) {
        //Implementa o metedo
        Verbo falar = () -> System.out.println("Ola mundo");
        //Chama o metodo
        falar.acao();
    }
}
