
package cn.start.roilat;


public class LongIpVsStringIPUtils {
	//ip long  to String
	 public static String iplongToIp(long ipaddress) {  
	        StringBuffer sb = new StringBuffer("");  
	        sb.append(String.valueOf((ipaddress >>> 24)));  
	        sb.append(".");  
	        sb.append(String.valueOf((ipaddress & 0x00FFFFFF) >>> 16));  
	        sb.append(".");  
	        sb.append(String.valueOf((ipaddress & 0x0000FFFF) >>> 8));  
	        sb.append(".");  
	        sb.append(String.valueOf((ipaddress & 0x000000FF)));  
	        return sb.toString();  
	    } 

	 //string ip to long
	 public static long ipStrToLong(String ipaddress) {  
	        long[] ip = new long[4];
	     int position1 = ipaddress.indexOf(".");  
	        int position2 = ipaddress.indexOf(".", position1 + 1);  
	        int position3 = ipaddress.indexOf(".", position2 + 1);  
	         ip[0] = Long.parseLong(ipaddress.substring(0, position1));  
	         ip[1] = Long.parseLong(ipaddress.substring(position1+1, position2));  
	         ip[2] = Long.parseLong(ipaddress.substring(position2+1, position3));  
	         ip[3] = Long.parseLong(ipaddress.substring(position3+1));  
	        return (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];  
	     } 
	 
	 public static void main(String[] args) {
		 System.out.println(LongIpVsStringIPUtils.iplongToIp(826983146));
		 System.out.println(LongIpVsStringIPUtils.ipStrToLong("49.74.194.234"));
	}
}

