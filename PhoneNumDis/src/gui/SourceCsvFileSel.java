package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SourceCsvFileSel implements ActionListener {
	public JTextField jTextField;
	public static File phoneNumberSrcFile;
	
	public SourceCsvFileSel(JTextField jTextField){
		this.jTextField = jTextField;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser jfc=new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
		jfc.showDialog(new JLabel(), "选择");
		File sourceFile=jfc.getSelectedFile();
		if(sourceFile.isDirectory()){
//			System.out.println("文件夹:"+sourceFile.getAbsolutePath());
			JOptionPane.showMessageDialog(null, "靓号库池文件必须是CSV文件，请重新选择", "警告", JOptionPane.ERROR_MESSAGE);
			jTextField.setText("靓号库池文件必须是CSV文件，请重新选择");
			jTextField.setBackground(new Color(255,0,0));
		}else if(sourceFile.isFile()){
//			System.out.println("文件:"+sourceFile.getAbsolutePath());
			jTextField.setText(sourceFile.getAbsolutePath());
			jTextField.setBackground(null);
			phoneNumberSrcFile = sourceFile;
			String fileName = jfc.getSelectedFile().getName();
			if(!fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()).equalsIgnoreCase("csv")){
				JOptionPane.showMessageDialog(null, "靓号库池文件必须是CSV文件，请重新选择", "警告", JOptionPane.ERROR_MESSAGE);
				jTextField.setText("靓号库池文件必须是CSV文件，请重新选择");
				jTextField.setBackground(new Color(255,0,0));
				return;
			}
		}
//		System.out.println(jfc.getSelectedFile().getName());
//		System.out.println(jfc.getSelectedFile().getName().substring(jfc.getSelectedFile().getName().lastIndexOf(".") + 1, jfc.getSelectedFile().getName().length()));
//		System.out.println("靓号库池文件是：" + sourceFile.getAbsolutePath());
	}
}
