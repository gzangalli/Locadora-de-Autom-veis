/**
 * Classe para ser a interface principal do programa.
 * Nela existirão 5 opçoes para o usuário vericar.
 */
package Interface;
import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
        int opcao = -1 ;
        String digitar="";
        while(opcao!=0){
        	mostraMenu();
            opcao = entrada.nextInt();
        	switch(opcao){
        	case 1:
        		Auxiliar.Cadastro_cliente();
        		break;
        	case 2:
        		Auxiliar.Cadastro_veiculo();
        		break;
        	case 3:
        		Auxiliar.Aluga_automovel();
        		break;
        	case 4:
        		Auxiliar.Devolve_automovel();
        		break;
        	case 5:
        		System.out.println("Deseja realmente sair? S-Sim/N-Não");
        		entrada.nextLine();
        		digitar = entrada.nextLine();
        		break;
        }	
        if(digitar.equals("S")||digitar.equals("s")) {
        	break;
    	}
        	
    }  	    
}
	/**
	 * Metodo para mostrar o menu principal com as opçoes ao usuario
	 */
	private static void mostraMenu() {
		System.out.println("------------------------------------------------------------");
		System.out.println("Locadora de Carros");
		System.out.println("------------------------------------------------------------");
		System.out.println("Escolha uma das opções a seguir:"); 
		System.out.println("1) Cadastrar Cliente");
		System.out.println("2) Cadastrar Automóvel");
		System.out.println("3) Alugar um automóvel ");
		System.out.println("4) Devolver um automóvel");
		System.out.println("5) Sair");
		System.out.println("------------------------------------------------------------");   
	}
}