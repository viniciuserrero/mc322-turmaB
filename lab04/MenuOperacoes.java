public enum MenuOperacoes {
    CADASTRAR(1),
    CADASTRAR_CLIENTE_PF_PJ(11),
    CADASTRAR_VEICULO(12),
    CADASTRAR_SEGURADORA(13),
    VOLTAR_CADASTRAR(14),
    LISTAR(2),
    LISTAR_CLIENTE_SEG(21),
    LISTAR_SINISTRO_SEG(22),
    LISTAR_SINISTRO_CLIENTE(23),
    LISTAR_VEICULO_CLIENTE(24),
    LISTAR_VEICULO_SEG(25),
    VOLTAR_LISTAR(26),
    EXCLUIR(3),
    EXCLUIR_CLIENTE(31),
    EXCLUIR_VEICULO(32),
    EXCLUIR_SINISTRO(33),
    VOLTAR_EXCLUIR(34),
    GERAR_SINISTRO(4),
    TRANSFERIR_SEGURO(5),
    CALCULAR_RECEITA(6),
    SAIR(0);

    public final int operacao;

    MenuOperacoes(int operacao){
        this.operacao = operacao;
    }

    public int getOperacao(){
        return this.operacao;
    }
}
