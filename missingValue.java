
public static int missingValue(int[] arr) 
{
    // Calculate the common differences between consecutive elements
    int d1 = arr[1] - arr[0];
    int d2 = arr[2] - arr[1];
    
    // Initialize low and high indices for binary search
    int low = 0;
    int high = arr.length - 1;
    int middle = 0;
    int d = d1;
    
    // Check if the missing number is at the beginning of the array
    if (d1 == 2 * d2)
        return arr[0] + d2;
    if (d2 == 2 * d1)
        return arr[1] + d1;
    
    // Binary search loop to find the missing number
    while (low != high)
    {
        middle = (high + low) / 2;
        
        // Check where the problem is found
        if (arr[middle] == arr[0] + d * middle)
            low = middle + 1; // The missing number is in the second half
        else
            high = middle - 1; // The missing number is in the first half
    }
    
    // Return the missing number
    return arr[0] + (low + 1) * d;
}
