/**
 * 转圈打印矩阵
 */
public class CirclePrint {


    public void circlePrint(int[][] maxtria){
        int X1 = 0;
        int Y1 = 0;
        int X2 = maxtria.length - 1;
        //列长
        int Y2 = maxtria[0].length - 1;
        while (X1 <= X2 && Y1 <= Y2){
            printEdge(maxtria, X1 ++, Y1 ++, X2 --, Y2 --);
        }
    }


    public void  printEdge(int[][] m, int X1, int Y1, int X2, int Y2 ){
        if(X1 == X2){
            //同一行
            for (int i = Y1; i <= Y2; i ++){
                System.out.print(m[X1][i] + " ");
            }
        } else if (Y1 == Y2){
            //同一列
            for (int i = X1; i < X2; i ++){
                System.out.print(m[Y1][i] + " ");
            }
        }else {
            int curC = Y1;
            int curR = X1;
            while (curC != Y2) {
                //从左向右
                System.out.print(m[X1][curC] + " ");
                curC ++;
            }
            while (curR != X2){
                //从上倒下
                System.out.print(m[curR][Y2] + " ");
                curR ++;
            }

            while (curC != Y1){
                //从右向左
                System.out.print(m[X2][curC] + " ");
                curC --;
            }
            while (curR != X1){
                //从下到上
                System.out.print(m[curR][Y1] + " ");
                curR --;
            }
        }

    }



    public static void main(String[] args) {
        int m[][] = {{1,2,3},{4,5,6},{7,8,9}};
        CirclePrint print = new CirclePrint();
        print.circlePrint(m);
    }
}
