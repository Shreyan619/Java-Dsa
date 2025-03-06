// next greater ele 3

public class lc556 {
    public int nextGreaterElement(int n) {
        char[] ch = Integer.toString(n).toCharArray();
        int len = ch.length;
        int index = -1;
        for (int i = len - 2; i >= 0; i--) {
            if (ch[i] < ch[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return -1;
        }
        for (int i = len - 1; i >= 0; i--) {
            if (ch[i] > ch[index]) {
                swap(ch, i, index);
                break;
            }
        }
        //Reverse the digits after index to get the next smallest permutation
        rev(ch, index + 1, len - 1);
        // Convert back to number and check for integer overflow
        long nextNum = Long.parseLong(new String(ch));
        return (nextNum > Integer.MAX_VALUE) ? -1 :(int) nextNum;
    }

    private void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void rev(char[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
