package lab5;

import java.util.List;
import java.util.ArrayList;

public abstract class Cliente {
    private String nome;
    private String endereco;
    private ArrayList<Veiculo> listaVeiculos;
    private double valorSeguro;
    private boolean naturalPerson;

    // Construtor
    protected Cliente(String nome, String endereco, boolean naturalPerson) {

        if(Validacao.validarNome(nome)){
            this.nome = nome;
        }

        else{
            throw new IllegalArgumentException("Nome inválido: Apenas letras são permitidas");
        }

        this.endereco = endereco;
        this.listaVeiculos = new ArrayList<>();
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

    public boolean getNaturalPerson(){
        return naturalPerson;
    }

    public void setNaturalPerson(boolean naturalPerson){
        this.naturalPerson = naturalPerson;
    }

    // Funções relacionadas ao veiculos do cliente
    public List<Veiculo> getListaVeiculos(){
        return this.listaVeiculos;
    }

    public void listarVeiculos() {
        System.out.println("Listando veículos de \"" + this.nome + "\":");
        for (Veiculo veiculoAlt : this.listaVeiculos) {
                System.out.println(veiculoAlt.toString());
        }
        if (this.listaVeiculos.isEmpty()){
            System.out.println("Sem veículos cadastrados");
        }
        System.out.println("\n");
    }

    public boolean addVeiculo(Veiculo veiculo) {
        return this.listaVeiculos.add(veiculo);
    }

    public boolean removeVeiculo(Veiculo veiculo) {
        return this.listaVeiculos.remove(veiculo);
    }

    // Funções que devem ser overriden

    public String getCPF(){
        throw new UnsupportedOperationException("This method must be overridden by a subclass.");
    }

    public String getCNPJ(){
        throw new UnsupportedOperationException("This method must be overridden by a subclass.");
    }

    public String toString() {
        throw new UnsupportedOperationException("This method must be overridden by a subclass.");
    }
}
