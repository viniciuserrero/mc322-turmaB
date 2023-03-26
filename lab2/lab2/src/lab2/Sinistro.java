package lab2;
import java.util.UUID;

public class Sinistro {
	 private int id ;
	 private String data ;
	 private String endereco ;

	 // Construtor
	 public Sinistro (String data , String endereco ) {
	 this.id = generate_id();
	 this.data = data ;
	 this.endereco = endereco ;
	 }

	 // Getters e setters
	 public int getID () {
	 return id ;
	 }

	 public String getData () {
	 return data ;
	 }

	 public void setData ( String data ) {
	 this.data = data ;
	 }

	 public String getEndereco () {
	 return endereco ;
	 }

	 public void setEndereco ( String endereco ) {
	 this.endereco = endereco ;
	 }
	 
	 // Generate id
	 private int generate_id() {
		 UUID random_id = UUID.randomUUID();
		 return (random_id.hashCode() & Integer.MAX_VALUE);
	 }
	 
}
