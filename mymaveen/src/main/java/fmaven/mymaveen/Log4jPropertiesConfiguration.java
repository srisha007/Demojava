package fmaven.mymaveen;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jPropertiesConfiguration {

	static Logger logger = Logger.getLogger(Log4jPropertiesConfiguration.class);
    public static void main(String[] args)
    {
        //PropertiesConfigurator is used to configure logger from properties file
        PropertyConfigurator.configure("C:\\Users\\SONY\\workspace\\mymaveen\\src\\main\\resources\\log4j.properties");
 
        //Log in console in and log file
        logger.debug("Log4j appender configuration is successful !!");
    }
}
