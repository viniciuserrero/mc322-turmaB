package lab2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Cliente cliente = new Cliente(null, null, null, 0, null);
		Seguradora seguradora = new Seguradora(null, null, null, null);
		Sinistro sinistro = new Sinistro(null, null);
		Veiculo veiculo = new Veiculo(null, null, null);
		String input;
		int num_input;
		
		while(true) {
			System.out.println("Qual registro deseja criar?");
			System.out.println("Opções válidas: cliente, seguradora, sinistro, veiculo");

			input = scanner.nextLine();
			input = input.toLowerCase();
			
			if(input.equals("cliente")) {
				System.out.println("Digite o nome do cliente:");
				input = scanner.nextLine();
				cliente.setNome(input);

				System.out.println("Digite o CPF do cliente:");
				input = scanner.nextLine();
				while(cliente.validarCPF(input) == false) {
					System.out.println("CPF inválido. Digite novamente");
					input = scanner.nextLine();
				}
				cliente.setCPF(input);

				System.out.println("Digite a idade do cliente:");
				num_input = scanner.nextInt();
				scanner.nextLine();
				cliente.setIdade(num_input);

				System.out.println("Digite o endereço do cliente:");
				input = scanner.nextLine();
				cliente.setEndereco(input);
				
				System.out.println("-------");
				System.out.println("Registro do cliente completo :) ");
				System.out.println("Abaixo segue os dados do cliente que você adicionou");
				System.out.println("Nome:" + cliente.getNome());
				System.out.println("CPF:" + cliente.getCPF());
				System.out.println("Idade:" + cliente.getIdade());
				System.out.println("Endereço:" + cliente.getEndereco());
				break;
			}
			
			  else if(input.equals("seguradora")) {
				System.out.println("Digite o nome da seguradora:");
				input = scanner.nextLine();
				seguradora.setNome(input);
				
				System.out.println("Digite o telefone da seguradora:");
				input = scanner.nextLine();
				seguradora.setTelefone(input);
				
				System.out.println("Digite o email da seguradora:");
				input = scanner.nextLine();
				seguradora.setEmail(input);
				
				System.out.println("Digite o endereço da seguradora:");
				input = scanner.nextLine();
				seguradora.setEndereco(input);
				
				System.out.println("-------");
				System.out.println("Registro da seguradora completo :) ");
				System.out.println("Abaixo segue os dados da seguradora que você adicionou");
				System.out.println("Nome:" + seguradora.getNome());
				System.out.println("Telefone:" + seguradora.getTelefone());
				System.out.println("Email:" + seguradora.getEmail());
				System.out.println("Endereço:" + seguradora.getEndereco());
				break;
			}
			  else if(input.equals("sinistro")){
				  	System.out.println("Digite a data da ocorrência:");
					input = scanner.nextLine();
					sinistro.setData(input);
					
					System.out.println("Digite o endereço da ocorrência:");
					input = scanner.nextLine();
					sinistro.setEndereco(input);
					
					System.out.println("-------");
					System.out.println("Ocorrência registrada");
					System.out.println("Abaixo segue os dados da ocorrência criada");
					System.out.println("ID da Ocorrência:" + sinistro.getID());
					System.out.println("Data:" + sinistro.getData());
					System.out.println("Endereço:" + sinistro.getEndereco());
					break;
			  }
			
			  else if(input.equals("veiculo") || input.equals("veículo")){
				System.out.println("Digite a placa do carro:");
				input = scanner.nextLine();
				veiculo.setPlaca(input);
				
				System.out.println("Digite a marca do carro:");
				input = scanner.nextLine();
				veiculo.setMarca(input);
				
				System.out.println("Digite o modelo do carro:");
				input = scanner.nextLine();
				veiculo.setModelo(input);
				
				System.out.println("-------");
				System.out.println("Registro do carro completo :) ");
				System.out.println("Abaixo segue os dados do carro que você adicionou");
				System.out.println("Placa:" + veiculo.getPlaca());
				System.out.println("Marca:" + veiculo.getMarca());
				System.out.println("Modelo:" + veiculo.getModelo());
				break;
			}
			
			  else {
				  System.out.println("Desculpe, não consegui entender o que você digitou. Tente novamente ");
			  }
		}
	}
}
