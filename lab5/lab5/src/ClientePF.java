package lab5;

import java.util.Date;

public class ClientePF extends Cliente {
    private final String cpf;
    private Date dataNascimento;
    private Date dataLicenca;
    private String educacao;
    private String genero;
    private String classeEconomica;

    public ClientePF(
            String nome,
            String endereco,
            String cpf,
            Date dataNascimento,
            Date dataLicenca,
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

    @Override
    public double calculaScore(){
        Date today =  new Date();
        double fator = getFator(today.getYear() - this.dataNascimento.getYear());
        double base = CalcSeguro.VALOR_BASE.getFator();
        int numCarros = super.getListaVeiculos().size();
        return fator*base*numCarros;
    }

    public double getFator(int age){
        if(age>90){
            throw new IllegalArgumentException("Muito idoso para dirigir");
        }
        else if(age>=60){
            return CalcSeguro.FATOR_60_90.getFator();
        }
        else if(age>=30){
            return CalcSeguro.FATOR_30_60.getFator();
        }
        else if(age>=18){
            return CalcSeguro.FATOR_18_30.getFator();
        }
        else{
            throw new IllegalArgumentException("Muito novo para dirigir");
        }
    }
}
