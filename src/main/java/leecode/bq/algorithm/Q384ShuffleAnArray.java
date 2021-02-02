package leecode.bq.algorithm;

import java.util.Random;

/**
 * <b> </b>
 *
 * Fisher-Yates Algorithm
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/17/21 9:34 PM
 */
public class Q384ShuffleAnArray {

    private int[] nums = null;
    // keep this array to avoid clone origin array on every shuffle function call
    private int[] shuffled = null;

    private Random random = new Random();

    public Q384ShuffleAnArray(int[] nums) {
        this.nums = nums.clone();
        this.shuffled = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < this.shuffled.length; i++) {
            // swap i and k (randomly picked in the left array)
            int k = random.nextInt(this.shuffled.length - i) + i;
            int tmp = this.shuffled[k];
            this.shuffled[k] = this.shuffled[i];
            this.shuffled[i] = tmp;
        }

        return this.shuffled;
    }

}
