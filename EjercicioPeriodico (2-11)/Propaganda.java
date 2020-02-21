
import java.util.Scanner;

import utilidades.Fecha;

public class Propaganda extends Publicacion {
	
	private float alto;
	private float ancho;
	private static float costoPorDia;
	
	public Propaganda(int nro, String nom, Fecha f, int d, float h, float w)
	{
		super(nro,nom,f,d);
		alto = h;
		ancho = w;
	}
	
	public float dameEspacio()
	{
		return alto * ancho;
		
	}
	public void informarCosto()
	{
		System.out.printf("El costo de la publicacion es de $%6.2f\n",alto*ancho*this.darCostoPorDia());
	}
	public float darCostoPorDia()
	{
		return Propaganda.dameCostoPorDia();
	}
	private static float dameCostoPorDia() {
		if(costoPorDia == 0){
			Scanner in = new Scanner(System.in);			
			System.out.println("Costo por dia de publicacion de Propaganda: ");
			costoPorDia = in.nextFloat(); 
		}
		return costoPorDia;
		
	}
}
