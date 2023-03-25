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

	 public String getcpf () {
	 return cpf ;
	 }

	 public void setcpf ( String cpf ) {
	 this.cpf = cpf ;
	 }
	 
	 public String getdataNascimento () {
	 return dataNascimento ;
	 }

	 public void setdataNascimento ( String dataNascimento ) {
	 this.dataNascimento = dataNascimento ;
	 }

	 public int getidade () {
	 return idade ;
	 }

	 public void setidade ( int idade ) {
	 this.idade = idade ;
	 }

	 public String getEndereco () {
	 return endereco ;
	 }

	 public void setEndereco ( String endereco ) {
	 this.endereco = endereco ;
	 }
	 
	 public boolean validarCPF( String cpf) {
//		 removendo caracteres que não são números(passo 1)
		 cpf = cpf.replaceAll("[^\\d]", "");
		 
//		 verificando tamanho da variável(passo 2)
		 if (cpf.length() != 11) {
	            return false;
	        }
		 
//		 verificando se todos os dígitos são iguais(passo 3)
		 
		 for(int i=1; i<12; i++){
			 
			 if(i==11) {
				 return false;
			 }
			 
			 if( cpf.charAt(i) == cpf.charAt(0)){
				 continue;
			 }
			 break;
		 }
		 
//		 calculando digitos verificadores (passo 4)
		 int[] fatores={11, 10, 9, 8, 7, 6, 5, 4 ,3, 2, 0};
		 int soma_d1, soma_d2, num;
		 soma_d1 = soma_d2 = num = 0;
		 
		 for(int i=0; i<10; i++) {
//			 convertendo char na posição i para int
			 num = Character.digit(cpf.charAt(i), 10);
			 
			 soma_d1 += num*fatores[i+1];
			 soma_d2 += num*fatores[i];
		 }
		 
//		 dividindo por 11 para obter digitos verificadores
		 int resto_d1 = soma_d1%11; 
		 int d1 = resto_d1;
		 int resto_d2 = soma_d2%11;
		 int d2 = resto_d2;
		 
//		 verificando se o resto é 10 ou 11,
//		 nesse caso o digito verificador será 0
		 if (resto_d1 > 9) {
			 d1 = 0;
		 }
		 if (resto_d2 > 9) {
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
		 return " O cliente " + nome + ", com número de CPF " + cpf + ", nascido em " + dataNascimento + ", mora no endereço" + endereco;
	 }
}