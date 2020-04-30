import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.StringTokenizer;

public class RefaccionariaAD
{
	
	private PrintWriter archivoOut;
	private BufferedReader	archivoIn;
	
	public String capturarProducto(String datos)
	{
		String resultado="";
		try
		{
			//1.- Abrir el archivo pra guardar los datos
			archivoOut= new PrintWriter(new FileWriter("Productos.txt",true));
			//2.- Almacenar o escribirlos datos en el archivo
			archivoOut.println(datos);
			//3.- Cerrar el archivo
			archivoOut.close();
		
			resultado = "Captura correcta de los datos...";
		}
		
		catch(IOException Ioe)
		{
			resultado ="Error: "+Ioe;
			System.out.println("Error: "+Ioe);
		}
	
		return resultado;
	}
	
	public String capturarServicio(String datos)
	{
		String resultado="";
		if(datos.equals("VACIO")){
			resultado="Campos vacios";
		}
		else{
			
			try{
				//1.- brir el archivo pra guardar los datos
				archivoOut= new PrintWriter(new FileWriter("Servicios.txt",true));
				//2.- Almacenar o escribirlos datos en el archivo
				archivoOut.println(datos);
				//3.- Cerrar el archivo
				archivoOut.close();
			
				resultado = "Captura correcta de los datos...";
			}
			
			catch(IOException Ioe){
				resultado ="Error: "+Ioe;
				System.out.println("Error: "+Ioe);
			}
			
		}
	
		return resultado;
	}
	public String consultarCatalogoProductos(){
		String datos="";
		
		try
		{
			//1.- Abrir el archivo para leer los datos
			archivoIn = new BufferedReader( new FileReader("Productos.txt"));
			//2.- Procesae los datos 
			while(archivoIn.ready())
				datos = datos +archivoIn.readLine()+"\n";
			//3.- Cerrar el archivo
			archivoIn.close();
		}
		catch(FileNotFoundException fnfe)
		{
			datos = "Error: "+fnfe;
			System.out.println("Error: "+fnfe);
		}
		catch(IOException Ioe)
		{
			datos ="Error: "+Ioe;
			System.out.println("Error: "+Ioe);
		}
		return datos;
	}
	public String consultarCatalogoServicios()
	{
		String datos="";
		
		try
		{
			//1.- Abrir el archivo para leer los datos
			archivoIn = new BufferedReader( new FileReader("Servicios.txt"));
			//2.- Procesae los datos 
			while(archivoIn.ready())
				datos = datos +archivoIn.readLine()+"\n";
			//3.- Cerrar el archivo
			archivoIn.close();
		}
		catch(FileNotFoundException fnfe)
		{
			datos = "Error: "+fnfe;
			System.out.println("Error: "+fnfe);
		}
		catch(IOException Ioe)
		{
			datos ="Error: "+Ioe;
			System.out.println("Error: "+Ioe);
		}
		return datos;
	}
	public String consultarClaveProducto(String cla)
	{
		String datos="";
		String strClave="";
		StringTokenizer st;
		String clave,nombreP,marca,unidad,tipo,precioFabrica,precioPublico,descripcion;
		boolean encontrado=false;
		try
		{

			//1.- Abrir archivo para leer
			archivoIn = new BufferedReader (new FileReader ("Productos.txt"));
			
			//2.- Buscar libros de la editorial indicada
			while (archivoIn.ready())
			{
				strClave= archivoIn.readLine();
				st = new StringTokenizer(strClave,"_");
				
				clave= st.nextToken();
				nombreP= st.nextToken();
				marca =st.nextToken();
				unidad =st.nextToken();
				tipo =st.nextToken();
				precioFabrica =st.nextToken();
				precioPublico =st.nextToken();
				descripcion =st.nextToken();
				
				if(clave.equals(cla))
				{
					datos = datos + strClave + "\n";
					encontrado = true;
					
				}
				
			}
			//3.- Cerrar el archivo
			archivoIn.close();
			
			if(! encontrado)
				datos= "No se localizo la clave "+cla;
			
		}
		catch(FileNotFoundException fnfe)
		{
			datos= "Error: "+fnfe;
			System.out.println("Error: "+fnfe);
		}
		catch(IOException Ioe)
		{
			datos ="Error: "+Ioe;
			System.out.println("Error: "+Ioe);
		}
		
		
		return datos;
	}
	public String consultarClaveServicio(String clas)
	{
		String datos="";
		String strClave="";
		StringTokenizer st;
		String clave,nombreP,precioFabrica,descripcion;
		boolean encontrado=false;
		try
		{

			//1.- Abrir archivo para leer
			archivoIn = new BufferedReader(new FileReader("Servicios.txt") );
			
			//2.- Buscar libros de la editorial indicada
			while (archivoIn.ready())
			{
				strClave= archivoIn.readLine();
				st = new StringTokenizer(strClave,"_");
				
				clave= st.nextToken();
				nombreP= st.nextToken();
				precioFabrica =st.nextToken();
				descripcion =st.nextToken();
				
				if(clave.equals(clas))
				{
					datos = datos + strClave + "\n";
					encontrado = true;
					
				}
				
			}
			//3.- Cerrar el archivo
			archivoIn.close();
			
			if(! encontrado)
				datos= "No se localizo la clave: "+clas;
			
		}
		catch(FileNotFoundException fnfe)
		{
			datos= "Error: "+fnfe;
			System.out.println("Error: "+fnfe);
		}
		catch(IOException Ioe)
		{
			datos ="Error: "+Ioe;
			System.out.println("Error: "+Ioe);
		}
		
		
		return datos;

		
		
	}
	public String consultarTipoProducto(String type)
	{
		String datos="";
		String strTipo="";
		StringTokenizer st;
		String clave,nombreP,marca,unidad,tipo,precioFabrica,precioPublico,descripcion;
		boolean encontrado=false;
		try
		{

			//1.- Abrir archivo para leer
			archivoIn = new BufferedReader(new FileReader("Productos.txt") );
			
			//2.- Buscar libros de la editorial indicada
			while (archivoIn.ready())
			{
				strTipo= archivoIn.readLine();
				st = new StringTokenizer(strTipo,"_");
				
				clave= st.nextToken();
				nombreP= st.nextToken();
				marca =st.nextToken();
				unidad =st.nextToken();
				tipo =st.nextToken();
				precioFabrica =st.nextToken();
				precioPublico =st.nextToken();
				descripcion =st.nextToken();
				
				if(tipo.equals(type))
				{
					datos = datos + strTipo + "\n";
					encontrado = true;
					
				}
				
			}
			//3.- Cerrar el archivo
			archivoIn.close();
			
			if(! encontrado)
				datos= "No se localizo el tipo: "+type;
			
		}
		catch(FileNotFoundException fnfe)
		{
			datos= "Error: "+fnfe;
			System.out.println("Error: "+fnfe);
		}
		catch(IOException Ioe)
		{
			datos ="Error: "+Ioe;
			System.out.println("Error: "+Ioe);
		}
		
		
		return datos;
		
		//Servicios
		
		
	}
	public String consultarMarca(String marc)
	{
		String datos="";
		String strMarca="";
		StringTokenizer st;
		String clave,nombreP,marca,unidad,tipo,precioFabrica,precioPublico,descripcion;
		boolean encontrado=false;
		try
		{

			//1.- Abrir archivo para leer
			archivoIn = new BufferedReader(new FileReader("Productos.txt"));
			//2.- Buscar libros de la editorial indicada
			while (archivoIn.ready())
			{
				strMarca= archivoIn.readLine();
				st = new StringTokenizer(strMarca,"_");
				
				clave= st.nextToken();
				nombreP= st.nextToken();
				marca =st.nextToken();
				unidad =st.nextToken();
				tipo =st.nextToken();
				precioFabrica =st.nextToken();
				precioPublico =st.nextToken();
				descripcion =st.nextToken();
				
				if(marca.equals(marc))
				{
					datos = datos + strMarca + "\n";
					encontrado = true;
					
				}
				
			}
			//3.- Cerrar el archivo
			archivoIn.close();
			
			if(! encontrado)
				datos= "No se localizo la marca: "+marc;
			
		}
		catch(FileNotFoundException fnfe)
		{
			datos= "Error: "+fnfe;
			System.out.println("Error: "+fnfe);
		}
		catch(IOException Ioe)
		{
			datos ="Error: "+Ioe;
			System.out.println("Error: "+Ioe);
		}
		
		
		return datos;
	}
	public String consultarNombreProducto(String namep)
	{
		String datos="";
		String strNombre="";
		StringTokenizer st;
		String clave,nombreP,marca,unidad,tipo,precioFabrica,precioPublico,descripcion;
		boolean encontrado=false;
		try
		{

			//1.- Abrir archivo para leer
			archivoIn = new BufferedReader(new FileReader("Productos.txt"));
			//2.- Buscar libros de la editorial indicada
			while (archivoIn.ready())
			{
				strNombre= archivoIn.readLine();
				st = new StringTokenizer(strNombre,"_");
				
				clave= st.nextToken();
				nombreP= st.nextToken();
				marca =st.nextToken();
				unidad =st.nextToken();
				tipo =st.nextToken();
				precioFabrica =st.nextToken();
				precioPublico =st.nextToken();
				descripcion =st.nextToken();
				
				if(nombreP.equals(namep))
				{
					datos = datos + strNombre + "\n";
					encontrado = true;
					
				}
				
			}
			//3.- Cerrar el archivo
			archivoIn.close();
			
			if(! encontrado)
				datos= "No se localizo el nombre: "+namep;
			
		}
		catch(FileNotFoundException fnfe)
		{
			datos= "Error: "+fnfe;
			System.out.println("Error: "+fnfe);
		}
		catch(IOException Ioe)
		{
			datos ="Error: "+Ioe;
			System.out.println("Error: "+Ioe);
		}
		
		
		return datos;
	}
	public String consultarNombreServicio(String namep)
	{
		String datos="";
		String strNombre="";
		StringTokenizer st;
		String clave,nombreP,precioFabrica,descripcion;
		boolean encontrado=false;
		try
		{

			//1.- Abrir archivo para leer
			archivoIn = new BufferedReader(new FileReader("Servicios.txt") );
			
			//2.- Buscar libros de la editorial indicada
			while (archivoIn.ready())
			{
				strNombre= archivoIn.readLine();
				st = new StringTokenizer(strNombre,"_");
				
				clave= st.nextToken();
				nombreP= st.nextToken();
				precioFabrica =st.nextToken();
				descripcion =st.nextToken();
				
				if(nombreP.equals(namep))
				{
					datos = datos + strNombre + "\n";
					encontrado = true;
					
				}
				
			}
			//3.- Cerrar el archivo
			archivoIn.close();
			
			if(! encontrado)
				datos= "No se localizo el nombre: "+namep;
			
		}
		catch(FileNotFoundException fnfe)
		{
			datos= "Error: "+fnfe;
			System.out.println("Error: "+fnfe);
		}
		catch(IOException Ioe)
		{
			datos ="Error: "+Ioe;
			System.out.println("Error: "+Ioe);
		}
		
		
		return datos;

		
		
	}
	
	
	
	
}