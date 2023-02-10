package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JProgressBar;

import modelo.*;
import vista.Vista;

public class Controlador implements ActionListener, MouseListener{

	Vista Vista = new Vista();
	private int votosTotales;
	private int progreso;
	private int avanza;
	
	
	public Controlador(Vista Vista) {
		this.Vista = Vista;
		this.Vista.botonInicio.addActionListener(this);
		this.Vista.comboBox.addActionListener(this);
		this.Vista.comboComunidades.addActionListener(this);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int numVotos = 0;
		Controlador helper = new Controlador(Vista);
		try {
			if(e.getSource() == this.Vista.botonInicio) {
				Connection connection = helper.createConnection();
				Vista.botonInicio.setVisible(false);
				Vista.progressBar.setVisible(false);
				Vista.cargando.setVisible(false);
				Vista.imagen.setVisible(false);
				procesarComunidadVoto(connection);
				Vista.seleccionFiltro.setVisible(true);
				Vista.comboBox.setVisible(true);
				Vista.panelTop1.setVisible(true);
				Vista.panelPosicionTop1.setVisible(true);
				Vista.panelTop2.setVisible(true);
				Vista.panelPosicionTop2.setVisible(true);
				Vista.panelTop3.setVisible(true);
				Vista.panelPosicionTop3.setVisible(true);
				Vista.panelTop4.setVisible(true);
				Vista.panelPosicionTop4.setVisible(true);
				Vista.panelTop5.setVisible(true);
				Vista.panelPosicionTop5.setVisible(true);
				Vista.panelTop6.setVisible(true);
				Vista.panelPosicionTop6.setVisible(true);
				Vista.panelTop7.setVisible(true);
				Vista.panelPosicionTop7.setVisible(true);
				Vista.panelTop8.setVisible(true);
				Vista.panelPosicionTop8.setVisible(true);
				Vista.panelTop9.setVisible(true);
				Vista.panelPosicionTop9.setVisible(true);
				Vista.panelTop10.setVisible(true);
				Vista.panelPosicionTop10.setVisible(true);
//				votacionAndalucia(connection, "");
				
			}
			if(e.getSource() == Vista.comboBox) {
				String filtro = (String)Vista.comboBox.getSelectedItem();
				if(filtro.equals("Comunidad")) {
					Vista.comboComunidades.setVisible(true);
				}else if(filtro.equals("Nacional")) {
					Vista.comboComunidades.setVisible(false);
				}else if(filtro.equals("Edad")) {
					Vista.comboComunidades.setVisible(false);
				}else {
					
				}
			}
			
		} catch (ClassNotFoundException | SQLException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	
	
	public void procesarComunidadVoto(Connection connection) {
		ArrayList<String> comunidades = new ArrayList<String>();
		ArrayList<String> rangos = new ArrayList<String>();
		
		String comunidad;
		String rango;
		
		try {
			
			comunidades = sacarComunidad(connection, comunidades);
			rangos = sacarRango(connection, rangos);
			
			for(int i = 0; i<comunidades.size(); i++) {
				for(int j = 0; j<rangos.size(); j++) {
					comunidad = comunidades.get(i);
					rango = rangos.get(j);
					
					String consulta = "SELECT " + rango + " FROM PORCENTAJES_RANGOEDAD WHERE NOMBRE_COMUNIDAD = ?";
					
					votacionComunidades(connection, consulta, rango, comunidad);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> sacarComunidad(Connection connection, ArrayList<String> comunidades) throws SQLException{
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			preparedStatement = connection.prepareStatement("SELECT NOMBRE_COMUNIDAD FROM PORCENTAJES_RANGOEDAD");
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				comunidades.add(resultSet.getString("NOMBRE_COMUNIDAD"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
			
		}finally {
			if (null != preparedStatement) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				
				}
			}
		}
		
		return comunidades;
	}
	
	public ArrayList<String> sacarRango(Connection connection, ArrayList<String> rangos) throws SQLException {
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			preparedStatement = connection.prepareStatement("SELECT RANGO FROM PORCENTAJE_VOTACION_RANGO WHERE ES_MAYOREDAD = '1'");
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				rangos.add(resultSet.getString("RANGO"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
			
		}finally {
			if (null != preparedStatement) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				
				}
			}
		}
		
		return rangos;
	}
	
	public void votacionComunidades(Connection connection, String consulta, String rango, String comunidad) throws SQLException {
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		int porcentajeVoto, numVotosFinal, totalHabitantes;
		double porcentajeRango;
		
		try {
			
			preparedStatement = connection.prepareStatement(consulta);
			preparedStatement.setString(1, comunidad);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				porcentajeVoto = resultSet.getInt(rango);

				porcentajeRango = votacionRango(connection, rango);
				
				totalHabitantes = habitantesComunidad(connection, comunidad);
			
				numVotosFinal = generarNumVotos(porcentajeVoto, porcentajeRango, totalHabitantes);
			
				votacion(connection, numVotosFinal, rango, comunidad);
			}		
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			if (null != preparedStatement) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				
					}
				}
		}
	}

	public int generarNumVotos(int porcentajeVoto, double porcentajeRango, int totalHabitantes) {
		int numVotosFinal;
		porcentajeVoto = (totalHabitantes * porcentajeVoto)/100;
		
		numVotosFinal = (int) ((porcentajeVoto * porcentajeRango)/100);
		
		return numVotosFinal;
	}
	
	public int habitantesComunidad(Connection connection, String comunidad) throws SQLException {
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		int totalHabitantes = 0;
		
		try {
			
			preparedStatement = connection.prepareStatement("SELECT TOTAL_HABITANTES FROM PORCENTAJES_RANGOEDAD WHERE NOMBRE_COMUNIDAD = ?");
			preparedStatement.setString(1, comunidad);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
			totalHabitantes = resultSet.getInt("TOTAL_HABITANTES");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return totalHabitantes;
	}
	
	public double votacionRango(Connection connection, String rango) throws SQLException{
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		double porcentajeVoto = 0;
		
		try {
			
			preparedStatement = connection.prepareStatement("SELECT PORCENTAJE FROM PORCENTAJE_VOTACION_RANGO WHERE RANGO = ?");
			preparedStatement.setString(1, rango);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
			porcentajeVoto = resultSet.getDouble("PORCENTAJE");
			
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}
		
		return porcentajeVoto;
	}

	public void votacion(Connection connection, int numVotos, String rango, String comunidad) {
		//Repetimos el for segun el numero de votos por porcentaje de rango
		int voto = 0;
		if(numVotos < 5) {
			numVotos = 5;
		}
		
		for(int i = 0; i< numVotos; i++) {
			//Creacion del hilo de prueba
			Votacion hilo = new Votacion(rango);
			
			hilo.start();
			try {
				//hilo.sleep(500);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
			
				hilo.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			//Recuperamos el voto que ha salido del numero random que calcula el hilo
			voto = hilo.getVoto();
			System.out.println(voto);
			
			}
		}

	
	
	public void updateVoto(Connection connection, int voto, String comunidad, String rango) throws SQLException {
		PreparedStatement preparedStatement = null;
		
		try {
			
			preparedStatement = connection.prepareStatement("UPDATE " + comunidad + " SET RANGO_18_25 = " );
			
			preparedStatement.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
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

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
