package br.com.java.pacote;

import javax.swing.JOptionPane;

import br.com.poo.metodos.*;

public class GPS {

	// Atributos, definidos como privado, ou seja, só podem ser acessados pela
	// própria classe, os métodos encapsulados devem ser acessados pelos métodos
	// públicos getters e setters
	private String idioma;

	private String rota;

	/*
	 * 
	 * Quando uma classe é definida sem nenhum construtor específico, o compilador
	 * Java cria automaticamente um construtor padrão sem argumentos para essa
	 * classe.
	 */

	// Acessando os atributos encapsulados através dos getters e setters.
	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {

		// Método para verificação de dados do tipo String

		TratarDados.tratarString(idioma);
		// Acessando o atributo encapsulado através dos getters e setters
		this.idioma = idioma;
	}

	public String getRota() {
		return rota;
	}

	public void setRota(String rota) {
		// Acessando o atributo encapsulado através dos getters e setters

		// Método para verificação de dados do tipo String
		TratarDados.tratarString(rota);

		this.rota = rota;
	}

	// Método que imprime os dados fornecidos
	public void mostrarDados() {

		JOptionPane.showMessageDialog(null, "Idioma fornecido: " + getIdioma() + "\nRota fornecida: " + getRota());
	}

}
