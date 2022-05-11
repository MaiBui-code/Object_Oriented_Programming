import java.util.Scanner;

public class HelloJava {
    public static void main (String [] arg)
    {
        Scanner sc= new Scanner(System.in); // System.in is a standard input stream 

       System.out.print( "(H)it or (S)tand? ");  // print a prompt

       String userDecision= sc.nextLine();     // wait for and accept input 

       if (userDecision == "h"){
        System.out.println( userDecision + "!" );   
       }
        else{
            System.out.println("a");
        }       
        sc.close(); // close the scanner
        int a = 5;
        int b = a ++;
        System.out.println( b);


       }

          

       

        /*Scanner user = new Scanner(System.in); 
        System.out.print( "(H)it or (S)tand? " );  // print a prompt

        String userDecision= user.nextLine();     // wait for and accept input  
        //if ((userDecision == "h") || (userDecision == "H")){
        System.out.println(userDecision);
        //}
        //else if ((userDecision == "s") || (userDecision == "S")){
            //System.out.println("no");
        //}
        user.close();*/
    }
