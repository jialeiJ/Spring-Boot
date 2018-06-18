package spring.boot.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CloneUtil implements Cloneable,Serializable {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws IOException {
		
		String str = "abcdefghijklmn";
		System.out.println(str.indexOf("a"));
		
		
		// TODO Auto-generated method stub  
		CloneUtil sc1 = new CloneUtil(1, "sc1Name");  
		CloneUtil sc2 = (CloneUtil)sc1.clone();
        System.out.println("sc1's id: " + sc1.id + "\tsc2's id: " + sc2.id);  
        System.out.println("sc1's name: " + sc1.name + "\tsc2's name: " + sc2.name);  
        System.out.println(sc1.name == sc2.name);  
        System.out.println(sc1.name.equals(sc2.name));
        System.out.println(sc1.id == sc2.id);  
        System.out.println(sc1.id.equals(sc2.id));
		
	}
	public Integer id;  
    public String name;
      
    public CloneUtil(int id, String name){  
        this.id = id;  
        this.name = name;  
    }  
    //深克隆
    @Override
    public Object clone(){
    	ByteArrayOutputStream bos = null;
    	ObjectOutputStream oos = null;
    	ObjectInputStream ois = null;
    	try {
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(this);
			ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
			return ois.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
    }

    //浅克隆
//	@Override
//	protected Object clone() {
//		try {
//			return super.clone();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
    
}
