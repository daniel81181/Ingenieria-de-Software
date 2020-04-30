import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.StringTokenizer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarCatalogoGUI extends JFrame implements ActionListener
{
	private JTextField tfClave, tfNombreProducto, tfMarca;
	private JButton    bConsultarProductosGeneral, bConsultarServiciosGeneral,bConsultarTipoProducto, bConsultarClaveProducto,bConsultarClaveServicio,bConsultarMarca, bConsultarNombreProducto, bConsultarNombreServicio, bMenuPrincipal;
	private JPanel     panel, panel1, panel2, panel3;
	private JTextArea  taDatos;

	private JComboBox comboDescripcion;
	private String descripcion[] = {"Producto","Servicio"};

	private JComboBox comboTipo;
	private String tipo[] = {"Accesorios","Caja de Velocidades","Colision","Frenos","Herramientas","Interior","Motor","Quimicos","Ruedas","S. Electrico","Suspension"};

	private RefaccionariaAD refaccionaria = new RefaccionariaAD();

	public ConsultarCatalogoGUI()
	{
		super("Refaccionaria Santa Cruz");

		//Crear objetos de los Atributos
		tfClave  	        = new JTextField(20);
		tfNombreProducto    = new JTextField();
        tfMarca             = new JTextField();
        bConsultarProductosGeneral   = new JButton("Consultar Catalogo Productos");
        bConsultarServiciosGeneral   = new JButton("Consultar Catalogo Servicios");
        bConsultarTipoProducto	 = new JButton("Consultar Tipo Producto");
        bConsultarClaveProducto		= new JButton("Consultar Clave Poducto");
        bConsultarClaveServicio		= new JButton("Consultar Clave Servicio");
        bConsultarMarca		= new JButton("Consultar Marca Producto");
        bConsultarNombreProducto = new JButton("Consultar Nombre Producto");
        bConsultarNombreServicio = new JButton("Consultar Nombre Servicio");
        bMenuPrincipal     = new JButton("Menu Pricipal");

        taDatos     = new JTextArea(10,60);
        panel		= new JPanel();
        panel1      = new JPanel();
        panel2      = new JPanel();
        panel3      = new JPanel();

        //Adicionar addActionListener a los JButtons
        bConsultarProductosGeneral.addActionListener(this);
        bConsultarServiciosGeneral.addActionListener(this);
        bConsultarTipoProducto.addActionListener(this);
        bConsultarClaveProducto.addActionListener(this);
        bConsultarClaveServicio.addActionListener(this);
        bConsultarMarca.addActionListener(this);
        bConsultarNombreProducto.addActionListener(this);
        bConsultarNombreServicio.addActionListener(this);
        bMenuPrincipal.addActionListener(this);

        comboDescripcion = new JComboBox(descripcion);
        comboTipo = new JComboBox(tipo);

        panel1.setLayout(new GridLayout(5,2));
        panel2.setLayout(new GridLayout(1,3));//servicio
        panel3.setLayout(new GridLayout(3,2));
        panel.setLayout(new FlowLayout());

        panel1.add(new JLabel("CONSULTA DE CATALOGO"));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel("Clave: "));
        panel1.add(tfClave);
		panel1.add(new JLabel("Nombre del Producto: "));
        panel1.add(tfNombreProducto);
        panel1.add(new JLabel("Marca: "));
        panel1.add(tfMarca);
        panel1.add(new JLabel("Tipo: "));
        panel1.add(comboTipo);

        panel2.add(bConsultarServiciosGeneral);
        panel2.add(bConsultarClaveServicio);
        panel2.add(bConsultarNombreServicio);

        panel3.add(bConsultarProductosGeneral);
        panel3.add(bConsultarTipoProducto);
        panel3.add(bConsultarClaveProducto);
        panel3.add(bConsultarMarca);
        panel3.add(bConsultarNombreProducto);

        panel3.add(bMenuPrincipal);

        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);

        panel.add(new JScrollPane(taDatos));

        add(panel);
        setSize(800,430);
        //setVisible(true);

	}

	public JPanel getPanel()
	{
        return this.panel;
    }


	public void actionPerformed(ActionEvent e)
	{
        String datos, resultado;


        if(e.getSource() == bConsultarProductosGeneral)
        {
        	datos = refaccionaria.consultarCatalogoProductos();

            taDatos.setText(datos);
        }
        if(e.getSource() == bConsultarServiciosGeneral)
        {
        	datos = refaccionaria.consultarCatalogoServicios();

            taDatos.setText(datos);
        }
        if(e.getSource() == bConsultarTipoProducto)
        {
        	String type   = (String)comboTipo.getSelectedItem();
        	datos=refaccionaria.consultarTipoProducto(type);
        	taDatos.setText(datos);
        }
        if(e.getSource() == bConsultarClaveProducto)
        {
        	String cla = tfClave.getText();
        	datos=refaccionaria.consultarClaveProducto(cla);
        	taDatos.setText(datos);
        }
        if(e.getSource() == bConsultarClaveServicio)
        {
        	String clas = tfClave.getText();
        	datos=refaccionaria.consultarClaveServicio(clas);
        	taDatos.setText(datos);
        }
        if(e.getSource() == bConsultarMarca)
        {
        	String marc = tfMarca.getText();
        	datos=refaccionaria.consultarMarca(marc);
        	taDatos.setText(datos);
        }
        if(e.getSource() == bConsultarNombreProducto)
        {
            String namep = tfNombreProducto.getText();
            datos=refaccionaria.consultarNombreProducto(namep);
            taDatos.setText(datos);
        }
        if(e.getSource() == bConsultarNombreServicio)
        {
        	String namep = tfNombreProducto.getText();
            datos=refaccionaria.consultarNombreServicio(namep);
            taDatos.setText(datos);
        }




    }

    public static void main(String args[])
    {
        new ConsultarCatalogoGUI();
    }


}
