import java.util.Scanner;

import utilidades.Fecha;

public class Aviso extends Publicacion{
	
	private int cantLineas;
	private static float costoPorDia;
	private static double superficiePorLinea;
	
	public Aviso(int nro, String nom, Fecha f, int d, int c)
	{
		super(nro, nom, f, d);
		cantLineas = c;
	}
	
	public float dameEspacio()
	{
		return (float) (cantLineas* this.darSuperficie() );
	}
	
	public void informarCosto()
	{
		System.out.printf("El costo de la publicacion es de $%6.2f\n",(cantLineas*this.darSuperficie())*this.darCostoPorDia());
	}
	public float darCostoPorDia()
	{
		return Aviso.dameCostoPorDia();
	}
	
	public double darSuperficie()
	{
		return Aviso.dameSuperficie();
	}
	private static float dameCostoPorDia() {
		if(costoPorDia == 0){
			Scanner in = new Scanner(System.in);			
			System.out.println("Costo por dia de publicacion de Aviso: ");
			costoPorDia = in.nextFloat(); 
		}
		return costoPorDia;
	}
	
	private static double dameSuperficie() {
		if(superficiePorLinea == 0){
			Scanner in = new Scanner(System.in);			
			System.out.println("Superficie del de Aviso: ");
			superficiePorLinea = in.nextDouble(); 
		}
		return superficiePorLinea;
		
	}
}


