import java.util.Date;
import java.util.ArrayList;

public class ClientePJ extends Cliente {
    private String cnpj;
    private Date dataFundacao;

    public ClientePJ(
            String nome,
            String endereco,
            ArrayList<Veiculo> listaVeiculos,
            String cnpj,
            Date dataFundacao) {
        // chama o construtor da superclasse

        super(nome, endereco);

        this.cnpj = validarCNPJ(cnpj);
        this.dataFundacao = dataFundacao;
    }

    public String getCNPJ() {
        return cnpj;
    }

    public void setCNPJ(String cnpj) {
        this.cnpj = validarCNPJ(cnpj);
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    @Override
    public String toString() {
        return "Dados do cliente:\nNome: " + getNome() + "\nEndereço: " + getEndereco() + "\nCPF: " + getCPF()
                + "\nData de Nascimento: " + getDataNascimento()
                + "\nData da licença: " + getDataLicenca() + "\nEducação: " + getEducacao() + "\nGênero: " + getGenero()
                + "\nClasse Econômica: " + getClasseEconomica() + "\nLista de veículos: " + getListaVeiculos();
    }

    public String validarCNPJ(String cnpj) {
        // removendo caracteres que não são números(passo 1)
        cnpj = cnpj.replaceAll("[^\\d]", "");

        // verificando tamanho da variável(passo 2)
        if (cnpj.length() != 14) {
            throw new IllegalArgumentException("CNPJ inválido: Tamanho diferente de 14 dígitos");
        }

        // verificando se todos os dígitos são iguais(passo 3)

        if (cnpj.matches("(\\d)\\1{13}")) {
            throw new IllegalArgumentException("CNPJ inválido: Todos os dígitos são iguais");
        }

        // calculando digitos verificadores (passo 4)
        int[] fatores = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2, 0 };
        int soma_d1, soma_d2, num;
        soma_d1 = soma_d2 = num = 0;

        for (int i = 0; i < 13; i++) {
            // convertendo char na posição i para int
            num = Character.digit(cnpj.charAt(i), 10);
            soma_d1 += num * fatores[i + 1];
            soma_d2 += num * fatores[i];
        }
        // dividindo por 11 para obter digitos verificadores
        int d1 = 11 - (soma_d1 % 11);
        int d2 = 11 - (soma_d2 % 11);

        // verificando se o resto é 10 ou 11,
        // nesse caso o digito verificador será 0
        if (d1 > 9) {
            d1 = 0;
        }
        if (d2 > 9) {
            d2 = 0;
        }

        int d1_recebido = Character.digit(cnpj.charAt(9), 10);
        int d2_recebido = Character.digit(cnpj.charAt(10), 10);

        if (d1 == d1_recebido && d2 == d2_recebido) {
            return cnpj;
        }

        throw new IllegalArgumentException("CNPJ inválido: Dígitos verificadores não conferem");
    }

}