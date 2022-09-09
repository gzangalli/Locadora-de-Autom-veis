/**
 * Classe para representar um veículo popular na locadora
 */
package modelo;

public class Veiculos_populares extends Veiculos {

	public Veiculos_populares(String placa, int ano_modelo, int capacidade, double valor_base_diar) {
		super(placa, ano_modelo, capacidade, valor_base_diar);
	}
	
	@Override
	public double getValor_base_diar() {
		return super.getValor_base_diar();
	}
}