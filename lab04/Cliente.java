import java.util.List;

public class Cliente {
    private String nome;
    private String endereco;
    private List<Veiculo> listaVeiculos;
    private double valorSeguro;
    private bool naturalPerson;

    // Construtor
    public Cliente(String nome, String endereco, bool naturalPerson) {
        this.nome = nome;
        this.endereco = endereco;
        this.listaVeiculos = new List<>();
        this.valorSeguro = 0;
        this.naturalPerson = naturalPerson;
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getValorSeguro(){
        return valorSeguro;
    }

    public void setValorSeguro(double valorSeguro){
        this.valorSeguro = valorSeguro;
    }

    public bool getNaturalPerson(){
        return naturalPerson;
    }

    public void setNaturalPerson(bool naturalPerson){
        this.naturalPerson = naturalPerson;
    }

    // Funções relacionadas ao veiculos do cliente
    public List<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public boolean addVeiculo(Veiculo veiculo) {
        return this.listaVeiculos.add(veiculo);
    }

    public boolean removeVeiculo(Veiculo veiculo) {
        return this.listaVeiculos.remove(veiculo);
    }

    // Funções que devem ser overriden
    public String toString() {
        throw new UnsupportedOperationException("This method must be overridden by a subclass.");
    }

    public double calculaScore(){
        throw new UnsupportedOperationException("This method must be overridden by a subclass.");
    }
}
