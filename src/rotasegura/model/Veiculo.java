package rotasegura.model;

public class Veiculo {
	//utilizamos private porque estamos aplicando encapsulamento.
	private String placa;
	private String marca;
	private String modelo;
	private int ano;
	private boolean disponivel;

	public Veiculo(String placa, String marca, String modelo, int ano) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.disponivel = true;
	}

		public String getPlaca() {
			return placa;
		}
		
		public void setPlaca(String placa) {
			this.placa = placa;
		}
		
		public String getMarca() {
			return marca;
		}
		
		public void setMarca(String marca) {
			this.marca = marca;
		}
		
		public String getModelo() {
			return modelo;
		}
		
		public void setModelo(String modelo) {
			this.modelo = modelo;
		}
		
		public int getAno() {
			return ano;
		}
		
		public void setAno(int ano) {
			this.ano = ano;
		}
		
		public boolean isDisponivel() {
			return disponivel;
		}
		
		public void setDisponivel(boolean disponivel) {
			this.disponivel = disponivel;
		}
		
		public double calcularDiaria() {
			return 100.0;
		}
}

