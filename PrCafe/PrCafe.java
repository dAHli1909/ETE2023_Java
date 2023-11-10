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

	//rivate ImageIcon imgAme, imgExp, imgCap, imgMok;
	Color café1 = new Color (0xCCAF7A);
	Color café2 = new Color (0x99793D);
	Color café3 = new Color (0x664914);
	Color café4 = new Color (0x382400);

	

	
	
	JPanel panelT = crearPanel(café4,0,0,1500,102,0);
	JPanel panelST = crearPanel(café3, 0, 102, 1500, 100, 0);
	JPanel panelP = crearPanel(café1, 0, 201, 751, 700, 0);
	JPanel panelC = crearPanel(café2, 751, 201, 752, 700, 0);
	

	private JPanel crearPanel(Color color, int x, int y, int width, int height, int g) {
		JPanel panel = new JPanel(new FlowLayout());
        if(g==1){
			panel = new JPanel(new GridLayout(4,4));
		}
        panel.setBackground(color);
        panel.setBounds(x, y, width, height);
        return panel;
    }
	private void crearGUI(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container ventana = getContentPane();
        ventana.setLayout(null);
		ventana.setSize(1500,900);
		
		
		ventana.add(panelT);
		ventana.add(panelST);
		ventana.add(panelP);
		ventana.add(panelC);
		
		//prueba con botones
		JButton b1; 
		panelP.add(new JButton("Button 1"));
		
        panelP.add(new JButton("Button 2"));
        panelP.add(new JButton("Button 3"));
        panelP.add(new JButton("Button 4"));
		ImageIcon imgAme = new ImageIcon("/home/daniel/Documents/Pr/ETE2023_Java/PrCafe/imgAme.jpg");
	Image AmeImage = imgAme.getImage();
	JLabel AmeImageLabel = new JLabel();
	AmeImageLabel.setIcon(imgAme);
		
		
	}
	public void actionPerformed(ActionEvent event) {

    	Object origen = event.getSource(); //permite trabajar con más de un botón
		//imgAme.paintIcon(this,panelP.getGraphics(), 100, 100);
		panelT.getGraphics().fillRect(5,5,790,490);
		//panelP.getGraphics().drawString();
	}
	
    public static void main(String[] args) {
        PrCafe marco = new PrCafe ();
        marco.crearGUI();
        marco.setTitle("Cafetería");
		marco.setSize(1500,900);
        marco.setVisible(true);
        
    }

}
