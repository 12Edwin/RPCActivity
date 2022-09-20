package client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class RPCClient {
    static Scanner teclado= new Scanner(System.in);
    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        Double response;
        System.out.println("Ingrese el inciso que desee");
        int opc = teclado.nextInt();
        switch (opc){
            case 1:
                System.out.println("Ingresa tu nombre");
                String nombre= teclado.next();
                System.out.println("Ingresa tu peso");
                double value1= teclado.nextDouble();
                System.out.println("Ingresa tu altura");
                double value2= teclado.nextDouble();
                Object[] num = {nombre,value1,value2};
                String imc = (String) client.execute("Methods.imc",num);
                System.out.println(imc);
                break;
            case 2:
                System.out.println("Ingrese el valor 1");
                double val1= teclado.nextDouble();
                System.out.println("Ingrese el valor 2");
                double val2= teclado.nextDouble();
                System.out.println("Ingrese el valor 3");
                double val3= teclado.nextDouble();
                System.out.println("Ingrese el valor 4");
                double val4= teclado.nextDouble();
                Object[] numbers = {val1,val2,val3,val4};
                Double addition = (Double) client.execute("Methods.addition",numbers);
                Double product = (Double) client.execute("Methods.product",numbers);
                Double prom = (Double) client.execute("Methods.prom",numbers);
                System.out.println("La suma es: "+ addition);
                System.out.println("El producto es: "+ product);
                System.out.println("El promedio es: "+ prom);
                break;
            case 3:
                System.out.println("Ingrese el valor 1");
                val1= teclado.nextDouble();
                System.out.println("Ingrese el valor 2");
                val2= teclado.nextDouble();
                Object[] numbers2 = {val1,val2};
                response = (Double) client.execute("Methods.addition3",numbers2);
                System.out.println("La suma es: "+ response);
                break;
            case 4:
                ArrayList<Object> nums= new ArrayList<>();
                System.out.println("Ingrese el valor 1");
                nums.add(teclado.nextInt());
                System.out.println("Ingrese el valor 2");
                nums.add(teclado.nextInt());
                System.out.println("Ingrese el valor 3");
                nums.add(teclado.nextInt());
                System.out.println("Ingrese el valor 4");
                nums.add(teclado.nextInt());
                System.out.println("Ingrese el valor 5");
                nums.add(teclado.nextInt());

                Object responses[] =(Object[]) client.execute("Methods.order",nums);

                System.out.println("El array ordenado es:");
                for (int i=0; i < responses.length;i++){
                    System.out.print(responses[i]+" ");
                }
                break;
            default:

                break;
        }
    }
}
