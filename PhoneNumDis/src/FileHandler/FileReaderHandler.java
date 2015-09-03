package FileHandler;

import gui.SourceCsvFileSel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileReaderHandler {
	public static File srcPhonePoolFile;
	public static ArrayList<String> phonePoolNum = new ArrayList<String>();
	
	public static ArrayList<String> readAndValidatePhoneNumber(){
		srcPhonePoolFile = SourceCsvFileSel.phoneNumberSrcFile;
		System.out.println("号码池源文件：	" + srcPhonePoolFile.getName());
		BufferedReader br = null;
		try {
			String lineData = "";
			br = new BufferedReader(new InputStreamReader(new FileInputStream(srcPhonePoolFile), "gb2312"));
			while((lineData = br.readLine()) != null){
				phonePoolNum.add(lineData);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return phonePoolNum;
	}
}
