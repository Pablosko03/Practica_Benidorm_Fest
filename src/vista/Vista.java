package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class Vista extends JFrame {

	private JPanel contentPane;

	public JButton botonInicio;
	public JProgressBar progressBar;
	public JLabel cargando, imagen, seleccionFiltro,lblTop1, lblTop2, lblTop3, lblTop4, lblTop5, lblTop6, lblTop7, lblTop8, lblTop9, lblTop10, lblNewLabel_2;
	public JComboBox comboBox,comboComunidades;
	public JPanel panelTop1, panelPosicionTop1, panelTop2, panelPosicionTop2, panelTop3, panelPosicionTop3, panelTop4, panelPosicionTop4, panelTop5, panelPosicionTop5, panelTop6, panelPosicionTop6, panelTop7, panelPosicionTop7, panelTop8, panelPosicionTop8, panelTop9, panelPosicionTop9, panelTop10, panelPosicionTop10;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_16;
	private JLabel lblNewLabel_17;
	private JLabel lblNewLabel_19;
	private JLabel lblNewLabel_20;
	private JLabel lblNewLabel_22;
	private JLabel lblNewLabel_23;
	private JLabel lblNewLabel_25;
	private JLabel lblNewLabel_26;
	private JLabel lblNewLabel_28;
	private JLabel lblNewLabel_29;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					frame.setVisible(true);
					Controlador controlador = new Controlador(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1111, 753);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboComunidades = new JComboBox();
		comboComunidades.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboComunidades.setModel(new DefaultComboBoxModel(new String[] {"-- Selecciona la comunidad --", "Andalucia", "Aragon", "Asturias", "Castilla La Mancha", "Castilla Leon", "Catalu\u00F1a", "Cantabria", "Ceuta", "Comunidad Valenciana", "Extremadura", "Galicia", "Islas Canarias", "Islas Baleares", "La Rioja", "Navarra", "Madrid", "Melilla", "Murcia", "Pais Vasco"}));
		comboComunidades.setBounds(718, 33, 229, 41);
		contentPane.add(comboComunidades);
		comboComunidades.setVisible(false);
		((JLabel)comboComunidades.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"-- Seleccione filtro --", "Nacional", "Comunidad", "Edad"}));
		comboBox.setToolTipText("-- Seleccione filtro --\r\nNacional\r\nComunidad\r\nEdad");
		comboBox.setBounds(464, 33, 210, 39);
		contentPane.add(comboBox);
		comboBox.setVisible(false);
		((JLabel)comboBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		
		seleccionFiltro = new JLabel("Selecciona el filtro:");
		seleccionFiltro.setForeground(Color.WHITE);
		seleccionFiltro.setFont(new Font("Tahoma", Font.BOLD, 25));
		seleccionFiltro.setBounds(152, 21, 271, 57);
		contentPane.add(seleccionFiltro);
		seleccionFiltro.setVisible(false);
		
		panelPosicionTop10 = new JPanel();
		panelPosicionTop10.setLayout(null);
		panelPosicionTop10.setBackground(new Color(255, 0, 0));
		panelPosicionTop10.setBounds(623, 566, 68, 70);
		contentPane.add(panelPosicionTop10);
		panelPosicionTop10.setVisible(false);
		
		lblTop10 = new JLabel("10");
		lblTop10.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTop10.setBounds(10, 15, 48, 40);
		panelPosicionTop10.add(lblTop10);
		
		panelTop10 = new JPanel();
		panelTop10.setLayout(null);
		panelTop10.setBackground(Color.WHITE);
		panelTop10.setBounds(623, 566, 324, 70);
		contentPane.add(panelTop10);
		panelTop10.setVisible(false);
		
		lblNewLabel_28 = new JLabel("");
		lblNewLabel_28.setIcon(new ImageIcon("C:\\Users\\itzul\\Desktop\\Cantantes\\sandrorey.png"));
		lblNewLabel_28.setBounds(67, 0, 70, 70);
		panelTop10.add(lblNewLabel_28);
		
		lblNewLabel_29 = new JLabel("Sandro Rey");
		lblNewLabel_29.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_29.setBounds(147, 20, 167, 25);
		panelTop10.add(lblNewLabel_29);
		lblNewLabel_29.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_29.setVerticalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_30_9 = new JLabel("0 pts.");
		lblNewLabel_30_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_30_9.setBounds(147, 47, 167, 13);
		panelTop10.add(lblNewLabel_30_9);
		lblNewLabel_30_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_30_9.setVerticalAlignment(SwingConstants.CENTER);
		
		panelPosicionTop9 = new JPanel();
		panelPosicionTop9.setLayout(null);
		panelPosicionTop9.setBackground(Color.GRAY);
		panelPosicionTop9.setBounds(623, 448, 68, 70);
		contentPane.add(panelPosicionTop9);
		panelPosicionTop9.setVisible(false);
		
		lblTop9 = new JLabel("9");
		lblTop9.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTop9.setBounds(22, 20, 22, 30);
		panelPosicionTop9.add(lblTop9);
		
		panelTop9 = new JPanel();
		panelTop9.setLayout(null);
		panelTop9.setBackground(Color.WHITE);
		panelTop9.setBounds(623, 448, 324, 70);
		contentPane.add(panelTop9);
		panelTop9.setVisible(false);
		
		lblNewLabel_25 = new JLabel("");
		lblNewLabel_25.setIcon(new ImageIcon("C:\\Users\\itzul\\Desktop\\Cantantes\\rajoy.png"));
		lblNewLabel_25.setBounds(67, 0, 70, 70);
		panelTop9.add(lblNewLabel_25);
		
		lblNewLabel_26 = new JLabel("M.Rajoy");
		lblNewLabel_26.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_26.setBounds(147, 20, 167, 25);
		panelTop9.add(lblNewLabel_26);
		lblNewLabel_26.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_26.setVerticalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_30_8 = new JLabel("0 pts.");
		lblNewLabel_30_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_30_8.setBounds(147, 47, 167, 13);
		panelTop9.add(lblNewLabel_30_8);
		lblNewLabel_30_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_30_8.setVerticalAlignment(SwingConstants.CENTER);
		
		panelPosicionTop8 = new JPanel();
		panelPosicionTop8.setLayout(null);
		panelPosicionTop8.setBackground(Color.GRAY);
		panelPosicionTop8.setBounds(623, 328, 68, 70);
		contentPane.add(panelPosicionTop8);
		panelPosicionTop8.setVisible(false);
		
		lblTop8 = new JLabel("8");
		lblTop8.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTop8.setBounds(22, 20, 22, 30);
		panelPosicionTop8.add(lblTop8);
		
		
		panelTop8 = new JPanel();
		panelTop8.setLayout(null);
		panelTop8.setBackground(Color.WHITE);
		panelTop8.setBounds(623, 328, 324, 70);
		contentPane.add(panelTop8);
		panelTop8.setVisible(false);
		
		lblNewLabel_22 = new JLabel("");
		lblNewLabel_22.setIcon(new ImageIcon("C:\\Users\\itzul\\Desktop\\Cantantes\\elnano.png"));
		lblNewLabel_22.setBounds(67, 0, 70, 70);
		panelTop8.add(lblNewLabel_22);
		
		lblNewLabel_23 = new JLabel("El Nano");
		lblNewLabel_23.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_23.setBounds(147, 20, 167, 25);
		panelTop8.add(lblNewLabel_23);
		lblNewLabel_23.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_23.setVerticalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_30_7 = new JLabel("0 pts.");
		lblNewLabel_30_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_30_7.setBounds(147, 47, 167, 13);
		panelTop8.add(lblNewLabel_30_7);
		lblNewLabel_30_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_30_7.setVerticalAlignment(SwingConstants.CENTER);
		
		panelPosicionTop7 = new JPanel();
		panelPosicionTop7.setLayout(null);
		panelPosicionTop7.setBackground(Color.GRAY);
		panelPosicionTop7.setBounds(623, 211, 68, 70);
		contentPane.add(panelPosicionTop7);
		panelPosicionTop7.setVisible(false);
		
		lblTop7 = new JLabel("7");
		lblTop7.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTop7.setBounds(22, 20, 22, 30);
		panelPosicionTop7.add(lblTop7);
		
		panelTop7 = new JPanel();
		panelTop7.setLayout(null);
		panelTop7.setBackground(Color.WHITE);
		panelTop7.setBounds(623, 211, 324, 70);
		contentPane.add(panelTop7);
		panelTop7.setVisible(false);
		
		lblNewLabel_19 = new JLabel("");
		lblNewLabel_19.setIcon(new ImageIcon("C:\\Users\\itzul\\Desktop\\Cantantes\\motomami.jpg"));
		lblNewLabel_19.setBounds(67, 0, 70, 70);
		panelTop7.add(lblNewLabel_19);
		
		lblNewLabel_20 = new JLabel("Esperanza");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_20.setBounds(147, 20, 167, 25);
		panelTop7.add(lblNewLabel_20);
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_20.setVerticalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_30_6 = new JLabel("0 pts.");
		lblNewLabel_30_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_30_6.setBounds(147, 47, 167, 13);
		panelTop7.add(lblNewLabel_30_6);
		lblNewLabel_30_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_30_6.setVerticalAlignment(SwingConstants.CENTER);
		
		panelPosicionTop5 = new JPanel();
		panelPosicionTop5.setLayout(null);
		panelPosicionTop5.setBackground(Color.GRAY);
		panelPosicionTop5.setBounds(152, 566, 68, 70);
		contentPane.add(panelPosicionTop5);
		panelPosicionTop5.setVisible(false);
		
		lblTop5 = new JLabel("5");
		lblTop5.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTop5.setBounds(22, 20, 22, 30);
		panelPosicionTop5.add(lblTop5);
		
		panelTop5 = new JPanel();
		panelTop5.setLayout(null);
		panelTop5.setBackground(Color.WHITE);
		panelTop5.setBounds(152, 566, 324, 70);
		contentPane.add(panelTop5);
		panelTop5.setVisible(false);
		
		lblNewLabel_17 = new JLabel("Jorge");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_17.setBounds(147, 20, 167, 25);
		panelTop5.add(lblNewLabel_17);
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_17.setVerticalAlignment(SwingConstants.CENTER);
		
		lblNewLabel_16 = new JLabel("");
		lblNewLabel_16.setIcon(new ImageIcon("C:\\Users\\itzul\\Desktop\\Cantantes\\jorge.png"));
		lblNewLabel_16.setBounds(67, 0, 70, 70);
		panelTop5.add(lblNewLabel_16);
		
		JLabel lblNewLabel_30_4 = new JLabel("0 pts.");
		lblNewLabel_30_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_30_4.setBounds(147, 47, 167, 13);
		panelTop5.add(lblNewLabel_30_4);
		lblNewLabel_30_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_30_4.setVerticalAlignment(SwingConstants.CENTER);
		
		panelPosicionTop4 = new JPanel();
		panelPosicionTop4.setLayout(null);
		panelPosicionTop4.setBackground(Color.GRAY);
		panelPosicionTop4.setBounds(152, 448, 68, 70);
		contentPane.add(panelPosicionTop4);
		panelPosicionTop4.setVisible(false);
		
		lblTop4 = new JLabel("4");
		lblTop4.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTop4.setBounds(22, 20, 22, 30);
		panelPosicionTop4.add(lblTop4);
		
		panelTop4 = new JPanel();
		panelTop4.setLayout(null);
		panelTop4.setBackground(Color.WHITE);
		panelTop4.setBounds(152, 448, 324, 70);
		contentPane.add(panelTop4);
		panelTop4.setVisible(false);
		
		lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon("C:\\Users\\itzul\\Desktop\\Cantantes\\johncena.png"));
		lblNewLabel_13.setBounds(67, 0, 70, 70);
		panelTop4.add(lblNewLabel_13);
		
		lblNewLabel_14 = new JLabel("Bing Chilling");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_14.setBounds(147, 20, 167, 25);
		panelTop4.add(lblNewLabel_14);
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_14.setVerticalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_30_3 = new JLabel("0 pts.");
		lblNewLabel_30_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_30_3.setBounds(147, 47, 167, 13);
		panelTop4.add(lblNewLabel_30_3);
		lblNewLabel_30_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_30_3.setVerticalAlignment(SwingConstants.CENTER);
		
		panelPosicionTop3 = new JPanel();
		panelPosicionTop3.setLayout(null);
		panelPosicionTop3.setBackground(new Color(184, 134, 11));
		panelPosicionTop3.setBounds(152, 328, 68, 70);
		contentPane.add(panelPosicionTop3);
		panelPosicionTop3.setVisible(false);
		
		lblTop3 = new JLabel("3");
		lblTop3.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTop3.setBounds(22, 20, 22, 30);
		panelPosicionTop3.add(lblTop3);
		
		panelTop3 = new JPanel();
		panelTop3.setLayout(null);
		panelTop3.setBackground(Color.WHITE);
		panelTop3.setBounds(152, 328, 324, 70);
		contentPane.add(panelTop3);
		panelTop3.setVisible(false);
		
		lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\itzul\\Desktop\\Cantantes\\abdurozik.png"));
		lblNewLabel_10.setBounds(67, 0, 70, 70);
		panelTop3.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("Abdu Rozik");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_11.setBounds(147, 20, 167, 25);
		panelTop3.add(lblNewLabel_11);
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setVerticalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_30_2 = new JLabel("0 pts.");
		lblNewLabel_30_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_30_2.setBounds(147, 47, 167, 13);
		panelTop3.add(lblNewLabel_30_2);
		lblNewLabel_30_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_30_2.setVerticalAlignment(SwingConstants.CENTER);
		
		panelPosicionTop2 = new JPanel();
		panelPosicionTop2.setLayout(null);
		panelPosicionTop2.setBackground(Color.LIGHT_GRAY);
		panelPosicionTop2.setBounds(152, 211, 68, 70);
		contentPane.add(panelPosicionTop2);
		panelPosicionTop2.setVisible(false);
		
		lblTop2 = new JLabel("2");
		lblTop2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTop2.setBounds(22, 20, 22, 30);
		panelPosicionTop2.add(lblTop2);
		
		panelTop2 = new JPanel();
		panelTop2.setLayout(null);
		panelTop2.setBackground(Color.WHITE);
		panelTop2.setBounds(152, 211, 324, 70);
		contentPane.add(panelTop2);
		panelTop2.setVisible(false);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\itzul\\Desktop\\Cantantes\\hasbulla.png"));
		lblNewLabel_7.setBounds(67, -11, 70, 95);
		panelTop2.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Hasbulla");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_8.setBounds(147, 20, 167, 25);
		panelTop2.add(lblNewLabel_8);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setVerticalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_30_1 = new JLabel("0 pts.");
		lblNewLabel_30_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_30_1.setBounds(147, 47, 167, 13);
		panelTop2.add(lblNewLabel_30_1);
		lblNewLabel_30_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_30_1.setVerticalAlignment(SwingConstants.CENTER);
		
		panelPosicionTop6 = new JPanel();
		panelPosicionTop6.setLayout(null);
		panelPosicionTop6.setBackground(Color.GRAY);
		panelPosicionTop6.setBounds(623, 99, 68, 70);
		contentPane.add(panelPosicionTop6);
		panelPosicionTop6.setVisible(false);
		
		lblTop6 = new JLabel("6");
		lblTop6.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTop6.setBounds(22, 20, 22, 30);
		panelPosicionTop6.add(lblTop6);
		
		panelTop6 = new JPanel();
		panelTop6.setLayout(null);
		panelTop6.setBackground(Color.WHITE);
		panelTop6.setBounds(623, 99, 324, 70);
		contentPane.add(panelTop6);
		panelTop6.setVisible(false);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\itzul\\Desktop\\Cantantes\\melendi.png"));
		lblNewLabel_4.setBounds(67, 0, 70, 70);
		panelTop6.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Melendi");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5.setBounds(147, 20, 167, 25);
		panelTop6.add(lblNewLabel_5);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setVerticalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_30_5 = new JLabel("0 pts.");
		lblNewLabel_30_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_30_5.setBounds(147, 47, 167, 13);
		panelTop6.add(lblNewLabel_30_5);
		lblNewLabel_30_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_30_5.setVerticalAlignment(SwingConstants.CENTER);
		
		panelPosicionTop1 = new JPanel();
		panelPosicionTop1.setBackground(Color.YELLOW);
		panelPosicionTop1.setBounds(152, 99, 68, 70);
		contentPane.add(panelPosicionTop1);
		panelPosicionTop1.setLayout(null);
		panelPosicionTop1.setVisible(false);
		
		JLabel lblTop1 = new JLabel("1");
		lblTop1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTop1.setBounds(22, 20, 22, 30);
		panelPosicionTop1.add(lblTop1);
		panelPosicionTop1.setVisible(false);
		
		panelTop1 = new JPanel();
		panelTop1.setBackground(Color.WHITE);
		panelTop1.setBounds(152, 99, 324, 70);
		contentPane.add(panelTop1);
		panelTop1.setLayout(null);
		panelTop1.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\itzul\\Desktop\\elton.png"));
		lblNewLabel.setBounds(67, 0, 70, 70);
		panelTop1.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("Mamberroi");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(147, 20, 167, 25);
		panelTop1.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_30 = new JLabel("0 pts.");
		lblNewLabel_30.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_30.setBounds(147, 47, 167, 13);
		panelTop1.add(lblNewLabel_30);
		lblNewLabel_30.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_30.setVerticalAlignment(SwingConstants.CENTER);
		
		botonInicio = new JButton("INICIAR VOTACI\u00D3N");
		botonInicio.setFont(new Font("Tahoma", Font.BOLD, 25));
		botonInicio.setBounds(381, 84, 324, 87);
		contentPane.add(botonInicio);
		
		progressBar = new JProgressBar();
		progressBar.setForeground(Color.WHITE);
		progressBar.setStringPainted(true);
		progressBar.setBounds(338, 626, 421, 51);
		progressBar.setValue(0);
		contentPane.add(progressBar);
		
		
		cargando = new JLabel("Cargando votaci\u00F3n...");
		cargando.setForeground(Color.WHITE);
		cargando.setFont(new Font("Tahoma", Font.BOLD, 25));
		cargando.setBounds(412, 579, 273, 37);
		contentPane.add(cargando);
		
		imagen = new JLabel("");
		imagen.setHorizontalAlignment(SwingConstants.CENTER);
		imagen.setIcon(new ImageIcon("src/Imagenes/benidorm.png"));
		imagen.setBounds(0, 0, 1097, 716);
		contentPane.add(imagen);
		
		
		
	
	}
}
