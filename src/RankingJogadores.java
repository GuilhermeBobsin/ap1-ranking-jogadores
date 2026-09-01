import java.util.Random;
import java.util.Scanner;

public class RankingJogadores {

    // ==========================================================
    // MÉTODO 1 - DADOS PADRÃO
    // ==========================================================

    public static void carregarDadosPadrao(
            String[] jogadores,
            int[][] pontuacoes
    ) {

        // Nomes
        jogadores[0] = "Jogador 1";
        jogadores[1] = "Jogador 2";
        jogadores[2] = "Jogador 3";
        jogadores[3] = "Jogador 4";
        jogadores[4] = "Jogador 5";


        // Jogador 1
        pontuacoes[0][0] = 80;
        pontuacoes[0][1] = 90;
        pontuacoes[0][2] = 70;
        pontuacoes[0][3] = 85;


        // Jogador 2
        pontuacoes[1][0] = 70;
        pontuacoes[1][1] = 75;
        pontuacoes[1][2] = 80;
        pontuacoes[1][3] = 90;


        // Jogador 3
        pontuacoes[2][0] = 95;
        pontuacoes[2][1] = 90;
        pontuacoes[2][2] = 85;
        pontuacoes[2][3] = 95;


        // Jogador 4
        pontuacoes[3][0] = 60;
        pontuacoes[3][1] = 80;
        pontuacoes[3][2] = 70;
        pontuacoes[3][3] = 75;


        // Jogador 5
        pontuacoes[4][0] = 85;
        pontuacoes[4][1] = 80;
        pontuacoes[4][2] = 90;
        pontuacoes[4][3] = 80;
    }


    // ==========================================================
    // MÉTODO 2 - CADASTRO MANUAL
    // ==========================================================

    public static void cadastrarJogadores(
            Scanner scanner,
            String[] jogadores,
            int[][] pontuacoes
    ) {

        // Limpa o ENTER que ficou no Scanner
        scanner.nextLine();


        for (int i = 0; i < jogadores.length; i++) {

            System.out.println();
            System.out.println("----------------------------------------");
            System.out.println("Cadastro do jogador " + (i + 1));
            System.out.println("----------------------------------------");


            // Nome
            System.out.print("Nome: ");

            jogadores[i] = scanner.nextLine();


            // Pontuações das quatro rodadas
            for (int j = 0; j < pontuacoes[i].length; j++) {

                do {

                    System.out.print(
                            "Pontuação da rodada "
                                    + (j + 1)
                                    + " (0 a 100): "
                    );

                    pontuacoes[i][j] = scanner.nextInt();


                    if (
                            pontuacoes[i][j] < 0
                                    || pontuacoes[i][j] > 100
                    ) {

                        System.out.println(
                                "Pontuação inválida. "
                                        + "Digite um valor entre 0 e 100."
                        );

                    }

                } while (
                        pontuacoes[i][j] < 0
                                || pontuacoes[i][j] > 100
                );
            }


            // Limpa o ENTER antes do próximo nome
            scanner.nextLine();
        }
    }


    // ==========================================================
    // MÉTODO 3 - CADASTRAR NOMES
    // ==========================================================

    public static void cadastrarNomes(
            Scanner scanner,
            String[] jogadores
    ) {

        // Limpa o ENTER
        scanner.nextLine();


        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("Cadastro dos jogadores");
        System.out.println("----------------------------------------");


        for (int i = 0; i < jogadores.length; i++) {

            System.out.print(
                    "Nome do jogador "
                            + (i + 1)
                            + ": "
            );

            jogadores[i] = scanner.nextLine();
        }
    }


    // ==========================================================
    // MÉTODO 4 - GERAR PONTUAÇÕES ALEATÓRIAS
    // ==========================================================

    public static void gerarPontuacoesAleatorias(
            int[][] pontuacoes,
            int numeroRodadas
    ) {

        Random random = new Random();


        for (int i = 0; i < pontuacoes.length; i++) {

            for (int j = 0; j < numeroRodadas; j++) {

                /*
                 * nextInt(101) gera números de 0 até 100.
                 */

                pontuacoes[i][j] = random.nextInt(101);
            }
        }
    }


    // ==========================================================
    // MÉTODO 5 - CALCULAR PONTUAÇÃO TOTAL
    // ==========================================================

    public static int[] calcularPontuacaoTotal(
            int[][] pontuacoes
    ) {

        int[] totais = new int[pontuacoes.length];


        for (int i = 0; i < pontuacoes.length; i++) {

            int soma = 0;


            for (int j = 0; j < pontuacoes[i].length; j++) {

                soma += pontuacoes[i][j];
            }


            totais[i] = soma;
        }


        return totais;
    }


    // ==========================================================
    // MÉTODO 6 - CONSULTAR JOGADOR
    // ==========================================================

