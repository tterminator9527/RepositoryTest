package actions;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Statement;

import db.Db;

public class HeaderConstruction {
	public static Logger log = Logger.getLogger(HeaderConstruction.class);  
	
	public String report_name;
	public String column1;
	public String column2;
	public String column3;
	public String column4;
	public String column5;
	public String column6;
	public String column7;
	public String column8;
	public String column9;
	public String column10;
	
	int column_count = 0;
	StringBuffer columnTemplateBuf = new StringBuffer(); //构造的用于插入数据库sql片段
	StringBuffer columnValueTemplateBuf = new StringBuffer(); //构造的用于插入数据库sql片段
	public  String productReportHeader(){
		outputDebug();
		
		//report_name
		if(!report_name.equalsIgnoreCase("")){ 
			columnTemplateBuf.append("report_name,");
			columnValueTemplateBuf.append("'" + report_name + "',");
		}
		//column1
		if(!column1.equalsIgnoreCase("")){
			column_count++;
			columnTemplateBuf.append("column1,");
			columnValueTemplateBuf.append("'" + column1 + "',");
		}
		//column2
		if(!column2.equalsIgnoreCase("")){
			column_count++;
			columnTemplateBuf.append("column2,");
			columnValueTemplateBuf.append("'" + column2 + "',");
		}
		//column3		
		if(!column3.equalsIgnoreCase("")){
			column_count++;
			columnTemplateBuf.append("column3,");
			columnValueTemplateBuf.append("'" + column3 + "',");
		}
		//column4		
		if(!column4.equalsIgnoreCase("")){
			column_count++;
			columnTemplateBuf.append("column4,");
			columnValueTemplateBuf.append("'" + column4 + "',");
		}
		//column5
		if(!column5.equalsIgnoreCase("")){
			column_count++;
			columnTemplateBuf.append("column5,");
			columnValueTemplateBuf.append("'" + column5 + "',");
		}
		//column6
		if(!column6.equalsIgnoreCase("")){
			column_count++;
			columnTemplateBuf.append("column6,");
			columnValueTemplateBuf.append("'" + column6 + "',");
		}
		//column7
		if(!column7.equalsIgnoreCase("")){
			column_count++;
			columnTemplateBuf.append("column7,");
			columnValueTemplateBuf.append("'" + column7 + "',");
		}
		//column8
		if(!column8.equalsIgnoreCase("")){
			column_count++;
			columnTemplateBuf.append("column8,");
			columnValueTemplateBuf.append("'" + column8 + "',");
		}
		//column9
		if(!column9.equalsIgnoreCase("")){
			column_count++;
			columnTemplateBuf.append("column9,");
			columnValueTemplateBuf.append("'" + column9 + "',");
		}
		//column10
		if(!column10.equalsIgnoreCase("")){
			column_count++;
			columnTemplateBuf.append("column10,");
			columnValueTemplateBuf.append("'" + column10 + "',");
		}

		columnTemplateBuf.append("column_count"); //增加一列计数总列数
		columnValueTemplateBuf.append(column_count); //增加一列计数总列数
		
		log.debug(columnTemplateBuf.toString());
		log.debug(columnValueTemplateBuf.toString());
		
		//insert into the database
		String sql = "insert into customtable" + "( " + columnTemplateBuf.toString() + ") " + "values" + "(" + columnValueTemplateBuf.toString() + ");";
		log.debug(sql);
		try {
			Connection conn = Db.getConnection();
			Statement statement = (Statement) conn.createStatement();
			statement.execute(sql);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		log.debug(sql);
		
		return "success";
	}
	
	protected void outputDebug(){
		log.debug(report_name);
		log.debug(column1);
		log.debug(column2);
		log.debug(column3);
		log.debug(column4);
		log.debug(column5);
		log.debug(column6);
		log.debug(column7);
		log.debug(column8);
		log.debug(column9);
		log.debug(column10);
	}
	
}
