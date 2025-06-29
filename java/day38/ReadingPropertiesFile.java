package day38;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingPropertiesFile {
	
	public static void main(String[] args)  throws IOException{
		
		//location of properties file 
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\Testdata\\config.properties");
		
		//Loading properties file
		
		Properties propertiesObj = new Properties();
		propertiesObj.load(file);
		
		//Reading data from properties file
		
		String url = propertiesObj.getProperty("appURL");
		String email = propertiesObj.getProperty("email");
		String pwd = propertiesObj.getProperty("password");
		String orderId = propertiesObj.getProperty("orderId");
		String customerId = propertiesObj.getProperty("customerId");
		
		System.out.println(url + " " + email + " " + pwd + " " + orderId + " " + customerId );
	}
}
