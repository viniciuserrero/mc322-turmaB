package lab5;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Condutor {
    private final String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private LocalDate dataNascimento;
    private ArrayList<Veiculo> listaSinistros;

    public Condutor(
            String cpf,
            String nome,
            String telefone,
            String endereco,
            String email,
            LocalDate dataNascimento,
            List<Veiculo> listaSinistros) {

        if(Validacao.validarCPF(cpf)){
            this.cpf = cpf;
        }

        else{
            this.cpf = null;
        }

        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.listaSinistros = listaSinistros;

    }
    //Getters e setters
    public String getCPF() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    public ArrayList<Veiculo> getListaSinistros(){
        return this.listaSinistros;
    }

    public void setListaSinistros(ArrayList<Veiculo> listaSinistros){
        this.listaSinistros = listaSinistros;
    }

    public void addSinistro(Veiculo veiculo){
        this.listaSinistros.add(veiculo);
    }

    public void removeSinistro(Veiculo veiculo){
        this.listaSinistros.remove(veiculo);
    }

    public String toString() {
        return "Condutor:\n cpf=" + cpf + ", nome=" + nome + ", telefone=" + telefone + ", endereco=" + endereco
                + ", email=" + email + ", dataNascimento=" + dataNascimento + ", listaSinistros=" + listaSinistros
                + "";
    }
}
