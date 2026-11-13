public static void swap(int nums[], int l, int i) { 
    int temp = nums[l]; 
    nums[l] = nums[i]; 
    nums[i] = temp; 
}

public static void permutations(int[] nums, int l, int h) { 
    if (l == h) {
        // DO SOMETHING WITH THE PERMUTATION
        test(nums);
        return; 
    } 

    for (int i = l; i <= h; i++) { 
        swap(nums, l, i); 
        permutations(nums, l + 1, h); 
        swap(nums, l, i); 
    } 
} 

// Function to get the permutations, call permute(arr);
public static void permute(int[] nums) { 
    int x = nums.length - 1; 
    permutations(nums, 0, x); 
} 