import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String lex, sep;
        String P;
        System.out.print("Введите строку лексем: ");
        lex=sc.nextLine();
        System.out.print("Введите строку разделителей: ");
        sep=sc.nextLine();
        String[] mas=splitLex(lex,sep);
        StringBuffer strBuf=new StringBuffer();
        ArrayList<String> words = new ArrayList<String>();
        ArrayList<String> numberWords = new ArrayList<String>();
        for(String a:mas)
        {
            if(!a.equals(""))
            {
                strBuf.append(a);
                strBuf.append(" ");
                words.add(a);
            }
        }
        String str =String.format("Строка лексем без разделителей с пробелами между лексемами %s", strBuf);
        System.out.println(str);
        System.out.println("Лексемы в двоичной системе");
        selectNumbers(words, numberWords);
        for(String a:numberWords)
            System.out.print(a+" ");
        System.out.println();
        printNotPalindromes(numberWords);
        System.out.print("Введите число P для поиска среди бинарных лексем: ");
        P=sc.nextLine();
        if(findP(numberWords,lex,P)!=-1)
        {
            System.out.println("В исходной строке оно начинается на позиции "+(findP(numberWords,lex,P)+1)+
                    "(позиции начинаются с 1)");
        }
        else
        {
            System.out.println("Такого числа среди бинарных лексем нет!");
        }
        //str =String.format("Строка лексем без разделителей с пробелами между лексемами %s", strBuf);
        //System.out.println(str);
        dublMaxNumber(numberWords, words);
        words.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(CountDigits(o1)>CountDigits(o2))
                    return 1;
                if(CountDigits(o1)==CountDigits(o2))
                    return 0;
                else
                    return -1;
            }
        });
        System.out.println("Строка лексем отсортированная по количеству цифр в лексемах:");
        for(String a:words)
            System.out.print(a+" ");
    }
    static String[] splitLex(String lex, String sep)
    {
        //String[] mas={"0","1","2"};
        String[] mas = new String[1];
        if(sep.length()==1 && lex.indexOf(sep)!=-1)
        {
            boolean more_than_one=false;
            for(int i=0;i<lex.length()-1;i++)
            {
                if((lex.charAt(i) == sep.charAt(0)) && (lex.charAt(i) == lex.charAt(i + 1)))
                {
                    more_than_one = true;
                    break;
                }
            }
            if(!more_than_one)
            {
                System.out.println("Используется String.split");
                mas=lex.split(sep);
                return mas;
            }
        }
            StringTokenizer st = new StringTokenizer(lex, sep);
            int count=st.countTokens();
            System.out.println("Используется StringTokenizer");
            System.out.println("Количество токенов в строке лексем "+count);
            mas=new String[count];
            for(int i=0;i<count;i++) {
                mas[i]=st.nextToken();
            }
        return mas;
    }
    static void selectNumbers(ArrayList<String> words, ArrayList<String> numberWords)
    {
        for(String a:words)
        {
            if(isBinaryNumeric(a))
                numberWords.add(a);
        }
    }
    static boolean isBinaryNumeric(String str) {
        return Pattern.matches("([0-1]+)", str);
    }

    static boolean isPalindrome(String str)
    {
        for(int i=0;i<str.length()/2;i++)
            if(str.charAt(i)!=str.charAt(str.length()-1-i))
                return false;
        return true;
    }
    static void printNotPalindromes(ArrayList<String> numberWords)
    {
        boolean allPalindromes = true;
        for(String a:numberWords)
            if(!isPalindrome(a))
            {
                allPalindromes=false;
                break;
            }
        if(!allPalindromes)
        {
            StringBuffer strBuf=new StringBuffer();
            for(String a:numberWords)
            {
                if(!isPalindrome(a))
                {
                    strBuf.append(a);
                    strBuf.append(" ");
                }
            }
            String str =String.format("Лексемы-числа, не являющиеся палиндромами %s", strBuf);
            System.out.println(str);
        }
    }

    static int findP(ArrayList<String> numberWords, String lex, String P)
    {
        boolean haveP = false;
        for (String a : numberWords) {
            if (a.equals(P)) {
                haveP = true;
                break;
            }
        }
        if(haveP)
        {
            return lex.indexOf(P);
        }
        else
            return -1;
    }

    static void dublMaxNumber(ArrayList<String> numberWords, ArrayList<String> words)
    {
        int max=-1;
        for (String a : numberWords) {
            if(Integer.parseInt(a)>max)
                max=Integer.parseInt(a);
        }
        if(!numberWords.isEmpty())
        {
            words.add(0,String.valueOf(max));
        }
        System.out.print("Строка лексем с продублированным максимальным числом в начале ");
        for(String a:words)
            System.out.print(a+" ");
        System.out.println();
    }
    static int CountDigits(String str)
    {
        int count=0;
        for(int i=0; i<str.length();i++)
        {
            if(Pattern.matches("([0-9])", String.valueOf(str.charAt(i))))
                count++;
        }
        return count;
    }

}