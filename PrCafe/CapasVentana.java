package ETE2023_Java;

import java.awt.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class CapasVentana {
    	JLayeredPane layeredPane = new JLayeredPane();
	    getContentPane().add(layeredPane);
	    
		JPanel panelA = crearPanel(Color.BLUE, 50, 50, 50, 50);
		JPanel panelB = crearPanel(Color.RED, 200, 200, 50, 50);
		
		layeredPane.add(panelA, JLayeredPane.DEFAULT_LAYER);
		layeredPane.add(panelB, JLayeredPane.DEFAULT_LAYER);


    private JPanel crearPanel(Color color, int x, int y, int width, int height) {
        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.setBounds(x, y, width, height);
        return panel;
    }
}
