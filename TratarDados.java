package br.com.poo.metodos;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import br.com.poo.pacote.Tarefa;

public class TratarDados {

	// Método sem retorno que recebe como parâmetro uma String.
	public static void tratarString(String palavra) {

		try {

			// remove os espaços iniciais e finais de uma String.

			palavra = palavra.trim();

			// Converte os caracteres em letras minúsculas, para obter uma padronização

			palavra = palavra.toLowerCase();

			// Verifica se a palavra é igual a nulo
			if (palavra.equals(null)) {

				// Gera uma mensagem de erro no prompt
				JOptionPane.showMessageDialog(null, "O campo está vazio, porém precisa ser preenchido adequadamente!",
						null, JOptionPane.ERROR_MESSAGE);

			}

			// Limitando a quantidade de caracteres que usuário pode digitar nesse campo
			else if (palavra.length() > 50) {

				// Gera uma mensagem de erro no prompt
				JOptionPane.showMessageDialog(null,
						"A quantidade de caracteres que você inseriu ultrapassou os limites, tente novamente", null,
						JOptionPane.WARNING_MESSAGE);

			}

			// Tratamento de exceções com try catch
		} catch (NullPointerException erro) {

			// gera uma mensagem intuitiva no prompt, informando que o usuário fechou o
			// programa de maneira incorreta
			JOptionPane.showMessageDialog(null, "O programa foi finalizado incorretamente", null,
					JOptionPane.ERROR_MESSAGE);

		}

	}

	// Método sem retorno que trata números decimais
	public static void tratarDecimais(Double valor) {

		try {

			// Se o valor decimal for um número negativo ou igual a zero gera um erro
			if (valor <= 0) {

				// Imprime a mensagem no prompt
				JOptionPane.showMessageDialog(null, "Não é possível inserir um valor negativo ou igual a zero!!", null,
						JOptionPane.ERROR_MESSAGE);

				// Se o valor for maior do que 300 , gera outro erro no prompt
			} else if (valor > 300) {

				// Imprime a mensagem de erro no prompt
				JOptionPane.showMessageDialog(null,
						"O valor digitado excedeu os limites, digite apenas valores menores do que 300 e maiores do que zero!!",
						null, JOptionPane.ERROR_MESSAGE);

			}
		} catch (NumberFormatException | NullPointerException erro) {

			// verifica dados não numéricos e se o programa foi fechado incorretamente, com
			// um ícone intuitivo no prompt
			JOptionPane.showMessageDialog(null,
					"Dados não numéricos foram inseridos ou o programa foi fechado incorretamente", null,
					JOptionPane.ERROR_MESSAGE);

		}
	}

	// Método sem retorno para tratamento de ano
	public static void tratarInteiros(int ano) {

		LocalDate anoAtual = LocalDate.now();

		// Se o ano for um número negativo ou igual a zero, gera uma mensagem de erro no
		// prompt.

		try {

			if (ano <= 0) {

				// Imprime no prompt uma verificação de erro
				JOptionPane.showMessageDialog(null,
						"Digite um valor maior do que zero, apenas números inteiros positivos são aceitos", null,
						JOptionPane.ERROR_MESSAGE);

			}

			// Se o ano que foi inserido for maior do que o ano atual (2023), gera um erro!
			else if (ano > anoAtual.getYear()) {

				JOptionPane.showMessageDialog(null,
						"Digite apenas valores menores do que o ano atual : " + anoAtual.getYear(), null,
						JOptionPane.ERROR_MESSAGE);

			}

			// Estrutura try catch, verifica se o dado inserido pelo usuário é um dado não
			// numérico ou se o programa foi fechado incorretamente
		} catch (NumberFormatException | NullPointerException erro) {

			// Gera uma mensagem intuitiva no prompt
			JOptionPane.showMessageDialog(null,
					"Dados não numéricos foram inseridos ou o programa foi finalizado incorretamente");
		}
	}

	// Método sem retorno para tratamento de valores booleanos
	public static void tratarBoolean(Boolean status) {

		// Se o "status" for igual a vazio, gera um erro
		if (status == null) {

			JOptionPane.showMessageDialog(null,
					"Nenhum valor válido foi fornecido, insira nesse campo apenas true ou false", null,
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void tratarVetor(ArrayList<Object> objetos) {

		// Início do método tratarVetor

		try {

			// Início de um bloco try-catch para tratar exceções

			int idExcluir = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID da tarefa que deseja excluir:"));

			// Solicita ao usuário que insira o ID da tarefa a ser excluída e o converte
			// para um número inteiro.

			Iterator<Object> iterator = objetos.iterator();

			// Cria um objeto Iterator para percorrer a lista de objetos.

			while (iterator.hasNext()) {
				// Inicia um loop enquanto houver elementos na lista.

				Object elemento = iterator.next();
				// Obtém o próximo elemento da lista.

				if (elemento instanceof Tarefa) {

					Tarefa tarefa = (Tarefa) elemento;

					// Verifica se o elemento é uma instância da classe Tarefa.

					if (tarefa.getId() == idExcluir) {

						// Compara o ID da tarefa com o ID inserido pelo usuário.

						// Se for, remove.

						iterator.remove();

						// Imprime no prompt uma mensagem
						JOptionPane.showMessageDialog(null, "Tarefa removida com sucesso!");

						return; // Sai do loop assim que a tarefa é encontrada e removida
					}
				}
			}

			// Se o ID não corresponde a nenhuma tarefa, exibe uma mensagem de aviso.

			JOptionPane.showMessageDialog(null, "Tarefa com ID " + idExcluir + " não encontrada.", null,

					JOptionPane.WARNING_MESSAGE);

		} catch (NumberFormatException e) {

			// Captura uma possível exceção de conversão de número.

			JOptionPane.showMessageDialog(null, "ID inválido. Insira um número válido.", null,

					JOptionPane.ERROR_MESSAGE);

			// Exibe uma mensagem de erro se o ID inserido não for um número válido.

		}
	}

	public static String formatarDecimais(Double valor) {

		// Definindo uma variavel do tipo String, que recebe valores decimais.
		String decimalFormatado;

		// Instanciando um novo objeto do tipo DF
		DecimalFormat df = new DecimalFormat("R$ ####.##");

		decimalFormatado = df.format(valor);

		return decimalFormatado;

	}

	public static String formatarVelocidade(Double velocidade) {

		// Define uma variavel do tipo string
		String velocidadeFormatada;

		// Instancia um novo objeto e define um modelo de formatação
		DecimalFormat df = new DecimalFormat("##.## KM/h");

		velocidadeFormatada = df.format(velocidade);

		return velocidadeFormatada;
	}

}
