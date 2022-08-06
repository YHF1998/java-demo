package com.getdream.net.tcpUpload;

import java.io.*;
import java.net.Socket;

//客户端-文件上传
//因为我还没想好，多文件用什么格式的名字，所以当前仅支持单客户端文件上传
public class Client {
    public static void main(String[] args) throws IOException {
        //建立连接
        Socket socket = new Socket("127.0.0.1", 8888);

        //获取输出流
        OutputStream outputStream = socket.getOutputStream();

        //读取文件
        FileInputStream fileInputStream = new FileInputStream("1.jpg");

        //把文件推送到输出流
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fileInputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
        }

        //通知服务器，已经传输完毕 重要：没有这行代码，服务端会认为你没有传输完，
        //那么永远走不到下面的服务器内容接收
        socket.shutdownOutput();


        //获取连接输入流-接收服务器返回信息
        InputStream socketInputStream = socket.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        //byte[] buffer2 = new byte[1024];
        //int len2;
        while ((len = socketInputStream.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, len);
        }

        System.out.println(byteArrayOutputStream.toString());

        byteArrayOutputStream.close();
        socketInputStream.close();
        fileInputStream.close();
        outputStream.close();

    }
}
