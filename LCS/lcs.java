import java.lang.*;
import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class lcs {
    public static void main(String[] args)throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Z pliku czy z konsoli:");
        String xd = scan.next();
        String str ="",str1="";
        if(Objects.equals(xd, "pliku")) {
            File file = new File("C:\\Users\\Piotr\\Desktop\\siema.txt");
            BufferedReader br
                    = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                System.out.println(st);
                str=st;
            }


            File file1 = new File("C:\\Users\\Piotr\\Desktop\\eniu.txt");
            BufferedReader br2
                    = new BufferedReader(new FileReader(file1));
            String st2;
            while ((st2 = br2.readLine()) != null) {
                System.out.println(st2);
                str1=st2;
            }

        }else{
            System.out.println("Podaj pierwszy ciąg:");
            str = scan.next();
            System.out.println("Podaj drugi ciąg:");
            str1 = scan.next();

        }

        String xyz = "";
        int lenstr = str.length() ;
        int lenstr1 = str1.length() ;
        int[][] arr = new int[lenstr1+1][lenstr+1];
        for(int i=0;i<lenstr1+1;i++){
            for(int j=0;j<lenstr+1;j++){
                arr[i][j] = 0;
            }
        }
        System.out.print("    ");
        for(int i=0;i<lenstr;i++){
            System.out.print(str.charAt(i)+" ");
        }
        System.out.println();
        for(int i=1;i<lenstr1+1;i++){
            for(int j=1;j<lenstr+1;j++){
                if(str.charAt(j-1) == str1.charAt(i-1)){
                    arr[i][j]=arr[i-1][j-1]+1;
                }else{
                    if(arr[i-1][j] < arr[i][j-1]){
                        arr[i][j] = arr[i][j-1];
                    }else{
                        arr[i][j] = arr[i-1][j];
                    }
                }
            }
        }
        int w=arr[0].length-1;
        int h=arr.length-1;
        int a=h;
        int b=w;

        while(w > 0 && h > 0){
            if(arr[h][w-1]%10==arr[h][w]%10){
                arr[h][w-1]=arr[h][w-1]+10;
                w--;

            }else if(arr[h-1][w]%10==arr[h][w]%10){
                arr[h-1][w]=arr[h-1][w]+10;
                h--;

            }else{
                arr[h-1][w-1]=arr[h-1][w-1]+10;

                xyz=xyz+str.charAt(w-1);
                h--;
                w--;

            }
        }
        arr[a][b]=arr[a][b]+10;


        for(int i=0;i<lenstr1+1;i++){
            if(i==0) {
                System.out.print("  ");
            }else{
                System.out.print(str1.charAt(i-1)+" ");
            }
            for(int j=0;j<lenstr+1;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        char ch;
        StringBuilder zyx= new StringBuilder();
        for(int i=xyz.length()-1;0<=i;i--){
            ch =xyz.charAt(i);
            zyx.append(ch);
        }
        System.out.println("Najdłuższy wspólny podciąg:"+zyx);

    }

}
