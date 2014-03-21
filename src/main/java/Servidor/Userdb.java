package Servidor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Userdb {
	
	//Nos conectamos a la base de datos. ( el nombre se lo hemos dado en el context.xml
		private DataSource ds;
		String passdb;
		public Userdb(){
			  try {
				Context ctx = new InitialContext();
				ds = (DataSource)ctx.lookup("java:comp/env/jdbc/gestion");
			  } catch (NamingException e) {
				e.printStackTrace();
			  }
			}
		public void setInfo(String username) throws SQLException{
			
			Connection con = ds.getConnection();//Hacemos la connexión
			
			//Preparamos la query
			Statement stmt = con.createStatement();//creamos para poder hacer una query
			
			String query = "select password from users where username = '"+username+"';";//Construimos la query
			ResultSet rs = stmt.executeQuery(query);//Enviamos la query
			rs.next();
			 passdb=rs.getString("password");
			
		}
		public String getPass(){
			return passdb;
		}
		

}
