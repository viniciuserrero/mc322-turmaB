
public class Cliente {
     private String nome ;
     private String endereco ;

     // Construtor
     public Cliente ( String nome , String cpf , String dataNascimento , int idade , String endereco ) {
         this.nome = nome ;
         this.endereco = endereco ;
     }

     // Getters e setters
     public String getNome () {
         return nome ;
     }

     public void setNome ( String nome ) {
         this.nome = nome ;
     }

     public String getEndereco () {
         return endereco ;
     }

     public void setEndereco ( String endereco ) {
         this.endereco = endereco ;
     }

     public String toString() {
         return "O cliente " + nome + ", com número de CPF " + cpf + ", nascido em " + dataNascimento + ", mora no endereço " + endereco;
     }
}
