package lab5;

public class Frota {
  private String code;
  private List<Veiculo> listaVeiculos;

  public Frota(List<Veiculo> listaVeiculos) {
    this.code = UUID.randomUUID().toString();
    this.listaVeiculos = listaVeiculos;
  }

  // Getters e setters
  public String getCode() {
    return code;
  }

  public List<Veiculo> getListaVeiculos() {
    return listaVeiculos;
  }

  public void setListaVeiculos(List<Veiculo> listaVeiculos) {
    this.listaVeiculos = listaVeiculos;
  }

  public void addVeiculo(Veiculo veiculo) {
    this.listaVeiculos.add(veiculo);
  }

  public void removeVeiculo(Veiculo veiculo) {
    this.listaVeiculos.remove(veiculo);
  }

  public String toString() {
    String str = "Frota: " + this.code + "\n";
    for (Veiculo veiculo : this.listaVeiculos) {
      str += veiculo.toString() + "\n";
    }
    return str;
  }
}
