package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDeDatos {
	 private final String URL = "jdbc:mysql://localhost:3306/"; // 
	 private final String BD = "aterrizar"; //
	 private final String USER = "root";
	 private final String PASSWORD = "09021984";

	 public Connection conexion = null;

	 @SuppressWarnings("finally")
	 public Connection conectar() throws SQLException {
		 try {
	         Class.forName("com.mysql.jdbc.Driver");
	         conexion = DriverManager.getConnection(URL + BD, USER, PASSWORD);
	         if (conexion != null) {
	             System.out.println("¡Conexión Exitosa!");
	         }
	     } catch (Exception e) {
	          System.out.println("Error al intentar conectar a la base de datos");
	     } finally {
	          return conexion;
	     }
	  }

}
