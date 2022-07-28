package com.getdream.demo.file.d01;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        //File file = new File(".\\files" + File.separator + "aa.txt");
        //try {
        //    file.getParentFile().mkdirs();
        //    if (file.createNewFile()) {
        //        // 文件创建成功:
        //        // TODO:
        //
        //    }
        //    //if (file.delete()) {
        //    //    // 删除文件成功:
        //    //}
        //} catch (Exception e) {
        //    System.out.println(e.getMessage());
        //}

        Path p1 = Paths.get(".", "project", "study");
        System.out.println(p1);
        Path p2 = p1.toAbsolutePath();
        System.out.println(p2);
        Path p3 = p1.normalize();
        System.out.println(p3);
        File f = p3.toFile();
        System.out.println(f);

    }
}
