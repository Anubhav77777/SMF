package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class readPropertiesFile {

	public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("\\home\\anubhav\\eclipse-workspace\\seleniumsmf\\src\\test\\resources\\config.properties");
          Properties p = new Properties();
          p.load(fr);
          
	}

}
