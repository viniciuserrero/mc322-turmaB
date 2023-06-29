package lab5;

import java.util.List;
import java.time.LocalDate;

public class SeguroPJ extends Seguro {
    private Frota frota;
    private ClientePJ cliente;

    public SeguroPJ(
        int id,
        LocalDate dataInicio,
        LocalDate dataFim,
        Seguradora seguradora,
        List<Sinistro> listaSinistros,
        List<Condutor> listaCondutores,
        int valorMensal,
        Frota frota,
        ClientePJ cliente) {
            super(id, dataInicio, dataFim, seguradora, listaSinistros, listaCondutores, valorMensal);
            this.frota = frota;
            this.cliente = cliente;
        }

        //Getters and setters
        public Frota getFrota() {
            return frota;
        }

        public void setFrota(Frota frota) {
            this.frota = frota;
        }

        public ClientePJ getCliente() {
            return cliente;
        }

        public void setCliente(ClientePJ cliente) {
            this.cliente = cliente;
        }

        //Methods
        public void autorizarCondutor(Condutor condutor){
            super.getListaCondutores().add(condutor);
        }

        public void desautorizarCondutor(Condutor condutor){
            super.getListaCondutores().remove(condutor);
        }

        public void gerarSinistro(){
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public double calcularValor(){
            LocalDate now = LocalDate.now();
            Seguradora seguradora = super.getSeguradora();

            double qtdeVeiculos = (double) this.frota.getListaVeiculos().size();
            double qtdeFuncionarios = (double) this.cliente.getQtdeFuncionarios();
            double anosPosFundacao = (double) this.cliente.getDataFundacao().getYear() - now.getYear();
            double qtdSinistrosCliente = (double) seguradora.getSinistrosPorCliente(this.cliente).size();
            double qtdSinistrosCondutor = 1; //todo: implementar

            int valorBase = 10;

            return (valorBase * (10 + (qtdeFuncionarios)/10) *
                    (1 + 1/(qtdeVeiculos + 2)) *
                    (1 + 1/(anosPosFundacao + 2)) *
                    (2 + qtdSinistrosCliente/10) *
                    (5 + qtdSinistrosCondutor/10));
        }
}
