package com.task.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    //creating object of Properties, we need this class to use methods like: load(), getProperty("key")
    // it is static because we are using it in static method
    // private because I want to cut access to other classes
   private static Properties properties = new Properties();
    //create the object of FileInputStream
    // we need this object to open file as a stream in java memory
    // we want to open the properties file and load to properties object ONLY ONCE before reading
    // static block always  runs first and once
    // it will open out configuration file in the beginning
    static {
        try{
        FileInputStream file = new FileInputStream("configuration.properties");
        //load properties obj with the file we open using FileInputStream
        properties.load(file);
        //  close the fil after loading, if do not close it will be stays in java memory
            // it will take space from computer memory like Scanner
        file.close();
    }catch(IOException e) {
            e.printStackTrace();
    }
    }
    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }
}
