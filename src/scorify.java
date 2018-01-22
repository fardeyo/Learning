import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class scorify {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("STDIN"));

        int numberOfTests = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numberOfTests; i++) {
            int DIM = sc.nextInt();

            int[] numbers = new int[DIM];

            //Loading numbers
            for (int j = 0; j < DIM; j++) {
                numbers[j] = sc.nextInt();
            }

            String[][] matrixBits = new String[DIM][DIM];

            for (int j = 0; j < DIM; j++) {
                int mod = (int) (numbers[j] % Math.pow(2, DIM));
                int bitts = Integer.parseInt(Integer.toBinaryString(mod));
                System.out.println(mod+" "+String.format("%0" + DIM + "d", bitts));
            }

            for (int j = 0; j < DIM / 2; j++) {
                if (sc.next().equals("R")) {
                    rotateRight(matrixBits, DIM, j);
                } else {
                    rotateLeft(matrixBits, DIM, j);
                }
            }

            int y = 0;
            for (String[] matrixBit : matrixBits) {
                StringBuilder builder = new StringBuilder();
                System.out.println(matrixBit.length);
                for (String s : matrixBit) {
                    builder.append(s);
                }
                String str = builder.toString();
                System.out.println(str);
//                int decimal = Integer.parseInt(str, 2);
//                String hexStr = Integer.toString(decimal, 16);
//                if (y++ >= DIM - 1) {
//                    System.out.print((leadingZeros(DIM) + hexStr).substring(hexStr.length()).toUpperCase());
//                } else {
//                    System.out.print((leadingZeros(DIM) + hexStr).substring(hexStr.length()).toUpperCase() + "-");
//                }
            }

            System.out.println("");

        }
    }

    public static String leadingZeros(int DIM) {
        StringBuilder bs = new StringBuilder();
        bs.append("0");
        for (int i = 1; i < DIM / 4; i++) {
            bs.append("0");
        }
        return bs.toString();
    }

    public static void rotateRight(String[][] matrix, int n, int first) {
        int last = n - 1 - first;
        for (int i = first; i < last; ++i) {
            int offset = i - first;
            String top = matrix[first][i]; // save top

            // left -> top
            matrix[first][i] = matrix[last - offset][first];

            // bottom -> left
            matrix[last - offset][first] = matrix[last][last - offset];

            // right -> bottom
            matrix[last][last - offset] = matrix[i][last];

            // top -> right
            matrix[i][last] = top; // right <- saved top
        }
    }

    public static void rotateLeft(String[][] matrix, int n, int first) {
        int last = n - 1 - first;
        for (int i = first; i < last; ++i) {
            int offset = i - first;
            String right = matrix[i][last]; // save right

            // bottom -> right
            matrix[i][last] = matrix[last][last - offset];

            // left -> bottom
            matrix[last][last - offset] = matrix[last - offset][first];

            // top -> left
            matrix[last - offset][first] = matrix[first][i];

            // right -> top
            matrix[first][i] = right; // right <- saved top
        }
    }

}
