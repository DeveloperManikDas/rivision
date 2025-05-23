import java.util.*;

class rivisionArray {

    public static int binarySearch(int arr[], int target) {

        int start = 0, end = arr.length - 1;

        while (start <= end) {

            // int mid = (start + end) / 2;
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public static void reverseArray(int arr[]) {

        int start = 0, end = arr.length - 1;

        while (start < end) {
            int temp;
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }

    }

    public static void printArrayPairs(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.println(arr[i] + " " + arr[j]);
            }
        }
    }

    public static int printSubarrayMaxBruteForce(int arr[]) {
        int maxSum = Integer.MIN_VALUE;

        if (arr == null || arr.length == 0) {
            System.out.println("Array is empty or null.");
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int curSum = 0;
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                    curSum += arr[k];
                }
                System.out.println("-> Sum: " + curSum);
                maxSum = Math.max(maxSum, curSum);
            }
        }
        System.out.println("Maximum Subarray Sum: " + maxSum);
        return maxSum;
    }

    public static int maxSubarraySumPrefix(int[] arr) {
        int n = arr.length;

        // Step 1: Build Prefix Sum Array
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        // Step 2: Calculate max subarray sum using prefix array
        int maxSum = prefix[0];
        int minPrefix = 0; // Important: minPrefix before any elements is 0

        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, prefix[i] - minPrefix);
            minPrefix = Math.min(minPrefix, prefix[i]);
        }

        return maxSum;
    }

    public static int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // either take the current element alone or extend the previous subarray
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }


    public int trap(int[] height) {
    int left = 0, right = height.length - 1;
    int leftMax = 0, rightMax = 0;
    int water = 0;

    while (left < right) {
        if (height[left] < height[right]) {
            if (height[left] >= leftMax)
                leftMax = height[left];
            else
                water += leftMax - height[left];
            left++;
        } else {
            if (height[right] >= rightMax)
                rightMax = height[right];
            else
                water += rightMax - height[right];
            right--;
        }
    }
    return water;
}

    public static void main(String[] args) {
        int arr[] = { 1, -13, 5, 7 };

        // binary Search function call 👇👇👇
        // int binarySearchResult = binarySearch(arr, 1);
        // if (binarySearchResult != -1) {
        // System.out.println("The target is found at index " + binarySearchResult);
        // } else {
        // System.out.println("The target is not found");
        // }

        // reverse an array 👇👇👇
        // reverseArray(arr);
        // for(int i : arr){
        // System.out.println(i);
        // }

        // print array pairs 👇👇👇
        // printArrayPairs(arr);

        // print sub-array max 👇👇👇

        // printSubarrayMaxBrute(arr);

        // maxSubarraySumPrefix(arr);


        System.out.println(maxSubArray(arr));   

    }
}