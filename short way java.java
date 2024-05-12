
public class CopyOfEx13
{

    static public void main(String args[])   
    {
        int [] road1= {5,4,5,8,12,9,9,3};
        int [] road2={7,3,3,12,10,2,10,7};
        System.out.println(shortestRoad(road1,road2));
    }

    public static int tzover( int [] arr)
    {
        int sum=0;
        int arrLength= arr.length;
        for(int i=0; i<arrLength;i++)
            sum+=arr[i];
        return sum;

    }

    public static int shortestRoad(int [] road1,int [] road2)
    {
        int startInRoad1= tzover(road1);
        int startInRoad2= tzover(road2);
        int minSum1=startInRoad1;
        int minSum2=startInRoad2;
        int sizeOfRoad= road1.length;
        // The size of the roads is equal//
        for (int i=sizeOfRoad-1; i>=0;i--)
        {
            if( minSum1>startInRoad1)
                minSum1=startInRoad1;
            startInRoad1-=road1[i];
            startInRoad1+=road2[i];
            if(minSum2>startInRoad2)
                minSum2=startInRoad2;
            startInRoad2-=road2[i];
            startInRoad2+=road1[i];
        }
        return Math.min( minSum2, minSum1);
    }
}
