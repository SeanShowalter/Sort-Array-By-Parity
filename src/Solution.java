public class Solution {
    public static int[] sortArrayByParity(int[] nums) {

        // Edge cases
        if (nums == null || nums.length < 2) return nums;

        int writePointer = 0; // first index of nums array
        int readPointer = nums.length - 1; // last index of nums array

        // We'll start our seacrh from the bottom of the stack

        // There's no need to check the first index, which is my we are only
        // looping up to index 1 (nums[1]). Why? Because if there are any even
        // numbers in the array after index 0 (nums[0]), and the first index is odd,
        // then the nums[0] will be swapped with an even number.
        // And, if the entire array is odd except for the first index,then the first
        // index will always be an even number. In other words, no indexes are ever
        // swapped unelss an even number is found.
        while (readPointer > writePointer) {
            // If the number is even, then we attempt to swap it with
            // the next odd number from the top of the stack.
            if (nums[readPointer] % 2 == 0) {
                // Store our even number in a variable
                int evenNum = nums[readPointer];

                // We can use another loop to find the next odd number starting at the
                // current position of the write pointer.

                // If we find an odd number, then we simply swap the two variables and
                // increment the write pointer so we can start at the location of the
                // next write pointer for the next loop pass.

                // We start the loop at the current position of the writePointer and
                // move down the line of the array until we reach the previous index
                // of our even number (or the current read pointer index)

                // If no odd numbers are found, then we can assume that the array
                // is sorted properly with even numbers first, and odd numbers last
                while (writePointer < readPointer) {
                    // Is this an odd number?
                    if (nums[writePointer] % 2 > 0) {
                        // If so, then swap the two numbers
                        int oddNum = nums[writePointer];
                        nums[writePointer] = evenNum;
                        nums[readPointer] = oddNum;



                        // I've kept the println statements in case you want to see what's
                        // going on...
                        System.out.println("Swapped " + evenNum + " with " + oddNum);
                        System.out.println("Index " + writePointer + " swapped with index " + readPointer);

                        // Since we swapped the two numbers we can increase the writePointer
                        // and break out of the while loop.
                        writePointer++;
                        System.out.println("Write pointer advanced to index " + writePointer);
                        break;
                    }
                    writePointer++;
                }
            }
            // Decrement the readPointer so we can check the next index as we move
            // from the back of the stack towards the front, looking for even numbers...
            readPointer--;
            System.out.println("writePointer=" + writePointer + " | readPointer=" + readPointer);
        }

        return nums;
    }
}
