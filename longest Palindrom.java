public static int longestPalindrom(int[] arr)
{
    // If the array is empty, return 0
    if (arr.length == 0)
        return 0; 

    // Call the private recursive function to find the longest palindrome in the array
    return longestPalindrom(arr, 0, 1);
}

private static int longestPalindrom(int[] arr, int i, int j)
{
    int arrayLength = arr.length;

    // If the beginning index has reached the end of the array, return 1
    if (i == arrayLength - 1)
        return 1;

    // If the end index has reached beyond the array, call itself again to check the next palindrome
    if (j == arrayLength)
        return longestPalindrom(arr, i + 1, i + 2);

    // Check if the subarray is a palindrome
    if (isPalindrom(arr, i, j))
    {
        // If it is a palindrome, compare its length with the length of the longest palindrome found so far
        // and return the maximum length
        return Math.max(j - i + 1, longestPalindrom(arr, i, j + 1));
    }
    else
    {
        // If it is not a palindrome, call itself to check the next subarray
        return longestPalindrom(arr, i, j + 1);
    }
}

// Check if the subarray from index1 to index2 is a palindrome
private static boolean isPalindrom(int[] arr, int index1, int index2)
{
    // If the index1 is greater than or equal to index2, it means we have checked the entire subarray
    // and it's a palindrome
    if (index1 >= index2)
        return true;

    // Check if the numbers at index1 and index2 are equal
    if (arr[index1] == arr[index2])
        // If they are equal, recursively call itself with the next indices
        return isPalindrom(arr, index1 + 1, index2 - 1);

    // If they are not equal, it's not a palindrome
    return false;
}