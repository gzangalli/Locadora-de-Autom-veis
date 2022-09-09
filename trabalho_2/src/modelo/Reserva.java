/**
 * Classe para representar a reserva de um veículo na locadora
 */
package modelo;

import java.time.LocalDate;
import java.util.Date;

public class Reserva {
	private Cliente cliente ;
    private	Veiculos veiculo ;
    private	LocalDate dataRetirada;
    private LocalDate dataDevolucao;
    
	public Reserva(Cliente cliente, Veiculos veiculo, LocalDate dataRetirada, LocalDate dataDevolucao) {
		this.cliente = cliente;
		this.veiculo = veiculo;
		this.dataRetirada = dataRetirada;
		this.dataDevolucao = dataDevolucao;
	}
	
	public LocalDate getDatadevolucao() {
		return dataDevolucao;
	}
	public void setDatadevolucao(LocalDate datadevolucao) {
		this.dataDevolucao = datadevolucao;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Veiculos getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculos veiculo) {
		this.veiculo = veiculo;
	}
	
	public LocalDate getDataretirada() {
		return dataRetirada;
	}
	public void setDataretirada(LocalDate dataretirada) {
		this.dataRetirada = dataretirada;
	}
}