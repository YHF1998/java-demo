package com.getdream.net.udpIm;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

//im聊天-消息接收方
public class Receive {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(6666);


        while (true) {
            //读取传过来的内容
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
            socket.receive(packet);//阻塞式接收包

            //断开连接
            byte[] data = packet.getData();
            //String receiveData = new String(data, 0, packet.getLength());
            String receiveData = new String(data, 0, data.length);

            System.out.println(receiveData);

            if (receiveData.equals("bye")) {
                break;
            }
        }

        socket.close();

    }
}
