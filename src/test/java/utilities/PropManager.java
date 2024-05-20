package utilities;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class PropManager {

    public static String getProperties(String environment, String propertyName) {

    String propFilePath = environment + ".properties";

    try (InputStream input = PropManager.class.getClassLoader().getResourceAsStream(propFilePath)) {

        Properties prop = new Properties();

        //load a properties file from class path, inside static method
        prop.load(input);

        //get the property value and print it out
        return prop.getProperty(propertyName);


    } catch (IOException ex) {
        ex.printStackTrace();
        return null;
    }


}
}
