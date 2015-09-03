package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PhoneDisUI extends Frame {
	
	private static final long serialVersionUID = 1L;

	public PhoneDisUI() throws HeadlessException {
		this.setTitle("靓号随机分配系统");
		this.setResizable(false);
		this.setSize(600, 450);
		this.setVisible(true);
		this.setLocationRelativeTo(null);//使界面处于屏幕中央
	}

	public static void main(String[] args) {
		PhoneDisUI pdui = new PhoneDisUI();//创建出基本的界面
		pdui.setColseWindow(pdui);//设置关闭按钮动作
		pdui.setDefLayout(pdui);
	}

	public void setColseWindow(Frame f){
		f.addWindowListener(new WindowAdapter(){//重写窗口关闭事件
			@Override
	        public void windowClosing(WindowEvent arg0) {
				System.exit(0);
	        }
	    });
	}
	
	public void setDefLayout(Frame f){
		GridBagLayout gblayout = new GridBagLayout();
		f.setLayout(gblayout);
		constructGui(f, gblayout);
	}
	
	public void constructGui(Frame f, GridBagLayout gblayout){
		GridBagConstraints gbc=new GridBagConstraints();  
		/*第一行界面开始*/
		//第一个label
		JLabel lb_src=new JLabel("靓号库池文件：");
		lb_src.setFont(new Font("Serif",Font.BOLD,15));
		setWidgetLayout(gbc,0,0,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(5,5,5,5),0,0);  
        f.add(lb_src,gbc);  
        //第二个textField
        JTextField jTextField_src = new JTextField(160);
        jTextField_src.setBackground(new Color(245,255,250));
        jTextField_src.setEditable(false);// 设置文本域是否为只读状态
        setWidgetLayout(gbc,1,0,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(5,5,5,5),350,6);  
        f.add(jTextField_src,gbc);  
        //第三个选择按钮
        JButton jbt_chooseSource=new JButton("浏览");
        jbt_chooseSource.setBackground(new Color(30, 144, 255));
        setWidgetLayout(gbc,2,0,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(5,5,5,5),0,0);  
        SourceCsvFileSel fileChoose = new SourceCsvFileSel(jTextField_src);
        jbt_chooseSource.addActionListener(fileChoose);
        f.add(jbt_chooseSource,gbc);  
        
        /*第二行界面开始*/
		//第一个label
		JLabel lb_dst=new JLabel("分配结果目录：");
		lb_dst.setFont(new Font("Serif",Font.BOLD,15));
		setWidgetLayout(gbc,0,1,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(5,5,5,5),0,0);  
        f.add(lb_dst,gbc);  
        //第二个textField
        JTextField jTextField_dst = new JTextField(160);
        jTextField_dst.setBackground(new Color(245,255,250));
        jTextField_dst.setEditable(false);// 设置文本域是否为只读状态
        setWidgetLayout(gbc,1,1,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(5,5,5,5),350,6);  
        f.add(jTextField_dst,gbc);  
        //第三个选择按钮
        JButton jbt_chooseDst=new JButton("浏览");
        jbt_chooseDst.setBackground(new Color(30, 144, 255));
        setWidgetLayout(gbc,2,1,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(5,5,5,5),0,0);  
        DestFolderSel fileChoose_dst = new DestFolderSel(jTextField_dst);
        jbt_chooseDst.addActionListener(fileChoose_dst);
        f.add(jbt_chooseDst,gbc);  
        
        /*第三行界面开始*/
        //靓号分多少份
        JLabel lb_fileCount=new JLabel("分配文件个数：");
        lb_fileCount.setFont(new Font("Serif",Font.BOLD,15));
		setWidgetLayout(gbc,0,2,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(5,5,5,5),0,0);  
        f.add(lb_fileCount,gbc); 
        JTextField jTextField_fileCount = new JTextField(10);
        jTextField_fileCount.setBackground(new Color(245,255,250));
        setWidgetLayout(gbc,1,2,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(5,5,5,5),50,6);  
        f.add(jTextField_fileCount,gbc);
        
        /*第四行界面开始*/
        //每份靓号有多少
        JLabel lb_numberPerfile=new JLabel("每文件靓号个数：");
        lb_numberPerfile.setFont(new Font("Serif",Font.BOLD,15));
		setWidgetLayout(gbc,0,3,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(5,5,5,5),0,0);  
        f.add(lb_numberPerfile,gbc); 
        JTextField jTextField_numberPerfile = new JTextField(10);
        jTextField_numberPerfile.setBackground(new Color(245,255,250));
        setWidgetLayout(gbc,1,3,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(5,5,5,5),50,6);  
        f.add(jTextField_numberPerfile,gbc);
        
        /*第五行界面开始*/
        //开始分配靓号
        JButton jbt_startWork=new JButton("开始靓号分配");
        jbt_startWork.setBackground(new Color(30, 144, 255));
        setWidgetLayout(gbc,1,4,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE,new Insets(5,5,5,5),80,6);  
        f.add(jbt_startWork,gbc);  
        
        /*第六行界面开始*/
        //添加一个大的panel
        JPanel  jpanel_msg=new JPanel(); 
        jpanel_msg.setBackground(new Color(245,255,250));
        jpanel_msg.setPreferredSize(new Dimension(300, 200));//关键代码,设置JPanel的大小 
        jpanel_msg.setLayout(new GridLayout(11, 1));//最大显示15条提示信息
        setWidgetLayout(gbc,0,5,3,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(5,5,5,5),100,200);  
        f.add(jpanel_msg,gbc);  
        
        //为“开始靓号分配”按钮添加事件监听器
        StartWork sw = new StartWork(jpanel_msg,jTextField_fileCount,jTextField_numberPerfile);
        jbt_startWork.addActionListener(sw);
        
        //界面绘制结束
        f.repaint();
        f.setVisible(true);
	}

	public void setWidgetLayout(GridBagConstraints gbc, int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty, int anchor, int fill, 
			Insets insets, int ipadx, int ipady) {
		gbc.gridx=gridx;  
        gbc.gridy=gridy;  
        gbc.gridwidth=gridwidth;  
        gbc.gridheight=gridheight;  
        gbc.weightx=weightx;  
        gbc.weighty=weighty;  
        gbc.anchor=anchor;  
        gbc.fill=fill;  
        gbc.insets=insets;
        gbc.ipadx=ipadx; 
        gbc.ipady=ipady;
	}
}
