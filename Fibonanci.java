public class Fibonanci {
    public static int fib(int n){
        //invalid 
        if (n <0)
            return -1;

        //base 
        if (n==0)
            return 1;
        else if (n==1){
            return 1;
    }   
        //recursive
        else {
            return fib(n-1) + fib(n-2);
        }

    }
    public static void main (String [] args){
        int a = Fibonanci.fib(5);
        System.out.println(a);
        
    }
}
