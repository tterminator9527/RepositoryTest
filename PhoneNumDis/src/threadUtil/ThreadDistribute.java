package threadUtil;

import service.PhonePoolDistribute;

public class ThreadDistribute extends Thread {
	public PhonePoolDistribute rp;
	public int fileCount;
	public int numberPerfile;
	public ThreadDistribute(PhonePoolDistribute rp, int fileCount, int numberPerfile) {
		this.rp = rp;
		this.fileCount = fileCount;
		this.numberPerfile = numberPerfile;
	}
	@Override
	public void run(){
		rp.service(fileCount, numberPerfile);
	}
}
