package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DestFolderSel implements ActionListener {
	public JTextField jTextField_dst;
	public static File destFolder;
	
	public DestFolderSel(JTextField jTextField_dst){
		this.jTextField_dst = jTextField_dst;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser jfc=new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
		jfc.showDialog(new JLabel(), "选择");
		File destFile=jfc.getSelectedFile();
		if(destFile.isDirectory()){
//			System.out.println("文件夹:"+destFile.getAbsolutePath());
			jTextField_dst.setText(destFile.getAbsolutePath());
			jTextField_dst.setBackground(null);
			destFolder = destFile;
		}else if(destFile.isFile()){
//			System.out.println("文件:"+destFile.getAbsolutePath());
			JOptionPane.showMessageDialog(null, "存放分配结果的地址必须是目录，请重新选择", "警告", JOptionPane.ERROR_MESSAGE);
			jTextField_dst.setText("存放分配结果的地址必须是目录，请重新选择");
			jTextField_dst.setBackground(new Color(255,0,0));
		}
//		System.out.println(jfc.getSelectedFile().getName());
//		System.out.println("存放结果的目录：" + destFolder);
	}
}
