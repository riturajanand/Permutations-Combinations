import java.util.Scanner;

/*
 * For understanding the intuition better refer the following video:
 * 
 *     https://www.youtube.com/watch?v=quAS1iydq7U
 *     
 *     
 * NOTE: The following program works even if there are duplicate elements in the given permutation.
 */
public class Find_The_Next_Permutation 
{

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
	
	public static void find_next_permutation(int arr[],int n)
	{
		int d_index=descending_from(arr,n);
		if(d_index==0)
		{
			System.out.println("This is already the last permutation");
			return;
		}
		
		
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
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
			
	}
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the value of n:");
		int n=input.nextInt();
		
		int arr[]=new int[n];
		System.out.println("Enter the current permutation:");
		for(int i=0;i<n;i++)
			arr[i]=input.nextInt();
		find_next_permutation(arr,n);
	}

}
