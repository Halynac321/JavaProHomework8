package com.hillel.homework8;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        FileNavigator myFileNavigator = new FileNavigator();
        FileData file1=new FileData("file1",1,"folder1/folder2");
        FileData file2=new FileData("file2",4,"folder1/folder2");
        FileData file3=new FileData("file3",2,"folder1/folder2");
        FileData file4=new FileData("file4",0,"folder1/folder3");
        FileData file5=new FileData("file5",7,"folder1/folder3");
        FileData file6=new FileData("file6",10,"folder1/folder4");
        myFileNavigator.add(file1.getPath(),file1);
        myFileNavigator.add(file2.getPath(),file2);
        myFileNavigator.add(file3.getPath(),file3);
        myFileNavigator.add(file4.getPath(),file4);
        myFileNavigator.add(file5.getPath(),file5);
        myFileNavigator.add(file6.getPath(),file6);
        System.out.println("Testing find");
        ArrayList <FileData> result1= myFileNavigator.find("folder1/folder2");
        for (FileData file: result1){
            System.out.println(file.getName());
        }
        System.out.println("Testing filterBySize");
        ArrayList <FileData> result2= myFileNavigator.filterBySize(5);
        for (FileData file: result2){
            System.out.println(file.getName());
        }
        System.out.println("Testing sortBySize");
        ArrayList <FileData> result3= myFileNavigator.sort();
        for (FileData file: result3){
            System.out.println(file.getName());
        }
        System.out.println("Testing remove");
        myFileNavigator.remove("folder1/folder2");
        ArrayList <FileData> result4= myFileNavigator.sort();
        for (FileData file: result4){
            System.out.println(file.getName());
        }

    }


}