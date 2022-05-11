public class BankAccount {
    private int dollars; 
    private int cents; 
    public BankAccount (int initialDollars, int initialCents) {
        dollars = initialDollars;
        cents = initialCents;
    }
    public int getDollars () {
        return dollars;
    }
    public int getCents () {
        return cents;
    }
    public int getBalance (){
        return dollars + cents/100;
    }
    public void setDollars ( int updatedDollars) {
        dollars = updatedDollars;
       }
    public void setCents (int updatedCents) {
        cents = updatedCents;
       }
    public static void main (String[] args){
        BankAccount checkingAccount = new BankAccount (1837,21);
        System.out.println ( checkingAccount.getBalance());
        checkingAccount.setDollars (checkingAccount.getDollars() * 10);
    }
}
