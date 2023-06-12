package lab4;

import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;

public class AppMain{
    
    private static final int MAX_ITER = 10000;
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_BLUE = "\u001B[34m";
    
    private static final String SELECT_MESSAGE = "Selecione uma das opções abaixo:";
    private static final String BACK_MAIN_MENU_MESSAGE = "Voltando ao menu principal\n";

    public static String nextLine(Scanner scanner){
        String line;
        do{
            line = scanner.nextLine().strip();
        } while (line.isEmpty());
        return line;
    }

    private static String colorString(String color, String str){
        return color + str + ANSI_RESET;
    }

    private static void clearConsole(){
        System.out.print("\033\143");
    }

    private static Date parseData(String data){
        SimpleDateFormat dataFormat = new SimpleDateFormat("dd/mm/yyyy");
        ParsePosition pos = new ParsePosition(0);
        return dataFormat.parse(data, pos);
    }
    
    private static void mockData(ArrayList<Cliente> clientes, ArrayList<Veiculo> veiculos, ArrayList<Seguradora> seguradoras){
        String enderecoPF = "Rua Sete de Setembro, 29";
        String enderecoPJ = "Avenida Brasil, 576";
        ClientePF clientePF = new ClientePF("Jose Carlos", enderecoPF, "643.566.460-96", parseData("20/10/1976"), parseData("18/02/1995"), "Ensino Superior", "Masculino", "A");
        ClientePJ clientePJ = new ClientePJ("Padaria Silva", enderecoPJ, "26.546.986/0001-93", parseData("02/01/2022"), 20);
        clientes.add(clientePF);
        clientes.add(clientePJ);

        Veiculo veiculo1 = new Veiculo("LSA-3421", "Porsche", "911 Turbo S", 2023);
        Veiculo veiculo2 = new Veiculo("NFB-3175", "FIAT", "Doblo", 2011);
        Veiculo veiculo3 = new Veiculo("MZV-1954", "FIAT", "Fiorino", 2010);
        veiculos.add(veiculo1);
        veiculos.add(veiculo2);
        veiculos.add(veiculo3);

        Seguradora seguradora1 = new Seguradora("Seu carro seguro", "1140028922", "atendimento@seucarroseguro.com.br", "Rua Nove de Julho, 211");
        Seguradora seguradora2 = new Seguradora("Seguradora Spark", "1132436692", "sac@seguradoraspark.com.br", "Rua Sete de Setembro, 55");
        seguradoras.add(seguradora1);
        seguradoras.add(seguradora2);

        Sinistro sinistro1 = new Sinistro(parseData("06/06/2023"),enderecoPF,seguradora1,veiculo1,clientePF);
        Sinistro sinistro2 = new Sinistro(parseData("25/10/2011"),enderecoPJ,seguradora2,veiculo2,clientePJ);
        Sinistro sinistro3 = new Sinistro(parseData("01/02/2010"),enderecoPJ,seguradora2,veiculo3,clientePJ);

        clientePF.addVeiculo(veiculo1);

        clientePJ.addVeiculo(veiculo2);
        clientePJ.addVeiculo(veiculo3);

        seguradora1.cadastrarCliente(clientePF);
        seguradora2.cadastrarCliente(clientePJ);

        seguradora1.gerarSinistro(sinistro1);
        seguradora2.gerarSinistro(sinistro2);
        seguradora2.gerarSinistro(sinistro3);

        clientePF.setValorSeguro(seguradora1.calcularPrecoSeguroCliente(clientePF));
        clientePJ.setValorSeguro(seguradora2.calcularPrecoSeguroCliente(clientePJ));

        seguradora1.listarClientes("PF");
        seguradora1.listarClientes("PJ");
        seguradora2.listarClientes("PF");
        seguradora2.listarClientes("PJ");

        seguradora1.listarSinistros();
        seguradora2.listarSinistros();

        System.out.println("Receita Seguradora \"" + seguradora1.getNome() + "\": " + seguradora1.calcularReceita());
        System.out.println("Receita Seguradora \"" + seguradora2.getNome() + "\": " + seguradora2.calcularReceita());
    }
    
