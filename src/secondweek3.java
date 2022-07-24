import java.util.*;
public class secondweek3 {
    public static void main(String[] args) {
        int[][] pos={{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};   //������ļ��ֱ仯
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int m=input.nextInt();
        int x=input.nextInt();
        int y=input.nextInt();
        int[][] step=new int[n][m];   //�Ե����ٴ���ͳ�Ƶ�����
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                step[i][j]=-1;
            }
        }
        int[][] flag=new int[n][m];   //���Ƿ��ܹ�����ı��
        bfs(pos,flag,step,x,y,n,m);
        pointPrint(step,n,m);
    }
    public static void bfs(int[][] arr,int[][] flag,int[][] step,int x,int y,int n,int m)
    {
        //�ö��С�bfs�㷨���
        Queue<Integer> xpos=new LinkedList<Integer>();
        Queue<Integer> ypos=new LinkedList<Integer>();
        xpos.offer(x);
        ypos.offer(y);
        flag[x-1][y-1]=1;
        step[x-1][y-1]=0;
        while(!xpos.isEmpty()&&!ypos.isEmpty()){     //���зǿ�ʱ�����µ�Ԫ��(�˸����������ֵ)�������
            int xline=xpos.poll();   //ÿ�ε���������Ϊ��һ�ο�ʼ���������
            int yline=ypos.poll();
            for(int i=0;i<8;i++){
                int xline1=xline+arr[i][0];
                int yline1=yline+arr[i][1];
                if(xline1>=1&&xline1<=n&&yline1>=1&&yline1<=m){
                    if(flag[xline1-1][yline1-1]==0) {
                        flag[xline1-1][yline1-1] = 1;
                        step[xline1-1][yline1-1] = step[xline-1][yline-1] + 1;    //ԭ������������ߣ�����flag����1��ʹ�������Ĳ����ߴ˲�������Ϊ��̾���
                        xpos.offer(xline1);
                        ypos.offer(yline1);
                    }
                }
            }
        }
    }
    public static void pointPrint(int[][] arr,int n,int m)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.printf("%-5d",arr[i][j]);
            }
            System.out.println();
        }
    }
}
