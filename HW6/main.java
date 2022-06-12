import java.util.concurrent.ThreadLocalRandom;

public class main {
   
    public static void main(String[] args){
        Integer[] dizi1=new Integer[100];
        Integer[] dizi2=new Integer[100];
        Integer[] dizi3=new Integer[100];
        int i;
        for(i=0;i<dizi1.length;++i){
            int randomNum = ThreadLocalRandom.current().nextInt(0, 1000 + 1);
            dizi1[i]=randomNum;
            dizi2[i]=randomNum;
            dizi3[i]=randomNum;
        }
        System.out.println("Before the New Sort:");
        for (int element: dizi1) {
            System.out.print(element + " ");
        }
        System.out.println();
        SortNew newSort = new SortNew<Integer>(dizi1);
        System.out.println("After the New Sort:");
        for (int element: dizi1) {
            System.out.print(element + " ");
        }
        System.out.println();



    }
}