    private static void mostrarMenuPrincipal(){
        System.out.println(colorString(ANSI_YELLOW, "Menu principal:"));
        System.out.println(SELECT_MESSAGE);
        System.out.println(colorString(ANSI_BLUE, "1.") + " Cadastros");
        System.out.println(colorString(ANSI_BLUE, "2.") + " Listar");
        System.out.println(colorString(ANSI_BLUE, "3.") + " Excluir");
        System.out.println(colorString(ANSI_BLUE, "4.") + " Gerar Sinistro");
        System.out.println(colorString(ANSI_BLUE, "5.") + " Transferir Seguro");
        System.out.println(colorString(ANSI_BLUE, "6.") + " Calcular Receita Seguradora");
        System.out.println(colorString(ANSI_RED, "0.") + " Sair");
    }

    private static void mostrarMenuCadastrar(){
        System.out.println(colorString(ANSI_YELLOW, "Cadastrar:"));
        System.out.println(SELECT_MESSAGE);
        System.out.println(colorString(ANSI_BLUE, "1.") + " Cadastrar Cliente PF/PJ");
        System.out.println(colorString(ANSI_BLUE, "2.") + " Cadastrar Veiculo");
        System.out.println(colorString(ANSI_BLUE, "3.") + " Cadastrar Seguradora");
        System.out.println(colorString(ANSI_BLUE, "4.") + " Voltar");
    }
    
    private static void mostrarMenuListar(){
        System.out.println(ANSI_YELLOW + "Listar:" + ANSI_RESET);
        System.out.println(SELECT_MESSAGE);
        System.out.println(colorString(ANSI_BLUE, "1.") + " Listar Cliente PF/PJ por Seguradora");
        System.out.println(colorString(ANSI_BLUE, "2.") + " Listar Sinistros por Seguradora");
        System.out.println(colorString(ANSI_BLUE, "3.") + " Listar Sinistros por Cliente");
        System.out.println(colorString(ANSI_BLUE, "4.") + " Listar Veiculos por Cliente");
        System.out.println(colorString(ANSI_BLUE, "5.") + " Listar Veiculos por Seguradora");
        System.out.println(colorString(ANSI_BLUE, "6.") + " Voltar");
    }

    private static void mostrarMenuExcluir(){
        System.out.println(ANSI_YELLOW + "Excluir:" + ANSI_RESET);
        System.out.println(SELECT_MESSAGE);
        System.out.println(colorString(ANSI_BLUE, "1.") + " Excluir Cliente");
        System.out.println(colorString(ANSI_BLUE, "2.") + " Excluir Veiculo");
        System.out.println(colorString(ANSI_BLUE, "3.") + " Excluir Sinistro");
        System.out.println(colorString(ANSI_BLUE, "4.") + " Voltar");
    }

    private static void cadastrarClientePFPJ(Scanner scanner, ArrayList<Cliente> clientes, ArrayList<Seguradora> seguradoras){
        Cliente cliente = null;
        clearConsole();
        System.out.println(colorString(ANSI_YELLOW, "Cadastro de cliente"));
        
        System.out.println("O cliente é pessoa física?"+ colorString(ANSI_BLUE, "[s/n]"));
        String naturalPerson = nextLine(scanner).toLowerCase();
        
        System.out.println("Qual o nome do cliente?");
        String name = nextLine(scanner);
        
        System.out.println("Qual o endereço do cliente?");
        String address = nextLine(scanner);

        if(naturalPerson.charAt(0) == 's'){

            System.out.println("Qual o CPF do cliente?");
            String cpf = nextLine(scanner);
            Validacao.validarCPF(cpf);

            System.out.println("Qual o gênero do cliente?");
            String gender = nextLine(scanner);

            System.out.println("Qual a classe econômica do cliente?");
            String wealth = nextLine(scanner);

            System.out.println("Qual o nível educacional do cliente?");
            String education = nextLine(scanner);

            System.out.println("Qual a data de nascimento do cliente? Formato [dd/mm/aaaa]");
            Date dataNascimento = parseData(nextLine(scanner));

            System.out.println("Qual a data de licença do cliente? Formato [dd/mm/aaaa]");
            Date dataLicenca = parseData(nextLine(scanner));

            cliente = new ClientePF(name, address, cpf, dataNascimento, dataLicenca, education, gender, wealth);
            
        }
        else if(naturalPerson.charAt(0) == 'n'){

            System.out.println("Qual o CNPJ do cliente?");
            String cnpj = scanner.nextLine();
            Validacao.validarCNPJ(cnpj);

            System.out.println("Qual a data da fundação do cliente?");
            Date dataFundacao = parseData(scanner.nextLine());

            System.out.println("Qual a quantidade de funcionários do cliente?");
            int qtdeFuncionarios = scanner.nextInt();
            scanner.nextLine();
            cliente = new ClientePJ(name, address, cnpj, dataFundacao, qtdeFuncionarios);

        }

        else{
            throw new IllegalArgumentException("Opção inválida. Digite s ou n");
        }

        clientes.add(cliente);
        
        System.out.println("Qual o nome da seguradora do cliente?");
        String nomeSeguradora = nextLine(scanner);
        
        boolean found = false;
        for(Seguradora seguradoraAlt : seguradoras){
            if (seguradoraAlt.getNome().equals(nomeSeguradora)){
                seguradoraAlt.cadastrarCliente(cliente);
                System.out.println("Cliente cadastrado com sucesso");
                found = true;
                break;
            }
        }
        
        if(!found){
            System.out.println("A seguradora \"" + nomeSeguradora + "\" não foi encontrada.");
            System.out.println("Abrindo menu de cadastro de seguradora");
            cadastrarSeguradora(scanner, seguradoras);
        }
        
    }
    
