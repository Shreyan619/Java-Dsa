
//find peaks
import java.util.*;
import java.util.List;

public class lc2951 {
    public static void main(String[] args) {
        int arr[] = { 1, 4, 3, 5, 6, 8, 4 };
        System.out.println(findPeaks(arr));
    }

    static List<Integer> findPeaks(int[] mountain) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < mountain.length - 1; i++) {
            int start = mountain[i - 1];
            int current = mountain[i];
            int end = mountain[i + 1];
            if (start < current && current > end) {
                list.add(i);
            }
        }
        return list;
    }
}
