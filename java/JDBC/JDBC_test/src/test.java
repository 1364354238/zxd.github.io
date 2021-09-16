import java.util.Arrays;

/**
 * @author dzx
 * @data 2021/9/11 -16:35
 */
public class test {
    public static void main(String[] args) {

        int [][]a=new int[][]{{1,2},{2,3}};
        Arrays.sort(a,(b, c)->c[0]-b[0]);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i][0]);
            System.out.println(a[i][1]);
        }
    }
}
