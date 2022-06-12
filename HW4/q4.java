public class q4{
	public static int max(int int1,int int2){
		if (int1 >= int2) {
			return int1;
		}
		else {
			return int2;
		}
	}
	public static int number_of_digits(int val){
		int counter = 0;
		while(val > 0) {
			val/= 10;
			counter++;
		}
		return counter;
	}
	public static int[] split_integer(int value,int digit){
		int[] arr = new int[2];
			arr[0] = value / (int)Math.pow(10,digit);
			arr[1] = value % (int)Math.pow(10,digit);
			return arr;
	}

	public static int foo(int integer1,int integer2){
		if (integer1 < 10 || integer2 < 10) {
			return integer1*integer2;
		}
		else {
			int n = max(number_of_digits(integer1),number_of_digits(integer2));
			int half = n/2;

			int[] arr1 = split_integer(integer1,half);
			int[] arr2 = split_integer(integer2,half);

			int sub0 = foo(arr1[1],arr2[1]);
			int sub1 = foo(arr1[1]+arr1[0],arr2[1]+arr2[0]);
			int sub2 = foo(arr1[0],arr2[0]);

			return (sub2*(int)Math.pow(10, half*2)) + ((sub1-sub2-sub0)*(int)Math.pow(10, half)) + sub0;
		}
	}

	public static void main(String[] args) {
		int value = foo(123,54);
		System.out.println(value);
	}
}