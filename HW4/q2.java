public class q2{

    public static void PrintSubArray(int[] array, int i, int n,int[]subArray, int j,int target){
        if(i==n){
            int iter = 0;
            int count = 0;
            while(iter<j){
                count+=subArray[iter];
                ++iter;
            }
            if(count == target){
                int k = 0;
                while(k < j){
                    System.out.printf("%d ", subArray[k]);
                    ++k;
                }
                System.out.println();
            }
            return;
        }

        PrintSubArray(array,i+1,n,subArray,j,target);
        subArray[j] = array[i];
        PrintSubArray(array,i+1,n,subArray,j+1,target);
    }
	public static void main(String args[])
	{
		int []arr = {1,2,3,4,5,6,7,8,9,10};
		int[] subset = new int[100];
		int n = arr.length;
        int target = 9;
		PrintSubArray(arr, 0, n,subset,0,target);
	}
}