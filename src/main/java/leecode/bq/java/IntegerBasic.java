package leecode.bq.java;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/14/21 9:38 PM
 */
public class IntegerBasic {

    public static void main(String[] args) {
        // by default division is: floor().
        System.out.println(8 / 3);
        System.out.println(Math.floor(8.0 / 3));

        // to get round:
        System.out.println(Math.round(8 / 3)); // won't work
        System.out.println(Math.round((double)8 / 3)); // works

    }

}
