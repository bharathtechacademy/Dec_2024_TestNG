package com.creatio.crm.framework.db.commons;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.creatio.crm.framework.utilities.DBUtil;

public class DbCommons {
	
	//This class will have all the common methods to read the data from database
	
	public static List<Map<String,String>> readData(String query) throws SQLException{
		List<Map<String,String>> data = new ArrayList<Map<String,String>>();
		ResultSet dataSet = DBUtil.readDB(query);
		while(dataSet.next()) {
			Map<String,String> rowData = new HashMap<String,String>();
			for(int col =1; col <=dataSet.getMetaData().getColumnCount() ; col++) {
				String columnName= dataSet.getMetaData().getColumnName(col);
				String columnValue = dataSet.getString(col);
				rowData.put(columnName, columnValue);
			}
			data.add(rowData);
		}
		
		return data;		
	}

}
