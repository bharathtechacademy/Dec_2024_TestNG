package com.creatio.crm.framework.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class DBUtil {	
	
	public static ResultSet readDB(String query) throws SQLException {
		Properties prop = PropUtil.readData("Config.properties");
		ResultSet dataSet = null;
		String url = prop.getProperty("db_url");
		String username = prop.getProperty("db_username");
		String password = prop.getProperty("db_password");		
		Connection connection = DriverManager.getConnection(url, username, password); //connect with database
		dataSet = connection.createStatement().executeQuery(query);	//run the query and get the data
		return dataSet;
	}

}
