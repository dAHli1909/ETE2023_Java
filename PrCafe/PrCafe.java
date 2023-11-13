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
	Color café1 = new Color (0x855F1B);
	Color café2 = new Color (0x99793D);
	Color café3 = new Color (0x664914);
	Color café4 = new Color (0x382400);
	Color negro = new Color (0x000000);

	JPanel panelT = crearPanel(café4,0,0,1380,80,0);
	JPanel panelST1 = crearPanel(café3, 0, 80, 690, 50, 0);
	JPanel panelST2 = crearPanel(café3, 690, 80, 690, 50, 0);
	JPanel panelP = crearPanel(café1, 0, 130, 690, 750, 0);
	JPanel panelC = crearPanel(café2, 690, 130, 690, 400, 0);
	JPanel panelCS = crearPanel(café3, 690,530, 690, 165, 0);

	private JButton botonAme, botonExp, botonCap, botonMok, botonLat, botonSan, botonDon, botonPan, botonHel;
	JButton botonAdelante = new JButton("Adelante");
	JButton botonAtras = new JButton("Atrás");
	JButton botonSelect = new JButton("Seleccionar");
	private ButtonGroup bgOpcionesLeche, bgOpcionesExtra;
    private JRadioButton LecheSin, LecheEntera, LecheLight, LecheDeslactosada;

	private JPanel crearPanel(Color color, int x, int y, int width, int height, int modificador) {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        if(modificador==1){
			panel = new JPanel(new GridLayout(1,2));
		}
        panel.setBackground(color);
        panel.setBounds(x, y, width, height);
        return panel;
    }
	private JPanel crearSubPanel(String archivo){
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20,12));
		ImageIcon imgAme = new ImageIcon(new ImageIcon("./img/"+archivo).getImage().getScaledInstance(170, 120, Image.SCALE_DEFAULT));
		JLabel AmeImageLabel = new JLabel();
		AmeImageLabel.setIcon(imgAme);
		panel.add(AmeImageLabel);
		panel.setBackground(null);
		panel.setPreferredSize(new Dimension(200,180));
		return panel;
	}
	private void crearGUI(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container ventana = getContentPane();
        ventana.setLayout(null);
		ventana.setSize(1500,900);
		
		ventana.add(panelT);
		ventana.add(panelST1);
		ventana.add(panelST2);
		ventana.add(panelP);
		ventana.add(panelC);
		ventana.add(panelCS);
		
		JLabel lblTitulo = new JLabel("Cafetería jiji");
		panelT.add(lblTitulo);
		JLabel lblProductos = new JLabel("Productos");
		JLabel lblCompras = new JLabel("Compras");
		panelST1.add(lblProductos);
		panelST2.add(lblCompras);
		
		botonAme = new JButton("Americano"); 
		botonAme.setPreferredSize(new Dimension(150,20));
		JPanel panelPSubAme = crearSubPanel("imgAme.jpg");
		panelPSubAme.add(botonAme);
		panelP.add(panelPSubAme);
		botonAme.addActionListener(this);
		botonExp = new JButton("Exprés"); 
		botonExp.setPreferredSize(new Dimension(150,20));
		JPanel panelPSubExp = crearSubPanel("imgExp.jpg");
		panelPSubExp.add(botonExp);
		panelP.add(panelPSubExp);
		botonExp.addActionListener(this);
		botonCap = new JButton("Capuchino"); 
		botonCap.setPreferredSize(new Dimension(150,20));
		JPanel panelPSubCap = crearSubPanel("imgCap.jpg");
		panelPSubCap.add(botonCap);
		panelP.add(panelPSubCap);
		botonCap.addActionListener(this);
		botonMok = new JButton("Moka"); 
		botonMok.setPreferredSize(new Dimension(150,20));
		JPanel panelPSubMok = crearSubPanel("imgMok.jpg");
		panelPSubMok.add(botonMok);
		panelP.add(panelPSubMok);
		botonMok.addActionListener(this);
		botonLat = new JButton("Latte"); 
		botonLat.setPreferredSize(new Dimension(150,20));
		JPanel panelPSubLat = crearSubPanel("imgLat.jpg");
		panelPSubLat.add(botonLat);
		panelP.add(panelPSubLat);
		botonLat.addActionListener(this);

		botonSan = new JButton("Sándwich"); 
		botonSan.setPreferredSize(new Dimension(150,20));
		JPanel panelPSubSan = crearSubPanel("imgSan.jpg");
		panelPSubSan.add(botonSan);
		panelP.add(panelPSubSan);
		botonSan.addActionListener(this);
		botonPan = new JButton("Panqué"); 
		botonPan.setPreferredSize(new Dimension(150,20));
		JPanel panelPSubPan = crearSubPanel("imgPan.jpg");
		panelPSubPan.add(botonPan);
		panelP.add(panelPSubPan);
		botonPan.addActionListener(this);
		botonDon = new JButton("Dona"); 
		botonDon.setPreferredSize(new Dimension(150,20));
		JPanel panelPSubDon = crearSubPanel("imgDon.jpg");
		panelPSubDon.add(botonDon);
		panelP.add(panelPSubDon);
		botonDon.addActionListener(this);
		botonHel = new JButton("Helado"); 
		botonHel.setPreferredSize(new Dimension(150,20));
		JPanel panelPSubHel = crearSubPanel("imgHel.jpg");
		panelPSubHel.add(botonHel);
		panelP.add(panelPSubHel);
		botonHel.addActionListener(this);

		JPanel opcionesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20,12));
		opcionesPanel.setBackground(null);
		opcionesPanel.setPreferredSize(new Dimension(120,180));
		panelCS.add(opcionesPanel);
		JLabel lblopciones = new JLabel("Opciones");
		opcionesPanel.add(lblopciones);
		opcionesPanel.add(botonAdelante);
		opcionesPanel.add(botonAtras);
		opcionesPanel.add(botonSelect);

		
	}
	@Override
	public void actionPerformed(ActionEvent event) {

    	Object origen = event.getSource(); 
		String compra; 
		int identificador_inicial = 0;
		 
		if(origen == botonAme){
			identificador_inicial=10;
		}else if(origen == botonExp){
			identificador_inicial=20;
		}else if(origen == botonCap){
			identificador_inicial=30;
		}else if(origen == botonMok){
			identificador_inicial=40;
		}else if(origen == botonLat){
			identificador_inicial=50;
		}else if(origen == botonSan){
			identificador_inicial=01;
		}else if(origen == botonPan){
			identificador_inicial=02;
		}else if(origen == botonDon){
			identificador_inicial=03;
		}else if(origen == botonHel){
			identificador_inicial=04;
		}

		if(identificador_inicial>20){
			bgOpcionesLeche=new ButtonGroup();
			radio1=new JRadioButton("Sumar");
			radio1.setBounds(10,110,100,30);
			bg.add(radio1); 
		}
				


		
	}
	
    public static void main(String[] args) {
        PrCafe marco = new PrCafe ();
        marco.crearGUI();
        marco.setTitle("Cafetería");
		marco.setSize(1500,900);
        marco.setVisible(true);
        
    }

}
