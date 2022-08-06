package com.getdream.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) throws Exception {
        //构建
        DatagramSocket datagramSocket = new DatagramSocket(9000);

        //创建接收体
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

        //接收
        datagramSocket.receive(packet);

        //打印数据
        System.out.println(packet.getAddress());
        System.out.println(new String(packet.getData()));

        datagramSocket.close();
    }
}
