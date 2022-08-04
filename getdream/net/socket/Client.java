package com.getdream.net.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        //与服务端建立连接
        Socket socket = new Socket("127.0.0.1", 8888);
        //获取输出流
        OutputStream outputStream = socket.getOutputStream();

        //发送消息
        outputStream.write("测试客户端向服务端发送消息".getBytes());

        outputStream.close();
        socket.close();
    }
}
