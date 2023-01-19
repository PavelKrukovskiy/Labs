import java.io.*;
import java.math.BigDecimal;
import java.text.*;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Введите аргумент: arctan ");
        Scanner sc = new Scanner(System.in);
        BigDecimal x = new BigDecimal(sc.next());
        System.out.println("Введите точность вычислений(число k) ");
        int k = sc.nextInt();

        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(k+1);

        Big_atan s1 = new Big_atan();
        System.out.println(("BigDecimal_atan --- ")+formatter.format(s1.calculation(x,k)));
        System.out.println(("Math.atan       --- ")+formatter.format(Math.atan(x.doubleValue())));
    }
}

class Teylor_atan{

    public double calculation(double x,int k) {
        double sum=0;
        double a = x;
        double e = Math.pow(10, (-k));
        int i = 1;
        while(true) {
            sum = sum + a;
            //System.out.println(sum);
            if (Math.abs(a) < e)
                break;
            a=(a*(-1.0)*Math.pow(x,2)*((i-1.0)*2.0+1.0))/(i*2.0+1.0);
            i++;
        }
        return sum;
    }
}

/*public class Main

   { public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.println("Введите аргумент: arctan ");
        //double x = Double.parseDouble(br.readLine());
        Scanner sc = new Scanner(System.in);
        BigDecimal x = new BigDecimal(sc.next());
        //System.out.println(xy);
        System.out.println("Введите точность вычислений(число k) ");
        //BigInteger k = new BigInteger(sc.next());
        int k = Integer.parseInt(br.readLine());
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(k+1);
        Big_atan s1 = new Big_atan();
        //System.out.println(("Teylor_atan --- ")+formatter.format(s1.calculation(x,k)));
        //Teylor_atan s1 =new Teylor_atan();
        System.out.println(("Teylor_atan --- ")+formatter.format(s1.calculation(x,k)));
        System.out.println(("Math.atan   --- ")+formatter.format(Math.atan(x.doubleValue())));
    }
    }
*/

