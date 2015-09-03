package actions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Statement;

import db.Db;

public class DetailConstruction {
	public static Logger log = Logger.getLogger(DetailConstruction.class);  
	
	public int column_count;
	public HashMap<String,String> volumnsMap = new HashMap<String,String>();
	public String report_name = "";
	
	public String reportDetail(){
		
		//查询数据库，获取报表头信息
		String sql = "select * from customtable order by id desc limit 1;";
		try {
			Connection conn = Db.getConnection();
			Statement statement = (Statement) conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				if(!rs.getString("column1").equalsIgnoreCase(""))
				{
					volumnsMap.put("column1", rs.getString("column1"));
				}
				if(!rs.getString("column2").equalsIgnoreCase(""))
				{
					volumnsMap.put("column2", rs.getString("column2"));
				}
				if(!rs.getString("column3").equalsIgnoreCase(""))
				{
					volumnsMap.put("column3", rs.getString("column3"));
				}
				if(!rs.getString("column4").equalsIgnoreCase(""))
				{
					volumnsMap.put("column4", rs.getString("column4"));
				}
				if(!rs.getString("column5").equalsIgnoreCase(""))
				{
					volumnsMap.put("column5", rs.getString("column5"));
				}
				if(!rs.getString("column6").equalsIgnoreCase(""))
				{
					volumnsMap.put("column6", rs.getString("column6"));
				}
				if(!rs.getString("column7").equalsIgnoreCase(""))
				{
					volumnsMap.put("column7", rs.getString("column7"));
				}
				if(!rs.getString("column8").equalsIgnoreCase(""))
				{
					volumnsMap.put("column8", rs.getString("column8"));
				}
				if(!rs.getString("column9").equalsIgnoreCase(""))
				{
					volumnsMap.put("column9", rs.getString("column9"));
				}
				if(!rs.getString("column10").equalsIgnoreCase(""))
				{
					volumnsMap.put("column10", rs.getString("column10"));
				}
				report_name = rs.getString("report_name");
				column_count = rs.getInt("column_count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "success";
	}
	
	
	
	public int getColumn_count() {
		return column_count;
	}

	public void setColumn_count(int column_count) {
		this.column_count = column_count;
	}
	
	public HashMap<String, String> getVolumnsMap() {
		return volumnsMap;
	}

	public void setVolumnsMap(HashMap<String, String> volumnsMap) {
		this.volumnsMap = volumnsMap;
	}

	public String getReport_name() {
		return report_name;
	}

	public void setReport_name(String report_name) {
		this.report_name = report_name;
	}
}
