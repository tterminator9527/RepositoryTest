package FileHandler;

import gui.DestFolderSel;
import gui.StartWork;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

public class FileWriteHandler {
	public static File destSaveDir;
	private static String timeString;
	
	public static void writeDistributeResult2File(String flag, ArrayList<ArrayList<String>> result){
		destSaveDir = DestFolderSel.destFolder;
		System.out.println("分配结果保存目录：	" + destSaveDir.getName());
		System.out.println("分配结果保存目录：	" + destSaveDir.getAbsolutePath());
		String fileName = "";
		File eachFile;
		BufferedWriter bw = null;
		timeString = (new SimpleDateFormat("MM-dd-HH-mm-ss-")).format(new Date());
		
		for(int i = 0; i < result.size(); i++){
			ArrayList<String> item = result.get(i);
			
			//创建保存分配结果的文件
//			fileName = flag + (i + 1) + ".csv";
			
			fileName = flag + timeString + (i + 1) + ".csv";
			eachFile = new File(destSaveDir.getAbsolutePath() + File.separator + fileName);
			if(eachFile.exists()){
				JOptionPane.showMessageDialog(null, "同名文件已存在，请重新选择目录后重新分配！", "警告", JOptionPane.ERROR_MESSAGE);
				return;
			}else{
				try {
					eachFile.createNewFile();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "创建保存分配结果的文件失败，请重新选择目录后重新分配！", "警告", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			
			//把分配结果保存到文件中
			try {
				bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(eachFile), "gb2312"));
				for(int j = 0; j < item.size(); j++){
					bw.write(item.get(j) + "\r\n");
				}
				bw.flush();
//				StartWork.showMessage("第" + (i + 1) + "组结果保存到文件成功!");
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					bw.close();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "保存分配结果的文件关闭失败，请重新分配！", "警告", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		}
	}
	
	public static void writerRemainResult2File(String flag_prefix, String flag_suffix, ArrayList<String> remainResult){
		destSaveDir = DestFolderSel.destFolder;
		System.out.println("号码池剩余分配结果保存目录：	" + destSaveDir.getName());
		System.out.println("号码池剩余分配结果保存目录：	" + destSaveDir.getAbsolutePath());
		String fileName = "";
		File eachFile;
		BufferedWriter bw = null;
		
		//创建保存分配结果的文件
//		fileName = flag + ".csv";
		fileName = flag_prefix + timeString + flag_suffix + ".csv";
		eachFile = new File(destSaveDir.getAbsolutePath() + File.separator + fileName);
		if(eachFile.exists()){
			JOptionPane.showMessageDialog(null, "同名文件已存在，请重新选择目录后重新分配！", "警告", JOptionPane.ERROR_MESSAGE);
			return;
		}else{
			try {
				eachFile.createNewFile();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "创建保存分配结果的文件失败，请重新选择目录后重新分配！", "警告", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		
		//把号码池剩余分配结果保存到文件中
			try {
				bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(eachFile), "gb2312"));
				for(int i = 0; i < remainResult.size(); i++){
					bw.write(remainResult.get(i) + "\r\n");
				}
				bw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					bw.close();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "保存分配结果的文件关闭失败，请重新分配！", "警告", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
//		StartWork.showMessage("号码池剩余分配结果保存到文件成功!");
	}
}
