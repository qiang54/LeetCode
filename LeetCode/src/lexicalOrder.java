import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 386 字典序排数
 *
 */
public class lexicalOrder {

    public List<Integer> lexicalOrder(int n){

        List<Integer> list = new ArrayList<>();
        int cur = 1;
        for (int i = 1; i <= n; i ++){
            list.add(cur);
            if ( cur * 10 <= n){
                cur = cur * 10;
            }else {
                if ( cur > n){
                    cur /= 10;
                }
                cur ++;
                while ( cur % 10 == 0){
                    cur = cur / 10;
                }
//                cur += 1;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        lexicalOrder lexicalOrder = new lexicalOrder();
        List<Integer> list = lexicalOrder.lexicalOrder(13);
        System.out.println(list.toString());
    }
}
