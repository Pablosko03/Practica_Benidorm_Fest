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
	public JLabel lblGanadores, cargando, imagen, seleccionFiltro,lblTop1, lblTop2, lblTop3, lblNombreTop1, lblImagenTop1,lblPuntosTop1,lblNombreTop2, lblPuntosTop2,lblImagenTop2, lblImagenTop3,lblNombreTop3, lblPuntosTop3;
	public JComboBox comboBox,comboComunidades;
	public JPanel panelTop1, panelPosicionTop1, panelTop2, panelPosicionTop2, panelTop3, panelPosicionTop3;

	
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
		comboComunidades.setModel(new DefaultComboBoxModel(new String[] {"Andalucia", "Aragon", "Asturias", "Castilla La Mancha", "Castilla Leon", "Catalu\u00F1a", "Cantabria", "Ceuta", "Comunidad Valenciana", "Extremadura", "Galicia", "Islas Canarias", "Islas Baleares", "La Rioja", "Navarra", "Madrid", "Melilla", "Murcia", "Pais Vasco"}));
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
		
		panelPosicionTop3 = new JPanel();
		panelPosicionTop3.setLayout(null);
		panelPosicionTop3.setBackground(new Color(184, 134, 11));
		panelPosicionTop3.setBounds(381, 482, 68, 70);
		contentPane.add(panelPosicionTop3);
		panelPosicionTop3.setVisible(false);
		
		lblTop3 = new JLabel("3");
		lblTop3.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTop3.setBounds(22, 20, 22, 30);
		panelPosicionTop3.add(lblTop3);
		
		panelTop3 = new JPanel();
		panelTop3.setLayout(null);
		panelTop3.setBackground(Color.WHITE);
		panelTop3.setBounds(381, 482, 324, 70);
		contentPane.add(panelTop3);
		panelTop3.setVisible(false);
		
		lblImagenTop3 = new JLabel("");
		lblImagenTop3.setIcon(new ImageIcon("src/Imagenes/abdurozik.png"));
		lblImagenTop3.setBounds(67, 0, 70, 70);
		panelTop3.add(lblImagenTop3);
		
		lblNombreTop3 = new JLabel("Abdu Rozik");
		lblNombreTop3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNombreTop3.setBounds(147, 20, 167, 25);
		panelTop3.add(lblNombreTop3);
		lblNombreTop3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreTop3.setVerticalAlignment(SwingConstants.CENTER);
		
		lblPuntosTop3 = new JLabel("0 pts.");
		lblPuntosTop3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPuntosTop3.setBounds(147, 47, 167, 13);
		panelTop3.add(lblPuntosTop3);
		lblPuntosTop3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntosTop3.setVerticalAlignment(SwingConstants.CENTER);
		
		panelPosicionTop2 = new JPanel();
		panelPosicionTop2.setLayout(null);
		panelPosicionTop2.setBackground(Color.LIGHT_GRAY);
		panelPosicionTop2.setBounds(381, 365, 68, 70);
		contentPane.add(panelPosicionTop2);
		panelPosicionTop2.setVisible(false);
		
		lblTop2 = new JLabel("2");
		lblTop2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTop2.setBounds(22, 20, 22, 30);
		panelPosicionTop2.add(lblTop2);
		
		panelTop2 = new JPanel();
		panelTop2.setLayout(null);
		panelTop2.setBackground(Color.WHITE);
		panelTop2.setBounds(381, 365, 324, 70);
		contentPane.add(panelTop2);
		panelTop2.setVisible(false);
		
		lblImagenTop2 = new JLabel("");
		lblImagenTop2.setIcon(new ImageIcon("src/Imagenes/hasbulla.png"));
		lblImagenTop2.setBounds(67, -11, 70, 95);
		panelTop2.add(lblImagenTop2);
		
		lblNombreTop2 = new JLabel("Hasbulla");
		lblNombreTop2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNombreTop2.setBounds(147, 20, 167, 25);
		panelTop2.add(lblNombreTop2);
		lblNombreTop2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreTop2.setVerticalAlignment(SwingConstants.CENTER);
		
		lblPuntosTop2 = new JLabel("0 pts.");
		lblPuntosTop2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPuntosTop2.setBounds(147, 47, 167, 13);
		panelTop2.add(lblPuntosTop2);
		lblPuntosTop2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntosTop2.setVerticalAlignment(SwingConstants.CENTER);
		
		panelPosicionTop1 = new JPanel();
		panelPosicionTop1.setBackground(Color.YELLOW);
		panelPosicionTop1.setBounds(381, 253, 68, 70);
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
		panelTop1.setBounds(381, 253, 324, 70);
		contentPane.add(panelTop1);
		panelTop1.setLayout(null);
		panelTop1.setVisible(false);
		
		lblImagenTop1 = new JLabel("");
		lblImagenTop1.setIcon(new ImageIcon("src/Imagenes/elton.png"));
		lblImagenTop1.setBounds(67, 0, 70, 70);
		panelTop1.add(lblImagenTop1);
		
		lblNombreTop1 = new JLabel("Mamberroi");
		lblNombreTop1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNombreTop1.setBounds(147, 20, 167, 25);
		panelTop1.add(lblNombreTop1);
		lblNombreTop1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreTop1.setVerticalAlignment(SwingConstants.CENTER);
		
		lblPuntosTop1 = new JLabel("0 pts.");
		lblPuntosTop1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPuntosTop1.setBounds(147, 47, 167, 13);
		panelTop1.add(lblPuntosTop1);
		lblPuntosTop1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntosTop1.setVerticalAlignment(SwingConstants.CENTER);
		
		botonInicio = new JButton("INICIAR VOTACI\u00D3N");
		botonInicio.setFont(new Font("Tahoma", Font.BOLD, 25));
		botonInicio.setBounds(381, 84, 324, 87);
		contentPane.add(botonInicio);
		
		
		cargando = new JLabel("Cargando votaci\u00F3n...");
		cargando.setForeground(Color.WHITE);
		cargando.setFont(new Font("Tahoma", Font.BOLD, 25));
		cargando.setBounds(412, 579, 273, 37);
		contentPane.add(cargando);
		
		imagen = new JLabel("");
		imagen.setHorizontalAlignment(SwingConstants.CENTER);
		imagen.setIcon(new ImageIcon("src/Imagenes/benidorm.png"));
		imagen.setBounds(0, 0, 1107, 737);
		contentPane.add(imagen);
		
		lblGanadores = new JLabel("");
		lblGanadores.setIcon(new ImageIcon("src/Imagenes/ganador.png"));
		lblGanadores.setBounds(0, 90, 1107, 716);
		contentPane.add(lblGanadores);
		lblGanadores.setVisible(false);
		
		
		
	
	}
}
