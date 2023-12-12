
/* 
*@Programa: PrCafe.java
*Autor:    Baca López Daniel Salvador 
*Fecha:    06/11/20,""23
*Descripcion: Cafetería 
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// import java.util.concurrent.*;
// import java.util.*;

public class MaqExp extends JFrame implements ActionListener{

    Color café1 = new Color (0x855F1B);
	Color café2 = new Color (0x99793D);
	Color café3 = new Color (0x664914);
	Color café4 = new Color (0x382400);
	Color negro = new Color (0x000000);

    JPanel panelVidrio = crearPanel(café2, 100, 50, 700,750, 0);
    JPanel panelOpciones = crearPanel(café3, 800, 50, 150,750, 0);
    JPanel panelSalida = crearPanel(café1,100,550,700,150,0);

    JButton B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,Moneda1,Moneda2,Moneda5,Moneda10,Moneda20,pagar,borrar;

    int contador = 0;
	int PrecioI = 100, Pago = 0;
    String producto = "";

    JLabel muestraPrecio = new JLabel("Precio: " );
    JLabel muestraProducto= new JLabel("Producto: " + producto);
	JLabel muestraPago= new JLabel("Pago: " +  String.valueOf(Pago));	
    JLabel[] denomina = new JLabel[5]; 

    

    private JPanel crearPanel(Color color, int x, int y, int width, int height, int modificador) {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        if(modificador==1){
			panel = new JPanel(new GridLayout(9,1));
		}
        panel.setBackground(color);
        panel.setBounds(x, y, width, height);
        return panel;
    }
    private JPanel crearSubPanel(String archivo, int w, int h, int wi, int hi, JPanel panelM){
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20,12));
		ImageIcon imgAme = new ImageIcon(new ImageIcon("./MaqExp/img/"+archivo).getImage().getScaledInstance(wi,hi, Image.SCALE_DEFAULT));
		JLabel AmeImageLabel = new JLabel();
		AmeImageLabel.setIcon(imgAme);
		panel.add(AmeImageLabel);
		panel.setBackground(null);
		panel.setPreferredSize(new Dimension(w,h));
        panelM.add(panel);
		return panel;
	}
    private JButton crearBoton(String texto, JPanel panel, int w, int h,String archivo){
        JButton boton = new JButton(texto); 
		boton.setPreferredSize(new Dimension(w,h));
		
        ImageIcon img = new ImageIcon(new ImageIcon("./MaqExp/img/"+archivo).getImage().getScaledInstance(w,h, Image.SCALE_DEFAULT));
        if(archivo!=""){
            boton.setIcon(img);
        }
        boton.addActionListener((this));
        panel.add(boton);
        return boton;
    }
    
    public static boolean isNumeric(String str)
	{
		try{
			double d= Double.parseDouble(str);
			if (d<=0){
				JOptionPane.showMessageDialog(null,"Pago inválido");
				return false;
			}else if(d>30){
                JOptionPane.showMessageDialog(null,"No puedes depositar más de $30");
            }

		}
		catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(null,  "Introduzca un valor válido");
			return false;
		}
		return true;
	}
    private void crearGUI(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container ventana = getContentPane();
        ventana.setLayout(null);
        ventana.setBackground(café4);

        ventana.add(panelSalida);
        ventana.add(panelVidrio);
        ventana.add(panelOpciones);

        panelOpciones.add(muestraPrecio);
        panelOpciones.add(muestraPago);
        panelSalida.add(muestraProducto);


        JPanel P1 = crearSubPanel("Agua.jpg", 150,150,100,100,panelVidrio);
        B1 = crearBoton("Agua $15",P1,120,20,"");
        
        JPanel P2 = crearSubPanel("Chips.jpg", 150,150,100,100,panelVidrio);
        B2 = crearBoton("Chips $18",P2,120,20,"");

        JPanel P3 = crearSubPanel("Choco.jpg", 150,150,100,100,panelVidrio);
        B3 = crearBoton("Choco $25",P3,120,20,"");

        JPanel P4 = crearSubPanel("Chokis.png", 150,150,100,100,panelVidrio);
        B4 = crearBoton("Chokis $12",P4,120,20,"");

        JPanel P5 = crearSubPanel("Cola.png", 150,150,100,100,panelVidrio);
        B5 = crearBoton("Cola $13",P5,120,20,"");

        JPanel P6 = crearSubPanel("Doritos.jpg", 150,150,100,100,panelVidrio);
        B6 = crearBoton("Doritos $18",P6,120,20,"");

        JPanel P7 = crearSubPanel("Gran.jpg", 150,150,100,100,panelVidrio);
        B7 = crearBoton("Barra $12",P7,120,20,"");

        JPanel P8 = crearSubPanel("JugNar.jpg", 150,150,100,100,panelVidrio);
        B8 = crearBoton("Jugo $19",P8,120,20,"");

        JPanel P9 = crearSubPanel("Man.jpg", 150,150,100,100,panelVidrio);
        B9 = crearBoton("Fruta$10",P9,120,20,"");

        JPanel P10 = crearSubPanel("sanswich.jpg", 150,150,100,100,panelVidrio);
        B10 = crearBoton("Sándwich $25",P10,130,20,"");

        Moneda1 = crearBoton("",panelOpciones,50,50,"1.png");
        Moneda2 = crearBoton("",panelOpciones,50,50,"2.png");
        Moneda5 = crearBoton("",panelOpciones,50,50,"5.png");
        Moneda10 = crearBoton("",panelOpciones,50,50,"10.png");
        Moneda20 = crearBoton("",panelOpciones,50,50,"20.jpg");
        borrar = crearBoton("Reiniciar",panelOpciones,100,50,"");
        for(JLabel denominas : denomina){
            panelOpciones.add(denominas);
        }
    }
    public MaqExp() {
        for (int i = 0; i < 5; i++) {
            denomina[i] = new JLabel();
            denomina[i].setVisible(false);
        }
    }
    @Override
	public void actionPerformed(ActionEvent e) {
        Object origen = e.getSource(); 
        if(denomina[0]!=null){
            for(int i = 0; i < 5; i++){
                denomina[i].setVisible(false);
            }
        }
        
        if(origen==borrar){
            producto="";
            PrecioI=100;
            Pago=0;
            // for(JLabel denominas : denomina){
            //     denominas = new JLabel("");
            // }
        }
        if(PrecioI > Pago){
            if(origen==B1){
                PrecioI=15;
                producto="Agua";
            }else if(origen==B2){
                PrecioI=18;
                producto="Chips";
            }else if(origen==B3){
                PrecioI=25;
                producto="Chocolate";
            }else if(origen==B4){
                PrecioI=12;
                producto="Chokis";
            }else if(origen==B5){
                PrecioI=13;
                producto="Cola";
            }else if(origen==B6){
                PrecioI=18;
                producto="Doritos";
            }else if(origen==B7){
                PrecioI=12;
                producto="Barra";
            }else if(origen==B8){
                PrecioI=19;
                producto="Jugo";
            }else if(origen==B9){
                PrecioI=10;
                producto="Manzana";
            }else if(origen==B10){
                PrecioI=25;
                producto="Sándwich";
            }

            if(origen==Moneda1){
                Pago+=1;
            }else if(origen==Moneda2){
                Pago+=2;
            }else if(origen==Moneda5){
                Pago+=5;
            }else if(origen==Moneda10){
                Pago+=10;
            }else if(origen==Moneda20){
                Pago+=20;
            }
        }if(PrecioI < Pago){
            float cambio = Pago-PrecioI;
            int[] monedas = {0,0,0,0,0};
            while(cambio!=0){
                if(cambio>=20){
                    cambio = Cambio(monedas, 0, 20, cambio);
                }else if(cambio>=10){
                    cambio = Cambio(monedas, 1, 10, cambio);
                }else if(cambio>=5){
                    cambio = Cambio(monedas, 2, 5, cambio);
                }else if(cambio>=2){
                    cambio = Cambio(monedas, 3, 2, cambio);
                }else if(cambio>=1){
                    cambio = Cambio(monedas, 4, 1, cambio);
                }
            }
            
            
            denomina[0].setText("monedas de 20: " + String.valueOf(monedas[0]));
            denomina[1].setText("monedas de 10: " + String.valueOf(monedas[1]));
            denomina[2].setText("monedas de 5: " + String.valueOf(monedas[2]));
            denomina[3].setText("monedas de 2: " + String.valueOf(monedas[3]));
            denomina[4].setText("monedas de 1: " + String.valueOf(monedas[4]));
            for(JLabel denominas : denomina){
                denominas.setVisible(true);
            }
            

                //JOptionPane.showMessageDialog(null,  "Reiniciando");
            
            
        }
        
        if(PrecioI<30){
            muestraPrecio.setText("Precio:" + String.valueOf(PrecioI));
        }else{
            muestraPrecio.setText("Precio:");
        }
        muestraProducto.setText("Producto: " + producto);
        muestraPago.setText("Pago: " +  String.valueOf(Pago));
        revalidate();
        repaint();
        
    }
    static float Cambio(int[] arrayP, int i, int n, float P){
		arrayP[i] = (int) Math.floor(P / n);
		P-=arrayP[i]*n;
		return P;
	}
    public static void main(String[] args) {
        MaqExp marco = new MaqExp ();
        marco.crearGUI();
        marco.setTitle("Máquina expendedora");
		marco.setSize(1050,900);
        marco.setVisible(true);
    } 
}
