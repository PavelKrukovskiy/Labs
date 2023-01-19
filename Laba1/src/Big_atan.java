import java.math.BigDecimal;
import java.math.RoundingMode;

public class Big_atan {

    public BigDecimal calculation(BigDecimal x, int k) {
        BigDecimal ten = new BigDecimal("10");
        BigDecimal MONED = new BigDecimal("-1");
        BigDecimal ONED = new BigDecimal("1");
        BigDecimal e= BigDecimal.valueOf(1,k);

        //System.out.println(e);
        BigDecimal sum = new BigDecimal("0");
        BigDecimal a = x;
        BigDecimal i = new BigDecimal("1");
        BigDecimal ii=i;
        while(true) {
            sum = sum.add(a);
            //System.out.println(a);
            if ((a.abs()).compareTo(e)==-1) {
                break;
            }
            a=a.multiply(MONED);
            a=(a.multiply(x)).multiply(x).multiply(ii);
            ii=ii.add(new BigDecimal("2"));

            a=a.divide(ii, k+100, RoundingMode.DOWN);
            i=i.add(ONED);
        }
        return sum;
    }

}

