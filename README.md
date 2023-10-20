# Tabela Hash com Tratamento de Colisões

Este programa implementa uma tabela hash que pode lidar com colisões usando duas técnicas: sondagem linear e exclusão lógica. Ele é capaz de armazenar nós com chaves do tipo inteiro.

## Funcionamento do Programa

### Implementação da Tabela Hash

A tabela hash é implementada com base em uma lista de alunos. A capacidade da tabela é determinada durante a inicialização.

### Função de Hash

A função de hash é usada para calcular o índice de inserção dos nós na tabela hash. Para chaves do tipo inteiro, o índice é calculado como o resto da divisão da chave pelo tamanho da tabela.

### Tratamento de Colisões

1. Sondagem Linear: Se ocorrer uma colisão durante a inserção, o programa usa a técnica de sondagem linear, procurando o próximo slot disponível na tabela hash e adicionando o novo nó nesse slot.

2. Exclusão Lógica: A deleção é feita de maneira lógica, onde, não se precisa reordenar a tabela ao excluir um elemento, já que elementos excluidos são identificáveis.

### Operações Suportadas

O programa suporta as seguintes operações na tabela hash:

- Inserção de Aluno.
- Busca de Nó por Ra.
- Remoção de Nó por Ra.

## Uso do Código

O arquivo `HashTable.java` contém a implementação da tabela hash, juntamente com as funções de hash, tratamento de colisões e operações de manipulação da tabela. O arquivo `Main.java` contém exemplos de uso das operações da tabela hash.

