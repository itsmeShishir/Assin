package Week6;

class Solution {
    static int min = Integer.MAX_VALUE;
    public static int minimumTimeRequired(int[] jobs, int k) {
        recurse(jobs, jobs.length - 1, new int[k]);
        return min;
    }

    protected static void recurse(int[] jobs, int index, int[] sum){
        int max = getMax(sum);
        if (max >= min)
            return;

        if (index < 0){
            min = Math.min(min,max);
            return;
        }

        for (int i=0;i<sum.length;i++){
            if (i > 0 && sum[i] == sum[i-1])
                continue;
            sum[i] += jobs[index];
            recurse(jobs, index - 1, sum);
            sum[i] -= jobs[index];
        }
    }
    protected static int getMax(int[] sum){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<sum.length;i++)
            max = Math.max(max, sum[i]);
        return max;
    }

    public static void main(String[] args) {
        var a = new Solution();
        int[] tasks = {1,2,4,7,8};
        int target = 2;
        System.out.println(Solution.minimumTimeRequired(tasks, target));

    }
}
