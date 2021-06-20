package leecode.bq.algorithm;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 10:29 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q904FruitIntoBaskets {

    class Solution {
        public int totalFruit(int[] tree) {
            int total = 0;
            int firstType = tree[0],  secondType= -1;
            int firstTypeAmount = 0, secondTypeAmount = 0;

            int i = 0;
            while (i < tree.length && tree[i] == firstType) {
                i++;
                firstTypeAmount++;
            }
            if (i == tree.length) {
                return firstTypeAmount;
            }

            secondType = tree[i];
            secondTypeAmount = 1;
            i++;

            while (i < tree.length) {
                if (tree[i] == firstType) {
                    firstTypeAmount++;
                } else if (tree[i] == secondType) {
                    secondTypeAmount++;
                } else {
                    total = Math.max(total, firstTypeAmount + secondTypeAmount);

                    firstType = tree[i-1];
                    firstTypeAmount = 0;
                    int j = i-1;
                    while (tree[j] == firstType) {
                        firstTypeAmount++;
                        j--;
                    }

                    secondType= tree[i];
                    secondTypeAmount = 1;
                }

                i++;
            }

            total = Math.max(total, firstTypeAmount + secondTypeAmount);

            return total;
        }
    }

}
