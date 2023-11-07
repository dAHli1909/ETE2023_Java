package ETE2023_Java;

/**:
*@Programa: PrCafe.java
*Autor:    Baca López Daniel Salvador 
*Fecha:    06/11/2023
*Descripcion: Cafetería 
*
***/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class PrCafe extends JFrame implements ActionListener{
	private JLabel etiqueta; 
	private JTextField campo;
	private JButton boton; 

	
    
    
	private void crearGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container ventana = getContentPane();
        ventana.setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,350);
        
        
    	
    	setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
    	Object origen= event.getSource(); //permite trabajar con más de un botón
    	
        //Graphics papel = panel.getGraphics();
    	
		
	}
	
    public static void main(String[] args) {
        PrCafe demo = new PrCafe ();
        demo.crearGUI();
        demo.setTitle("Acomodar controles y panels");
        demo.setVisible(true);
        SwingUtilities.invokeLater(() -> new CapasVentana());
    }

}
