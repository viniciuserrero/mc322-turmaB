package lab5;

import java.time.LocalDate;

public class SeguroPF extends Seguro {
    private Veiculo veiculo;
    private ClientePF cliente;

    public SeguroPF(
        int id,
        LocalDate dataInicio,
        LocalDate dataFim,
        Seguradora seguradora,
        List<Sinistro> listaSinistros,
        List<Condutor> listaCondutores,
        int valorMensal,
        Veiculo veiculo,
        ClientePF cliente) {
            super(id, dataInicio, dataFim, seguradora, listaSinistros, listaCondutores, valorMensal);
            this.veiculo = veiculo;
            this.cliente = cliente;
        }

        //Getters and setters
        public Veiculo getVeiculo() {
            return veiculo;
        }
        public void setVeiculo(Veiculo veiculo) {
            this.veiculo = veiculo;
        }
        public ClientePF getCliente() {
            return cliente;
        }
        public void setCliente(ClientePF cliente) {
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

        public double getFator(int idade){
            if(idade > 60)
                return 1.5;
            else if(idade > 30)
                return 1.25;
            else
                return 1.2;
        }

        public double calcularValor(){
            double fatorIdade = getFator(cliente.getIdade());
            return (10 * fatorIdade * (1 + 1/(cliente.getListaVeiculos().size() + 2)) * cliente.getListaVeiculos().size());
        }
}
