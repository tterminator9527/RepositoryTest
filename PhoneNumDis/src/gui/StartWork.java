package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import service.PhonePoolDistribute;
import threadUtil.ThreadDistribute;

public class StartWork implements ActionListener {
	public static JPanel jpanel1;
	public JTextField jTextField_fileCount;
	public JTextField jTextField_numberPerfile;
	public String fileCount = "";
	public String numberPerfile = "";
	public StartWork(JPanel  jpanel1, JTextField jTextField_fileCount,JTextField jTextField_numberPerfile){
		this.jpanel1  = jpanel1;
		this.jTextField_fileCount = jTextField_fileCount;
		this.jTextField_numberPerfile = jTextField_numberPerfile;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		jpanel1.removeAll();
		showMessage("界面初始化成功！");
		
		fileCount = jTextField_fileCount.getText();
		numberPerfile = jTextField_numberPerfile.getText();
		//检查用户分配方案是否有效
		if(fileCount.equalsIgnoreCase("") || numberPerfile.equalsIgnoreCase("")){
			JOptionPane.showMessageDialog(null, "分配方案无效，请检查后重设！", "警告", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		//开始分配靓号号码池---方法1
//		PhonePoolDistribute rp = new PhonePoolDistribute();
//		rp.service(Integer.parseInt(fileCount), Integer.parseInt(numberPerfile));
		
		//开始分配靓号号码池---方法2
		PhonePoolDistribute rp = new PhonePoolDistribute();
		ThreadDistribute td = new ThreadDistribute(rp, Integer.parseInt(fileCount), Integer.parseInt(numberPerfile));
		td.start();
		
		jpanel1.repaint();
	}
	
	/**
	 * 在信息提示板中添加提示信息
	 * */
	public static void showMessage(String message){
		JLabel test = new JLabel(message);
		test.setVisible(true);
		jpanel1.add(test);
		jpanel1.validate();
	}
}
