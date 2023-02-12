package task1;

import java.io.*;
import java.net.*;

public class UdpServer {
    public static void main(String args[]) throws Exception {
// open datagram socket on port 9876
        DatagramSocket sock = new DatagramSocket(9876);
// create two packets sharing a common buffer
        byte[] buf = new byte[1000];
        DatagramPacket inPkt = new DatagramPacket(buf, buf.length);
        DatagramPacket outPkt = new DatagramPacket(buf, buf.length);
        while (true) {
            sock.receive(inPkt);
            System.out.println("Recevied...");
            outPkt.setAddress(inPkt.getAddress());
            outPkt.setPort(inPkt.getPort());
            outPkt.setLength(inPkt.getLength());
            sock.send(outPkt);
            System.out.println("Sent...");
        }
    }
}