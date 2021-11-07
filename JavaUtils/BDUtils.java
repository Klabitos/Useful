package com.klabitos.bbdd.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class BDUtils {

	public static Connection conexionBBDD(String nombreBase) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver"); //OBLIGATORIO Y SIEMPRE IGUAL
		
		String servidor = ""+nombreBase; //COGEMOS DE LA LOCAL LA QUE SE LLAMA CLASSIC MODELS
		String username = "root";
		String password = ""; //NUESTRA CONTRASE�A DE AQUI
		Connection conexionBD = DriverManager.getConnection(servidor, username, password); //ESTABLECEMOS CONEXION AL SERVIDOR CON EL USUARIO Y LA CONTRASE�A
		
		return conexionBD;
	}
}
