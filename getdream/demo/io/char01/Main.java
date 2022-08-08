package com.getdream.demo.io.char01;

import java.io.*;

//字符缓冲流
public class Main {
    public static void main(String[] args) throws IOException {

        File directory = new File("");//参数为空 
        String courseFile = directory.getCanonicalPath() ;
        System.out.println(courseFile);
        
        FileOutputStream fileOutputStream = new FileOutputStream("src/com/getdream/demo/io/char01/1.txt", true);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        
        outputStreamWriter.write("sadfsfsafasf");
        outputStreamWriter.flush();
        outputStreamWriter.close();
        fileOutputStream.close();
        
    }
}
