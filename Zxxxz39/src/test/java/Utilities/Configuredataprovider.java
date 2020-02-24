package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuredataprovider {
	
	
	
	
	
	Properties pro;
public Configuredataprovider(){
File f=new File("./Configure/Config.properties");
try {
	FileInputStream fis=new FileInputStream(f);
	 pro=new Properties();
	pro.load(fis);
} catch (Exception e) {
	System.out.println("unsuccessful"+e.getMessage());

}
}
public String getString(String keytosearch){
	return pro.getProperty(keytosearch);
	
}
public String getBrowser(){
	return pro.getProperty("Browser");
	
}
public String getappurl(){
	return pro.getProperty("appurl");
	
}

}
