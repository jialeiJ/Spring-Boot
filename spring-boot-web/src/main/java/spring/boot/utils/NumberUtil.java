package spring.boot.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 功能描述：数字操作工具类 ，例如将包含逗号的金额字符串转出double ，将double转成千分位等
 * @autor:tianming
 * @date: 2015-8-5
 */
public class NumberUtil {
	/**
	 *  转换为Double类型
	 * @param sdata  String
	 * @return Double
     *   i:小数点后保留位数
	 */
	public final static double strToDouble(String sdata, int i)
	{
		sdata = sdata.trim();
		int k = sdata.indexOf("|");
		if (k>0)
		{
			sdata = sdata.substring(0, k);
		}
		if(sdata == null || sdata.equals("")) 
			sdata = "0.00";
		if (sdata.indexOf(".") == -1) 
			sdata = sdata+".00";
		if (sdata.indexOf(".") == 0) 
			sdata="0"+sdata;
		sdata = sdata + "000000000000";
		if (i == 0)
			sdata = sdata.substring(0,sdata.indexOf("."));
		else if (i < 0) 
			sdata = sdata.substring(0,sdata.indexOf("."));
		else 
			sdata = sdata.substring(0,sdata.indexOf(".")+1+i);

		return Double.parseDouble(sdata);
	}         
   
   /**
   * @描述: 求 double a 保留 n位小数 四舍五入后的值
   * @参数: @param a
   * @参数: @param n
   * @参数: @return 
   * @日期  Mar 22, 2012
   * @作者   段海峰
    */
	public final static double getDouble_sishewuru(double a,int n)
	{
		double num = 0;
		BigDecimal num_tmp=new BigDecimal(String.valueOf(a));
		num = num_tmp.setScale(n,BigDecimal.ROUND_HALF_UP).doubleValue();
		num_tmp = null;
		return num;
	}
	
	/**
   * @描述: 求 double a 保留 2位小数 四舍五入后的值
   * @参数: @param a
   * @参数: @return 
   * @日期  20140808
   * @作者  wxy
    */
	public final static double getDouble_sishewuru(double a) {
		return getDouble_sishewuru(a, 2);
	}
	/**
	 * @描述:将double转换成至少包含2位小数的String型，不是四舍五入，是准确值
	 * @参数: @param a
	 * @参数: @return 
	 * @日期  20140808
	 * @作者  wxy
    */
	public final static String getNumToString(double num_tmp)
	{
		String num = Double.toString(num_tmp);
		
		System.out.println("**(0) String的原始数据为** num_beg= "+num);
	
		/*如果num为空*/
		if(num==null||num.equals(""))
		{
			System.out.println("**(1) String转换成double型数据为** num= "+num);
	
		}
		/*如果num不为空*/
		else
		{
			int num_length = num.length();
			System.out.println("1：num的长度为 num_length= "+num_length);
		
			int a = num.indexOf(".");
			System.out.println("2：小数点所在位置为 a= "+a);
		
			int b = a+1;
			int c = num_length-b;
		
			/*如果小数点不出现在num中*/
			if(a==-1)
			{
				System.out.println("3：小数点不存在与num中 a= "+a);
				num = num+".00";
			}
		/*如果小数点存在于num中*/
		else
			{
				/*如果num最后一位是小数点*/
				int m = num_length - a;
				if(m==1)
				{
					System.out.println("4-1：小数点存在与num中的第 "+b+ "位");
					System.out.println("4-2：小数点是最后一位 ");
					System.out.println("4-3：num中存在 "+c+ "位小数");
				
					num=num+"00";
				}
				/*如果有一位小数*/
			else if(m==2)
				{
					System.out.println("5-1：小数点存在与num中的第 "+b+ "位");
					System.out.println("5-2：存在一位小数 ");
					System.out.println("5-3：num中存在 "+c+ "位小数");
				
					num=num+"0";
				}
				/*如果存在至少二位小数*/
			else
				{
					System.out.println("6-1：小数点存在与num中的第 "+b+ "位");
					System.out.println("6-2：存在至少二位小数 ");
					System.out.println("6-3：num中存在 "+c+ "位小数");
				}
			}
		
		}
		
		System.out.println("**(2) String转换成double型数据为** num_end= "+num);
		return num;
	}
	
