package Week4;


import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static int findMaximizedCapital(int numberOfProjects, int initialCapital, int[] profits, int[] capital) {
        int n = profits.length;
        PriorityQueue<Integer> minCapitalHeap = new PriorityQueue<>(n, Comparator.comparingInt(i -> capital[i]));
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(n, (i1, i2) -> profits[i2] - profits[i1]);

        // insert all project capitals to a min-heap
        for (int i = 0; i < n; i++)
            minCapitalHeap.offer(i);

        // let's try to find a total of 'numberOfProjects' best projects

        int availableCapital = initialCapital;
        for (int i = 0; i < numberOfProjects; i++) {
            // find all projects that can be selected within the available capital and insert them in a max-heap
            while (!minCapitalHeap.isEmpty() && capital[minCapitalHeap.peek()] <= availableCapital)
                maxProfitHeap.add(minCapitalHeap.poll());

            // terminate if we are not able to find any project that can be completed within the available capital
            if (maxProfitHeap.isEmpty())
                break;

            // select the project with the maximum profit
            availableCapital += profits[maxProfitHeap.poll()];
        }

        return availableCapital;
    }

    public static void main(String[] args) {
        var a = new Solution();
        int c = 0;
        int[] profit = {1,2,3};
        int[] capital = {0,1,2};
        System.out.println(Solution.findMaximizedCapital(3, 0, profit, capital));

    }


//    var solution = new OptimizeWaterDistribution();
//
//    int[] wells = new int[]{1,2,2};
//    int[][] pipes = new int[][]{
//            {1,2,1},
//            {2,3,1}
//    };
}