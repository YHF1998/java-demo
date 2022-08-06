package com.getdream.net.tcpUpload;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务端-文件接收
public class Server {
    public static void main(String[] args) throws IOException {
        //监听端口
        ServerSocket serverSocket = new ServerSocket(8888);

        //接受客户端请求-如果没有客户端连接，会一直是阻塞状态
        Socket socket = serverSocket.accept();

        //获取输入流
        InputStream inputStream = socket.getInputStream();

        //定义输出流
        FileOutputStream fileOutputStream = new FileOutputStream("2.jpg");

        //读取输入流文件
        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1) {
            fileOutputStream.write(buffer, 0, len);
        }

        //获取连接输出流
        OutputStream socketOutputStream = socket.getOutputStream();
        socketOutputStream.write("已经成功接收".getBytes());


        socketOutputStream.close();
        fileOutputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
