/**
 * 转圈打印矩阵
 */
public class CirclePrint {


    public void circlePrint(int[][] maxtria){
        int aR = 0;
        int aC = 0;
        int bR = maxtria.length - 1;
        //列长
        int bC = maxtria[0].length - 1;
        while (aR <= bR && aC <= bC){
            printEdge(maxtria, aR ++, aC ++, bR --, bC --);
        }
    }


    public void  printEdge(int[][] m, int aR, int aC, int bR, int bC ){
        if(aR == bR){
            //同一行
            for (int i = aC; i <= bC; i ++){
                System.out.print(m[aR][i] + " ");
            }
        } else if (aC == bC){
            //同一列
            for (int i = aR; i < bR; i ++){
                System.out.print(m[aC][i] + " ");
            }
        }else {
            int curC = aC;
            int curR = aR;
            while (curC != bC) {
                //从左向右
                System.out.print(m[aR][curC] + " ");
                curC ++;
            }
            while (curR != bR){
                //从上倒下
                System.out.print(m[curR][bC] + " ");
                curR ++;
            }

            while (curC != aC){
                //从右向左
                System.out.print(m[bR][curC] + " ");
                curC --;
            }
            while (curR != aR){
                //从下到上
                System.out.print(m[curR][aC] + " ");
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