    private static void cadastrarVeiculo(Scanner scanner, ArrayList<Cliente> clientes, ArrayList<Veiculo> veiculos){

        System.out.println(colorString(ANSI_YELLOW,"Cadastro de veículo"));
        
        String marcaCarro = scanner.nextLine();
        System.out.println("Qual a marca do veículo?");

        String modeloCarro = scanner.nextLine();
        System.out.println("Qual o modelo do veículo?");

        String placaCarro = scanner.nextLine();
        System.out.println("Qual a placa do veículo?");

        int anoCarro = scanner.nextInt();
        System.out.println("Qual o ano de produção do veículo?");

        System.out.println("O dono do veículo é:");
        System.out.println(colorString(ANSI_BLUE,"1.") + " Pessoa Física");
        System.out.println(colorString(ANSI_BLUE,"2.") + " Pessoa Jurídica");

        int tipoDonoCarro = scanner.nextInt();

        if(tipoDonoCarro == 1){
            System.out.println("Qual o CPF do dono do veículo?");
            String cpf = scanner.nextLine();
            Validacao.validarCPF(cpf);

            for(Cliente clienteAlt: clientes){
                if(clienteAlt.getNaturalPerson() && clienteAlt.getCPF().equals(cpf)){
                    Veiculo veiculo = new Veiculo(placaCarro, marcaCarro, modeloCarro, anoCarro);
                    veiculos.add(veiculo);
                    clienteAlt.addVeiculo(veiculo);
                }
            }
        }
        
        else if(tipoDonoCarro == 2){
            System.out.println("Qual o CNPJ do dono do veículo?");
            String cnpj = scanner.nextLine();
            Validacao.validarCNPJ(cnpj);

            for(Cliente clienteAlt: clientes){
                if(clienteAlt.getNaturalPerson() && clienteAlt.getCNPJ().equals(cnpj)){
                    Veiculo veiculo = new Veiculo(placaCarro, marcaCarro, modeloCarro, anoCarro);
                    veiculos.add(veiculo);
                    clienteAlt.addVeiculo(veiculo);
                }
            }
        }

        else{
            throw new IllegalArgumentException("Opção inválida");
        }

        System.out.println("Carro cadastrado com sucesso");
    }

    private static void cadastrarSeguradora(Scanner scanner, ArrayList<Seguradora> seguradoras){
        System.out.println(colorString(ANSI_YELLOW,"Cadastro de seguradora"));
        
        System.out.println("Qual o nome da seguradora?");
        String nomeSeguradora = nextLine(scanner);

        System.out.println("Qual o telefone da seguradora?");
        String telefoneSeguradora = nextLine(scanner);

        System.out.println("Qual o email da seguradora?");
        String emailSeguradora = nextLine(scanner);

        System.out.println("Qual o endereço da seguradora?");
        String enderecoSeguradora = nextLine(scanner);

        Seguradora seguradora = new Seguradora(nomeSeguradora, telefoneSeguradora, emailSeguradora, enderecoSeguradora);
        seguradoras.add(seguradora);

        System.out.println("Seguradora \"" + nomeSeguradora + "\" adicionada com sucesso");
        System.out.println(BACK_MAIN_MENU_MESSAGE);
        
    }
    
    private static void listarClienteSeguradora(Scanner scanner, ArrayList<Seguradora> seguradoras){
        System.out.println("Qual o nome da seguradora que você deseja listar os clientes?");
        String nome = nextLine(scanner);
        
        System.out.println("Deseja listar clientes do tipo pessoa física ou jurídica?");
        System.out.println("Digite " + colorString(ANSI_BLUE,"PF") + " para Pessoa Física");
        System.out.println("Digite "+ colorString(ANSI_BLUE,"PJ") + " para Pessoa Jurídica");
        String tipoClienteString = nextLine(scanner);

        for(Seguradora seguradora: seguradoras){
            if (seguradora.getNome().equals(nome)){
                seguradora.listarClientes(tipoClienteString);
            }
        }
    }

