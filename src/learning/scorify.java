package learning;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class scorify {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("STDIN"));

        int numberOfTests = sc.nextInt();
        
        for (int i = 0; i < numberOfTests; i++) {
            int d = sc.nextInt();
            int [] res = new int [5];
            
            
            for (int j = 0; j < 5; j++) {
                res[j] = sc.nextInt() * d;
            }
            BigInteger re = new BigInteger("0");
            for (int j = 0; j < 5; j++) {
                BigInteger pow = new BigInteger(sc.next());
                re = re.add(new BigInteger(res[j]+"").modPow(pow, new BigInteger("50")));
            }
            
            System.out.println(re.mod(new BigInteger("50")));
            
        }
    }
}
