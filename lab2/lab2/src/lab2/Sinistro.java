package lab2;

public class Sinistro {
	 private int id ;
	 private String data ;
	 private String endereco ;

	 // Construtor
	 public Sinistro ( int id , String data , String endereco ) {
	 this.id = id ;
	 this.data = data ;
	 this.endereco = endereco ;
	 }

	 // Getters e setters
	 public int getid () {
	 return id ;
	 }

	 public void setid ( int id ) {
	 this.id = id ;
	 }

	 public String getdata () {
	 return data ;
	 }

	 public void setdata ( String data ) {
	 this.data = data ;
	 }

	 public String getEndereco () {
	 return endereco ;
	 }

	 public void setEndereco ( String endereco ) {
	 this.endereco = endereco ;
	 }
}
