
/* git check out and merge testing 2017-05-06 */
public class CodeSqrt 
{

	public static void main(String[] args) 
	{
		// test the coded Sqrt function
		
		System.out.println("Sqrt(50) = " + CalSqrt(50));
		System.out.println("Sqrt(4) = " + CalSqrt(4));
		System.out.println("Sqrt(-2) = " + CalSqrt(20));
		System.out.println("Sqrt(1) = " + CalSqrt(50));
	}
	
	public static double CalSqrt(double i_num)
	{
		//check if the input is negative
		if (i_num<0) return -1;
		
		//check if the input is zero or one
		if (0==i_num || 1==i_num) return i_num;
		
		//stop condition: when a pre-defined precision is reached. 
		//normally 0< sqrt(x) < x; however, if x < 1, then 0 < x < sqrt(x)
		double l_precision = 0.00001; 
		double l_start = 0; 
		double l_end = i_num; 
		if (i_num<1) l_end = 1;
		
		//loop to find a value that is reaching the precision
		while (l_end - l_start > l_precision)
		{
			double l_temp = (l_start + l_end)/2;
			double l_result = l_temp * l_temp;
			
			if (l_result == i_num) return l_temp; //found the exact value of sqrt(x)
			else if (l_result < i_num) l_start = l_temp; //shift to focus to bigger half
			else l_end = l_temp; //shift to focus to smaller half
		}
		
		//if fail to find exact value, return the value that is close enough to the precision
		return ((l_start + l_end)/2);
		
	}

}
