package utils;

import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private Properties properties;
    public PropertyReader(){
        try{
            properties = new Properties();
            properties.load(PropertyReader.class.getClassLoader().getResourceAsStream("automation.properties"));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
public String getStringProperty(String propertyName){ return properties.getProperty(propertyName);}
    public int getIntProperty(String propertyName){
        return Integer.valueOf(properties.getProperty(propertyName));
    }
    public double getDoubleProperty(String propertyName){
        return(double)properties.get(propertyName);
    }
}
