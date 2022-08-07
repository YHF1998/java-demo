package com.getdream.net.udpImThread;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

//接收
public class Receive implements Runnable {
    DatagramSocket socket = null;

    private int port;
    private String msgFrom;

    public Receive(int port, String msgFrom) {
        this.port = port;
        this.msgFrom = msgFrom;
        try {
            this.socket = new DatagramSocket(this.port);
        } catch (SocketException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        while (true) {
            try {
                byte[] container = new byte[1024];
                //接收传过来的数据
                DatagramPacket packet = new DatagramPacket(container, 0, container.length);

                socket.receive(packet);

                byte[] data = packet.getData();
                String receiveData = new String(data, 0, data.length);

                //输出内容
                System.out.println(this.msgFrom + ": " + receiveData);

                if (receiveData.equals("bye")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.socket.close();
    }
}
