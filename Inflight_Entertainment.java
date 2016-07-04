/*
Program:	Inflight Entertainment
Coded by:	Zachary Hollingsworth
Date:		6/30/2016
https://www.interviewcake.com/question/java/inflight-entertainment

You've built an in-flight entertainment system with on-demand movie streaming.

Users on longer flights like to start a second movie right when the first one
ends, but they complain that the plane usually lands before they can see the
ending. So you're building a feature for choosing two movies whose total 
runtimes will equal the exact flight length.

Write a function that takes an integer value flightLength(in minutes)
and an array of integers movieLengths(in minutes) and returns a boolean
indicating whether there are two numbers in movieLengths whose sum
equal flightLength.

When building your function:
	* Assume you users will watch exactly two movies.
	* Don't make your users watch the same movie twice.
	* Optimize for runtime over memory.
*/

public class Inflight_Entertainment
{
	public static boolean moviePicks(int flightLength, int[] movieLengths)
	{
		int fliLen = flightLength;
		int[] movLen = new int[5];
		System.arraycopy(movieLengths, 0, movLen, 0, movieLengths.length);
		int total = 0;
		int count = 0;
		int i = 0;

		do
		{
			total = movLen[count];
			for(i = 1; i < movLen.length; i++)
			{
				if((total + movLen[i]) < fliLen)
					return true;
			}
			count++;
		}while(total > fliLen);

		return false;
	}

	public static void main(String[] args)
	{
		int flightLength = 175;
		int[] movieLengths = {90, 120, 85, 75, 135};
		boolean watch = moviePicks(flightLength, movieLengths);
		System.out.println(watch);
	}
}
