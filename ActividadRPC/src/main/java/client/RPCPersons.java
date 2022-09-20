package client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class RPCPersons {
    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        Scanner entrada = new Scanner(System.in);
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        System.out.print("Introduce tu nombre: ");
        String nombre = entrada.nextLine();
        System.out.print("Introduce tu peso: ");
        double peso = entrada.nextDouble();
        System.out.print("Introduce tu altura: ");
        double altura = entrada.nextDouble();
        Object[] data = {nombre,peso,altura};
        String result = (String) client.execute("Methods.imc",data);
        System.out.println(result);
    }
}
