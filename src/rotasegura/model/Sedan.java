package rotasegura.model;

public class Sedan extends Veiculo 
{
	
	public Sedan(String placa, String marca, String modelo, int ano) {
		super(placa, marca, modelo, ano);
	}
	
	@Override
	public double calcularDiaria() {
		return 120.0;
	}
	
}

