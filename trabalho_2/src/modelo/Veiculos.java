/**
 * Classe para representar os veiculos da locadora
 */
package modelo;

public class Veiculos {
	
	private String placa;
	private int ano_modelo;
	private int capacidade;
	private double valor_base_diar;
	
	public Veiculos() {
	}
	
	public double base_unico() {
		return this.valor_base_diar;
	}
	
	public Veiculos(String placa,int ano_modelo,int capacidade, double valor_base_diar) {
		this.placa = placa;
		this.ano_modelo = ano_modelo;
		this.capacidade = capacidade;
		this.valor_base_diar = valor_base_diar;
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public int getAno_modelo() {
		return ano_modelo;
	}
	public void setAno_modelo(int ano_modelo) {
		this.ano_modelo = ano_modelo;
	}
	
	public int getcapacidade() {
		return capacidade;
	}
	public void setCapac_cidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
	public double getValor_base_diar() {
		return valor_base_diar;
	}
	public void setValor_base_diar(double valor_base_diar) {
		this.valor_base_diar = valor_base_diar;
	}	
}