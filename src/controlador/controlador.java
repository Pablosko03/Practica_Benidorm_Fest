package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import modelo.Votacion;
import vista.vista;

public class controlador implements ActionListener{

	vista vista = new vista();
	
	public controlador(vista vista) {
		this.vista = vista;
		this.vista.btnNewButton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int numVotos = 0;
		controlador helper = new controlador(vista);
		try {
			
			if(e.getSource() == this.vista.btnNewButton) {
				helper.createConnection();
				
				votacion(numVotos);
			}
			
		} catch (ClassNotFoundException | SQLException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	public void votacion(int numVotos) {
		//Repetimos el for segun el numero de votos por porcentaje de rango
		String rango = "";
		for(int i = 0; i< numVotos; i++) {
			//Creacion del hilo de prueba
			Votacion hilo = new Votacion(rango);
		
			//Recuperamos el voto que ha salido del numero random que calcula el hilo
			int voto = hilo.getVoto();
		}
	}

	public static Connection createConnection() throws ClassNotFoundException, SQLException, IOException {

		Connection censoHabitantes = null;

		try {
			//Accedemos al fichero de propiedades para recuperar los datos para conectarnos a base de datos
			Properties propiedades = new Properties();
			propiedades.load(new FileReader("src/recursos/database.properties"));
			String driver = propiedades.getProperty("database.driver");
			String url = propiedades.getProperty("database.url");
			String user = propiedades.getProperty("database.user");
			String password = propiedades.getProperty("database.password");

			//Relizamos el registro del driver y obtenemos la conexion
			Class.forName(driver);
			censoHabitantes = DriverManager.getConnection(url, user, password);

			// Nos aseguramos setAutoCommit a false
			censoHabitantes.setAutoCommit(false);
			
			System.out.println("conexion creada con exito");
						
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			throw e;
		}

		return censoHabitantes;
	}
}
