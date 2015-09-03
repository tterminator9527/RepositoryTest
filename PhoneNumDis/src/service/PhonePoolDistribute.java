package service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

import FileHandler.FileReaderHandler;
import FileHandler.FileWriteHandler;
import gui.StartWork;

public class PhonePoolDistribute {
	public static ArrayList<String> phonePool = new ArrayList<String>();
	static Random rd = new Random(System.currentTimeMillis());//种子一定不能一样，否则每次生成的随机数都一样
	
	public void service(int fileCount, int numberPerfile) {
		
		//从界面接收用户分配要求
		int groupCount = fileCount;
		int numberPerGroup = numberPerfile;
		
		//开始读入靓号池文件到内存
		StartWork.showMessage("正在读取靓号库文件......");
		phonePool.clear();//先清空，否则每次打开程序只能运行一次，此步非常重要
		phonePool = FileReaderHandler.readAndValidatePhoneNumber();
		StartWork.showMessage("靓号库文件读取完毕，共有" + phonePool.size() +"条靓号！");
		System.out.println("靓号库文件读取完毕，共有" + phonePool.size() +"条靓号！");
		
		
		//判断各分组总数是否超出号码池总和
	    if(groupCount * numberPerGroup > phonePool.size()){
	    	System.out.println("各分组总和大于号码池总数，分配方案无效！！！");
	    	JOptionPane.showMessageDialog(null, "各分组总和大于号码池号码总数，分配方案无效！", "警告", JOptionPane.ERROR_MESSAGE);
	    	StartWork.showMessage("各分组总和大于号码池号码总数，分配方案无效，靓号分配已停止！");
	    	return;
	    }else{
	    	StartWork.showMessage("分配方案有效，验证通过!");
	    }
	    	
	    	
		//创建用于存储各组结果的存储结构
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		for(int i = 0; i < groupCount; i++ ){
			ArrayList<String> arraylist = new ArrayList<String>();
			result.add(arraylist);
		}
		
		//创建用于存储号码池分配剩余结果的存储结构
		ArrayList<String> remainResult = new ArrayList<String>();
		
		//开始根据用户指定的分组要求分配靓号号码池
		StartWork.showMessage("正在分配靓号......");
		HashSet<Integer> existHset = new HashSet<Integer>();
		int randomNumber;
		for(int i = 0; i < groupCount; i++){
//			System.out.print("第" + (i+1) + "组靓号序号为:	");
			for(int j = 0; j < numberPerGroup; ){
				randomNumber = rd.nextInt(phonePool.size());
				if(!existHset.contains(randomNumber)){
					existHset.add(randomNumber);
					result.get(i).add(phonePool.get(randomNumber));
//					System.out.print(randomNumber + "	");
					if(j == (numberPerGroup - 1)){
//						StartWork.showMessage("第" + (i+1) + "组靓号分配完毕！");
						System.out.println();
					}
					j++;
				}
			}
		}
		StartWork.showMessage("靓号分配完毕！");
		
		
		//控制台输出各分组结果
//		for(int i = 0; i < result.size(); i++){
//			ArrayList<String> item = result.get(i);
//			System.out.println("第" + (i + 1) + "组分配结果为:");
//			for(int j = 0; j < item.size(); j++){
//				System.out.println(item.get(j));
//			}
//		}
		
		//保存各分组结果到文件
		StartWork.showMessage("正在保存分组结果到文件......");		
		FileWriteHandler.writeDistributeResult2File("靓号分组", result);
		StartWork.showMessage("保存分组结果到文件完成！");	
		
		//控制台输出号码池剩余分配结果
		if(groupCount * numberPerGroup == phonePool.size()){
			System.out.println("号码池分配完毕！");
			StartWork.showMessage("号码池中无靓号剩余,不再保存到文件！");	
			StartWork.showMessage("本次靓号分配全部完成！");	
		}else{
			System.out.println("号码池分配后剩余结果：");
			StartWork.showMessage("正在保存号码池剩余分配结果到文件......");		
			for(int i = 0; i < phonePool.size(); i++){
				if(!existHset.contains(i)){
//					System.out.print(i + "	");
//					System.out.println(phonePool.get(i));
					remainResult.add(phonePool.get(i));
				}
			}
			//保存号码池剩余分配结果到文件
			FileWriteHandler.writerRemainResult2File("靓号分组","号码池剩余分配结果", remainResult);
			StartWork.showMessage("保存号码池剩余分配结果到文件完成！");	
			StartWork.showMessage("本次靓号分配全部完成！");	
			JOptionPane.showMessageDialog(null, "本次靓号分配全部完成！", "信息", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
