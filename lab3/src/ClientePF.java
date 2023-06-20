import java.util.Date;
import java.util.ArrayList;

public class ClientePF extends Cliente {
    private String cpf;
    private Date dataNascimento;
    private Date dataLicenca;
    private String educacao;
    private String genero;
    private String classeEconomica;

    public ClientePF(
            String nome,
            String endereco,
            Date dataLicenca,
            String educacao,
            String genero,
            String classeEconomica,
            ArrayList<Veiculo> listaVeiculos,
            String cpf,
            Date dataNascimento) {
        // chama o construtor da superclasse

        super(nome, endereco);

        this.cpf = validarCPF(cpf);
        this.dataNascimento = dataNascimento;
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.genero = genero;
        this.classeEconomica = classeEconomica;

    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = validarCPF(cpf);
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataLicenca() {
        return dataLicenca;
    }

    public void setDataLicenca(Date dataLicenca) {
        this.dataLicenca = dataLicenca;
    }

    public String getEducacao() {
        return educacao;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getClasseEconomica() {
        return classeEconomica;
    }

    public void setClasseEconomica(String classeEconomica) {
        this.classeEconomica = classeEconomica;
    }

    @Override
    public String toString() {
        return "Dados do cliente:\nNome: " + getNome() + "\nEndereço: " + getEndereco() + "\nCPF: " + getCPF()
                + "\nData de Nascimento: " + getDataNascimento()
                + "\nData da licença: " + getDataLicenca() + "\nEducação: " + getEducacao() + "\nGênero: " + getGenero()
                + "\nClasse Econômica: " + getClasseEconomica() + "\nLista de veículos(" + getListaVeiculos().size() + "): " + getListaVeiculos();
    }

    public String validarCPF(String cpf) {
        // removendo caracteres que não são números(passo 1)
        cpf = cpf.replaceAll("[^\\d]", "");

        // verificando tamanho da variável(passo 2)
        if (cpf.length() != 11) {
            throw new IllegalArgumentException("CPF inválido: Tamanho diferente de 11 dígitos");
        }

        // verificando se todos os dígitos são iguais(passo 3)

        if (cpf.matches("(\\d)\\1{10}")) {
            throw new IllegalArgumentException("CPF inválido: Todos os dígitos são iguais");
        }

        // calculando digitos verificadores (passo 4)
        int[] fatores = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 0 };
        int soma_d1, soma_d2, num;
        soma_d1 = soma_d2 = num = 0;

        for (int i = 0; i < 10; i++) {
            // convertendo char na posição i para int
            num = Character.digit(cpf.charAt(i), 10);
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

        int d1_recebido = Character.digit(cpf.charAt(9), 10);
        int d2_recebido = Character.digit(cpf.charAt(10), 10);

        if (d1 == d1_recebido && d2 == d2_recebido) {
            return cpf;
        }

        throw new IllegalArgumentException("CPF inválido: Dígitos verificadores não conferem");
    }

}