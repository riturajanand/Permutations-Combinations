import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Print_All_Combinations_Of_Size_k 
{
	/*
	 * This program prints all the combinations of size k from a given array.
	 * 
	 * the key approach here is same as forming subsets 
	 * and if the length of the subset becomes k it adds the combinations to the collection of combinations
	 * and returns back to form more possible combinations.
	 */
	static List<List<Integer>> combinations;
	public static void form_combinations(int arr[],int combination[],int index,int k,int c_index,int n)
	{
		if(c_index==k)
		{
			List<Integer> arrL=new ArrayList<Integer>();
			for(int i=0;i<k;i++)
				arrL.add(combination[i]);
			combinations.add(arrL);
			return;
		}
		//if number of remaining elements is less than required number of elements the return
		if(k-c_index>n-index)
             return;
		if(index==n)
			return;
		/*
		 * Using array in place of array list saves us an additional O(n) complexity of cloning an array list.
		 */
		//ArrayList<Integer> local=new ArrayList<>(combination);
        combination[c_index]=arr[index];
	    form_combinations(arr,combination,index+1,k,c_index+1,n);
		form_combinations(arr,combination,index+1,k,c_index,n);
		
	}
	
	public static List<List<Integer>> find_combinations(int arr[],int n,int k)
	{
		combinations=new ArrayList<List<Integer>>();
		int combination[]=new int[k];
		form_combinations(arr,combination,0,k,0,n);
		return combinations;
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
		System.out.println("Enter the value of k:");
		int k=input.nextInt();
		List<List<Integer>> cmbns=find_combinations(arr,n,k);
		
		for(List<Integer> cmbn: cmbns)
		{
			System.out.println(cmbn.toString());
		}
		

	}

}