	/*将 String 转换成至少包含2位小数的String型，不是四舍五入，是准确值*/
	public final static String getStringToNum_Str(String num)
	{
		
		System.out.println("**(0) String的原始数据为** num= "+num);
	
		/*如果num为空*/
		if(num==null||num.equals(""))
		{
			System.out.println("**(1) String转换成double型数据为** num= "+num);
	
		}
		/*如果num不为空*/
		else
		{
			int num_length = num.length();
			System.out.println("1：num的长度为 num_length= "+num_length);
		
			int a = num.indexOf(".");
			System.out.println("2：小数点所在位置为 a= "+a);
		
			int b = a+1;
			int c = num_length-b;
		
			/*如果小数点不出现在num中*/
			if(a==-1)
			{
				System.out.println("3：小数点不存在与num中 a= "+a);
				num = num+".00";
			}
		/*如果小数点存在于num中*/
		else
			{
				/*如果num最后一位是小数点*/
				int m = num_length - a;
				if(m==1)
				{
					System.out.println("4-1：小数点存在与num中的第 "+b+ "位");
					System.out.println("4-2：小数点是最后一位 ");
					System.out.println("4-3：num中存在 "+c+ "位小数");
				
					num=num+"00";
				}
				/*如果有一位小数*/
			else if(m==2)
				{
					System.out.println("5-1：小数点存在与num中的第 "+b+ "位");
					System.out.println("5-2：存在一位小数 ");
					System.out.println("5-3：num中存在 "+c+ "位小数");
				
					num=num+"0";
				}
				/*如果存在至少二位小数*/
			else
				{
					System.out.println("6-1：小数点存在与num中的第 "+b+ "位");
					System.out.println("6-2：存在至少二位小数 ");
					System.out.println("6-3：num中存在 "+c+ "位小数");
				}
			}
		
		}
		
		System.out.println("**(2) String转换成double型数据为** num_end= "+num);
		return num;
	}
	/**
	 * 
	 * 功能描述：将 String类型的数字 转换成带规定小数位的String
	 * @param num
	 * @return String
	 * @author dongfushuai
	 * @date Oct 16, 2008
	 * @修改日志：
	 */
	public final static String getDoubleToStringValue(String num,int i){
		String numValue = "";
		if(num==null || "".equals(num) || ".".equals(num)){
			numValue = "0.00";
		}
		else{
			int no = num.indexOf("-");
			if(no >= 0) {
				num = num.substring(no);
			}
			double num_tmp = 0.00;
			num_tmp = Double.parseDouble(num);
			numValue = NumberUtil.numToString(num_tmp, i);
		}
		return numValue;
	}
	/**
	 * 
	 * 功能描述：将 Double类型转换为int类型，例2.00 转换成2
	 * @param num
	 * @return int
	 * @author zhouyufei
	 * @date Nov 28, 2008
	 * @修改日志：
	 */
	public final static int doubleToInt(double num){
		String num_tmp = Double.toString(num);
		Double num1 = Double.valueOf(num_tmp);
		int numValue = 0;
		if(num1==null){
			numValue = 0;
		}
		else{
			numValue  = num1.intValue();
		}
		return numValue;
	}
	/**
	 * 
	 * 功能描述：将 String类型的前面带0的整数，例00200 转换成不带0的整数的String型200
	 * @param num
	 * @return String
	 * @author dongfushuai
	 * @date Oct 16, 2008
	 * @修改日志：
	 */
	public final static String getIntStrToStringValue(String num){
		String numValue = "";
		if(num==null || "".equals(num) || ".".equals(num)){
			numValue = "0";
		}
		else{
			//num = getZero(num);
			int no = num.indexOf("-");
			if(no >= 0) {
				num = num.substring(no);
			}
			int num_tmp = 0;
			num_tmp = Integer.parseInt(num);
			numValue = String.valueOf(num_tmp);
		}
		return numValue;
	}
	/**
	 * 
	 * 功能描述：将 String类型2000 转换成带千分位的整数的String型2,000(金额型，后面两位小数)
	 * @param num
	 * @return String
	 * @author lx
	 * @date May 16, 2009
	 * @修改日志：
	 */
	public final static String getIntStrToStringCommafy(String num){
		String numValue = "";
		
		if(num==null || "".equals(num) || ".".equals(num)){
			numValue = "0.00";
		}else {
			num = num.trim();//不能放到if上面，如果num为空的话会报空指针异常
			//num = getZero(num);
			int no = num.indexOf("-");
			if(no >= 0) {
				num = num.substring(no);
			}
			DecimalFormat myformat = new DecimalFormat("#,##0.00");
			double num_tmp = 0.00;
			num_tmp = Double.valueOf(num);
			numValue = String.valueOf(myformat.format(num_tmp));
			myformat = null;
		}
		return numValue;
	}
	/**
	 * 
	 * 功能描述：将 String类型2000 转换成带千分位的整数的String型2,000（整数型，后面没有小数）
	 * @param num
	 * @return
	 * @author zhushuai
	 * @date 2010-10-11
	 * @修改日志：
	 */
	public final static String getIntStrToString(String num){
		String numValue = "";
		
		if(num==null || "".equals(num) || ".".equals(num)){
			numValue = "0";
		}else {
			num = num.trim();//不能放到if上面，如果num为空的话会报空指针异常
			//num = getZero(num);
			int no = num.indexOf("-");
			if(no >= 0) {
				num = num.substring(no);
			}
			DecimalFormat myformat = new DecimalFormat("#,###");
			double num_tmp = 0;
			num_tmp = Double.valueOf(num);
			numValue = String.valueOf(myformat.format(num_tmp));
			myformat = null;
		}
		return numValue;
	}
	/**
	 * 
	 * 功能描述：将 double类型2000 转换成带千分位的整数的String型2,000
	 * @param num
	 * @return String
	 * @author lx
	 * @date May 16, 2009
	 * @修改日志：
	 */
	
