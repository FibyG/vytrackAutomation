package com.vytrack.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//this class is only created in utilities package. One time for project framework, and it will be called with the class name
public class ConfigurationReader {
    //1. first create an object of Properties class
    //we need properties class in order to use methods that come from that class
    private static Properties properties  = new Properties();//it is static because we use it in the static method and using static block
    //it is private because I want to eliminate access to this class, it only  will be user in this class
    //the properties file will be loaded into memory first and only once because it is in the static block
    static {
        try{

        //2. second create an object of FileInputStream
        //we need this object to open file as a stream in Java memory
        FileInputStream file = new FileInputStream("configuration.properties");


        //3. third is to load properties object using FileInputStream object
        //load "properties" object with the "file" we opened using FileInputStream
        properties.load(file);
        file.close();//close file after its loaded. If file is not closed it will take computer memory


    }catch(IOException e) {

        }
    }
    public static String getProperty(String keyword){//this method reads value from configuration.properties file. Keyword --> key name in configuration.property file. Returns value for the  key
        //driver.get(ConfigurationReader.getProperty("env"));
        return properties.getProperty(keyword);
    }

    }

