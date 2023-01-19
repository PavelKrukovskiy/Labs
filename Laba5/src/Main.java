import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*if(isRight("KB1234567 Московский РУВД Могилев"))
            System.out.println("ДА");
        else
            System.out.println("Нет");
        */
        String s1="input.txt";
        String s2="output.txt";
        ArrayList<String> isRight=new ArrayList<>();
        ArrayList<String> isntRight=new ArrayList<>();
        try{
            BufferedReader buf1=new BufferedReader(new FileReader(s1));
            BufferedWriter buf2=new BufferedWriter(new FileWriter(s2));
            String IS=new String();
            while(true)
            {
                try {
                    if (!((IS=buf1.readLine())!=null))
                        break;
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                if(isRight(IS))
                    isRight.add(IS);
                else isntRight.add(IS);
                //buf2.write(IS);
                //buf2.write('\n');
            }
            if(isRight.isEmpty())
                buf2.write("Правильных выражений нет\n");
            else
            {
                buf2.write("Правильные выражения:\n");
                for(String a:isRight)
                    buf2.write(a+"\n");
            }
            if(isntRight.isEmpty())
                buf2.write("Неправильных выражений нет\n");
            else
            {
                buf2.write("Неправильные выражения:\n");
                for(String a:isntRight)
                    buf2.write(a+"\n");
            }
            buf1.close();
            buf2.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }


    static boolean isRight(String str)
    {
        String regExp = new String(" ?\\d{7} \\D*РУВД ");
        String regExpCities = new String(" ?\\d{7} \\D+РУВД ");
        //MP|KB|HB|KH|BM|AB|
        String obl=new String("MP"+regExpCities+"Минск"+"|"+"KB"+regExpCities+"Могилев"+"|"+
                "HB"+regExpCities+"Гомель"+"|"+"KH"+regExpCities+"Гродно"+"|"+"BM"+regExpCities+"Витебск"+"|"+
                "AB"+regExpCities+"Брест"+"|"+"|"+"PP"+regExp+"\\D+"+"|"+"MP|KB|HB|KH|BM|AB|MC"+regExp+
                "(?!(Минск|Могилев|Гомель|Гродно|Витебск|Брест))\\D+");
        return str.matches(String.valueOf(obl));
    }
}