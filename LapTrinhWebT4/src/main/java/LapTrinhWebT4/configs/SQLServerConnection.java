package LapTrinhWebT4.configs;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import LapTrinhWebT4.configs.SQLServerConnection;

public class SQLServerConnection {
	private static final String serverName = "localhost";
	private static final String dbname = "BT_Tuan3";
	private static final String portNumber = "1433";
	private static final String instance = "";
	private static final String userID = "sa";
	private static final String password = "123456";

	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbname;

			if (instance == null || instance.trim().isEmpty())
				url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbname;
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			return DriverManager.getConnection(url, userID, password);

		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		try {
			System.out.println(new SQLServerConnection().getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
