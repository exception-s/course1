package Client;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        try {
            // Client client = new Client(InetAddress.getByName("helios.cs.ifmo.ru"), 2829);  // helios
            Client client = new Client(InetAddress.getByName("localhost"), 52829); // localhost
            client.initialize();
        } catch (UnknownHostException e) {
            System.out.println("Хост не распознан.");
        }
    }
}
