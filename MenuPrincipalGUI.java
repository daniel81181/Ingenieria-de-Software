import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.StringTokenizer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipalGUI extends JFrame implements ActionListener{

	private JPanel    panel, panel1, panel2, panel3;
    private JButton   bConsultar, bAgregar, bVenta, bCotizacion, bAgregarEmpleado,bModificar;

    private AgregarProductoGUI agregar = new AgregarProductoGUI();
    private ConsultarCatalogoGUI consultas = new ConsultarCatalogoGUI();

    public MenuPrincipalGUI(){

    	super("Refaccionaria");

        bConsultar	=new JButton("Consultar Catalogo");
        bAgregar =new JButton("Agregar Producto/Servicio");
        bVenta		=new JButton("Realizar Venta");
        bCotizacion		=new JButton("Cotizaciones");
        bAgregarEmpleado	=new JButton("Agregar Empleado");
        bModificar =new JButton("Modificar Catalogo");


        panel1 = new JPanel();
        panel2 = new JPanel();
        panel  = new JPanel();

        bConsultar.addActionListener(this);
        bAgregar.addActionListener(this);
        bVenta.addActionListener(this);
        bCotizacion.addActionListener(this);
        bAgregarEmpleado.addActionListener(this);
        bModificar.addActionListener(this);

        panel1.setLayout(new GridLayout(1,1));
        panel2.setLayout(new GridLayout(3,2));
        panel.setLayout(new FlowLayout());

        panel1.add(new JLabel("*Refaccionaria*"));

        panel2.add(bConsultar);
        panel2.add(bAgregar);
        panel2.add(bVenta);
        panel2.add(bCotizacion);
        panel2.add(bAgregarEmpleado);
        panel2.add(bModificar);

		panel.add(panel1);
		panel.add(panel2);
		add(panel);
        setSize(450,550);
      //  setVisible(true);

    }
public JPanel getPanel(){
	return this.panel;
}
    public void actionPerformed(ActionEvent e){

    	if(e.getSource() == bAgregar){

    		panel.setVisible(false);
            panel = agregar.getPanel();
            panel.setVisible(true);
            add(panel);
            setVisible(true);
    	}

    	if(e.getSource() == bConsultar){

    		panel.setVisible(false);
            panel = consultas.getPanel();
            panel.setVisible(true);
            add(panel);
            setVisible(true);
    	}
    }

   	public static void main(String args[]){
        new MenuPrincipalGUI();
    }

}
