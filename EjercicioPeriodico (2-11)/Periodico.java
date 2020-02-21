import java.util.Scanner;
import java.util.ArrayList; 

import utilidades.Fecha;

public class Periodico {
	
	private ArrayList<Publicacion> publicaciones;
	private int ultimoCodigo; 
	
	public Periodico()
	{
		publicaciones = new ArrayList<Publicacion>();
		ultimoCodigo = 0;
	}
	
	
	public void agregarPublicacion()
	{
		Scanner e = this.obtenerEntrada();
		Publicacion p;
		byte op;
		do
		{
			System.out.print("\nIngrese 1 Propaganda - 2 Aviso: ");
			op = e.nextByte();
		}
		while(op != 1 && op != 2);
		
		System.out.print("Ingrese nombre del solicitante: ");
		String nom = e.next();
		System.out.print("Ingrese días de publicación: ");
		int dias = e.nextInt();
		Fecha f = Fecha.nuevaFecha();
		int nro;
		nro = ultimoCodigo + 1;
		ultimoCodigo = nro;
		if(op == 1) // PROPAGANDA
		{
			float alto,ancho = 0;
			do
			{
				System.out.print("Ingrese alto en cm: ");
				alto = e.nextFloat();
			}
			while (alto <= 0);
			do
			{
				System.out.print("Ingrese ancho en cm: ");
				ancho = e.nextFloat();
			}
			while (ancho <= 0);
			//nro = ultimoCodigo + 1;
			//ultimoCodigo = nro;
			p = new Propaganda(nro, nom, f, dias,alto,ancho);			
		}
		else // CASO AVISO
		{
			int lineas;
			do
			{
				System.out.print("Ingrese cantidad de lineas: ");
				lineas = e.nextInt();
			}
			while(lineas < 1);
			
		//	nro = ultimoCodigo + 1;
		//	ultimoCodigo = nro;
			p = new Aviso(nro, nom, f, dias, lineas);			
			
		}
		publicaciones.add(p);
		System.out.printf("Publicación agregada exitosamente. Código: %d\n",nro);		
	}
	public void informarCosto()
	{
		Scanner e = this.obtenerEntrada();
		System.out.print("Ingrese código de publicación: ");
		int cod = e.nextInt();
		Publicacion p = this.buscarPublicacion(cod);
		if(p == null)
		{
			System.out.println("No existe una publicacion para el código dado");
		}
		else
		{
			p.informarCosto();
		}
		
	}
	public void eliminarPublicacionesExpiradas()
	{
		Scanner e = this.obtenerEntrada();
		String rta = "";
		System.out.print("Esta seguro que desea eliminar todas las publicaciones expiradas?(S/N): ");
		rta = e.next();
		if(rta.compareToIgnoreCase("s") == 0)
		{
			int i = 0;
			do {
				if((publicaciones.get(i).estasExpirada()))
					{
						System.out.printf("Se eliminó publicacion: %s\n",publicaciones.get(i));
						System.out.println(publicaciones.get(i).getClass().getName());
						publicaciones.remove(publicaciones.get(i));
					}
				else
					i++;
			}
			while (i < publicaciones.size() );
			
		}
		
	}
	public void calcularEspacioTotalRequerido()
	{
		Fecha f = Fecha.nuevaFecha();		
		float espTtl = 0;
		for(Publicacion p: publicaciones)
		{
			if(p.estasVigentePara(f))
			{
				espTtl += p.dameEspacio();
			}
		}
		
		System.out.printf("Se requieren %6.2f cm2 para publicar todo lo contratado el %s.\n",espTtl,f.toString());
	}
	
	public void informarContratados()
	{
		System.out.println("\nLas publicaciones contratadas son: ");
		for(Publicacion pub: publicaciones)
		{
			System.out.printf("%s - %s\n",pub,pub.dameEstado());			
		}
	}
	
 	public Publicacion buscarPublicacion(int cod)
	{
		int i = 0;
		while (i < publicaciones.size() && !publicaciones.get(i).sosCodigo(cod))
		{i++;}
		if(i < publicaciones.size())		
			return publicaciones.get(i);		
		else
			return null;
	}
	public Scanner obtenerEntrada()
	{
		/*PARA EVITAR ESCRIBIR ESTAS DOS LINEAS CONSTANTEMENTE*/
		Scanner s = new Scanner(System.in);
		s.useDelimiter(System.getProperty("line.separator"));
		return s;
	}
}
