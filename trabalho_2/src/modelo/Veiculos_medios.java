/**
 * Classe para representar um veículo medio na locadora
 */
package modelo;

import java.util.Date;

public class Veiculos_medios extends Veiculos {
	public Veiculos_medios(String placa, int ano_modelo, int capacidade, double valor_base_diar) {
		super(placa, ano_modelo, capacidade, valor_base_diar);
		
	}
	
	@Override
	public double base_unico() {
		double mult;
		int ano = 2020;
		ano = ano - getAno_modelo();
		if (ano >= 5) {
			mult = getValor_base_diar() * (0.10);
			return getValor_base_diar() - mult;
		}
		else 
			mult = getValor_base_diar() * (0.02 * ano);
			return getValor_base_diar() - mult;
	}
	
	@Override
	public double getValor_base_diar() {
		return super.getValor_base_diar();
	}
}