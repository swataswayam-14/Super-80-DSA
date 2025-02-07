package DynamicProgramming;

public class FrogJump {
    public static void main(String[] args) {
        int[] heights = {10, 20, 30, 10};
        int n = heights.length;
        int minEnergy = findMinimumEnergyBrute(n - 1, heights);
        System.out.println("Minimum energy required: " + minEnergy);
    }
    static int findMinimumEnergyBrute(int index, int arr[]) {
        if (index == 0) {
            return 0;
        }
        int left = findMinimumEnergyBrute(index-1, arr) + Math.abs(arr[index] = arr[index-1]);

        int right = Integer.MAX_VALUE;

        if (index > 1) {
            right =  findMinimumEnergyBrute(index-2, arr) + Math.abs(arr[index] - arr[index - 2]);
        }
        return Math.min(left, right);
    }
}
