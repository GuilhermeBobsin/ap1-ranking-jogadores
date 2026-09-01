import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] jogadores = new String[5];

        int[][] pontuacoes = new int[5][4];

        int opcao;

        System.out.println("========================================");
        System.out.println("       RANKING DE JOGADORES");
        System.out.println("========================================");
        System.out.println("1 - Usar dados padrão");
        System.out.println("2 - Cadastrar jogadores manualmente");
        System.out.println("3 - Gerar pontuações aleatórias");
        System.out.println("========================================");

        do {

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            if (opcao < 1 || opcao > 3) {

                System.out.println("Opção inválida. Digite 1, 2 ou 3.");

            }

        } while (opcao < 1 || opcao > 3);


        switch (opcao) {

            case 1:

                RankingJogadores.carregarDadosPadrao(
                        jogadores,
                        pontuacoes
                );

                break;


            case 2:

                RankingJogadores.cadastrarJogadores(
                        scanner,
                        jogadores,
                        pontuacoes
                );

                break;


            case 3:

                RankingJogadores.cadastrarNomes(
                        scanner,
                        jogadores
                );

                RankingJogadores.gerarPontuacoesAleatorias(
                        pontuacoes,
                        4
                );

                break;
        }


        int[] totais = RankingJogadores.calcularPontuacaoTotal(
                pontuacoes
        );


        String[] jogadoresMerge = jogadores.clone();

        int[] totaisMerge = totais.clone();

        RankingJogadores.mergeSort(
                jogadoresMerge,
                totaisMerge
        );


        System.out.println();
        System.out.println("========================================");
        System.out.println("         RANKING - MERGE SORT");
        System.out.println("========================================");

        RankingJogadores.exibirRanking(
                jogadoresMerge,
                totaisMerge
        );

        String[] jogadoresBubble = jogadores.clone();

        int[] totaisBubble = totais.clone();

        RankingJogadores.bubbleSort(
                jogadoresBubble,
                totaisBubble
        );


        System.out.println();
        System.out.println("========================================");
        System.out.println("         RANKING - BUBBLE SORT");
        System.out.println("========================================");

        RankingJogadores.exibirRanking(
                jogadoresBubble,
                totaisBubble
        );

        scanner.nextLine();

        System.out.println();
        System.out.println("========================================");
        System.out.println("         CONSULTA DE JOGADOR");
        System.out.println("========================================");

        System.out.print("Digite o nome do jogador: ");

        String nome = scanner.nextLine();

        int[] resultado = RankingJogadores.consultarJogador(
                jogadoresMerge,
                totaisMerge,
                nome
        );


        if (resultado != null) {

            System.out.println(
                    nome
                            + " possui "
                            + resultado[0]
                            + " pontos e está em "
                            + resultado[1]
                            + "º lugar no ranking."
            );

        } else {

            System.out.println("Jogador não encontrado.");

        }

        System.out.println();
        System.out.println("========================================");
        System.out.println("       TOTAL DE PONTOS DA RODADA");
        System.out.println("========================================");

        int rodada;

        do {

            System.out.print("Digite a rodada (1 a 4): ");

            rodada = scanner.nextInt();

            if (rodada < 1 || rodada > 4) {

                System.out.println(
                        "Rodada inválida. Digite um número entre 1 e 4."
                );

            }

        } while (rodada < 1 || rodada > 4);


        int totalRodada =
                RankingJogadores.somarPontuacoesRodada(
                        pontuacoes,
                        rodada
                );


        System.out.println(
                "Total de pontos da rodada "
                        + rodada
                        + ": "
                        + totalRodada
        );


        scanner.close();
    }

}