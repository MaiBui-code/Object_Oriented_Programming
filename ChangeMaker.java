package ExactChange;
public class ChangeMaker {
//     Input

// An integer target 

// An array of integer values representing the coins you have

// Output

// true if there is a subset of the values (you can only "use" each element of the array at most once) that sum to the target

// false otherwise



   public ChangeMaker()

   {

       testExactChange();

   }



   /**

    * Determine if it is possible to make exact change for the target

    * value given the array of coin values. Return true if it is possible

    * and false otherwise.

    */

   public boolean exactChange( int target, int[] values )

   {

       // "start" the recursion by allowing all coins to be used


       return exactChange( target, values, values.length );

   }



   /**

    * Determine if it is possible to make exact change for the target

    * value using only coin values at indices 0 up to (but not including)

    * stopIndex. Return true if it is possible and false otherwise.

    */

   public boolean exactChange( int target, int[] values, int stopIndex )

   {
        boolean result = false; 
       // Base cases

       // When target < 0, you cannot make change
        if (target<0)
            result = false;

       // When target is 0, you can make change
        else if (target==0)
            return true;
       // When target > 0 and there are no coins, you cannot make change
        else if ((target >0) && (stopIndex == 0))
            return false;
       //     HINT: there are no coins if the stopIndex is 0


       // Recursive case (when target > 0 and there are coins)
        else if ((target >0) && (stopIndex != 0)) {
       // Choose an arbitrary coin -- we'll use the last one

       //     HINT: the last one is the one at index stopIndex - 1 
       int usedCoin;
       usedCoin  = values[stopIndex -1];

       // You can make change if:

                // int[] copyValues = new int[values.length - 1];

                // for (int i = 0, j = 0; i < values.length; i++) {
                //     if (i != (stopIndex -1)) {
                //         copyValues[j++] = values[i];

            //     You use that coin and can make change with only the remaining coins
            //     and a reduced target value (target minus the value of that coin)
            if (
                (exactChange(target - usedCoin, values, stopIndex -1) ) 
      //     OR
            ||
            //     You can make change with only the remaining coins
            //     HINT: to recurse on the remaining coins, subtract 1 from the stopIndex
                
                 (exactChange(target, values, stopIndex -1)))
                    result = true; 
                }

       // STUB placeholder
        return result;

   }



   /**

    * Here are some initial test cases, though you should add some of your own as well!

    */

   public void testExactChange()

   {

       int[] coins1 = {1,1,5,10,50};

       int[] targets1 = {2,22,53,61};

       boolean[] expectedOutputs1 = {true, false, false, true};



       int[] coins2 = {5,26,30};

       int[] targets2 = {31,35,28,0};

       boolean[] expectedOutputs2 = {true, true, false, true};

      

       int[] coins3 = {2,3,7,7,22,50,75};

       int[] targets3 = {62,63,97,17};

       boolean[] expectedOutputs3 = {true, false, true, true};



       int[] coins4 = {};

       int[] targets4 = {0,5,10};

       boolean[] expectedOutputs4 = {true, false, false};



       testExactChange( coins1, targets1, expectedOutputs1 );

       testExactChange( coins2, targets2, expectedOutputs2 );

       testExactChange( coins3, targets3, expectedOutputs3 );

       testExactChange( coins4, targets4, expectedOutputs4 );

   }



   public void testExactChange( int[] values, int[] targets, boolean[] expectedOutputs )

   {

       for (int i = 0; i < targets.length; i++ )

       {

           String testOutput = "Testing exactChange(" + Integer.toString(targets[i]) + ", {";

           for ( int j = 0; j < values.length; j++ )

               testOutput += Integer.toString( values[j] ) + ", ";

           // if there were values in the list, we have an extra ", " at the end

           if (values.length > 0)

               // strip off the last two characters to remove the extra ", "

               testOutput = testOutput.substring( 0, testOutput.length() - 2);

           testOutput += "})...";

           boolean testResult = exactChange( targets[i], values );

  

           if (testResult == expectedOutputs[i])

               testOutput += "PASSED";

           else   

               testOutput += "FAILED";

           System.out.println( testOutput + "\nExpected: " + expectedOutputs[i] + ", Actual: " + testResult );

       }

   }



   public static void main( String[] args )

   {

       new ChangeMaker();

   }

}

