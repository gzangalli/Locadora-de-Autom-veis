/**
 * Classe para ser a auxiliar da Interface Principal
 * Nesta classe estão os metodos a serem chamados na interface principal
 */
package Interface;
import java.text.DateFormat;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import modelo.Cliente;
import modelo.Reserva;
import modelo.Veiculos;
import modelo.Veiculos_grande;
import modelo.Veiculos_medios;
import modelo.Veiculos_populares;


public class Auxiliar {
	
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private static ArrayList<Veiculos> veiculos = new ArrayList<Veiculos>();
	private static  ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	private static Scanner escreve = new Scanner(System.in);
	/**
	 * Metodo para cadastro de cliente
	 */
	public static void Cadastro_cliente() {
	
		System.out.println("Informe o Nome do Cliente");
		String Nome_cli = escreve.nextLine();
		System.out.println("Informe o CPF do Cliente");
		String CPF = escreve.nextLine();
		boolean acha_cpf = false;
		for (Cliente cliente : clientes) {
			if(cliente.getCpf().equals(CPF)) {
				acha_cpf = true;
				break ;
			} 	
		}
		if (acha_cpf) {
			System.out.println("CPF ja Cadastrado");
		}
		else {
			System.out.println("Cliente Cadastrado com sucesso!!");
			Cliente cliente = new Cliente(Nome_cli,CPF);
			clientes.add(cliente);
		}
		System.out.println("\nTecle enter para voltar ao menu");
		escreve.nextLine();
	}
	/**
	 * Metodo para cadastro de veiculo
	 */
	public static void Cadastro_veiculo() {
		System.out.println("Informe a Placa do veiculo");
		String placa = escreve.nextLine();
		System.out.println("Informe o ano do veiculo");
		int ano_fab = escreve.nextInt();
		escreve.nextLine();
		System.out.println("Informe a capacidade do veiculo");
		int capacidade = escreve.nextInt();
		escreve.nextLine();
		System.out.println("Informe o valor base do veiculo");
		double valor_base = escreve.nextDouble();
		escreve.nextLine();
		System.out.println("Informe o tipo do veiculo:\n 1-Populares  2-Medio  3-Grande");
		int tipo_veicu = escreve.nextInt();
		escreve.nextLine();
		Veiculos veiculo = new Veiculos();
		switch (tipo_veicu) {
			case 1:
				veiculo = new Veiculos_populares(placa,ano_fab,capacidade,valor_base);
				System.out.println("Veiculo cadastrado como Popular");
				break ;
			case 2:
				veiculo = new Veiculos_medios(placa,ano_fab,capacidade,valor_base);
				System.out.println("Veiculo cadastrado como Médio");
				break ;
			case 3:
				veiculo = new Veiculos_grande(placa,ano_fab,capacidade,valor_base);
				System.out.println("Veiculo cadastrado como Grande");
				break ;
		}
		veiculos.add(veiculo);
		System.out.println("\nTecle enter para voltar ao menu");
		escreve.nextLine();
	}
	/**
	 * Metodo para aluguel de veículo
	 */
	public static void Aluga_automovel() {
		boolean acha_cpf = false;
		Cliente cliente_reserva = new Cliente();
		System.out.println("Informe o CPF do Cliente");
		String CPF = escreve.nextLine();
		for (Cliente cliente : clientes) {
			if(cliente.getCpf().equals(CPF)) {
				acha_cpf = true;
				cliente_reserva = cliente;
				break ;
			}
		}
		if (! acha_cpf) {
			System.out.println("CPF não encontrado");
			System.out.println("O usuario voltara ao menu");
		}
		else {
			System.out.println("Valor máximo da Diária");
			double diaria = escreve.nextDouble();
			escreve.nextLine();
			System.out.println("Informe a capacidade desejada");
			int capacidade = escreve.nextInt();
			escreve.nextLine();
			System.out.println("Informe o numero de dias");
			long numeroDias = escreve.nextLong();
			escreve.nextLine();
			ArrayList<Veiculos> reserva_veiculos = new ArrayList<Veiculos>();
			for (Veiculos veiculo : veiculos) {
				boolean existe_reserva = false;
				if((veiculo.getcapacidade() >= capacidade)&&(veiculo.getValor_base_diar()<= diaria)){
					for (Reserva reserva : reservas) {
						if(reserva.getVeiculo().equals(veiculo)) {
							existe_reserva = true;
							break;
						}
					}
					if(existe_reserva == false) {
						reserva_veiculos.add(veiculo);
					}
				}
			}
			if(reserva_veiculos.isEmpty()) {
				System.out.println("Não foram encontrados veiculos com as informações requeridas");
			}
			else {
				for (Veiculos veiculo : reserva_veiculos) {
					System.out.println("Identificador do veiculo:" + reserva_veiculos.indexOf(veiculo));
					System.out.println("Placa: " + veiculo.getPlaca());
					System.out.println("Ano: "+ veiculo.getAno_modelo());
					System.out.println("Capacidade: " + veiculo.getcapacidade() + "\n");
				}
				System.out.println("Escolha um veiculo pelo Identificador");
				int opcao = escreve.nextInt();
				escreve.nextLine();
				reserva_veiculos.get(opcao);
				LocalDate data_reserva = LocalDate.now();
				data_reserva.plusDays(numeroDias);
				reservas.add(new Reserva(cliente_reserva,reserva_veiculos.get(opcao),LocalDate.now(),data_reserva));
			}
		}
		System.out.println("\nTecle enter para voltar ao menu");
		escreve.nextLine();
	}
	/**
	 * Metodo para devolução devolução do veiculo
	 */
	public static void Devolve_automovel() {
		ArrayList<Reserva> reserva_auxiliar = new ArrayList<Reserva>();
		System.out.println("Informe o CPF do cliente:");
		String CPF1 = escreve.nextLine();
		for (Reserva R : reservas) {
			if (R.getCliente().getCpf().compareTo(CPF1) == 0) {
				reserva_auxiliar.add(R);
				System.out.println("Placa veiculos alugados nesse CPF: "+ R.getVeiculo().getPlaca());
			}
		}
		System.out.println("Informe a placa do veiculo:");
		String placa = escreve.nextLine();
		LocalDate dataConvertida = null ;
		for (Reserva R : reserva_auxiliar) {
			if (R.getVeiculo().getPlaca().compareTo(placa) == 0) {
				System.out.println("Data de retirada: " + R.getDataretirada());
				System.out.println("Informe a data de devolução:");
				String dataDevolucao = escreve.nextLine();
				LocalDate data_conv = null;
				try { 
					DateTimeFormatter conversao = DateTimeFormatter.ofPattern("dd/MM/uuuu");
					data_conv = LocalDate.parse(dataDevolucao,conversao); 
				
				} 
				catch (Exception ex) {
					ex.printStackTrace(); 
				}
        		  
				double preco = R.getVeiculo().base_unico();
				Period p = Period.between(R.getDataretirada(), data_conv);
				int dias = p.getDays();
				if (dias != 0) {
					System.out.println("Valor " + preco + " multa " + preco * (dias * 0.20));
					System.out.println("Valor total: " + preco + (preco * (dias * 0.20)));
					System.out.println("Data Devolução:" + data_conv);
					preco =  preco + (preco * (dias * 0.20)); 
				}
				else {
					System.out.println("Valor: " + preco + "\n Data Devolução: " + data_conv );
				}
				System.out.println("Deseja confirmar 1-Sim 2-Não");
				int confirmar = escreve.nextInt();
				escreve.nextLine();
				if (confirmar == 1 ) {
					reservas.remove(R);
				}
				else {
					break;
				}
				
			}			
		}
		System.out.println("\nTecle enter para voltar ao menu");
		escreve.nextLine();
	}
}