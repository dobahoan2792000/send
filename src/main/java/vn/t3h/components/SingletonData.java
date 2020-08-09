package vn.t3h.components;

import java.util.ArrayList;
import java.util.List;

public class SingletonData {
	public static SingletonData intance = null;
	private List<String> datas = new ArrayList<String>();
	public static SingletonData getIntance()
	{
		if(intance != null) 
			return intance;
		return intance = new SingletonData();
	}
	public void addData(String str)
	{
		datas.add(str);
	}
	public List<String> getDatas(){
		return datas;
	}
	public int checkSize() {
		return datas.size();
	}
}
