import java.util.Locale;
import java.util.Scanner;

public class ExerciciosSenac {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        int opcao;

        do {
            System.out.println("\n================ MENU DE OPÇÕES ================");
            System.out.println("1 - Sistema de Aumento de Salário");
            System.out.println("2 - Determinar Maior e Menor Valor (Encerra com 0)");
            System.out.println("3 - Estatísticas de Idade e Sexo (Encerra com 'N')");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    executarAumentoSalario(scanner);
                    break;
                case 2:
                    executarMaiorEMenorValor(scanner);
                    break;
                case 3:
                    executarEstatisticasGrupo(scanner);
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    // =========================================================================
    // ATIVIDADE ORIGINAL: Aumento de Salário
    // =========================================================================
    public static void executarAumentoSalario(Scanner scanner) {
        System.out.println("\n--- [1] Sistema de Aumento de Salário ---");
        System.out.print("Digite o salário atual do colaborador: R$ ");
        double salario = scanner.nextDouble();

        double aumento = calcularAumento(salario);
        double percentual = (aumento / salario) * 100;

        System.out.printf("Salário Base: R$ %.2f%n", salario);
        System.out.printf("Valor do Aumento: R$ %.2f%n", aumento);
        System.out.printf("Percentual de Aumento: %.2f%%%n", percentual);
        System.out.printf("Novo Salário: R$ %.2f%n", (salario + aumento));
    }

    public static double calcularAumento(double salarioAtual) {
        if (salarioAtual <= 1000.00) {
            return 193.56;
        } else if (salarioAtual <= 2000.00) {
            return 174.34;
        } else {
            return 127.89;
        }
    }

    // =========================================================================
    // EXERCÍCIO 1 DA IMAGEM: Menor e Maior valor (encerra digitando 0)
    // =========================================================================
    public static void executarMaiorEMenorValor(Scanner scanner) {
        System.out.println("\n--- [2] Maior e Menor Valor de um Conjunto ---");
        System.out.println("Digite números inteiros e positivos (Digite 0 para encerrar):");

        int valor;
        int maior = Integer.MIN_VALUE;
        int menor = Integer.MAX_VALUE;
        int quantidade = 0;

        while (true) {
            System.out.print("Digite um valor: ");
            valor = scanner.nextInt();

            if (valor == 0) {
                break; // Encerra o laço e não considera o 0
            }

            if (valor < 0) {
                System.out.println("Atenção: Digite apenas números inteiros e positivos!");
                continue;
            }

            if (valor > maior) {
                maior = valor;
            }

            if (valor < menor) {
                menor = valor;
            }

            quantidade++;
        }

        if (quantidade > 0) {
            System.out.println("\n--- Resultados ---");
            System.out.println("Maior valor lido: " + maior);
            System.out.println("Menor valor lido: " + menor);
        } else {
            System.out.println("Nenhum valor válido foi digitado.");
        }
    }

    // =========================================================================
    // EXERCÍCIO 2 DA IMAGEM: Idade e Sexo de um grupo (encerra com sexo 'N')
    // =========================================================================
    public static void executarEstatisticasGrupo(Scanner scanner) {
        System.out.println("\n--- [3] Estatísticas de Grupo (Idade e Sexo) ---");

        int totalPessoas = 0;
        int somaIdades = 0;
        int totalMasculino = 0;
        int totalFeminino = 0;

        int maiorIdadeM = Integer.MIN_VALUE;
        int menorIdadeF = Integer.MAX_VALUE;

        while (true) {
            System.out.print("Digite o sexo (M/F ou N para finalizar): ");
            char sexo = scanner.next().toUpperCase().charAt(0);

            if (sexo == 'N') {
                break; // Finaliza quando sexo == N
            }

            if (sexo != 'M' && sexo != 'F') {
                System.out.println("Sexo inválido! Digite apenas M, F ou N.");
                continue;
            }

            System.out.print("Digite a idade: ");
            int idade = scanner.nextInt();

            totalPessoas++;
            somaIdades += idade;

            if (sexo == 'M') {
                totalMasculino++;
                if (idade > maiorIdadeM) {
                    maiorIdadeM = idade;
                }
            } else { // sexo == 'F'
                totalFeminino++;
                if (idade < menorIdadeF) {
                    menorIdadeF = idade;
                }
            }
        }

        if (totalPessoas > 0) {
            double mediaIdade = (double) somaIdades / totalPessoas;
            double percentualM = ((double) totalMasculino / totalPessoas) * 100;
            double percentualF = ((double) totalFeminino / totalPessoas) * 100;

            System.out.println("\n--- Resultados do Grupo ---");
            System.out.printf("Média de idade do grupo: %.2f anos%n", mediaIdade);
            System.out.printf("Percentual do sexo Masculino: %.2f%%%n", percentualM);
            System.out.printf("Percentual do sexo Feminino: %.2f%%%n", percentualF);

            if (totalMasculino > 0) {
                System.out.println("Maior idade masculina: " + maiorIdadeM + " anos");
            } else {
                System.out.println("Nenhum homem registrado no grupo.");
            }

            if (totalFeminino > 0) {
                System.out.println("Menor idade feminina: " + menorIdadeF + " anos");
            } else {
                System.out.println("Nenhuma mulher registrada no grupo.");
            }
        } else {
            System.out.println("Nenhuma pessoa foi cadastrada.");
        }
    }
}
