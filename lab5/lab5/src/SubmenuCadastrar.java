package lab5;

public enum SubmenuCadastrar {
    CADASTRAR_CLIENTE_PF_PJ(1),
    CADASTRAR_VEICULO(2),
    CADASTRAR_SEGURADORA(3),
    VOLTAR_CADASTRAR(4);

    public final int operacao;

    SubmenuCadastrar(int operacao){
        this.operacao = operacao;
    }

    public int getOperacao(){
        return this.operacao;
    }
}
