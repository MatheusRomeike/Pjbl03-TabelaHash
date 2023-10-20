public class Hash {
    private int MaximoItens;
    private int MaximoPosicoes;
    private int QuantidadeItens;
    private Aluno[] Estrutura;
    private static final double FATOR_CARGA_MAXIMO = 0.75;

    private double calcularFatorCarga() {
        return (double) QuantidadeItens / MaximoPosicoes;
    }

    private void redimensionarTabela() {
        int novoTamanho = MaximoPosicoes * 2; // Dobra o tamanho do array
        Aluno[] novaEstrutura = new Aluno[novoTamanho];

        for (int i = 0; i < novoTamanho; i++)
            novaEstrutura[i] = new Aluno();

        for (Aluno aluno : Estrutura) {
            if (aluno.obterRa() != -1) {
                int indice = FuncaoHash(aluno.obterRa());
                while (novaEstrutura[indice].obterRa() != -1 && novaEstrutura[indice].obterRa() != -2) {
                    indice = (indice + 1) % novoTamanho;
                }
                novaEstrutura[indice] = aluno;
            }
        }
        Estrutura = novaEstrutura;
        MaximoPosicoes = novoTamanho;
    }
    private int FuncaoHash(int ra) {
        return ra % MaximoPosicoes;
    }
    public Hash(int maximoItens, int maximoPosicoes) {
        QuantidadeItens = 0;
        MaximoItens = maximoItens;
        MaximoPosicoes = maximoPosicoes;
        Estrutura = new Aluno[MaximoPosicoes];
        for (int i = 0; i < MaximoPosicoes; i++)
            Estrutura[i] = new Aluno();
    }
    public void Destruir() {
        QuantidadeItens = 0;
        Estrutura = new Aluno[MaximoPosicoes];
    }
    public boolean EstaCheio() {
        return QuantidadeItens == MaximoItens;
    }
    public int ObterTamanhoAtual() {
        return QuantidadeItens;
    }
    public void Inserir(int ra, String nome) {
        if (calcularFatorCarga() >= FATOR_CARGA_MAXIMO) {
            redimensionarTabela();
        }
        int indice = FuncaoHash(ra);
        while (Estrutura[indice].obterRa() != -1 && Estrutura[indice].obterRa() != -2) {
            indice = (indice + 1) % MaximoPosicoes;
        }
        Estrutura[indice] = new Aluno(ra, nome);
        QuantidadeItens++;
    }
    public Aluno Deletar(int ra) {
        int indice = FuncaoHash(ra);
        while (Estrutura[indice].obterRa() != -1) {
            if (Estrutura[indice].obterRa() == ra)
                break;
            indice = (indice + 1) % MaximoPosicoes;
        }
        Estrutura[indice] = new Aluno(-2, " ");
        QuantidadeItens--;
        return Estrutura[indice];
    }
    public Aluno Buscar(int ra) {
        int indice = FuncaoHash(ra);
        while (Estrutura[indice].obterRa() != -1) {
            if (Estrutura[indice].obterRa() == ra)
                break;
            indice = (indice + 1) % MaximoPosicoes;
        }
        if (Estrutura[indice].obterRa() == ra)
            return Estrutura[indice];
        else
            return null;
    }
    public void Imprimir() {
        System.out.println("Tabela Hash: \n");
        for (int i = 0; i < MaximoPosicoes; i++) {
            System.out.printf("Posicao %d: ", i);
            Aluno aluno = Estrutura[i];
            if (aluno.obterRa() != -1)
                System.out.printf("%d %s\n", Estrutura[i].obterRa(), Estrutura[i].obterNome());
            else
                System.out.printf("Vazio\n");
        }
    }
}
