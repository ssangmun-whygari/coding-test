class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int st = 0;
        int ed = numbers.length - 1;
        int sum = 10000;

        while (st < ed) {
            int curVal = numbers[st] + numbers[ed];
            if (curVal == target) {
                break;
            } else if (curVal < target){
              st++;
            } else if (curVal > target) {
              ed--;
            }
        }

        return new int[] {st + 1, ed + 1};
    }
}
