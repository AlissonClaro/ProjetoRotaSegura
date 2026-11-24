package rotasegura.model;

public class SUV extends Veiculo 
{
	
	public SUV(String placa, String marca, String modelo, int ano) {
		super(placa, marca, modelo, ano);
	}
	
	@Override
	public double calcularDiaria() {
		return 180.0;
	}
	
}

