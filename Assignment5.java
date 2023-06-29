// 1. Solution 

//Time= O(m*n)
//Space=O(m*n)


public int[][] convertTo2DArray(int[] original, int m, int n) {
    int length = original.length;
    if (length != m * n) {
        return new int[0][0]; // Return empty 2D array if the conversion is not possible
    }
    
    int[][] result = new int[m][n];
    for (int i = 0; i < length; i++) {
        int row = i / n; // Calculate the row index
        int col = i % n; // Calculate the column index
        result[row][col] = original[i];
    }
    
    return result;
}




// 2. Solution 

//Time=O(squrt(n))
//Space=O(1)



public class Solution {
    public int arrangeCoins(int n) {
        int rows = 0;
        int coinsRequired = 1;

        while (n >= coinsRequired) {
            n -= coinsRequired;
            coinsRequired++;
            rows++;
        }

        return rows;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 5;
        int completeRows = solution.arrangeCoins(n);
        System.out.println(completeRows);
    }
}



// 3. Solution 

//Time=O(n)
//Space=O(n)



 import java.util.Arrays;

public class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length - 1;

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[index] = leftSquare;
                left++;
            } else {
                result[index] = rightSquare;
                right--;
            }

            index--;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-4, -1, 0, 3, 10};
        int[] squaredSorted = solution.sortedSquares(nums);
        System.out.println(Arrays.toString(squaredSorted));
    }
}




// 4. Solution 

//Time=O(n+m)
//Space=O(n+m)



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            set2.add(num);
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int num : nums1) {
            if (!set2.contains(num)) {
                list1.add(num);
            }
        }

        for (int num : nums2) {
            if (!set1.contains(num)) {
                list2.add(num);
            }
        }

        result.add(list1);
        result.add(list2);

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 6};
        List<List<Integer>> answer = solution.findDisappearedNumbers(nums1, nums2);
        System.out.println(answer);
    }
}





// 5. Solution 

//Time=O(n*m)
//Space=O(1)



public class Solution {
    public int distanceBetweenArrays(int[] arr1, int[] arr2, int d) {
        int distance = 0;

        for (int num1 : arr1) {
            boolean found = false;

            for (int num2 : arr2) {
                if (Math.abs(num1 - num2) <= d) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                distance++;
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {4, 5, 8};
        int[] arr2 = {10, 9, 1, 8};
        int d = 2;
        int distance = solution.distanceBetweenArrays(arr1, arr2, d);
        System.out.println(distance);
    }
}



// 6. Solution 

//Time=O(n)
//Space=O(1)



import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            int index = num - 1;

            if (nums[index] > 0) {
                nums[index] = -nums[index];
            } else {
                duplicates.add(num);
            }
        }

        return duplicates;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> duplicates = solution.findDuplicates(nums);
        System.out.println(duplicates);
    }
}



// 7. Solution 

//Time=O(log n)
//Space=O(1)


public class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 4, 5, 1, 2};
        int min = solution.findMin(nums);
        System.out.println(min);
    }
}




// 8. Solution 

//Time=O(n)
//Space=O(n)


import java.util.HashSet;

public class Solution {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) {
            return new int[0]; // If the length is odd, it can't be a doubled array
        }

        int[] original = new int[changed.length / 2];
        HashSet<Integer> set = new HashSet<>();

        for (int num : changed) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                int originalNum = num / 2;
                original[set.size()] = originalNum;
                set.add(originalNum);
            }
        }

        if (set.isEmpty()) {
            return original;
        } else {
            return new int[0]; // If set is not empty, it means some values were not doubled
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] changed = {1, 3, 4, 2, 6, 8};
        int[] original = solution.findOriginalArray(changed);
        for (int num : original) {
            System.out.print(num + " ");
        }
    }
}



