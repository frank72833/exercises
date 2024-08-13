package exercises.arrayandstrings;

// 1004. Max Consecutive Ones III
// Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
// Output: 6
// Explanation: [1,1,1,0,0,1,1,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
public class LongestOnes {
    public int longestOnes(int[] nums, int k) {
        var left = 0;
        var numberOfZero = 0;
        var result = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                numberOfZero++;
            }

            while (numberOfZero > k) {
                if (nums[left] == 0) {
                    numberOfZero--;
                }
                left++;
            }

            var seqLength = right - left + 1;
            result = Math.max(result, seqLength);
        }

        return result;
    }

    public static void main(String[] args) {
        final var sut = new LongestOnes();
        final var result = sut.longestOnes(new int[] {1,1,1,0,0,0,1,1,1,1,0}, 2);

        System.out.println(result);
    }
}
