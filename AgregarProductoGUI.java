import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.StringTokenizer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarProductoGUI extends JFrame implements ActionListener{
	
	private JTextField tfClave, tfNombreProducto, tfMarca, tfUnidad,tfPrecioFabrica,tfPrecioPublico;
	private JButton    bAgregar, bMenuP;
	private JPanel     panel, panel1, panel2, panel3;
	
	private JComboBox comboDescripcion;
	private String descripcion[] = {"Producto","Servicio"};
	
	private JComboBox comboTipo;
	private String tipo[] = {"Accesorios","Caja de Velocidades","Colision","Frenos","Herramientas","Interior","Motor","Quimicos","Ruedas","S. Electrico","Suspension"};
	
	private RefaccionariaAD refaccionaria = new RefaccionariaAD();
	
	public AgregarProductoGUI(){
		
		super("Refaccionaria Santa Cruz");
		
		//Crear objetos
		tfClave  	        = new JTextField(20);
		tfNombreProducto    = new JTextField();
        tfMarca             = new JTextField();
        tfUnidad            = new JTextField();
        tfPrecioFabrica   	= new JTextField();
        tfPrecioPublico     = new JTextField();
        
        bAgregar   = new JButton("Agregar");
        bMenuP     = new JButton("Menu Pricipal");
        
        panel  = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        
         // Adicionar ActionLisener a los botones

        bAgregar.addActionListener(this);
        bMenuP.addActionListener(this);

        comboDescripcion = new JComboBox(descripcion);
        comboTipo = new JComboBox(tipo);
        
        panel1.setLayout(new GridLayout(1,1));
        panel2.setLayout(new GridLayout(8,2));
        panel3.setLayout(new GridLayout(2,1));
        panel.setLayout(new FlowLayout());
        
        panel1.add(new JLabel("**Agregar Producto al Catalogo**"));
        
        panel2.add(new JLabel("Clave: "));
        panel2.add(tfClave);
		panel2.add(new JLabel("Nombre del Producto: "));
        panel2.add(tfNombreProducto);
        panel2.add(new JLabel("Marca: "));
        panel2.add(tfMarca);
        panel2.add(new JLabel("Unidad: "));
        panel2.add(tfUnidad);
        panel2.add(new JLabel("Tipo: "));
        panel2.add(comboTipo);
        panel2.add(new JLabel("Precio Fabrica: "));
        panel2.add(tfPrecioFabrica);
        panel2.add(new JLabel("Precio Publico: "));
        panel2.add(tfPrecioPublico);
        panel2.add(new JLabel("Descripcion: "));
        panel2.add(comboDescripcion);
        
        panel3.add(bAgregar);
        panel3.add(bMenuP);
        
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        
        add(panel);
        setSize(500,350);
        //setVisible(false);
	}
	
	public JPanel getPanel(){
        return this.panel;
    }
    
	
	 private String obtenerInf()
    {
        String datos = "";
        
        String clave  = tfClave.getText();
        String nombreP  = tfNombreProducto.getText();
        String marca  = tfMarca.getText();
        String unidad = tfUnidad.getText();
        String tipo   = (String)comboTipo.getSelectedItem();
        String precioFabrica   = tfPrecioFabrica.getText();
        String precioPublico   = tfPrecioPublico.getText();
        String descripcion   = (String)comboDescripcion.getSelectedItem();
        
		if (descripcion.equals("Producto")){
			
			if(clave.isEmpty()|| nombreP.isEmpty()||marca.isEmpty()||unidad.isEmpty()||precioFabrica.isEmpty()||precioPublico.isEmpty())
		            datos = "VACIO";
		        else
		        {
		            try
		            {
		                int precioF = Integer.parseInt(precioFabrica);
		                int precioP = Integer.parseInt(precioPublico);
		                datos = clave+"_"+nombreP+"_"+marca+"_"+unidad+"_"+tipo+"_"+precioF+"_"+precioP+"_"+descripcion;
		            }
		            catch(NumberFormatException nfe)
		            {
		                datos = "NO_NUMERICO";
		            }
		        }
		        
		        return datos;		
			
		}
		else{
			if(clave.isEmpty()|| nombreP.isEmpty()||precioPublico.isEmpty())
		            datos = "VACIO";
	        else
	        {
	            try
	            {
	                int precioP = Integer.parseInt(precioPublico);
	                datos = clave+"_"+nombreP+"_"+precioP+"_"+descripcion;
	            }
	            catch(NumberFormatException nfe)
	            {
	                datos = "NO_NUMERICO";
	            }
	        }
	        
	        return datos;	
			
		}

    }
    public void cleanTextF(){
    	tfClave.setText("");
		tfNombreProducto.setText("");
        tfMarca.setText("");
        tfUnidad.setText("");
        tfPrecioFabrica.setText("");
        tfPrecioPublico.setText("");
    	
    	
    }
	
	public void actionPerformed(ActionEvent e){
		
		String datos="",resultado="";
		String descripcion   = (String)comboDescripcion.getSelectedItem();
		
		if(descripcion.equals("Producto")&(e.getSource() == bAgregar)){
			
			datos=obtenerInf();
			if (datos.equals("VACIO")){
				resultado="Campos VACIO";
			}
			else{
				resultado= refaccionaria.capturarProducto(datos);
			}
      
			JOptionPane.showMessageDialog(null, resultado);
			cleanTextF();
			
		}
		
		else if(descripcion.equals("Servicio")&(e.getSource() == bAgregar)){
			
			datos=obtenerInf();
			if (datos.equals("VACIO")){
				resultado="Campos VACIO";
			}
			else{
				resultado= refaccionaria.capturarServicio(datos);
			}
			JOptionPane.showMessageDialog(null, "Servicio Registrado");
			cleanTextF();
        	
        }
        if(e.getSource() == bMenuP){
			
			panel.setVisible(false);
			
		}
			
			
	}
	
	public static void main(String args[])
    {
        new AgregarProductoGUI();
    }
	
	
}

