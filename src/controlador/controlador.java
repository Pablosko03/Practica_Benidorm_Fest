package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import modelo.*;
import vista.Vista;

public class controlador implements ActionListener{

	Vista Vista = new Vista();
	
	public controlador(Vista Vista) {
		this.Vista = Vista;
		this.Vista.botonInicio.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int numVotos = 0;
		controlador helper = new controlador(Vista);
		try {
			Connection connection = helper.createConnection();
			
			if(e.getSource() == this.Vista.botonInicio) {
				
				procesarComunidadVoto(connection);
//				votacionAndalucia(connection, "");
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
			
				votacion(numVotosFinal, rango, comunidad);
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

	public void votacion(int numVotos, String rango, String comunidad) {
		//Repetimos el for segun el numero de votos por porcentaje de rango
		System.out.println(numVotos);
		for(int i = 0; i< numVotos; i++) {
			//Creacion del hilo de prueba
			Votacion hilo = new Votacion(rango);
			hilo.start();
		
			//Recuperamos el voto que ha salido del numero random que calcula el hilo
			int voto = hilo.getVoto();
			
			System.out.println(voto);
			
		}
		System.out.println("Votacion del  "+rango +" de "+comunidad+" finalizada");
	}
	
	public void updateVoto(Connection connection, int voto, String comunidad, String rango) throws SQLException {
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			preparedStatement = connection.prepareStatement("");
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
			
			
			}
			
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
}
