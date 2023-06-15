package lab4;

import java.util.Date;
import java.util.UUID;

public class Sinistro {
    private final int id ;
    private Date data ;
    private String endereco ;
    private Seguradora seguradora ;
    private Veiculo veiculo ;
    private Cliente cliente ;

    // Construtor
    public Sinistro (
        Date data,
        String endereco,
        Seguradora seguradora,
        Veiculo veiculo,
        Cliente cliente ) {

        this.id = generateId();
        this.data = data ;
        this.endereco = endereco ;
        this.seguradora = seguradora;
        this.veiculo = veiculo;
        this.cliente = cliente;
    }

    // Getters e setters
    public int getID () {
        return id ;
    }

    public Date getData () {
        return data ;
    }

    public void setData ( Date data ) {
        this.data = data ;
    }

    public String getEndereco () {
        return endereco ;
    }

    public void setEndereco ( String endereco ) {
        this.endereco = endereco ;
    }

    public Seguradora getSeguradora () {
        return seguradora ;
    }

    public void setSeguradora ( Seguradora seguradora ) {
        this.seguradora = seguradora ;
    }

    public Veiculo getVeiculo () {
        return veiculo ;
    }

    public void setVeiculo ( Veiculo veiculo ) {
        this.veiculo = veiculo ;
    }

    public Cliente getCliente () {
        return cliente ;
    }

    public void setCliente ( Cliente cliente ) {
        this.cliente = cliente ;
    }

    public String toString(){
        return "Dados do sinistro:\n" + 
                "ID: " + getID() + "\n" + 
                "Data: " + getData() + "\n" +
                "Endereço: " + getEndereco() + "\n" +
                "Seguradora: " + this.seguradora.getNome() + "\n\n" +
                this.cliente.toString() +
                "\n\n------";
    }

    // Generate id
    private int generateId() {
        UUID randomId = UUID.randomUUID();
        return (randomId.hashCode() & Integer.MAX_VALUE);
    }

}
