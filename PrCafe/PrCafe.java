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
import java.util.concurrent.*;
import java.util.*;

public class PrCafe extends JFrame implements ActionListener{

	//colores
	Color café1 = new Color (0x855F1B);
	Color café2 = new Color (0x99793D);
	Color café3 = new Color (0x664914);
	Color café4 = new Color (0x382400);
	Color negro = new Color (0x000000);

	//paneles
	JPanel panelT = crearPanel(café4,0,0,1380,80,0);
	JPanel panelST1 = crearPanel(café3, 0, 80, 690, 50, 0);
	JPanel panelST2 = crearPanel(café3, 690, 80, 690, 50, 0);
	JPanel panelP = crearPanel(café1, 0, 130, 690, 750, 0);
	JPanel panelC = crearPanel(café2, 690, 130, 690, 400, 0);
	JPanel panelCS = crearPanel(café3, 690,530, 690, 165, 0);
	JPanel opcionesPanel1, opcionesPanel2, opcionesPanel3, opcionesPanel4;

	//interfaz gráfica; 
	private JButton botonAme, botonExp, botonCap, botonMok, botonLat, botonSan, botonDon, botonPan, botonHel, pagar;
	JButton botonAdelante = new JButton("Adelante");
	JButton botonAtras = new JButton("Atrás");
	JButton botonSelect = new JButton("Borrar");
	private ButtonGroup bgOpcionesLeche, bgOpcionesExtra;
    private JRadioButton LecheEntera, LecheLight, LecheDeslactosada, CremaBatida, ChispasChocolate, CremaChispas, Ninguna;
	JTextField pago;

	//variables posteriormente acumulativas;
	int contador = 0;
	String[] compraLista = new String[2]; 
	String[] compraFrag;
	

