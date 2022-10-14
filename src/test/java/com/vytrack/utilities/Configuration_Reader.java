package com.vytrack.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration_Reader {

    private static Properties properties = new Properties();

    static {  // We want to open the properties file and loa properties object ONLY ONCE before reading
        // static block runs first
        try {
            // 2. Create the object of FileInputStream
            // We need this object to open the file as a stream in Java memory
            FileInputStream file = new FileInputStream("configuration.properties");

            // 3. Load the properties object using  FileInputStream object
            // Load "properties" object with the "file" we opened using  FileInputStream
            properties.load(file);
            file.close(); //  close the file after loading, if we don't close the file, it will take space from computer memory

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getProperty(String keyword) {
        return properties.getProperty(keyword);
    }
}
