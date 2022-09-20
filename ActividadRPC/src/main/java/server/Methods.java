package server;

import java.util.ArrayList;
import java.util.Collections;

public class Methods {
    public String imc (String name,double peso,double altura){
        double IMC = peso/(altura*altura);
        return"Hola "+name+", tu IMC es de: "+ IMC;
    }
    public double addition (double val1, double val2, double val3, double val4){
        return val1+val2+val3+val4;
    }
    public double product (double val1, double val2, double val3, double val4){
        return val1*val2*val3*val4;
    }
    public double prom (double val1, double val2, double val3, double val4){
        return (val1+val2+val3+val4)/4;
    }
    public double addition3 (double val1, double val2){
        double add=0;
        ArrayList<Double> vals= new ArrayList();

        if (val1-val2 >= 0){
            if (val1 != val2){
                while (val1 != val2-1 | val2 > val1){
                    val2+=1;
                    vals.add(val2);
                }
            }
        }else {
            while (val1 != val2-1 | val2 < val1){
                val1+=1;
                vals.add(val1);
            }
        }
        for (double val : vals){
            add += val;
        }
        return add;
    }
    public Object[] order(int val1, int val2, int val3, int val4, int val5){
        ArrayList<Integer> numOrder = new ArrayList<>();
        numOrder.add(val1);
        numOrder.add(val2);
        numOrder.add(val3);
        numOrder.add(val4);
        numOrder.add(val5);
        Collections.sort(numOrder);
        Object a[]= new Object[numOrder.size()];
        int count=0;
        for (int i : numOrder){
            a[count]= i;
            count++;
        }
        return a;
    }
}
