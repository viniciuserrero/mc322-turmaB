package lab5;

import java.time.LocalDate;

public class ClientePF extends Cliente {
    private final String cpf;
    private LocalDate dataNascimento;
    private LocalDate dataLicenca;
    private String educacao;
    private String genero;
    private String classeEconomica;

    public ClientePF(
            String nome,
            String endereco,
            String cpf,
            LocalDate dataNascimento,
            LocalDate dataLicenca,
            String educacao,
            String genero,
            String classeEconomica) {

        // chama o construtor da superclasse
        super(nome, endereco, true);

        if(Validacao.validarCPF(cpf)){
            this.cpf = cpf;
        }

        else{
            this.cpf = null;
        }

        this.dataNascimento = dataNascimento;
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.genero = genero;
        this.classeEconomica = classeEconomica;

    }

    //Getters e setters
    @Override
    public String getCPF() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getIdade() {
        LocalDate now = LocalDate.now();
        return now.getYear() - dataNascimento.getYear();
    }

    public LocalDate getDataLicenca() {
        return dataLicenca;
    }

    public void setDataLicenca(LocalDate dataLicenca) {
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
        return "Dados do cliente(PF):\n" +
                "Nome: " + super.getNome() + "\n" +
                "Valor do seguro: " + super.getValorSeguro() + "\n" +
                "Endereço: " + super.getEndereco() + "\n" +
                "CPF: " + getCPF() + "\n" +
                "Data de Nascimento: " + getDataNascimento() + "\n" +
                "Data da licença: " + getDataLicenca()+ "\n" +
                "Educação: " + getEducacao()+ "\n" +
                "Gênero: " + getGenero() + "\n" +
                "Classe Econômica: " + getClasseEconomica() + "\n" +
                "Lista de veículos(" + super.getListaVeiculos().size() + "): " + getListaVeiculos();
    }
}
