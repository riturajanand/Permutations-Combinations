import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Permutation_Rec_Naive_Duplicates 
{

	static List<List<Integer>> permutations;
	/*
	 * Here the approach is same as the naive solution we are just ensuring that same value doesn't come 
	 * at that index of the permutation and we will here make unique permutations
	 * 
	 * NOTE: this code will print the permutations is lexographical order.
	 */
	
	public static void permute(int arr[],int permutation[],boolean included[],int n,int index)
	{
		if(index==n)
		{
			if(index==n)
			{
				List<Integer> arrL=new ArrayList<Integer>();
				for(int i=0;i<n;i++)
				   arrL.add(permutation[i]);
				permutations.add(arrL);
				return;
			}
		}
		for(int i=0;i<n;i++)
		{
			if(included[i]==false)
			{
				included[i]=true;
				permutation[index]=arr[i];
				permute(arr,permutation,included,n,index+1);
				included[i]=false;
				
				//In order to avoid duplicates we will shift to new value for further construction
				int val=arr[i];
				while(i<n && arr[i]==val)
					i++;
				i--;
			}
		}
	}
	
	public static List<List<Integer>> find_unique_permutations(int arr[],int n)
	{
		permutations=new ArrayList<List<Integer>>();
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
	   System.out.println("Enter the elements in the array:");
	   for(int i=0;i<n;i++)
		   arr[i]=input.nextInt();
	   List<List<Integer>> pmns=find_unique_permutations(arr,n);
		for(List<Integer> arrL:pmns)
		{
			for(int ele:arrL)
				System.out.print(ele+" ");
			System.out.println();
		}

	}

}
