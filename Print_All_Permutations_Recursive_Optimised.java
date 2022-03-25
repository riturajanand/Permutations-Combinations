import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Print_All_Permutations_Recursive_Optimised 
{

	static List<List<Integer>> permutations;
	/*
	 * Here the approach is to give chance of all the non fixed elements to 'index' position of the permutation 
	 * and then fix that element and proceed to construct the remaining permutation using the non fixed elements.
	 * 
	 *  In order to achieve that we will swap the first non fixed element with all other non fixed elements.
	 *  
	 *  
	 *      1 2 3 to be permuted 
	 *      index is 0
	 *      
	 *      1 is swapped with 1 itself 1 2 3
	 *      1 is swapped with 2        2 1 3
	 *      1 is swapped with 3        3 2 1 
	 *      
	 *      index 1
	 *      1 2 3  2 is swapped with 2 itself 1 2 3
	 *             2 is swapped with 3        1 3 2
	 *             
	 *      2 1 3  1 is swapped with 1 itself 2 1 3
	 *             1 is swapped with 3        2 3 1
	 *             
	 *      3 2 1  2 is swapped with 2 itself 3 2 1
	 *             2 is swapped with 1        3 1 2 
	 */
	
	/*
	 * NOTE: This approach doesn't prints the permutations in lexographical order.
	 */
	
	public static void permute(int arr[],int n,int index)
	{
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
			swap(i,index,arr);
			permute(arr,n,index+1);
		    swap(i,index,arr);
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
		permute(arr,n,0);
		return permutations;
	}
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the value of n:");
		int n=input.nextInt();
		
		int arr[]=new int[n];
		System.out.println("Enter the elements in the array:");
		for(int i=0;i<n;i++)
			arr[i]=input.nextInt();
		List<List<Integer>> pmns=find_all_permutations(arr,n);
		for(List<Integer> arrL:pmns)
		{
			for(int ele:arrL)
				System.out.print(ele+" ");
			System.out.println();
		}
	}

}
