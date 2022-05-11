package IceCreamScoop;
import java.util.List;
import java.util.ArrayList;
public class IceCreamScoop {
    private String flavor;
    private List<String> toppings;
    private boolean melted;

    public IceCreamScoop (String flav) {
        flavor = flav;
        toppings = new ArrayList <String> ();
        melted = false;
    }
    public void melt() {
        melted = true;

    }

    public void addToping(String topping) {
        toppings.add(topping);
    }
    
    public String toString () {
        String basicDescription = "This " + flavor + " ice cream scoop, topped with " + toppings.toString();
        
        if (melted) {
            return basicDescription + "has melted";}
        else {
            return basicDescription + "has not melted";}
    }


    public static void main (String [] args)
    {
        IceCreamScoop vanillaCreamScoop = new IceCreamScoop("vanilla");
        vanillaCreamScoop.addToping("sprinkles"); 
        System.out.println(vanillaCreamScoop);

        IceCreamScoop strawberryScoop = new IceCreamScoop("strawberry");
        strawberryScoop.melt();
        strawberryScoop.addToping("whipped cream");
        System.out.println(strawberryScoop);
    }
}

