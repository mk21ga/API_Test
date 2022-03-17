package ApiRestAssured.ApiFramework;

import java.io.FileInputStream;
import java.util.Properties;

public class Base {
	
	public Properties getGlobalProperty()
	{
		FileInputStream fis;
		try {
			fis = new FileInputStream("src\\test\\java\\resources\\global.properties");
			Properties prop = new Properties();
			prop.load(fis);
			return prop;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	
		
	}

}
