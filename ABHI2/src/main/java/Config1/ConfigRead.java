package Config1;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;



public class ConfigRead {
	
	public static  void getproperties() throws IOException {
		Properties prop=new Properties();
		String fileName = ".\\Configurationfile\\data.properties";
		 FileInputStream fis=new FileInputStream(fileName);
		 prop.load(fis);
		 String browserName=prop.getProperty("browser");
		 String URL=prop.getProperty("url");
		 System.out.println(browserName);
		 SingletonClass.browserName=browserName;
			SingletonClass.URL=URL;

}
}