    private static void listarSinistrosSeguradora(Scanner scanner, ArrayList<Seguradora> seguradoras){
        System.out.println("Qual o nome da seguradora que você deseja listar os sinistros?");
        String nome = nextLine(scanner);

        for(Seguradora seguradora: seguradoras){
            if (seguradora.getNome().equals(nome)){
                seguradora.listarSinistros();
            }
        }
    }

    private static void listarSinistrosCliente(Scanner scanner, ArrayList<Seguradora> seguradoras){

        System.out.println("Qual o nome da seguradora do cliente?");
        String nomeSeguradora = nextLine(scanner);

        System.out.println("O cliente é pessoa física?"+ colorString(ANSI_BLUE, "[s/n]"));
        String naturalPerson = nextLine(scanner).toLowerCase();

        if(naturalPerson.charAt(0) == 's'){

            System.out.println("Qual o CPF do cliente?");
            String cpf = nextLine(scanner);
            Validacao.validarCPF(cpf);

            for(Seguradora seguradora: seguradoras){
                if (seguradora.getNome().equals(nomeSeguradora)){
                    seguradora.visualizarSinistro(cpf);
                }
            }
        }

        else if(naturalPerson.charAt(0) == 'n'){

            System.out.println("Qual o CNPJ do cliente?");
            String cnpj = nextLine(scanner);
            Validacao.validarCNPJ(cnpj);

            for(Seguradora seguradora: seguradoras){
                if (seguradora.getNome().equals(nomeSeguradora)){
                    seguradora.visualizarSinistro(cnpj);
                }
            }
        }
        else{
            throw new IllegalArgumentException("Opção inválida");
        }
    }

    private static void listarVeiculosCliente(Scanner scanner, ArrayList<Cliente> clientes){
        System.out.println("O cliente é pessoa física?"+ colorString(ANSI_BLUE, "[s/n]"));
        String naturalPerson = nextLine(scanner).toLowerCase();
        String cpf=null;
        String cnpj=null;
        
        if(naturalPerson.charAt(0) == 's'){
            System.out.println("Qual o CPF do cliente?");
            cpf = nextLine(scanner);
            Validacao.validarCPF(cpf);
        }
        
        else if(naturalPerson.charAt(0) == 'n'){
            System.out.println("Qual o CNPJ do cliente?");
            cnpj = nextLine(scanner);
            Validacao.validarCNPJ(cnpj);
        }
        
        else{
            throw new IllegalArgumentException("Opção inválida");
        }

        for(Cliente clienteAlt: clientes){
            if((clienteAlt.getNaturalPerson() && clienteAlt.getCPF().equals(cpf))|| (!clienteAlt.getNaturalPerson() && clienteAlt.getCNPJ().equals(cnpj))){
                clienteAlt.listarVeiculos();
                break;
            }
        }
    }
    
    private static void listarVeiculosSeguradora(Scanner scanner, ArrayList<Seguradora> seguradoras){
        System.out.println("Qual o nome da seguradora?");
        String nomeSeguradora = nextLine(scanner);
        for(Seguradora seguradora: seguradoras){
            if (seguradora.getNome().equals(nomeSeguradora)){
                seguradora.listarVeiculos();
            }
        }
    }
    
    private static void excluirCliente(Scanner scanner, ArrayList<Cliente> clientes, ArrayList<Seguradora> seguradoras){
        
        System.out.println("Qual o nome da seguradora do cliente?");
        String nomeSeguradora = nextLine(scanner);

        System.out.println("O cliente é pessoa física?"+ colorString(ANSI_BLUE, "[s/n]"));
        String naturalPerson = nextLine(scanner).toLowerCase();

        if(naturalPerson.charAt(0) == 's'){

            System.out.println("Qual o CPF do cliente?");
            String cpf = nextLine(scanner);
            Validacao.validarCPF(cpf);

            for(Seguradora seguradora: seguradoras){
                if (seguradora.getNome().equals(nomeSeguradora)){
                    seguradora.removerCliente(cpf);
                }
            }

            for(Cliente cliente: clientes){
                if (cliente.getCPF().equals(cpf)){
                    clientes.remove(cliente);
                }
            }
        }

        else if(naturalPerson.charAt(0) == 'n'){

            System.out.println("Qual o CNPJ do cliente?");
            String cnpj = nextLine(scanner);
            Validacao.validarCNPJ(cnpj);

            for(Seguradora seguradora: seguradoras){
                if (seguradora.getNome().equals(nomeSeguradora)){
                    seguradora.removerCliente(cnpj);
                }
            }
            
            for(Cliente cliente: clientes){
                if (cliente.getCNPJ().equals(cnpj)){
                    clientes.remove(cliente);
                }
            }
        }

        else{
            throw new IllegalArgumentException("Opção inválida");
        }
    }
    
