import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String endereco;
    private ArrayList<Veiculo> listaVeiculos;

    // Construtor
    public Cliente(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.listaVeiculos = new ArrayList<Veiculo>();
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

    public boolean addVeiculo(Veiculo veiculo) {
        return listaVeiculos.add(veiculo);
    }

    public boolean removeVeiculo(Veiculo veiculo) {
        return listaVeiculos.remove(veiculo);
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public String toString() {
        return "O cliente " + nome + "de endereço " + endereco + " possui " + listaVeiculos.size()
                + " veículos, sendo eles: " + listaVeiculos.toString();
    }
}
