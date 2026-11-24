package rotasegura.model;

public class Popular extends Veiculo 
{
	
	public Popular(String placa, String marca, String modelo, int ano) {
		super(placa, marca, modelo, ano);
	}
	
	@Override
	public double calcularDiaria() {
		return 80.0;
	}
	
}

