class Solution {
     int search(int[] arr, int key) {
         int low = 0;
         int high = arr.length - 1;

         while (low <= high) {
             // Safer way to find mid without integer overflow
             int mid = low + (high - low) / 2; 

             if (arr[mid] == key) return mid;

             // Check if the left half is sorted
             if (arr[low] <= arr[mid]) {
                 // Check if key lies within the sorted left half
                 if (key >= arr[low] && key < arr[mid]) {
                     high = mid - 1;
                 } else {
                     low = mid + 1;
                 }
             } 
             // Otherwise, the right half must be sorted
             else {
                 // Check if key lies within the sorted right half
                 if (key > arr[mid] && key <= arr[high]) {
                     low = mid + 1;
                 } else {
                     high = mid - 1;
                 }
             }
         }
         return -1; // Removed quotes to return an int instead of a String
     }
 }
