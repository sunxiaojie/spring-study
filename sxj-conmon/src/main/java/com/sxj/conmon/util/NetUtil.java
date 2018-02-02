package com.sxj.conmon.util;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
/**
 * @author SXJ
 * @Date 2017年8月23日
 */
public class NetUtil {

	private static Set<String> noIpAddress = new HashSet<>();
	
	static{
		noIpAddress.add("127.0.0.1");
		noIpAddress.add("192.168.56.1");
	}
	
	public static String getLocalIp() {
		
		String localIP="127.0.0.1";
		try {
			Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
			while (enumeration.hasMoreElements()) {
			    NetworkInterface networkInterface = enumeration.nextElement();
			    if (networkInterface.isUp()) {
			        Enumeration<InetAddress> addressEnumeration = networkInterface.getInetAddresses();
			        while (addressEnumeration.hasMoreElements()) {
			        	InetAddress address = addressEnumeration.nextElement();
			        	if(address instanceof Inet4Address){
			        		localIP = address.getHostAddress();
			        		if(!noIpAddress.contains(localIP)){
			        			return localIP;
			        		}
			        	}
			        }
			    }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return localIP;
	}
	
}
