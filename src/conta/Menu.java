package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.util.Cores;
import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class Menu {

	public static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		ContaController contas = new ContaController();

		int opcao, numero, agencia, tipo, cpf, numeroDestino;
		String titular;
		float saldo, limite, valor;

		System.out.println("\nCriar Conats\n");

		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "Millena", 1000f, 100.0f);
		contas.cadastrar(cc1);

		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Isabella", 2000f, 100.0f);
		contas.cadastrar(cc2);

		ContaCorrente cp1 = new ContaCorrente(contas.gerarNumero(), 125, 2, "Silvana", 4000f, 12);
		contas.cadastrar(cp1);

		ContaCorrente cp2 = new ContaCorrente(contas.gerarNumero(), 125, 2, "Andressa", 8000f, 100.0f);
		contas.cadastrar(cp2);

		while (true) {

			System.out.println(Cores.TEXT_PURPLE + Cores.ANSI_BLACK_BACKGROUND
					+ "***********************************************************");
			System.out.println("                                                           ");
			System.out.println("                       BANCO MIL                           ");
			System.out.println("                                                           ");
			System.out.println("***********************************************************");
			System.out.println("                                                           ");
			System.out.println("                1 - CRIAR CONTA                            ");
			System.out.println("                2 - LISTAR TODAS AS CONTAS                 ");
			System.out.println("                3 - BUSCAR CONTA POR NÚMERO                ");
			System.out.println("                4 - ATUALIZAR DADOS DA CONTA               ");
			System.out.println("                5 - APAGAR CONTA                           ");
			System.out.println("                6 - SACAR                                  ");
			System.out.println("                7 - DEPOSITAR                              ");
			System.out.println("                8 - TRASFERIR VALORES ENTRE CONTAS         ");
			System.out.println("                9 - SAIR                                   ");
			System.out.println("                                                           ");
			System.out.println("***********************************************************");
			System.out.println("                                                           ");
			System.out.println("ENTRE COM A OPÇÃO DESEJADA:                                ");
			System.out.println("                                                           " + Cores.TEXT_RESET);

			try {

				opcao = leia.nextInt();

			} catch (InputMismatchException e) {

				System.out.println("\nDigite valores interiros!");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 9) {

				System.out.println(Cores.TEXT_WHITE_BOLD + "\n ATÉ LOGO - BANCO MIL");
				sobre();
				leia.close();
				System.exit(0);

			}

			switch (opcao) {

			case 1:

				System.out.println(Cores.TEXT_WHITE + "Criar Conta \n\n");

				System.out.println("Digite o Número da Agência: ");
				agencia = leia.nextInt();

				System.out.println("Digite o Nome do Titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();

				do {

					System.out.println("Digite o Tipo da Conta (1)Conta Corrente ou (2) Conta Poupança: ");
					tipo = leia.nextInt();

				} while (tipo < 1 && tipo > 2);

				System.out.println("Digite o Saldo da Conta (R$): ");
				saldo = leia.nextFloat();

				switch (tipo) {

				case 1 -> {
					System.out.println("Digite o Limite de Crédito (R$): ");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}

				case 2 -> {
					System.out.println("Digite o cpf: ");
					cpf = leia.nextInt();
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, cpf));
				}

				}

				keyPress();
				break;

			case 2:

				System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas \n\n");
				contas.listarTodas();
				keyPress();
				break;

			case 3:

				System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número \n\n");

				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();

				contas.procurarPorNumero(numero);

				keyPress();
				break;

			case 4:

				System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta \n\n");

				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();

				var buscaConta = contas.buscarNaCollection(numero);

				if (buscaConta != null) {

					tipo = buscaConta.getTipo();

					System.out.println("Digite o Numero da Agencia: ");
					agencia = leia.nextInt();
					System.out.println("Digite o Nome do Titular: ");
					leia.skip("\\R?");
					titular = leia.nextLine();

					System.out.println("Digite o Saldo da Conta (R$): ");
					saldo = leia.nextFloat();

					switch (tipo) {

					case 1 -> {

						System.out.println("Digite o Limite de Crédito (R$): ");
						limite = leia.nextFloat();

						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));

					}

					case 2 -> {

						System.out.println("Digite o dia do Cpf da Conta: ");
						cpf = leia.nextInt();

						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, cpf));

					}

					default -> {

						System.out.println("Tipo de conta inválido!");

					}

					}

				} else {

					System.out.println("A Conta não foi encontrada!");

				}

				keyPress();
				break;

			case 5:

				System.out.println(Cores.TEXT_WHITE + "Apagar a Conta \n\n");

				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();

				contas.deletar(numero);

				keyPress();
				break;

			case 6:

				System.out.println(Cores.TEXT_WHITE + "Saque \n\n");

				System.out.println("Digite o Numero da conta: ");
				numero = leia.nextInt();

				do {

					System.out.println("Digite o Valor do Saque (R$): ");
					valor = leia.nextFloat();

				} while (valor <= 0);

				contas.sacar(numero, valor);

				keyPress();
				break;

			case 7:

				System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");

				System.out.println("Digite o Numero da conta: ");
				numero = leia.nextInt();

				do {

					System.out.println("Digite o Valor do Depósito (R$): ");
					valor = leia.nextFloat();

				} while (valor <= 0);

				contas.depositar(numero, valor);

				keyPress();
				break;

			case 8:

				System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas \n\n");

				System.out.println("Digite o Numero da Conta de Origem: ");
				numero = leia.nextInt();

				System.out.println("Digite o Numero da Conta de Destino: ");
				numeroDestino = leia.nextInt();

				do {

					System.out.println("Digite o Valor da Transfêrencia (R$): ");
					valor = leia.nextFloat();

				} while (valor <= 0);

				contas.transferir(numero, numeroDestino, valor);

				keyPress();
				break;

			default:

				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n");
				keyPress();
				break;
			}
		}
	}

	public static void sobre() {

		System.out.println("\n***********************************************************");
		System.out.println("Projeto Desenvolvimento por:");
		System.out.println("Millena Oliveira");
		System.out.println("***********************************************************");

	}

	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}
	}
}
