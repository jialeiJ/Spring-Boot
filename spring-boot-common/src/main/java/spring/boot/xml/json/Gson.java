package spring.boot.xml.json;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Gson {

	public static void main(String[] args) {
		
		String jsonStr = "{\"JACKIE_ZHANG\":\"张学友\",\"ANDY_LAU\":\"刘德华\",\"LIMING\":\"黎明\",\"Aaron_Kwok\":\"郭富城\"}" ;  
        //做5次测试  
        for(int i=0,j=5;i<j;i++)  
        {  
            JsonObject jsonObject = (JsonObject) new JsonParser().parse(jsonStr);  
            for(java.util.Map.Entry<String,JsonElement> entry:jsonObject.entrySet()){  
                System.out.print(entry.getKey()+"-"+entry.getValue()+"\t");  
            }  
            System.out.println();//用来换行  
        }  

	}

}
