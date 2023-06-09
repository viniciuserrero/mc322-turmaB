import java.time.LocalDate;
import java.util.List;

public class Seguradora {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private List<Sinistro> listaSinistros;
    private List<Cliente> listaClientes;

    // Construtor
    public Seguradora(
        String nome,
        String telefone,
        String email,
        String endereco) {

        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listaSinistros = new List<>();
        this.listaClientes = new List<>();
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public boolean cadastrarCliente(Cliente cliente) {
        return this.listaClientes.add(cliente);
    }

    public boolean removerCliente(String cliente){
        for (Cliente clientAlt : this.listaClientes) {
            if (clientAlt.getNome().equals(cliente)) {
                return this.listaClientes.remove(clientAlt);
            }
        }
        return false;
    }

    public void listarClientes(String tipo) {
        for (Cliente clientAlt : this.listaClientes) {
            if (clientAlt instanceof ClientePF && tipo.equals("PF") || clientAlt instanceof ClientePJ && tipo.equals("PJ")) {
                System.out.println("-----");
                System.out.println(clientAlt.toString());
            }
        }
    }

    public boolean gerarSinistro(String data, String endereco, Veiculo veiculo, Cliente cliente) {
        Sinistro sinistro = new Sinistro(data, endereco, this, veiculo, cliente);
        return this.listaSinistros.add(sinistro);
    }

    public boolean visualizarSinistro(String clientAlt) {
        for (Sinistro sinistro : this.listaSinistros) {
            if (sinistro.getCliente().getNome().equals(clientAlt)) {
                System.out.println("ID: " + sinistro.getID());
                System.out.println("Data: " + sinistro.getData());
                System.out.println("Endereço: " + sinistro.getEndereco());
                System.out.println("Seguradora: " + sinistro.getSeguradora().getNome());
                System.out.println("Veículo: " + sinistro.getVeiculo().getPlaca());
                System.out.println("Cliente: " + sinistro.getCliente().getNome());
                return true;
            }
        }
        return false;
    }

    public void listarSinistros(){
        System.out.println("Not implemented");
    }

    public List getListaClientes(){
        return this.listaClientes;
    }

    public double calcularPrecoSeguroCliente(Cliente clientAlt){
        int qtdSinistros = 0;
        
        for (Sinistro _sinistro : this.listaSinistros){
            String nomeAlt = _sinistro.getCliente().getNome();
            if(clientAlt.getNome().equals(nomeAlt)){
                qtdSinistros++;
            }
        }

        double score = clientAlt.calculaScore();
        
        return score*(1+qtdSinistros);
    }

    public double calcularReceita(){
        double receita = 0;
        for(Cliente clienteAlt : this.listaClientes){
            receita += clienteAlt.getValorSeguro();
        }
        return receita;
    }
}
