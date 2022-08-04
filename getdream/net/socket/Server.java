package com.getdream.net.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {


        //创建服务
        ServerSocket serverSocket = new ServerSocket(8888);
        //接受请求连接
        Socket client = null;
        //获取输入内容/输入流 读取客户端信息
        InputStream in = null;
        //创建输出流
        ByteArrayOutputStream byteArrayOutputStream = null;

        while (true) {
            //接受请求连接
            client = serverSocket.accept();
            //获取输入内容/输入流 读取客户端信息
            in = client.getInputStream();
            //创建输出流
            byteArrayOutputStream = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, len);
            }

            System.out.println(byteArrayOutputStream.toString());

            if (client == null) {
                break;
            }
        }


        if (byteArrayOutputStream != null) {
            byteArrayOutputStream.close();
        }

        if (in != null) {
            in.close();
        }

        if (client != null) {
            client.close();
        }

        if (serverSocket != null) {
            serverSocket.close();
        }

    }
}
