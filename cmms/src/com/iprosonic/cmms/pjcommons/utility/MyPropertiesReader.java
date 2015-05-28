package com.iprosonic.cmms.pjcommons.utility;
import java.io.InputStream;
import java.util.Properties;

public class MyPropertiesReader {
    String propValue;
    public MyPropertiesReader() {
    }
    public String getFilePath(String PropertyName) {
        InputStream inputStream = this.getClass().getClassLoader()
        .getResourceAsStream("com/iprosonic/cmms/pjcommons/utility/ApplicationResource.properties");
        try {
            Properties properties = new Properties();            
            properties.load(inputStream);
            propValue = properties.getProperty(PropertyName);           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return propValue;
    }
}