	public final static String getIntStrToStringCommafy(double num){
		String numValue = "";
		if("".equals(num)){
			numValue = "0.00";
		} else {
			DecimalFormat myformat = new DecimalFormat("#,##0.00");
			numValue = (String)myformat.format(num);
			myformat = null;
		}
		return numValue;
	}
	/**
	 * 
	 * 功能描述：将 String类型. 转换成带千分位的整数的String型0.00
	 * @param num
	 * @return String
	 * @author lx
	 * @date May 16, 2009
	 * @修改日志：
	 */
	
	public final static String getZero(String num){
		String numValue = num.trim();
		if(".".equals(num)){
			numValue = "0.00";
		}
		return numValue;
	}
	/**
     * 
     * 功能描述：将科学计数法格式的数字d转换为i位小数位的字符串
     * @param d
     * @param i
     * @return 
     * @date 2010-8-27
     */
    
    private static String pNumToString(double d, int i)
    {
        String s = Double.toString(d).trim();
        char ac[] = s.toCharArray();
        String s1 = "";
        int i2 = 0;
        int j = 0;
        do
        {
            if(j >= ac.length)
                break;
            if(ac[j] == 'E' || ac[j] == 'e')
            {
                i2 = j;
                break;
            }
            j++;
        } while(true);
        int l3 = 0;
        j = 0;
        do
        {
            if(j >= ac.length)
                break;
            if(ac[j] == '.')
            {
                l3 = j;
                break;
            }
            j++;
        } while(true);
        if(l3 == 0)
            return s;
        j = 0;
        if(ac[j] == '-')
        {
            s1 = s1 + "-";
            j++;
        }
        if(i2 == 0)
        {
            for(; j < l3; j++)
                s1 = s1 + ac[j];

            if(i == 0)
                return s1;
            s1 = s1 + ".";
            j++;
            if(ac.length - l3 - 1 < i)
            {
                for(; j < ac.length; j++)
                    s1 = s1 + ac[j];

                for(int k = 0; k < i - (ac.length - l3 - 1); k++)
                    s1 = s1 + "0";

                return s1;
            }
            for(; j < l3 + 1 + i; j++)
                s1 = s1 + ac[j];

            return s1;
        }
        if(ac[j + 1] != '.')
            return s;
        if(ac[i2 + 1] == '-')
        {
            int j3 = (new Integer(s.substring(i2 + 2, ac.length))).intValue();
            System.out.println("iEIndex==" + i2 + " iArrayIndex==" + j + " iPowerNum==" + j3);
            s1 = s1 + "0.";
            int j2 = 0;
            int l = 0;
            do
            {
                if(l >= j3 - 1)
                    break;
                s1 = s1 + "0";
                if(++j2 >= i)
                    break;
                l++;
            } while(true);
            if(j2 < i)
                for(; j < i2; j++)
                {
                    if(ac[j] == '.')
                        continue;
                    s1 = s1 + ac[j];
                    if(++j2 >= i)
                        break;
                }

            for(; j2 < i; j2++)
                s1 = s1 + "0";

        } else
        {
            int k3 = (new Integer(s.substring(i2 + 1, ac.length))).intValue();
            if(i2 - j - 1 - 1 <= k3)
            {
                int k2 = i2 - j - 1;
                for(; j < i2; j++)
                    if(ac[j] != '.')
                        s1 = s1 + ac[j];

                for(int i1 = 0; i1 < (k3 - k2) + 1; i1++)
                    s1 = s1 + "0";

                s1 = s1 + ".";
                for(int j1 = 0; j1 < i; j1++)
                    s1 = s1 + "0";

            } else
            {
                int l2 = 0;
                for(; j < i2; j++)
                {
                    if(ac[j] == '.')
                        continue;
                    s1 = s1 + ac[j];
                    if(++l2 >= k3 + 1)
                        break;
                }

                j++;
                s1 = s1 + ".";
                if(i2 - j < i)
                {
                    int i3 = i2 - j;
                    for(; j < i2; j++)
                        s1 = s1 + ac[j];

                    for(int k1 = 0; k1 < i - i3; k1++)
                        s1 = s1 + "0";

                } else
                {
                    for(int l1 = 0; l1 < i; l1++)
                    {
                        s1 = s1 + ac[j];
                        j++;
                    }

                }
            }
        }
        return s1;
    }
    /**
     * 
     * 功能描述：
     * @param d
     * @return
     * @ tianming 
     * @ 2015-8-11
     */
    public static String numToString(double num)
    {
        return pNumToString(num, 2);
    }

