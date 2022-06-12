public class q3{
    public static int recursive_max(int array[],int l,int index,int max){
		if (index >= l) {
            int mid = l + (index - l) / 2;

            if (array[mid] == max)
                return mid;

            else if (array[mid] > max && array[mid+1] < max) {
            	return mid;
            }
 
            if (array[mid] > max){
                return recursive_max(array, l, mid - 1, max);
            } 
            return recursive_max(array, mid + 1, index, max);
        }
        return -1;
	}
	public static int recursive_min(int array[],int l,int index,int min){
		if (index >= l) {
            int mid = l + (index - l) / 2;
 
            if (array[mid] == min)
                return mid;

            else if (array[mid] > min && array[mid-1] < min) {
            	return mid;
            }

            if (array[mid] > min){
                return recursive_min(array, l, mid - 1, min);
            }
            return recursive_min(array, mid + 1, index, min);
        }
        return -1;
	}


	public static void main(String[] args) {
		int array[] = {0,1,1,2,3,4,5,6,7,8,9};
		int min = 2;
		int max = 8;
		int n = array.length;
		int s1 = recursive_min(array,0,n-1,min);
		int s2 = recursive_max(array,0,n-1,max);
		System.out.println(s1 + " " + s2);
	}
}