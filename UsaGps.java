package br.com.java.pacote;

import javax.swing.JOptionPane;

public class UsaGps {

	public static void main(String[] args) {

		// Instanciando um novo objeto do tipo gps.
		GPS gps1 = new GPS();

		// Variaveís do tipo inteiro
		int opcao = 0;

		int escolha = 0;

		// Entrada do loop
		do {

			// Estrutura Try-catch
			try {

				// O usuário entra com um valor e define o caminho que o programa deve tomar.
				opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
						"ESCOLHA UMA OPÇÃO \n1-Definir rota do veículo \n2-Finalizar o programa"));

				// Estrutura switch-case
				switch (opcao) {

				// Se o usuário escolher a opção para definir os dados do GPS
				case 1:

					// Acessando os atributos encapsulados através dos métodos públicos getters e
					// setters, o método público permite que o atributo seja acessado, onde o método
					// atua como um mediador entre o parametro e o atributo
					gps1.setIdioma(JOptionPane.showInputDialog(null, "Defina o idioma que deseja:"));

					gps1.setRota(JOptionPane.showInputDialog(null,
							"Defina a rota que o veículo deve tomar, explique detalhadamente:"));

					escolha = JOptionPane.showConfirmDialog(null, "Deseja verificar a rota do veiculo?");

					if (escolha == 0) {

						// Caso a escolha seja igual a SIM(0) imprime no prompt os valores.
						gps1.mostrarDados();
					}

					else {

						// Caso contrário imprime uma mensagem genérica

						JOptionPane.showMessageDialog(null, "O programa foi finalizado!!");
					}

					break;

				case 2:

					// Caso contrário imprime uma mensagem no prompt informando que a opção
					// 2(finalizar programa) foi selecionada.

					JOptionPane.showMessageDialog(null, "O programa foi finalizado!!", null,
							JOptionPane.WARNING_MESSAGE);

					break;

				default:

					// Imprime no prompt uma mensagem caso nenhuma opção entre as duas seja
					// fornecida
					JOptionPane.showMessageDialog(null,
							"Nenhuma opção válida foi escolhida, portanto a aplicação foi finalizada", null,
							JOptionPane.WARNING_MESSAGE);

					break;
				}

				// Tratamento de exceções para dados não numéridos ou caso o programa seja
				// fechado incorretamente!!
			} catch (NumberFormatException | NullPointerException erro) {

				// Imprime no prompt o erro para auxiliar o usuário.

				JOptionPane.showMessageDialog(null,
						"Dados não numéricos foram inseridos ou o programa foi fechado incorretamente!!", null,
						JOptionPane.ERROR_MESSAGE);

				// Sai do loop

				break;

			}

			// Enquanto o valor inserido pelo usuário for maior do que zero, continue o
			// loop.
		} while (opcao > 0);
	}

}
