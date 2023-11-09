package ETE2023_Java.PrCafe;
/* 
*@Programa: PrCafe.java
*Autor:    Baca López Daniel Salvador 
*Fecha:    06/11/2023
*Descripcion: Cafetería 
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PrCafe extends JFrame implements ActionListener{

	

	

	private JPanel crearPanel(Color color, int x, int y, int width, int height) {
        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.setBounds(x, y, width, height);
        return panel;
    }
	private void crearGUI(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container ventana = getContentPane();
        ventana.setLayout(null);

		Color café1 = new Color (0xCCAF7A);
		Color café2 = new Color (0x99793D);
		Color café3 = new Color (0x664914);
		Color café4 = new Color (0x382400);
		JPanel panelT = crearPanel(café4,0,0,1500,102);
		JPanel panelST = crearPanel(café3, 0, 102, 1500, 100);
		JPanel panelP = crearPanel(café1, 0, 201, 751, 700);
		JPanel panelC = crearPanel(café2, 751, 201, 752, 700);
		ventana.add(panelT);
		ventana.add(panelST);
		ventana.add(panelP);
		ventana.add(panelC);
	}
	public void actionPerformed(ActionEvent event) {

    	Object origen = event.getSource(); //permite trabajar con más de un botón
	}
	
    public static void main(String[] args) {
        PrCafe marco = new PrCafe ();
        marco.crearGUI();
        marco.setTitle("Cafetería");
		marco.setSize(1500,900);
        marco.setVisible(true);
        
    }

}
