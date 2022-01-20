import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.FileNotFoundException;
import java.util.*;

public class MagicSquare {
    String fileName;
    public static void main(String[] args) throws IOException {
        MagicSquare M=new MagicSquare("C:\\Users\\L\\Desktop\\Lab\\src\\P1\\5.txt");
        boolean Bool=M.isLegalMagicSquare("C:\\Users\\L\\Desktop\\Lab\\src\\P1\\5.txt");
        System.out.println(Bool);
    }
    public MagicSquare(String fileName){
        this.fileName=fileName;
    }
    public boolean isLegalMagicSquare(String fileName) throws IOException {
        Path path=Paths.get(fileName);
        int m=0,n=0;
        Scanner aScanner=new Scanner(path);
        int[][] Ms;
        String line;
        //先计算行数和列数
        while(aScanner.hasNext()){
            m=m+1;
            aScanner.nextLine();
        }//行数

        aScanner=new Scanner(path);
        Scanner bScanner = new Scanner(aScanner.nextLine());
        aScanner.reset();
        while(bScanner.hasNext()){
            n=n+1;
            bScanner.next();
        }//列数

        if(m!=n){
            System.out.println("不是矩阵！");
            return false;
        }//错误提示信息
        Ms=new int[m][n];
        int i=0;
        int j=0;
        //初始化矩阵数组
        aScanner=new Scanner(path);
        while(aScanner.hasNext()){
            line=aScanner.nextLine();
            j=0;
            bScanner=new Scanner(line);
            while(bScanner.hasNext()){
                try{
                    Ms[i][j]=bScanner.nextInt();
                }catch(InputMismatchException e){
                    System.out.println("矩阵数字有误！");
                    return false;
                }
                j++;
            }
            i++;
            if(j!=n){
                System.out.println("不是矩阵！");
                return false;
            }

        }//读入数组

        int sum=0,temp=0;
        for(int a=0;a<m;a++){
            sum += Ms[a][a];
        }//以右斜线为基准数
        for(int a=0;a<m;a++){
            temp += Ms[m-a-1][a];
        }//计算左斜线
        if(temp!=sum){
            return false;
        }
        temp=0;
        for(int[] k :Ms){
            for(int l:k){
                temp+=l;
            }
            if(temp!=sum){
                return false;
            }
            temp=0;
        }//计算所有行
        for(int k=0;k<n;k++){
            for(int l=0;l<m;l++){
                temp+=Ms[l][k];
            }
            if(temp!=sum){
                return false;
            }
            temp=0;
        }//计算所有列
        return true;
    }

 /*       for(int k=0;k<m;k++){
            for(int l=0;l<n;l++){
                System.out.print(Ms[k][l]);
            }
            System.out.println();
        }
        return true;
    }
    */
}
