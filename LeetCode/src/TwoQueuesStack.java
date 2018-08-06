import java.util.LinkedList;
import java.util.Queue;

/**
 * 用连个队列实现栈结构
 */
public class TwoQueuesStack {

    private Queue<Integer> data;
    private Queue<Integer> help;

    public TwoQueuesStack() {
        data = new LinkedList<Integer>();
        help = new LinkedList<Integer>();
    }

    /**
     * 进栈操作
     * @param n
     */
    public void push(int n){
        data.add(n);
    }

    /**
     * 出栈操作
     * @return
     */
    public int poll(){
        if (data.isEmpty()){
            throw new RuntimeException("Stack is empty.");
        }
        while (data.size() > 1){
            help.add(data.poll());
        }

        int res = data.poll();
        swap();
        return res;
    }

    private void swap() {
        Queue<Integer> temp = data;
        data = help;
        help = temp;
    }

    public int peek(){
        if (data.isEmpty()){
            throw new RuntimeException("Stack is empty.");
        }
        while (data.size() > 1){
            help.add(data.poll());
        }

        int res = data.poll();
        //将最后一个再压入栈中
        help.add(res);
        swap();
        return res;
    }
}
