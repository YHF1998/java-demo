package com.getdream.net.udp;

import java.net.*;

//使用udp向服务端发送数据
public class Client {
    public static void main(String[] args) throws Exception {
        //构建socket
        DatagramSocket datagramSocket = new DatagramSocket();

        //设置地址和端口
        InetAddress address = InetAddress.getByName("localhost");
        int port = 9000;

        //构建数据
        String msg = "你好，服务器";

        //实例化数据,设置要发送给谁，发送什么信息
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, address, port);

        //发送包
        datagramSocket.send(packet);


        //关闭资源
        datagramSocket.close();
        
    }
}
