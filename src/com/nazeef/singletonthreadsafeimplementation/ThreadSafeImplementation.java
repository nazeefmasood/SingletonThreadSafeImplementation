package com.nazeef.singletonthreadsafeimplementation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.HashMap;



/*
 * CODE AND WORKING EXPLAINATION:
 * -----------------------------------------------------------------------------------------------------------------------------------
 *  In the below basically we are trying to achieve the thread safe Implementation the Thread Safe Implementation
 *  which basically means when we talk about thread we mean that we want this program to perform more than one task 
 *  at the same time so when we are executing the multiple threads at the same time and if they all are sharing the same 
 *  object or data structure then it can lead to the inconsistencies meaning if you run the same method in the multiple threads
 *  it will give you the different results and we want our results to be consistent. So we can prevents this racing of the multiple 
 *  threads by using "synchronized" keyword what it does is that we add a synchronized keyword before declaring the type of function
 *  so what it will do is that when we run the code the java compiler will acquire a lock on the method and will know that which object
 *  this method belongs to, which helps in ensuring that only one thread can execute that method. This helps in preventing the racing 
 *  conditions and inconsistencies. if there are multiple threads who wants to execute the methods they have to wait then when their turn 
 *  they java complier will run the method but will not allow multiple threads to execute the same method at the same time. 
 * -----------------------------------------------------------------------------------------------------------------------------------
 * HELPFULL RESOURCES:  https://www.turing.com/kb/thread-safety-in-java-and-implementation
 * */





public class ThreadSafeImplementation {
    private static ThreadSafeImplementation instance;
    private HashMap<String, String> config = new HashMap<String, String>();

    private ThreadSafeImplementation() {
        loadConfig();
    }

    private synchronized void loadConfig() {
 
        try {
            File file = new File("./src/config.properties");
            FileInputStream fileInput = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fileInput);
            fileInput.close();

            Enumeration<Object> enuKeys = properties.keys();

            while (enuKeys.hasMoreElements()) {
                String key = (String) enuKeys.nextElement();
                String value = properties.getProperty(key);
                config.put(key, value);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized String getValue(String key) {
        String value = null;
        if (config.containsKey(key)) {
            value = config.get(key);
        }
        return value;
    }

    public static synchronized ThreadSafeImplementation getInstance() {
        if (instance == null)
            instance = new ThreadSafeImplementation();
        return instance;
    }
}