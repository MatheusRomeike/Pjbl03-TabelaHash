public class Aluno {
    private int Ra;
    private String Nome;

    public Aluno() {
        Ra = -1;
        Nome = " ";
    }
    public Aluno(int ra, String nome) {
        Ra = ra;
        Nome = nome;
    }

    public int obterRa() {
        return Ra;
    }
    public String obterNome() {
        return Nome;
    }
}
