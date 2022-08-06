package com.getdream.net.udpIm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

//im聊天-消息发送方
public class Sender {
    public static void main(String[] args) throws Exception {
        //初始化
        DatagramSocket socket = new DatagramSocket(8888);

        //构建数据-从控制台读取需要发送的数据
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String data = reader.readLine();
            byte[] datas = data.getBytes();
            //构建数据
            DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 6666));

            socket.send(packet);

            //没有用处的代码，只是为了下面的close不报错
            if (packet.equals("")) {
                break;
            }

        }

        reader.close();
        socket.close();
    }
}
