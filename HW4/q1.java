public class q1{
	public static int rec_func(String bigger,String target,int index,int counter,int ocurrence){
        if(index>bigger.length()-1){
            return -1;
        }else{
            if (target.charAt(counter) == bigger.charAt(index)) {
                counter++;
                if (counter == target.length() ) {
                    ocurrence-=1;
                    if (ocurrence == 0) {
                        return index-target.length()+1;
                    }
                    else{
                        return rec_func(bigger,target,index+1,0,ocurrence);
                    }
                }
                else{
                    return rec_func(bigger,target,index+1,counter,ocurrence);
                }
            }else{
                return rec_func(bigger,target,index+1,counter,ocurrence);
            }
        }
}
	public static void main(String[] args) {
		String ati = "ati";
		String foo = "12aatia23atisd123attiati";
		int res = rec_func(foo,ati,0,0,5);
		System.out.println(res);
	}

}