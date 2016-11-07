package com.siddhartharya.doitnow;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siddharth Arya on 07-Nov-16.
 */
public class DataSupplier {
    public static ArrayList<Task> tasks = new ArrayList<>();


    public static void readData(Context context) {
        try {
            FileInputStream fis = context.openFileInput("data");
            ObjectInputStream ois = new ObjectInputStream(fis);
            tasks = (ArrayList<Task>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeData(Context context) {
        try {
            FileOutputStream fos = context.openFileOutput("data", Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(tasks);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
