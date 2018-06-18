package spring.boot.xml.json;

import java.util.Map.Entry;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class FastJson {

	public static void main(String[] args) {
		
		String jsonStr = "[{\"JACKIE_ZHANG\":\"张学友\"},{\"ANDY_LAU\":\"刘德华\"},{\"LIMING\":\"黎明\"},{\"Aaron_Kwok\":\"郭富城\"}]" ;  
        JSONArray jsonArray = JSONArray.parseArray(jsonStr);  
        for(int k=0;k<jsonArray.size();k++){  
            System.out.print(jsonArray.get(k) + "\t");    
        }  
        System.out.println();//用来换行 
        
        
        jsonStr = "{\"name\":\"李明\",\"age\":19}";
        //没有对象直接解析JSON对象 
        JSONObject jsonObject = JSON.parseObject(jsonStr);  
        for(int k=0;k<jsonObject.size();k++){  
            System.out.print(jsonObject.getString("name") + "\t");    
        }  
        System.out.println();//用来换行    
        
        
        jsonStr = "[{\"name\":\"李明\",\"age\":19,\"gender\":\"nv\"},{\"name\":\"张三\",\"age\":12,\"gender\":\"nan\"}]";//"[{\"name\":\"李明\",\"age\":19},{\"name\":\"张三\",\"age\":12}]"
      //没有对象直接解析JSON数组
        JSONArray jarry = JSON.parseArray(jsonStr);
         
        for(int i=0,len=jarry.size();i<len;i++){
            JSONObject jo =  jarry.getJSONObject(i);
            System.out.println("result="+jo.entrySet());
            for( Entry<String, Object> entry:jo.entrySet()){  
                System.out.print(entry.getKey()+"=="+entry.getValue()+"\t");  
            }
            System.out.println();//用来换行    
            System.out.printf("name:%s,age:%d\n",jo.getString("name"),jo.getBigInteger("age"));
        }
         
        for(Object obj:jarry){
            System.out.println(obj.toString());
        }

	}

}