    public static int[] consultarJogador(
            String[] jogadores,
            int[] totais,
            String nome
    ) {

        /*
         * Procura o jogador no vetor já ordenado.
         */

        for (int i = 0; i < jogadores.length; i++) {

            if (jogadores[i].equalsIgnoreCase(nome)) {

                /*
                 * Criamos um vetor com duas posições:
                 *
                 * posição 0 = total de pontos
                 * posição 1 = posição no ranking
                 */

                int[] resultado = new int[2];


                resultado[0] = totais[i];

                resultado[1] = i + 1;


                return resultado;
            }
        }


        /*
         * Se o jogador não foi encontrado,
         * retorna null.
         */

        return null;
    }


    // ==========================================================
    // MÉTODO 7 - SOMAR PONTUAÇÕES DE UMA RODADA
    // ==========================================================

    public static int somarPontuacoesRodada(
            int[][] pontuacoes,
            int rodada
    ) {

        int soma = 0;


        /*
         * O usuário informa:
         *
         * rodada 1
         * rodada 2
         * rodada 3
         * rodada 4
         *
         * Mas os índices da matriz começam em 0.
         *
         * Por isso:
         *
         * rodada 1 -> coluna 0
         * rodada 2 -> coluna 1
         * rodada 3 -> coluna 2
         * rodada 4 -> coluna 3
         */

        int coluna = rodada - 1;


        for (int i = 0; i < pontuacoes.length; i++) {

            soma += pontuacoes[i][coluna];
        }


        return soma;
    }


    // ==========================================================
    // MÉTODO 8 - EXIBIR RANKING
    // ==========================================================

    public static void exibirRanking(
            String[] jogadores,
            int[] totais
    ) {

        for (int i = 0; i < jogadores.length; i++) {

            System.out.println(
                    (i + 1)
                            + "º "
                            + jogadores[i]
                            + " - "
                            + totais[i]
                            + " pontos"
            );
        }
    }


    // ==========================================================
    // MÉTODO 9 - BUBBLE SORT
    // ==========================================================

    public static void bubbleSort(
            String[] jogadores,
            int[] totais
    ) {

        /*
         * Ordenação decrescente:
         * maior pontuação primeiro.
         */

        for (int i = 0; i < totais.length - 1; i++) {

            for (
                    int j = 0;
                    j < totais.length - 1 - i;
                    j++
            ) {

                if (totais[j] < totais[j + 1]) {

                    // Troca a pontuação
                    int tempTotal = totais[j];

                    totais[j] = totais[j + 1];

                    totais[j + 1] = tempTotal;


                    // Troca o nome junto
                    String tempJogador = jogadores[j];

                    jogadores[j] = jogadores[j + 1];

                    jogadores[j + 1] = tempJogador;
                }
            }
        }
    }


    // ==========================================================
    // MÉTODO 10 - MERGE SORT
    // ==========================================================

    public static void mergeSort(
            String[] jogadores,
            int[] totais
    ) {

        mergeSortRecursivo(
                jogadores,
                totais,
                0,
                totais.length - 1
        );
    }


    // ==========================================================
    // MÉTODO 11 - MERGE SORT RECURSIVO
    // ==========================================================

    private static void mergeSortRecursivo(
            String[] jogadores,
            int[] totais,
            int inicio,
            int fim
    ) {

        if (inicio < fim) {

            int meio = (inicio + fim) / 2;


            // Primeira metade
            mergeSortRecursivo(
                    jogadores,
                    totais,
                    inicio,
                    meio
            );


            // Segunda metade
            mergeSortRecursivo(
                    jogadores,
                    totais,
                    meio + 1,
                    fim
            );


            // Junta as duas partes
            intercalar(
                    jogadores,
                    totais,
                    inicio,
                    meio,
                    fim
            );
        }
    }


    // ==========================================================
    // MÉTODO 12 - INTERCALAR MERGE SORT
    // ==========================================================

    private static void intercalar(
            String[] jogadores,
            int[] totais,
            int inicio,
            int meio,
            int fim
    ) {

        int tamanho = fim - inicio + 1;


        int[] totaisTemporarios =
                new int[tamanho];


        String[] jogadoresTemporarios =
                new String[tamanho];


        int i = inicio;

        int j = meio + 1;

        int k = 0;


        /*
         * Compara os elementos das duas partes.
         *
         * O maior fica primeiro.
         */

        while (i <= meio && j <= fim) {

            if (totais[i] >= totais[j]) {

                totaisTemporarios[k] = totais[i];

                jogadoresTemporarios[k] = jogadores[i];

                i++;

            } else {

                totaisTemporarios[k] = totais[j];

                jogadoresTemporarios[k] = jogadores[j];

                j++;
            }

            k++;
        }


        // Elementos restantes da primeira metade
        while (i <= meio) {

            totaisTemporarios[k] = totais[i];

            jogadoresTemporarios[k] = jogadores[i];

            i++;

            k++;
        }


        // Elementos restantes da segunda metade
        while (j <= fim) {

            totaisTemporarios[k] = totais[j];

            jogadoresTemporarios[k] = jogadores[j];

            j++;

            k++;
        }


        /*
         * Copia os valores temporários
         * para os vetores originais.
         */

        for (k = 0; k < tamanho; k++) {

            totais[inicio + k] =
                    totaisTemporarios[k];

            jogadores[inicio + k] =
                    jogadoresTemporarios[k];
        }
    }
}