    public static String numToString(double d, int i)
    {
        if(i < 0)
            return pNumToString(d, 2);
        else
            return pNumToString(d, i);
    }

    public static String numToString(int i)
    {
        return pNumToString(i, 0);
    }

    public static String numToString(int i, int j)
    {
        if(j < 0)
            return pNumToString(i, 0);
        else
            return pNumToString(i, j);
    }
    /**
     * 
     * 功能描述：根据操作符,返回两个double值之间的关系是否满足对应关系
     * @param amt1 金额1
     * @param inpot 操作符 <、>、=、<=、>=、!=
     * @param amt2 金额2
     * @return
     * @author lifeng
     * @throws Exception 
     * @date 2012-9-24 下午7:56:04
     */
    public static boolean getDoubleEquals(double amt1, String inpot, double amt2) throws Exception{
    	try {
    		//log.debug("amt1:" + amt1);
    		//log.debug("操作符:" + inpot);
    		//log.debug("amt2:" + amt2);
    		if("=".equals(inpot)||"==".equals(inpot)){
    			if(compareDouble(amt1, amt2)==0){
    				return true;
    			} else {
    				return false;
    			}
    		} else if("<".equals(inpot)){
    			if(compareDouble(amt1, amt2)==-1){
    				return true;
    			} else {
    				return false;
    			}
    		} else if(">".equals(inpot)){
    			if(compareDouble(amt1, amt2)==1){
    				return true;
    			} else {
    				return false;
    			}
    		} else if("<=".equals(inpot)){
    			if((compareDouble(amt1, amt2)==-1)||(compareDouble(amt1, amt2)==0)){
    				return true;
    			} else {
    				return false;
    			}
    		}else if(">=".equals(inpot)){
    			if((compareDouble(amt1, amt2)==1)||(compareDouble(amt1, amt2)==0)){
    				return true;
    			} else {
    				return false;
    			}
    		}else if("!=".equals(inpot)){
    			if(compareDouble(amt1, amt2)==0){
    				return false;
    			} else {
    				return true;
    			}
    		}  else {
    			throw new Exception("传入操作符异常");
    		}
    	} catch (Exception e) {
    		//log.error("比较两个double值异常-传入操作符异常", e);
    		e.printStackTrace();
    		throw new Exception("比较两个double值异常-传入操作符异常");
    	} finally {
    		
    	}
    }
    /**
     * 功能描述：比较两个double类型数值的大小(比较前四舍五入保留i位小数)
     * @param amt1 金额1
     * @param amt2 金额2
     * @return amt1<amt2时返回-1，amt1==amt2时返回0，amt1>amt2时返回1
     * @author quanhao
     * @throws Exception 
     * @date 2012-11-16 下午0:47:44
     */
    public static int compareDouble(double amt1, double amt2,int i){
    	amt1 = getDouble_sishewuru(amt1,i);
    	amt2 = getDouble_sishewuru(amt2,i);
    	
    	double comPare = 0.5*Math.pow(10, -i);
    	if (amt1 - amt2 < -comPare) {
    		return -1;
    	} else if (amt1 - amt2 > comPare) {
    		return 1;
    	} else {
    		return 0;
    	}
    	
    }
    /**
     * 功能描述：比较两个double类型数值的大小
     * @param amt1 金额1
     * @param amt2 金额2
     * @return amt1小于amt2时返回-1，amt1==amt2时返回0，amt1>amt2时返回1
     * @author quanhao
     * @throws Exception 
     * @date 2012-11-15 下午23:56:37
     */
    public static int compareDouble(double amt1, double amt2){
    	return compareDouble(amt1,amt2,2);
    }
	
