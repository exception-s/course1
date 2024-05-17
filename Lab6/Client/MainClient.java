package Client;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainClient {
    public static void main(String[] args) {
        try {
            Client client = new Client(InetAddress.getByName("localhost"), 52829);
            client.initialize();
        } catch (UnknownHostException e) {
            System.out.println("Хост не распознан.");
        }
    }
}
