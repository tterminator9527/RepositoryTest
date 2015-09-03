package actions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.mysql.jdbc.Statement;

import db.Db;

public class ReportQuery {
	public static Logger log = Logger.getLogger(ReportQuery.class);  
	
	public String reportName;
	public HashMap<Integer, String> headersMap = new HashMap<Integer, String>();
	public ArrayList<HashMap<Integer, String>> contentMapList = new ArrayList<HashMap<Integer, String>>();
	
	
	public String reportQuery(){
		
		//获取表头
		String sqlHeader = "select * from customtable where report_name = '" + reportName + "' order by id desc limit 1;";
		log.debug(sqlHeader);
		try {
			Connection conn = Db.getConnection();
			Statement statement = (Statement) conn.createStatement();
			ResultSet rs = statement.executeQuery(sqlHeader);
			while(rs.next()){
				int count = rs.getInt("column_count");
				for(int i = 1; i <= count; i++){
					headersMap.put(i, rs.getString("column" + i));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//获取报表内容
		String sqlContent = "select * from reportcontent where report_name = '" + reportName + "'";
		log.debug(sqlContent);
		HttpServletRequest request = ServletActionContext.getRequest();//利用request实现浏览器页面条目显示
		try {
			HashMap<Integer, String> contentItemMap;
			Connection conn = Db.getConnection();
			Statement statement = (Statement) conn.createStatement();
			ResultSet rs = statement.executeQuery(sqlContent);
			while(rs.next()){
				int count = rs.getInt("column_count");
				contentItemMap = new HashMap<Integer, String>();
				for(int i = 1; i <= count; i++){
					contentItemMap.put(i, rs.getString("column" + i));
				}
				contentMapList.add(contentItemMap);
			}
			request.setAttribute("list_data", contentMapList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return "success";
	}
	
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public HashMap<Integer, String> getHeadersMap() {
		return headersMap;
	}

	public void setHeadersMap(HashMap<Integer, String> headersMap) {
		this.headersMap = headersMap;
	}

	public ArrayList<HashMap<Integer, String>> getContentMapList() {
		return contentMapList;
	}

	public void setContentMapList(ArrayList<HashMap<Integer, String>> contentMapList) {
		this.contentMapList = contentMapList;
	}

}
