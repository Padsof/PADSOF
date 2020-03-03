package ads.PADSOF;
public class InfPopularidad extends Informe {

	private double popularidad;
	
	  public InfPopularidad(double popu) {
		  popularidad = popu;
	  }

	public double getPopularidad() {
		return popularidad;
	}

	public void setPopularidad(double popularidad) {
		this.popularidad = popularidad;
	}
}
