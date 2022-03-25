import java.util.Arrays;
import java.util.Scanner;
public class Printing_All_Permutations_Iteratively 
{

	/*
	 * the approach is just to find the next permutation at every iteration till the descending_from function
	 * returns 0.
	 * 
	 * NOTE: This code is understandable only if you understand the Find_Next_Permutation code
	 */
	public static void swap(int i,int j,int arr[])
	{
		arr[i]=arr[i]^arr[j];
		arr[j]=arr[i]^arr[j];
		arr[i]=arr[i]^arr[j];
	}
	
	//function to reverse an array from a given index till end 
	public static void reverse_from(int index,int arr[],int n)
	{
		if(index==n)
			return;
		int left=index, right=n-1;
		while(left<right)
		{
			swap(left,right,arr);
			left++; right--;
		}
	}
	//function to find the index from where the decreasing sequence has started
		public static int descending_from(int arr[],int n)
		{
			int index=n-1;
			while(index>=1 && arr[index]<=arr[index-1])
				index--;
			return index;
				
		}
		
		public static int find_next_permutation(int arr[],int n)
		{
			int d_index=descending_from(arr,n);
			if(d_index==0)
			   return 0;
			
			
			//finding the element which is just greater than the element at d_index-1
			int index=n-1;
			while(index>=0 && arr[index]<=arr[d_index-1])
			{
				index--;
			}
			
			//swapping the element at d_index-1 with the element just greater than that 
			swap(index,d_index-1,arr);
			
			//reversing the sub-array
			reverse_from(d_index,arr,n);
			return d_index;
				
		}
	public static void print_all_permutations(int arr[],int n)
	{
		//In order to print permutations lexographically they must be sorted 
		Arrays.sort(arr);
		
		//for sake of a non-zero value assigning 1 to print the first permutation
		int d_index=1;
		while(d_index!=0)
		{
			for(int i=0;i<n;i++)
				System.out.print(arr[i]+" ");
			System.out.println();
			d_index=find_next_permutation(arr,n);
		}
	}
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the value of n:");
		int n=input.nextInt();
		
		int arr[]=new int[n];
		System.out.println("Enter the elements to permute for:");
		for(int i=0;i<n;i++)
			arr[i]=input.nextInt();
		
		print_all_permutations(arr,n);

	}
	
	
	/*
	 * the above one is an optimized approach to print all permutations recursively
	 * 
	 *  One naive approach can be 
	 *  
	 *  Suppose we have to permute 1 2 3
	 *  
	 *  Start with 
	 *                    [ _ 1 _ ]   Now 2 can be inserted in two blank spaces 
	 *                    
	 *             [_2_1_]             [_1_2_]  Now three can be inserted in three blank spaces
	 *             
	 *   [3 2 1]  [2 3 1]  [2 1 3]    [3 1 2] [1 3 2] [1 2 3]    
	 *   
	 *   This approach has a large space and large time complexity, also we cannot have a lexographical order 
	 *   of permutations.
	 */

}
