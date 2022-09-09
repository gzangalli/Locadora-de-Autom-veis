/**
 * Classe para representar um veículo do tipo grande na locadora
 */
package modelo;

public class Veiculos_grande  extends Veiculos{
	
	public Veiculos_grande(String placa, int ano_modelo, int capacidade, double valor_base_diar) {
		super(placa, ano_modelo, capacidade, valor_base_diar);
	}
	
	@Override
	public double base_unico() {
		if (getcapacidade() <= 5) {
			return getValor_base_diar();
		}
		else {
			if(getcapacidade() >= 9){
				return getValor_base_diar() + getValor_base_diar() * 0.20; 
			}
			else {
				return getValor_base_diar() + getValor_base_diar() * (getcapacidade() * 0.05);
			}
		}
	}
	
	@Override
	public double getValor_base_diar() {
		return super.getValor_base_diar();
	}
}