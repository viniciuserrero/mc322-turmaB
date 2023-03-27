package lab2;

public class Cliente {
     private String nome ;
     private String cpf ;
     private String dataNascimento ;
     private int idade ;
     private String endereco ;

     // Construtor
     public Cliente ( String nome , String cpf , String dataNascimento , int idade , String endereco ) {
         this.nome = nome ;
         this.cpf = cpf ;
         this.dataNascimento = dataNascimento ;
         this.idade = idade ;
         this.endereco = endereco ;
     }

     // Getters e setters
     public String getNome () {
         return nome ;
     }

     public void setNome ( String nome ) {
         this.nome = nome ;
     }

     public String getCPF () {
         return cpf ;
     }

     public void setCPF ( String cpf ) {
         this.cpf = cpf ;
     }

     public String getdataNascimento () {
         return dataNascimento ;
     }

     public void setdataNascimento ( String dataNascimento ) {
         this.dataNascimento = dataNascimento ;
     }

     public int getIdade () {
         return idade ;
     }

     public void setIdade ( int idade ) {
         this.idade = idade ;
     }

     public String getEndereco () {
         return endereco ;
     }

     public void setEndereco ( String endereco ) {
         this.endereco = endereco ;
     }

     public boolean validarCPF( String cpf) {
//       removendo caracteres que não são números(passo 1)
         cpf = cpf.replaceAll("[^\\d]", "");

//       verificando tamanho da variável(passo 2)
         if (cpf.length() != 11) {
                return false;
            }

//       verificando se todos os dígitos são iguais(passo 3)

         if (cpf.matches("(\\d)\\1{10}")) {
                return false;
            }

//       calculando digitos verificadores (passo 4)
         int[] fatores={11, 10, 9, 8, 7, 6, 5, 4 ,3, 2, 0};
         int soma_d1, soma_d2, num;
         soma_d1 = soma_d2 = num = 0;

         for(int i=0; i<10; i++) {
//           convertendo char na posição i para int
             num = Character.digit(cpf.charAt(i), 10);
             soma_d1 += num*fatores[i+1];
             soma_d2 += num*fatores[i];
         }
//       dividindo por 11 para obter digitos verificadores
         int d1 = 11 - (soma_d1%11);
         int d2 = 11 - (soma_d2%11);

//       verificando se o resto é 10 ou 11,
//       nesse caso o digito verificador será 0
         if (d1 > 9) {
             d1 = 0;
         }
         if (d2 > 9) {
             d2 = 0;
         }

         int d1_recebido = Character.digit(cpf.charAt(9), 10);
         int d2_recebido = Character.digit(cpf.charAt(10), 10);

         if(d1 == d1_recebido && d2 == d2_recebido) {
             return true;
         }

         return false;
    }

     public String toString() {
         return "O cliente " + nome + ", com número de CPF " + cpf + ", nascido em " + dataNascimento + ", mora no endereço " + endereco;
     }
}
