package com.king.dao;

public class DAOSupport {
	
	
	protected java.sql.Connection connection;

	protected java.sql.ResultSet execSql(String sql, Object... args) throws Exception {
		openConnection();
		java.sql.PreparedStatement pStatement = connection.prepareStatement(sql);
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
			pStatement.setObject(i + 1, args[i]);
		}
		pStatement.execute();
		return pStatement.getResultSet();
	}

	private void openConnection() {
		try {
			if (connection == null) {
				javax.naming.Context context = new javax.naming.InitialContext();
				javax.sql.DataSource dataSource = (javax.sql.DataSource) context.lookup("java:/comp/env/jdbc/lmsDB");
				connection = dataSource.getConnection();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
