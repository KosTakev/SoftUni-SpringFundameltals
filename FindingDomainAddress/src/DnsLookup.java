import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class DnsLookup {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        String webAddress = scanner.nextLine();

        InetAddress[] addresses = InetAddress.getAllByName(webAddress);

        for (InetAddress address : addresses) {
            String domain = address.getCanonicalHostName();
            System.out.printf("%s --> %s [Accessible: %s]\n", address, domain,
                    address.isReachable(2000));
        }
    }
}
