import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Juego extends JFrame implements ActionListener{
	Color blanco = new Color (0xFFFFFF);
	//quizás se agreguen arreglos de paneles para mejorar el funcionamiento 
	JPanel panelA = crearPanel(new Color(0xFFAABB),1,1,120,768,0);
	private JPanel crearPanel(Color color, int x, int y, int width, int height, int modificador) {
		JPanel panel = new JPanel();
        if(modificador==1){
			panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}
        panel.setBackground(color);
        panel.setBounds(x, y, width, height);
        
        
        return panel;
    }
	private void cambioCoordenadas(JPanel panel,int x, int y){
		panel.setLocation(x, y);
		revalidate();
		repaint();
	}
	private void crearGUI(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container ventana = getContentPane();
		ventana.setLayout(null);
		ventana.setSize(1400,768);
		ventana.add(panelA);
        
	    Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
            public void eventDispatched(AWTEvent event) {
                // Como se usa la máscara AWTEvent.KEY_EVENT_MASK nunca va a fallar 
                KeyEvent keyEvent = (KeyEvent) event;

                // es true cuando se ha soltado la tecla
                if (keyEvent.getID() == KeyEvent.KEY_RELEASED) {
                    // Aquí pones tu lógica
                    System.out.println("F10 " + (keyEvent.getKeyCode() == KeyEvent.VK_F10));
                    for(int i = 1;i <=85; i++){
            			cambioCoordenadas(panelA,i+50,1);
            			try {
            				Thread.sleep(5);
            			} catch (InterruptedException e1) {
            				// TODO Auto-generated catch block
            				e1.printStackTrace();
            			}
            		}
                }
            }
	    }, AWTEvent.KEY_EVENT_MASK);// Esto indica que se escucharan solo los eventos de teclado
		
	}
    
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
	}
	
	public static void main(String[] args) {
        Juego marco = new Juego ();
        marco.crearGUI();
        marco.setTitle("Cafetería");
		marco.setSize(1400,768);
        marco.setVisible(true);
        

        
    }
}