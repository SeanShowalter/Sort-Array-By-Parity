
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] myArray = new int[]{1,2,2,4,3,6,7,8,9,10,11,23,34,45};
        int[] sortedArray = Solution.sortArrayByParity(myArray);
        System.out.println(Arrays.toString(sortedArray));
    }
}