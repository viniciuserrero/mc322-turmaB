import java.time.LocalDate;
import java.util.List;

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

        this.cnpj = Validacao.validarCNPJ(cnpj);
        this.dataFundacao = dataFundacao;
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

    //Getters e setters
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
        float base = CalcSeguro.VALOR_BASE.getValor();
        int numCarros = super.getListaVeiculos().size();
        return base*numCarros*(1+(this.qtdeFuncionarios)/100);
    }

}
