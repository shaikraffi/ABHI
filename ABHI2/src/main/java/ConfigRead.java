import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import Config1.SingletonClass;

public class ConfigRead {

	public static void main(String[] args) throws Exception {
		Properties prop = new Properties();
	    String fileName = ".\\Configurationfile\\data.properties";
	    InputStream is = new FileInputStream(fileName);

	    prop.load(is);
	    String browserName=prop.getProperty("browser");
	    System.out.println(browserName);
	    String urlName=prop.getProperty("url");
	    System.out.println(urlName);
	    

	    

	    

	}

}
