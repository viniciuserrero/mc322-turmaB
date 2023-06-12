package lab4;

import java.util.Date;

public class ClientePJ extends Cliente {
    private final String cnpj;
    private Date dataFundacao;
    private int qtdeFuncionarios;

    public ClientePJ(
            String nome,
            String endereco,
            String cnpj,
            Date dataFundacao,
            int qtdeFuncionarios) {
        
        // chama o construtor da superclasse
        super(nome, endereco, false);

        if(Validacao.validarCNPJ(cnpj)){
            this.cnpj = cnpj;
        }
        
        else{
            this.cnpj = null;
        }
        
        this.dataFundacao = dataFundacao;
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

    //Getters e setters
    @Override
    public String getCNPJ() {
        return cnpj;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public int getQtdeFuncionarios(){
        return qtdeFuncionarios;
    }

    public void setQtdeFuncionarios(int qtdeFuncionarios){
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

    @Override
    public String toString() {
        return "Dados do cliente(PJ):\n" + 
                "Nome: " + super.getNome() + "\n" + 
                "Valor do seguro: " + super.getValorSeguro() + "\n" +
                "Endereço: " + super.getEndereco() + "\n" +
                "CNPJ: " + getCNPJ() + "\n" +
                "Data de Fundação: " + getDataFundacao() + "\n" +
                "Quantidade de funcionários: " + getQtdeFuncionarios()+ "\n" +
                "Lista de veículos(" + getListaVeiculos().size() + "): " + getListaVeiculos();
    }

    @Override
    public double calculaScore(){
        int numCarros = super.getListaVeiculos().size();
        double base = CalcSeguro.VALOR_BASE.getFator();
        double division = (1+(this.qtdeFuncionarios)/100);
        return base*numCarros*division;
    }
}
