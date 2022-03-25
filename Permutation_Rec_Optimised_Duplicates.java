import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Permutation_Rec_Optimised_Duplicates 
{
    static List<List<Integer>> permutations; 
	/*
	 * The approach will be same as the normal permute but we just need to take care of two things
	 * 
	 * 1. Swap for indices which are not equal to index should be performed only if they are unequal
	 * 2. Even if the un - equal indices are swapped the next swapping to happen for un - equal elements
	 * 
	 * Example: 1 2 2
	 *          1 at index 0 is swapped with 2 at index 1
	 *          
	 *          so they will give rise to recursive calls 
	 *          2 ->1 2    2 ->2 1  though they do not look same but when we analyze more 
	 *          
	 *          2 1 2   will give 2 1 2 (swapped with same index) 
	 *                            2 2 1 (1 and later 2 swapped)
	 *                            
	 *          2 2 1   will give 2 2 1(swapped with same)
	 *                            2 1 2(the later 2 is swapped with 1)
	 *                            
	 *          So here we can see that due to swapping with un - equal elements more than once we 
	 *          gave rise to non-unique permutations also.
	 */
	public static void permute(int arr[],int n,int index)
	{
		/*
		 * We can not permute a single element it remains as it is so when we reach the index n-1 its 
		 * end of permuting.
		 */
		if(index==n-1)
		{
			List<Integer> arrL=new ArrayList<Integer>();
			for(int i=0;i<n;i++)
				arrL.add(arr[i]);
			permutations.add(arrL);
			return;
		}
		
		for(int i=index;i<n;i++)
		{
			//do not swap for identical values 
		    if(i!=index && arr[i]==arr[index])
		    	continue;
		   swap(i,index,arr);
		   permute(arr,n,index+1);
		   swap(i,index,arr);
		   int val=arr[i];
		   while(i<n && arr[i]==val)
		     i++;
		   i--;
		}
	}
	
	public static void swap(int i,int j,int arr[])
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public static List<List<Integer>> find_all_permutations(int arr[],int n)
	{
		permutations=new ArrayList<List<Integer>>();
		Arrays.sort(arr);
		permute(arr,n,0);
		return permutations;
	}
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the number of elements in the array:");
		int n=input.nextInt();
		
		int arr[]=new int[n];
		System.out.println("Enter the data in the aray:");
		for(int i=0;i<n;i++)
			arr[i]=input.nextInt();
		List<List<Integer>> pmns=find_all_permutations(arr,n);
        for(List<Integer> arrL: pmns)
        {
        	for(int ele: arrL)
        		System.out.print(ele+" ");
        	System.out.println();
        }
	}
	
}
