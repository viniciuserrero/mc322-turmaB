package lab5;

public enum SubmenuListar {
    LISTAR_CLIENTE_SEG(1),
    LISTAR_SINISTRO_SEG(2),
    LISTAR_SINISTRO_CLIENTE(3),
    LISTAR_VEICULO_CLIENTE(4),
    LISTAR_VEICULO_SEG(5),
    VOLTAR_LISTAR(6);

    public final int operacao;

    SubmenuListar(int operacao){
        this.operacao = operacao;
    }

    public int getOperacao(){
        return this.operacao;
    }
}
