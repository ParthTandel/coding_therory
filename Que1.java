package coding_theory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Que1
{
	  static int printAllKLength(char set[], int k ,  int ar[][] , int code , int m , int gf ,BufferedWriter bw , BufferedWriter bw2) throws IOException 
	    {
		   
	        int n = set.length;        
	        int l = printAllKLengthRec(set, "", n, k , ar , code , m , gf , 0 , bw , bw2);
	        return l;
	    }
	 
	   
	    static int printAllKLengthRec(char set[], String prefix, int n, int k ,  int ar[][] , int code , int m , int gf , int least ,BufferedWriter bw ,BufferedWriter bw2) throws IOException 
	    {
	        int l = least;
	        if (k == 0) 
	        {
	           
	            int arrr[] =  new int[m];  
		        for(int xx = 0 ; xx < code ; xx++)
		        {
		        	for(int yy =0 ; yy<m ; yy++)
		        	{
		        	  arrr[yy] = (arrr[yy] + (ar[xx][yy]* Character.getNumericValue(prefix.charAt(xx))))%gf ;	
		        	}
		            	
	            }
		        int count = 0;
		        String str = "";
		        for(int yy =0 ; yy<m ; yy++)
	        	{
		         
		          str = str + Integer.toString(arrr[yy]);
	        	  System.out.print(arrr[yy]) ;
	        	  if(arrr[yy] > 0)
	        	  {
	        		  count ++;
	        	  }
	        	  if(l == 0)
	        	  {
	        		  l = count;
	        	  }
	        	  else
	        	  {
	        		  if(l >= count)
	        		  {
	        			  l = count;
	        		  }
	        	  }
	        	  
	        	}
		        str = str + "\n";
		        bw.write(str);
		        bw2.write(Integer.toString(count)+"\n");
		        System.out.println() ;
	            return l;
	        }
	 
	    
	        for (int i = 0; i < n; ++i) 
	        {
	             
	            String newPrefix = prefix + set[i]; 
	            printAllKLengthRec(set, newPrefix, n, k - 1 , ar , code ,m, gf , l , bw , bw2); 
	        }
	        return l;
	    }
	
	
	public static void main(String ags[]) throws IOException
	{
		Scanner scan = new Scanner(new File("C:\\Workspace\\coding_theory\\src\\coding_theory\\input.txt"));
		int k = 0;
		int[][] arr = new int[100][100];
		int n = 0;
		int gf= scan.nextInt();
		scan.nextLine();
		while(scan.hasNext())
		{
			
			String Thisline[] = scan.nextLine().split(" ");
			n = 0;
			for(int i = 0 ; i<Thisline.length;i++)
			{
				arr[k][i] = Integer.parseInt(Thisline[i]);
				n++;
			}
		    k++;
		}
		
		String s = "";
		char ch[] = new char[gf];
		for (int i = 0 ; i < gf ; i++)
		{
			s = s + Integer.toString(i);
		}
		for (int i = 0 ; i < s.length() ; i++)
		{
			ch[i] = s.charAt(i);
		}
		File file = new File("C:\\Workspace\\coding_theory\\src\\coding_theory\\output.txt");
		File file2 = new File("C:\\Workspace\\coding_theory\\src\\coding_theory\\out.txt"); 
		file2.createNewFile();
		
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		FileWriter fw2 = new FileWriter(file2.getAbsoluteFile());
		BufferedWriter bw2 = new BufferedWriter(fw2);
	
		printAllKLength(ch,k,arr,k ,n ,gf , bw , bw2);
		Scanner Scan2  =  new Scanner(file2);
		bw2.close();
		int d = 0;
		while(Scan2.hasNext())
		{
			String s11 = Scan2.nextLine();
			if(d>Integer.parseInt(s11) || d == 0)
			{
				d = Integer.parseInt(s11);
			}
			
		}
		System.out.println(d);
		String parameter = "N:"+n+"  K:"+k+"  D:"+d;
		bw.write(parameter);
		scan.close();
		bw.close();
		file2.delete();
		
	}

}