    private static void excluirVeiculo(){
        System.out.println("Currently not implemented");
    }

    private static void excluirSinistro(){
        System.out.println("Currently not implemented");
    }

    private static void gerarSinistro(){
        System.out.println("Currently not implemented");
    }

    private static void transferirSeguro(){
        System.out.println("Currently not implemented");
    }

    private static void calcularReceita(){
        System.out.println("Currently not implemented");
    }
    public static void main(String[] args){
        
        int numIter = 0;
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        ArrayList<Seguradora> seguradoras = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        clearConsole();
        
        // Mock data
        System.out.println("Deseja testar com dados fictícios?"+ colorString(ANSI_BLUE, "[s/n]"));
        Character mock = nextLine(scanner).toLowerCase().charAt(0);
        
        if(mock =='s'){
            mockData(clientes,veiculos,seguradoras);
            System.out.println("Pressione qualquer tecla pra continuar");
            scanner.nextLine();
        }
        
        clearConsole();
        
        while(numIter < MAX_ITER){
            mostrarMenuPrincipal();
            MenuOperacoes op = MenuOperacoes.values()[scanner.nextInt()];

            switch(op){
                case CADASTRAR:
                    clearConsole();
                    mostrarMenuCadastrar();
                    SubmenuCadastrar opCad = SubmenuCadastrar.values()[scanner.nextInt()-1]; 
                    switch(opCad){
                        case CADASTRAR_CLIENTE_PF_PJ:
                            cadastrarClientePFPJ(scanner, clientes, seguradoras);
                            break;    
                        case CADASTRAR_VEICULO:
                            cadastrarVeiculo(scanner, clientes, veiculos);
                            break;
                        case CADASTRAR_SEGURADORA:
                            cadastrarSeguradora(scanner, seguradoras);
                            break;
                        case VOLTAR_CADASTRAR:
                            break;
                    }
                    break;

                case LISTAR:
                    clearConsole();
                    mostrarMenuListar();
                    SubmenuListar opList = SubmenuListar.values()[scanner.nextInt()-1];

                    switch(opList){

                        case LISTAR_CLIENTE_SEG:
                            listarClienteSeguradora(scanner, seguradoras);    
                            break;
                        
                        case LISTAR_SINISTRO_SEG:
                            listarSinistrosSeguradora(scanner, seguradoras);
                            break;

                        case LISTAR_SINISTRO_CLIENTE:
                            listarSinistrosCliente(scanner,seguradoras);
                            break;
                        
                        case LISTAR_VEICULO_CLIENTE:
                            listarVeiculosCliente(scanner, clientes);
                            break;

                        case LISTAR_VEICULO_SEG:
                            listarVeiculosSeguradora(scanner, seguradoras);
                            break;

                        case VOLTAR_LISTAR:
                            break;
                        }
                        break;

                case EXCLUIR:
                    clearConsole();
                    mostrarMenuExcluir();
                    SubmenuExcluir opExcl = SubmenuExcluir.values()[scanner.nextInt()-1];

                    switch(opExcl){
                        case EXCLUIR_CLIENTE:
                            excluirCliente(scanner,clientes, seguradoras); 
                            break;
                            
                        case EXCLUIR_VEICULO:
                            excluirVeiculo();
                            break;

                        case EXCLUIR_SINISTRO:
                            excluirSinistro();
                            break;
                        
                        case VOLTAR_EXCLUIR:
                            break;
                    }
                    break;

                case GERAR_SINISTRO:
                    gerarSinistro();
                    break;

                case TRANSFERIR_SEGURO:
                    transferirSeguro();
                    break;

                case CALCULAR_RECEITA:
                    calcularReceita();
                    break;

                case SAIR:
                    return;

                default:
                    clearConsole();
                    System.out.println("Opção inválida. Tente novamente");
            }

            numIter++;
        }

        scanner.close();
    }
}