    /**
	 * 提供精确的加法运算。
	 * @param args
	 * @return arg1+arg2+...+argn
	 */
	public static double add(double...args){
		
		BigDecimal result = new BigDecimal("0");
		for(double arg : args){
			BigDecimal temp = new BigDecimal(Double.toString(arg));
			result = result.add(temp);
			temp = null;
		}
		return result.doubleValue();
	}
	
	/**
	 * 提供精确的减法运算。
	 * @param args
	 * @return arg1-arg2-...-argn
	 */
	public static double sub(double...args){
		
		BigDecimal result = new BigDecimal(Double.toString(args[0]));
		
		for(int i=1;i<args.length;i++){
			BigDecimal temp = new BigDecimal(Double.toString(args[i]));
			result = result.subtract(temp);
			temp = null;
		}
		return result.doubleValue();
	}
	
	/**
	 * 提供精确的乘法运算。
	 * @param args
	 * @return arg1*arg2*...argn
	 */
	public static double mul(double...args){
		
		BigDecimal result = new BigDecimal("1");
		
		for(double arg : args){
			BigDecimal temp = new BigDecimal(Double.toString(arg));
			result = result.multiply(temp);
			temp = null;
		}
		return result.doubleValue();
	}
	
	/**
	 * 提供精确的除法运算。
	 * @param args
	 * @return arg1/arg2/.../argn
	 */
	public static double div(double...args){
		
		BigDecimal result = new BigDecimal(Double.toString(args[0]));
		
		for(int i=1;i<args.length;i++){
			BigDecimal temp = new BigDecimal(Double.toString(args[i]));
			result = result.divide(temp,32,BigDecimal.ROUND_HALF_UP);
			temp = null;
		}
		return result.doubleValue();
	}
	
	public static void main(String args[]){
		
		System.out.println( Math.abs(0.3-(0.1+0.2))<0.001);
		
		
	}
}
