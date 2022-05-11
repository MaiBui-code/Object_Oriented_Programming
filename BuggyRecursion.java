package ExactChange;
public class BuggyRecursion

{



   public BuggyRecursion()

   {

       testReverseString();

       testPalindrome();

       testCountDown(); 

   }



   /**

    * Given a word, reverse it. For example,

    * "cat" -> "tac" and "bulb" -> "blub".

    */

   public String reverseString( String word )

   {

       // base case

       if (word.length() == 0)   

           return word;   

       // recursive case

       else

       {   

           // peel off the first letter and recurse

           String firstLetter = word.substring(0,1);   

           String restOfWord = word.substring(1);   

           return reverseString(restOfWord) + firstLetter;

       }

   }

   /**

    * A palindrome is a word that is the same as its own reversal.

    * For example, "wow" is a palindrome since it is the same forwards as backwards,

    * but "bulb" is not. This function should return true if the given word

    * is a palindrome.

    * @return

    */

   public boolean isPalindrome( String word )

   {

       // base case

       if (word.length() == 1)    

           return true;   
           
        // if the word is ""
        else if  (word.length() == 0)
            return true; 

       // recursive case

       else

       {

           // peel off outer two    

           String firstLetter = word.substring( 0, 1 );

           String lastLetter = word.substring( word.length() - 1 );

           String interior = word.substring(1,word.length()-1 );  

           // check if the first and last match

           if (firstLetter.equals(lastLetter))   

               // then recurse

               return isPalindrome(interior);

           // otherwise, we know it's not a palindrome
           else

            return false;

       }

   }



   /**

    * Given a number greater than or equal to 0

    * to start at, counts down until the value 1, then ends with "Go!".

    * Invalid inputs (with a negative number) should return the empty string "".

    * For example,

    *   5  -> "5,4,3,2,1,Go!"

    *   3  -> "3,2,1,Go!"

    *   -4 -> ""

    */

   public String countDown( int startValue )

   {
       //invalid 
       if (startValue < 0)
            return "";

       // base case

       else if (startValue == 0)

           return "Go!";    

       // recursive case    

       else    

           return Integer.toString(startValue) + "," + countDown( startValue - 1 ) ;

   }

  

   public void testReverseString()

   {

       String[] testCases = {"bulb","cat",""};

       String[] expectedOutput = {"blub","tac",""};

  

       for ( int i = 0; i < testCases.length; i++ )

       {

           String testOutput = "Testing reverseString(" + testCases[i] + ")...";

           String testResult = reverseString( testCases[i] );

  

           if (testResult.equals(expectedOutput[i]))

               testOutput += "PASSED";   

           else   

               testOutput += "FAILED";

  

           System.out.println( testOutput + "\nExpected: " + expectedOutput[i] + ", Actual: " + testResult );

       }

   }

   public void testCountDown()

   {

       int[] testCases = {5,3,0,-2};

       String[] expectedOutput = {"5,4,3,2,1,Go!","3,2,1,Go!","Go!",""};



       for (int i = 0; i < testCases.length; i++ )

       {

           String testOutput = "Testing countDown(" + Integer.toString(testCases[i]) + ")...";

           String testResult = countDown( testCases[i] );

  

           if (testResult.equals(expectedOutput[i]))

               testOutput += "PASSED";

           else   

               testOutput += "FAILED";

           System.out.println( testOutput + "\nExpected: " + expectedOutput[i] + ", Actual: " + testResult );

       }

   }

  

   public void testPalindrome()

   {

       String[] testCases = {"bulb","wow","","cat"};

       boolean[] expectedOutput = {false,true,true,false};   

       for (int i = 0; i < testCases.length; i++ )   

       {

           String testOutput = "Testing isPalindrome(" + testCases[i] + ")...";

           boolean testResult = isPalindrome( testCases[i] );

  

           if (testResult == expectedOutput[i] )

               testOutput += "PASSED";   

           else   

               testOutput += "FAILED";

           System.out.println( testOutput + "\nExpected: " + expectedOutput[i] + ", Actual: " + testResult );

       }

   } 

   public static void main( String[] args )

   {

       new BuggyRecursion();

   }

}