package com.hillel.homework8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Hashtable;

public class FileNavigator {
    Hashtable<String, ArrayList <FileData>> filesList = new Hashtable<>();

    public void add(String pathKey, FileData file) {
        if (!pathKey.equals(file.getPath())) {
            System.out.println("Має бути помилка, оскільки шлях-ключ і шлях до файлу не співпадають!");
            return;
        }
        ArrayList <FileData>myArray;
        if (filesList.containsKey(pathKey)) {
            myArray= filesList.get(pathKey);
        }
        else {
            myArray = new ArrayList<FileData>();
            filesList.put(pathKey,myArray);
        }
        myArray.add(file);
    }

    public ArrayList find (String pathKey) {
        ArrayList <FileData> myArray= filesList.get(pathKey);
        return myArray;
    }

    public ArrayList filterBySize (int size) {
        ArrayList <FileData> result = new ArrayList<FileData>();
        for (String keyPath:filesList.keySet()) {
            ArrayList <FileData> myArray = filesList.get(keyPath);
            for (FileData file: myArray){
                if (file.getSize() <= size) result.add(file);
            }

        }
        return result;
    }

    public void remove (String pathKey) {
        filesList.remove(pathKey);
    }

    public ArrayList <FileData> sort () {
        ArrayList <FileData> allFiles = new ArrayList<FileData>();
        for (String keyPath:filesList.keySet()) {
            ArrayList<FileData> myArray = filesList.get(keyPath);
            allFiles.addAll(myArray);
        }
        allFiles.sort(Comparator.comparing(FileData::getSize));
        return  allFiles;
    }

}