	private JPanel crearPanel(Color color, int x, int y, int width, int height, int modificador) {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        if(modificador==1){
			panel = new JPanel(new GridLayout(2,3));
		}
        panel.setBackground(color);
        panel.setBounds(x, y, width, height);
        return panel;
    }
	private JPanel crearSubPanel(String archivo){
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20,12));
		ImageIcon imgAme = new ImageIcon(new ImageIcon("./PrCafe/img/"+archivo).getImage().getScaledInstance(170, 120, Image.SCALE_DEFAULT));
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

		opcionesPanel1 = crearSubPanel("");
		panelCS.add(opcionesPanel1);
		JLabel lblopciones = new JLabel("Opciones:");
		opcionesPanel1.add(lblopciones);
		opcionesPanel1.add(botonAdelante);
		opcionesPanel1.add(botonAtras);
		opcionesPanel1.add(botonSelect);
		botonAdelante.addActionListener((this));
		botonSelect.addActionListener((this));
		botonAtras.addActionListener((this));

		opcionesPanel2 = crearSubPanel("");
		panelCS.add(opcionesPanel2);
		JLabel lblLeche = new JLabel("Leche:");
		opcionesPanel2.add(lblLeche);
		bgOpcionesLeche = new ButtonGroup();
		LecheEntera = new JRadioButton("Leche entera");
		LecheLight = new JRadioButton("Leche light"); 
		LecheDeslactosada = new JRadioButton("Leche deslactosada");
		bgOpcionesLeche.add(LecheEntera); 
		bgOpcionesLeche.add(LecheLight); 
		bgOpcionesLeche.add(LecheDeslactosada); 
		opcionesPanel2.add(LecheEntera);
		opcionesPanel2.add(LecheLight);
		opcionesPanel2.add(LecheDeslactosada);
		LecheEntera.addActionListener(this);
		LecheDeslactosada.addActionListener(this);
		LecheLight.addActionListener(this);

		opcionesPanel3 = crearSubPanel("");
		panelCS.add(opcionesPanel3);
		JLabel lblExtras = new JLabel("Extras");
		opcionesPanel3.add(lblExtras);
		bgOpcionesExtra = new ButtonGroup();
		CremaBatida = new JRadioButton("Crema batida");
		ChispasChocolate = new JRadioButton("Chispas de chocolate");
		CremaChispas = new JRadioButton("Ambas");
		Ninguna = new JRadioButton("Ninguna");
		bgOpcionesExtra.add(CremaBatida);
		bgOpcionesExtra.add(ChispasChocolate);
		bgOpcionesExtra.add(CremaChispas);
		bgOpcionesExtra.add(Ninguna);
		opcionesPanel3.add(CremaBatida);
		opcionesPanel3.add(ChispasChocolate);
		opcionesPanel3.add(CremaChispas);
		opcionesPanel3.add(Ninguna);
		Ninguna.setSelected(true);
		CremaBatida.addActionListener(this);
		ChispasChocolate.addActionListener(this);
		CremaChispas.addActionListener(this);
		Ninguna.addActionListener(this);

		opcionesPanel2.setVisible(false);
		opcionesPanel3.setVisible(false);
		
		opcionesPanel4 = crearSubPanel("");
		panelCS.add(opcionesPanel4);
		JLabel lblpago = new JLabel("PAGO");
		pago = new JTextField();
		pago.setPreferredSize(new Dimension(80,20));
		pagar = new JButton("Pagar");
		pagar.setPreferredSize(new Dimension(150,20));
		opcionesPanel4.add(lblpago);
		opcionesPanel4.add(pago);
		opcionesPanel4.add(pagar);
		pagar.addActionListener((this));
		pago.addActionListener((this));
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		Object origen = e.getSource(); 
		String compra = "", identificador_secundario = ""; 
		String[] compraSubFrag = new String[4];
		char A = '0';
		char B = '0';
		int identificador_inicial = 0;
		CountDownLatch latch = new CountDownLatch(1);
		Thread Select;

		class Select implements Runnable {
			private String nombre;
			private CountDownLatch latch;
			public Select(String nombre, CountDownLatch latch) {
				this.nombre = nombre;
				this.latch = latch;
			}
		}


		if(origen!=pagar){
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
				compra = "01";
			}else if(origen == botonPan){
				compra = "02";
			}else if(origen == botonDon){
				compra = "03";
			}else if(origen == botonHel){
				compra = "04";
			}

			if(identificador_inicial>20){
				LecheEntera.setSelected(true);
				opcionesPanel2.setVisible(true);
				opcionesPanel3.setVisible(true);
				// Select = new Thread(new Select("Selección del tipo de leche", latch));
				// Select.start();
				// try{
				// 	latch.await();
				// }catch(InterruptedException IE){
				// 	IE.printStackTrace();
				// }
				// botonSi.addEventListener("click", function() {
				// 	// Coloca aquí el código que quieres que se ejecute cuando se hace clic en el botón "Sí"
				// 	alert("¡Has hecho clic en Sí!");
				// });
				
				
					if(LecheEntera.isSelected()){
					A='1';
					}else if(LecheDeslactosada.isSelected()){
						A='2';
					}else if(LecheLight.isSelected()){
						A='3';
					}else{
						A='0';
					}
					if(CremaBatida.isSelected()){
						B='1';
					}else if(ChispasChocolate.isSelected()){
						B='2';
					}else if(CremaChispas.isSelected()){
						B='3';
					}else if(Ninguna.isSelected()){
						B='0';
					}
				
				
			}
			else{
				opcionesPanel2.setVisible(false);
				opcionesPanel3.setVisible(false);		
			}
			identificador_secundario=""+A+B;
			if(identificador_inicial>0){
				compra = Integer.toString(identificador_inicial);
			}
			compra = compra + identificador_secundario;
			//JOptionPane.showMessageDialog(null,"Unión de compra e identificador secundario: " + compra);
			contador++;
			if(contador==1){
				compraLista[0]=compra;
				//JOptionPane.showMessageDialog(null,"CompraLista1 "+compra);
			}else{
				compraLista[1]=compra;
				compraLista[0]=compraLista[0]+compra;
				compraLista[1]=null;
				//JOptionPane.showMessageDialog(null,"CompraLista2 o más " + compraLista[0]);
			}
		}
		//Validación 
		else if(origen == pagar){
			if(isNumeric(pago.getText())){
				//cálculos
				float Precio = 0;
				float CantidadPago = Float.parseFloat(pago.getText());
				JOptionPane.showMessageDialog(null,"Cantidad a pagar:(float->string)" + String.valueOf(CantidadPago));

				int cantidadFragmentosG = (int) Math.ceil((double) compraLista[0].length() / 4);
				JOptionPane.showMessageDialog(null,"CantidadFragmentosG:" + String.valueOf(cantidadFragmentosG));

				compraFrag=dividirCadena(compraLista[0], 4 );
				JOptionPane.showMessageDialog(null,"comprafrag:" + Arrays.toString(compraFrag));

				for(int i = 1; i <= cantidadFragmentosG; i++){
					compraSubFrag=dividirCadena(compraFrag[i-1],1);
					if(compraSubFrag[0].equals("1")){//americano
						Precio+=35;
					}else if(compraSubFrag[0].equals("2")){//exprés
						Precio+=60;
					}else if(compraSubFrag[0].equals("3")){//capuchino
						Precio+=70;
					}else if(compraSubFrag[0].equals("4")){//moka
						Precio+=90;
					}else if(compraSubFrag[0].equals("5")){//latte
						Precio+=90;
					}
					if(compraSubFrag[1].equals("1")){//sándwich
						Precio+=100;
					}else if(compraSubFrag[1].equals("2")){//panqué
						Precio+=40;
					}else if(compraSubFrag[1].equals("3")){//dona
						Precio+=30;
					}else if(compraSubFrag[1].equals("4")){//helado
						Precio+=120;
					}
					if(compraSubFrag[2].equals("1") || compraSubFrag[2].equals("0")){//entera o ninguna
						Precio+=0;
					}else if(compraSubFrag[2].equals("2")){//deslactosada
						Precio+=6;
					}else if(compraSubFrag[2].equals("3")){//light
						Precio+=8;
					}
					if(compraSubFrag[3].equals("1")){//chispas
						Precio+=7;
					}else if(compraSubFrag[3].equals("2")){//cremita
						Precio+=5;
					}else if(compraSubFrag[3].equals("3")){//ambas
						Precio+=12;
					}else if(compraSubFrag[3].equals("0")){//nignuna
						Precio+=0;
					}
					JOptionPane.showMessageDialog(null,"CicloA: " +  String.valueOf(i) + ", CicloB: " + " compraSubFrag:" + Arrays.toString(compraSubFrag) + " Precio: " + String.valueOf(Precio));
				}
				if(Precio <= CantidadPago){
					int[] billetes = {0,0,0,0,0,0,0,0,0};
					CantidadPago-=Precio;//acá se vuelve en realidad el cambio
					while(CantidadPago>0){
						if(CantidadPago>=500){
							CantidadPago = Cambio(billetes, 0, 500, CantidadPago);
						}else if(CantidadPago>=200){
							CantidadPago = Cambio(billetes, 1, 200, CantidadPago);
						}else if(CantidadPago>=100){
							CantidadPago = Cambio(billetes, 2, 100, CantidadPago);
						}else if(CantidadPago>=50){
							CantidadPago = Cambio(billetes, 3, 50, CantidadPago);
						}else if(CantidadPago>=20){
							CantidadPago = Cambio(billetes, 4, 20, CantidadPago);
						}else if(CantidadPago>=10){
							CantidadPago = Cambio(billetes, 5, 10, CantidadPago);
						}else if(CantidadPago>=5){
							CantidadPago = Cambio(billetes, 6, 5, CantidadPago);
						}else if(CantidadPago>=2){
							CantidadPago = Cambio(billetes, 7, 2, CantidadPago);
						}else if(CantidadPago>=1){
							CantidadPago = Cambio(billetes, 8, 1, CantidadPago);
						}
					}
					JOptionPane.showMessageDialog(null, "Billetes: 	" + Arrays.toString(billetes));
				}else{
					JOptionPane.showMessageDialog(null,"Pago insuficiente");
				}	
			}
		}
	}
	static float Cambio(int[] arrayP, int i, int n, float P){
		arrayP[i] = (int) Math.floor((double) P / n);
		P-=arrayP[i]*n;
		return P;
	}
	public static boolean isNumeric(String str)
	{
		/* El try -catch es un bloque para detectar y controlar una excepción 
		   generada por código en funcionamiento*/
		try{
			double d= Double.parseDouble(str);
			if (d<=0){
				JOptionPane.showMessageDialog(null,"Pago inválido");
				return false;
			}
		}
		catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(null,  "Introduzca un valor válido");
			return false;
		}
		return true;
	}
	public String[] dividirCadena(String cadena, int tamañoFragmento) {
        if (tamañoFragmento <= 0) {
            System.out.println("El tamaño del fragmento debe ser mayor que cero.");
			return null;
        }
		 int cantidadFragmentos = (int) Math.ceil((double) cadena.length() / tamañoFragmento);
		 String[] fragmentos = new String[cantidadFragmentos];
		 for (int i = 0; i < cadena.length(); i += tamañoFragmento){
			 int endIndex = Math.min(i + tamañoFragmento, cadena.length());
			 String fragmento = cadena.substring(i, endIndex);
			 fragmentos[i / tamañoFragmento] = fragmento;
		 }
		 return fragmentos;
	 }
    public static void main(String[] args) {
        PrCafe marco = new PrCafe ();
        marco.crearGUI();
        marco.setTitle("Cafetería");
		marco.setSize(1500,900);
        marco.setVisible(true);
    }
}
