import java.util.Date;
import java.util.ArrayList;

public class Seguradora {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Cliente> listaClientes;

    // Construtor
    public Seguradora(String nome, String telefone, String email, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listaSinistros = new ArrayList<Sinistro>();
        this.listaClientes = new ArrayList<Cliente>();
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
        return listaClientes.add(cliente);
    }

    public boolean removerCliente(String cliente){
        for (Cliente _cliente : listaClientes) {
            if (_cliente.getNome().equals(cliente)) {
                return listaClientes.remove(_cliente);
            }
        }
        return false;
    }

    public ArrayList<Cliente> listarClientes(String tipo) {
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        for (Cliente cliente : listaClientes) {
            if (cliente instanceof ClientePF && tipo.equals("PF") | cliente instanceof ClientePJ && tipo.equals("PJ")) {
                lista.add(cliente);
            }
        }
        return lista;
    }

    public boolean gerarSinistro(String data, String endereco, Veiculo veiculo, Cliente cliente) {
        Sinistro sinistro = new Sinistro(data, endereco, this, veiculo, cliente);
        return listaSinistros.add(sinistro);
    }

    public boolean visualizarSinistro(String cliente) {
        for (Sinistro sinistro : listaSinistros) {
            if (sinistro.getCliente().getNome().equals(cliente)) {
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
}
