package co.edu.usa.adf.logica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Leer {

	public static String string() throws IOException{
		return new BufferedReader(new InputStreamReader(System.in)).readLine();
	}
	
	public static int integer() throws IOException{
		return Integer.parseInt(string());
	}
	
	public static boolean bool() throws IOException{
		return Boolean.parseBoolean(string());
	}
	
	public static double doub() throws IOException{
		return Double.parseDouble(string());
	}
	
	public static long lon() throws IOException{
		return Long.parseLong(string());
	}
	
	public static float flo() throws IOException{
		return Float.parseFloat(string());
	}
	
	public static Date date() throws Exception{
		return new SimpleDateFormat("yyyy-MM-dd-hh-mm").parse(string());
	}
}
