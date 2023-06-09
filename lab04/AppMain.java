import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.text.SimpleDateFormat;

public class AppMain{

    public static Date parseData(String data){
        SimpleDateFormat data_format = new SimpleDateFormat("dd/mm/yyyy");
        return data_format.parse(data, null);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        // Mock data
        String enderecoPF = "Rua Sete de Setembro, 29";
        String enderecoPJ = "Avenida Brasil, 576";
        ClientePF clientePF = new ClientePF("José Carlos", enderecoPF, "643.566.460-96", parseData("20/10/1976"), parseData("18/02/1995"), "Ensino Superior", "Masculino", "A");
        ClientePJ clientePJ = new ClientePJ("Padaria Silva", "", "Avenida Brasil, 576", parseData("02/01/2022"), 20);

        Veiculo veiculo1 = new Veiculo("LSA-3421", "Porsche", "911 Turbo S", 2023);
        Veiculo veiculo2 = new Veiculo("KDV-3268", "Nissan", "Kicks", 2016);
        Veiculo veiculo3 = new Veiculo("NFB-3175", "FIAT", "Doblo", 2011);
        Veiculo veiculo4 = new Veiculo("MZV-1954", "FIAT", "Fiorino", 2010);

        Seguradora seguradora1 = new Seguradora("Seu carro seguro", "1140028922", "atendimento@seucarroseguro.com.br", "Rua Nove de Julho, 211");
        Seguradora seguradora2 = new Seguradora("Seguradora Spark", "1132436692", "sac@seguradoraspark.com.br", "Rua Sete de Setembro, 55");
        
        clientePF.addVeiculo(veiculo1);
        clientePF.addVeiculo(veiculo2);

        clientePJ.addVeiculo(veiculo3);
        clientePJ.addVeiculo(veiculo4);

        seguradora1.gerarSinistro(parseData("06/06/2023"),enderecoPF,veiculo1,clientePF);
        seguradora2.gerarSinistro(parseData("10/02/2016"),enderecoPF,veiculo2,clientePF);
        seguradora1.gerarSinistro(parseData("25/10/2011"),enderecoPJ,veiculo3,clientePJ);
        seguradora2.gerarSinistro(parseData("01/02/2010"),enderecoPJ,veiculo4,clientePJ);

        seguradora1.listarClientes("PF");
        seguradora1.listarClientes("PJ");
        seguradora2.listarClientes("PF");
        seguradora2.listarClientes("PJ");

        seguradora1.listarSinistros();
        seguradora1.listarSinistros();
        seguradora2.listarSinistros();
        seguradora2.listarSinistros();

        System.out.println("Receita Seguradora " + seguradora1.getNome() + ": " + seguradora1.calcularReceita());
        System.out.println("Receita Seguradora " + seguradora2.getNome() + ": " + seguradora1.calcularReceita());

        while(true){
           break;
        }
        scanner.close();
    }
}
