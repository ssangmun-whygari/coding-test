class Triplet {
  public int x1, x2, x3;

  Triplet(int x1, int x2, int x3) {
    int[] sorted = new int[] {x1, x2, x3};
    Arrays.sort(sorted);
    this.x1 = sorted[0]; this.x2 = sorted[1]; this.x3 = sorted[2];
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Triplet)) return false;

    Triplet other = (Triplet) o;
    return this.x1 == other.x1 && this.x2 == other.x2 && this.x3 == other.x3;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x1, x2, x3);
  }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<Triplet> result = new HashSet<>();
        Arrays.sort(nums);
        for (int f = 0; f < nums.length - 2; f++) {
          int target = nums[f] * -1;
          int st = f + 1;
          int ed = nums.length - 1;
          while (st < ed) {
            if (nums[st] + nums[ed] == target) {
              result.add(new Triplet(nums[f], nums[st], nums[ed]));
              st++;
            } else if (nums[st] + nums[ed] < target) {
              // 증가시켜야 함
              st++;
            } else {
              // 감소시켜야 함
              ed--;
            }
          }
        }
        List<List<Integer>> answer = new ArrayList<>();
        for (Triplet triplet : result) {
          List<Integer> list = new ArrayList<>();
          list.add(triplet.x1);
          list.add(triplet.x2);
          list.add(triplet.x3);
          answer.add(list);
        }
        return answer;
    }
}
