import java.util.Scanner;
import java.util.ArrayList;
public class Print_All_Subsets 
{

	/*
	 * Key approach here is recursing over the two possibilities of every element
	 * 
	 * The possibilities are :
	 *   1. the element at index i will not be included in the subset
	 *   2. the element at index i will be included in the subset
	 */
	static ArrayList<ArrayList<Integer>> subsets;
	public static void form_subsets(int subset[],int arr[],int index,int s_index,int n)
	{
	    if(index==n)
	    {
	    	ArrayList<Integer> arrL=new ArrayList<Integer>();
	    	for(int i=0;i<s_index;i++)
	    		arrL.add(subset[i]);
	    	subsets.add(arrL);
	    	return;
	    }
	    form_subsets(subset,arr,index+1,s_index,n);
	    subset[s_index]=arr[index];
	    form_subsets(subset,arr,index+1,s_index+1,n);
	    
	}
	public static ArrayList<ArrayList<Integer>> form_all_subsets(int arr[],int n)
	{
		subsets=new ArrayList<ArrayList<Integer>>();
		int subset[]=new int[n];
		form_subsets(subset,arr,0,0,n);
		return subsets;
	}
	
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of elements in n:");
		int n=input.nextInt();
		
		System.out.println("Enter the elements in the array:");
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=input.nextInt();
		ArrayList<ArrayList<Integer>> ss=form_all_subsets(arr,n);
		
		for(ArrayList<Integer> set: ss)
		   System.out.println(set.toString());
	}

}
