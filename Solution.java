package DateExercise;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;


public class Solution {
	 static Date date;
	 
	 protected static Date[] sortDates(Date[] dates,int lowestIndex, int highestIndex){
		 if(lowestIndex >= highestIndex)
			 return dates;  //no need to sort, only one or 0 elements
			 Date pivot= dates[highestIndex];//consider the last element of the array as pivot
			 int left=lowestIndex;
			 int right=highestIndex;
			
			 while(left<right)
			 {
				 while(dates[left].compareTo(pivot) < 0)
					 left++;
				 
				 while(dates[right].compareTo(pivot)>0)
					 right--;
				 
				 if(right>left)
				 {  //swapping 
					 Date temp= dates[right];
					// System.out.println(dates[right]);
					dates[right]=dates[left];
					dates[left]=temp;			
				 }
			 }
			 System.out.println("jo");
			 sortDates(dates,lowestIndex,right-1);//recursively calling its own method to sort the left side of the array
			 sortDates(dates,right+1,highestIndex);//recursively calling its own method to sort the right side of the ar
			 return dates;
	 }
		public static Date getDate(String s) throws ParseException
		{
			 
				 date= new SimpleDateFormat("dd-MM-yyyy").parse(s);		 
				 return date;
				 
		 }
		
	
	public static void main (String[] args) throws ParseException{
		
		
		
		String [] mystring= { "12-03-1999", "23-12-1994", "27-09-1988","23-12-1996","23-12-1995", "23-12-1994", "27-09-1988"};
		Date [] dates = new Date[mystring.length];
		 for(int i=0;i<mystring.length;i++){
			 dates[i]= getDate(mystring[i]);
			 System.out.println(dates[i]);
		 }
		// sortDates(dates,0,mystring.length -1);
		System.out.println(Arrays.toString(dates));
		//sortDates(dates,0,mystring.length -1);
		System.out.println(sortDates(dates,0,mystring.length -1)[mystring.length-3]);
		
		
		
		//System.out.println(quicksort(dates,0,mystring.length-1)[mystring.length-3]);
		// System.out.println(sortDates(dates,0,mystring.length-1)[mystring.length - 3]);
	
}}
