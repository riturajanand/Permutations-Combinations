import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Print_All_Permutations_Recursive_Naive 
{

	static List<List<Integer>> permutations;
	/*
	 * Here the approach is to maintain a boolean array named included and which tells us whether 
	 * the element at that index has been considered or not in the permutation constructed so far
	 * or not, 
	 * if yes go forward and search for the other element and included it now recurse and construct 
	 * the remaining permutation, 
	 * come back and give other element which has not been included yet to be on that 
	 * index of the permutation and construct the remaining permutation
	 */
	
	/*
	 * NOTE: This approach prints the permutations in lexographical order.
	 */
	
	public static void permute(int arr[],int permutation[], boolean included[],int n,int index)
	{
		//base case
		//when the length of the permutation becomes n 
		if(index==n)
		{
			List<Integer> arrL=new ArrayList<Integer>();
			for(int i=0;i<n;i++)
			   arrL.add(permutation[i]);
			permutations.add(arrL);
			return;
		}
		for(int i=0;i<n;i++)
		{
			if(included[i]==false)
			{
				included[i]=true;
				permutation[index]=arr[i];
				permute(arr,permutation,included,n,index+1);
				included[i]=false;
			}
		}
	}
	
	public static List<List<Integer>> find_all_permutations(int arr[],int n)
	{
	   permutations =new ArrayList<List<Integer>>();
	   int permutation[]=new int[n];
	   boolean included[]=new boolean[n];
	   permute(arr,permutation,included,n,0);
	   return permutations;
	}
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the number of elements in the array:");
		int n=input.nextInt();
		
		int arr[]=new int[n];
		System.out.println("Enter the data in the array:");
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
