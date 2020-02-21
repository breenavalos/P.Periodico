import utilidades.Fecha;

public abstract class Publicacion {
	
	private int codigo;
	private String nombreSolicitante;
	private Fecha fechaContrato;
	private int diasContrato;
	
	public Publicacion(int nro, String nom, Fecha f, int d)
	{
		codigo = nro;
		nombreSolicitante = nom;
		fechaContrato = f;
		diasContrato = d;		
		
	}		

	public abstract void informarCosto();
	public abstract float dameEspacio();
	
	public boolean estasExpirada()
	{					
		return (Fecha.hoy().compareTo(fechaContrato) > diasContrato);		
		
	}
	public boolean estasVigentePara(Fecha f)
	{
		int dif = f.compareTo(fechaContrato);
		return (dif >= 0 && dif <= diasContrato);
	}
	
	public boolean sosCodigo(int nro)
	{return codigo == nro;}
	public String darSolicitante()
	{return nombreSolicitante;}
	
	public String toString()
	{
		return nombreSolicitante + " - " + fechaContrato.toString();
	}
	
	public String dameEstado()
	{
		if(this.estasExpirada())
			return "Expirada";
		else
			return "VIGENTE !!";
		
	}
}
