package lab5;

public class Validacao {

    public static boolean validarCPF(String cpf) {
        // removendo caracteres que não são números(passo 1)
        cpf = cpf.replaceAll("[^\\d]", "");

        // verificando tamanho da variável(passo 2)
        if (cpf.length() != 11) {
            throw new IllegalArgumentException("CPF inválido: Tamanho diferente de 11 dígitos");
        }

        // verificando se todos os dígitos são iguais(passo 3)

        if (cpf.matches("(\\d)\\1{10}")) {
            throw new IllegalArgumentException("CPF inválido: Todos os dígitos são iguais");
        }

        // calculando digitos verificadores (passo 4)
        int[] fatores = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 0 };
        int somaD1 = 0;
        int somaD2 = 0;
        int num;

        for (int i = 0; i < 10; i++) {
            // convertendo char na posição i para int
            num = Character.digit(cpf.charAt(i), 10);
            somaD1 += num * fatores[i + 1];
            somaD2 += num * fatores[i];
        }
        // dividindo por 11 para obter digitos verificadores
        int d1 = 11 - (somaD1 % 11);
        int d2 = 11 - (somaD2 % 11);

        // verificando se o resto é 10 ou 11,
        // nesse caso o digito verificador será 0
        if (d1 > 9) {
            d1 = 0;
        }
        if (d2 > 9) {
            d2 = 0;
        }

        int d1Recebido = Character.digit(cpf.charAt(9), 10);
        int d2Recebido = Character.digit(cpf.charAt(10), 10);

        if (d1 == d1Recebido && d2 == d2Recebido) {
            return true;
        }

        throw new IllegalArgumentException("CPF inválido: Dígitos verificadores não conferem");
    }

    public static boolean validarCNPJ(String cnpj) {
        // removendo caracteres que não são números(passo 1)
        cnpj = cnpj.replaceAll("[^\\d]", "");

        // verificando tamanho da variável(passo 2)
        if (cnpj.length() != 14) {
            throw new IllegalArgumentException("CNPJ inválido: Tamanho diferente de 14 dígitos");
        }

        // verificando se todos os dígitos são iguais(passo 3)

        if (cnpj.matches("(\\d)\\1{13}")) {
            throw new IllegalArgumentException("CNPJ inválido: Todos os dígitos são iguais");
        }

        // calculando digitos verificadores (passo 4)
        int[] fatores = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2, 0 };
        int somaD1 = 0;
        int somaD2 = 0;
        int num;

        for (int i = 0; i < 13; i++) {
            // convertendo char na posição i para int
            num = Character.digit(cnpj.charAt(i), 10);
            somaD1 += num * fatores[i + 1];
            somaD2 += num * fatores[i];
        }
        // dividindo por 11 para obter digitos verificadores
        int d1 = 11 - (somaD1 % 11);
        int d2 = 11 - (somaD2 % 11);

        // verificando se o resto é 10 ou 11,
        // nesse caso o digito verificador será 0
        if (d1 > 9) {
            d1 = 0;
        }
        if (d2 > 9) {
            d2 = 0;
        }

        int d1Recebido = Character.digit(cnpj.charAt(12), 10);
        int d2Recebido = Character.digit(cnpj.charAt(13), 10);

        if (d1 == d1Recebido && d2 == d2Recebido) {
            return true;
        }

        throw new IllegalArgumentException("CNPJ inválido: Dígitos verificadores não conferem");
    }

    public static boolean validarNome(String nome){
            return nome.matches("[A-Za-z ]+");
    }
}
