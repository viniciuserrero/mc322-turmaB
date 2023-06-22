package lab5;

import java.util.Date;
import java.util.UUID;

import java.util.List;
import java.util.ArrayList;

public class Seguro {
    private final int id ;
    private Date dataInicio ;
    private Date dataFim ;
    private Seguradora seguradora ;
    private ArrayList<Veiculo> listaVeiculos;
    private ArrayList<Condutor> listaCondutores;
    private int valorMensal;

    public Seguro(
        Date dataInicio,
        Date dataFim,
        Seguradora seguradora,
        List<Veiculo> listaVeiculos,
        List<Condutor> listaCondutores,
        int valorMensal ){
            this.id = generateID();
            this.dataInicio = dataInicio;
            this.dataFim = dataFim;
            this.seguradora = seguradora;
            this.listaVeiculos = listaVeiculos;
            this.listaCondutores = listaCondutores;
            this.valorMensal = valorMensal;
        }
        
        // Getters e setters
        public int getID () {
            return id ;
        }

        public Date getDataInicio () {
            return dataInicio ;
        }

        public void setDataInicio ( Date dataInicio ) {
            this.dataInicio = dataInicio ;
        }

        public Date getDataFim () {
            return dataFim ;
        }

        public void setDataFim ( Date dataFim ) {
            this.dataFim = dataFim ;
        }

        public Seguradora getSeguradora () {
            return seguradora ;
        }

        public void setSeguradora ( Seguradora seguradora ) {
            this.seguradora = seguradora ;
        }

        public List<Veiculo> getListaVeiculos () {
            return listaVeiculos ;
        }

        public void setListaVeiculos ( List<Veiculo> listaVeiculos ) {
            this.listaVeiculos = listaVeiculos ;
        }

        public List<Condutor> getListaCondutores () {
            return listaCondutores ;
        }

        public void setListaCondutores ( List<Condutor> listaCondutores ) {
            this.listaCondutores = listaCondutores ;
        }

        public int getValorMensal () {
            return valorMensal ;
        }

        public void setValorMensal ( int valorMensal ) {
            this.valorMensal = valorMensal ;
        }

        public void autozizarCondutor(Condutor condutor){
            listaCondutores.add(condutor);
        }

        public void desautorizarCondutor(Condutor condutor){
            listaCondutores.remove(condutor);
        }

        public int calcularValor(){
            return 0;
        }
        // Generate id
        private int generateID() {
            UUID randomId = UUID.randomUUID();
            return (randomId.hashCode() & Integer.MAX_VALUE);
        }
        //tostring
        public String toString() {
            return "Seguro:\ndataFim=" + dataFim + ", dataInicio=" + dataInicio + ", id=" + id + ", listaCondutores="
                    + listaCondutores + ", listaVeiculos=" + listaVeiculos + ", seguradora=" + seguradora
                    + ", valorMensal=" + valorMensal;
        }
}
