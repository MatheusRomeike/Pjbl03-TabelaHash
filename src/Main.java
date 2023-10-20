import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Hash alunoHash = new Hash(8, 8);
        Menu(alunoHash);
        //TestarEficiencia();
    }

    private static void Menu(Hash alunoHash) {
        System.out.println("1 - Inserir");
        System.out.println("2 - Deletar");
        System.out.println("3 - Buscar");
        System.out.println("4 - Imprimir");
        System.out.println("5 - Sair");
        var opcao = 0;
        Scanner scanner = new Scanner(System.in);
        while (opcao != 5) {
            System.out.println("--------------------");
            System.out.print("Digite uma opção: ");
            opcao = scanner.nextInt();
            if (opcao == 1) {
                Inserir(alunoHash, scanner);
            } else if (opcao == 2) {
                Deletar(alunoHash, scanner);
            } else if (opcao == 3) {
                Buscar(alunoHash, scanner);
            } else if (opcao == 4) {
                Imprimir(alunoHash);
            }
        }
        scanner.close();
    }

    private static void Inserir(Hash alunoHash, Scanner scanner) {
        System.out.print("Digite o RA: ");
        var ra = scanner.nextInt();
        System.out.print("Digite o nome: ");
        var nome = scanner.next();
        alunoHash.Inserir(ra, nome);
    }

    private static void Deletar(Hash alunoHash, Scanner scanner) {
        System.out.print("Digite o RA: ");
        int ra = scanner.nextInt();
        Aluno aluno = alunoHash.Deletar(ra);
        if (aluno != null)
            System.out.printf("Deletado. %d %s\n", aluno.obterRa(), aluno.obterNome());
        else
            System.out.println("Aluno não encontrado");
    }

    private static void Buscar(Hash alunoHash, Scanner scanner) {
        System.out.print("Digite o RA: ");
        int ra = scanner.nextInt();
        var aluno = alunoHash.Buscar(ra);
        if (aluno != null)
            System.out.printf("Encontrado. %d %s\n", aluno.obterRa(), aluno.obterNome());
        else
            System.out.println("Aluno não encontrado");
    }

    private static void Imprimir(Hash alunoHash) {
        alunoHash.Imprimir();
    }

    private static void TestarEficiencia() {
        TesteTabelaLinear();
        TesteExclusaoLogica();
    }

    private static void TesteTabelaLinear() {
        Hash tabela = new Hash(8, 8);
        long startTimeLinear = System.nanoTime();

        tabela.Inserir(101, "Alice");
        tabela.Inserir(201, "Bob");
        tabela.Inserir(301, "Charlie");

        tabela.Buscar(101);
        tabela.Buscar(201);
        tabela.Buscar(301);

        long endTimeLinear = System.nanoTime();
        long durationLinear = TimeUnit.NANOSECONDS.toMillis(endTimeLinear - startTimeLinear);
        System.out.println("Tempo de execução para a sondagem linear: " + durationLinear + " ms.");
    }

    private static void TesteExclusaoLogica() {
        Hash tabela = new Hash(8, 8);
        long startTimeExclusaoLogica = System.nanoTime();

        tabela.Inserir(101, "Alice");
        tabela.Inserir(201, "Bob");
        tabela.Inserir(301, "Charlie");

        tabela.Deletar(201);

        tabela.Buscar(101);
        tabela.Buscar(301);

        long endTimeExclusaoLogica = System.nanoTime();
        long durationExclusaoLogica = TimeUnit.NANOSECONDS.toMillis(endTimeExclusaoLogica - startTimeExclusaoLogica);
        System.out.println("Tempo de execução para a exclusão lógica: " + durationExclusaoLogica + " ms.");

    }
}
