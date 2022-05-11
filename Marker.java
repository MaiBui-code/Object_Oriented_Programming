public class Marker {
    private String color;
    private String capColor;

    public Marker (String col) {
        color = col;
        capColor = col;
    }

    public String getColor () {
        return color; 
    }

    public String getCapColor () {
        return capColor;
    }

    public void setCapColor (String updatedCapColor) {
        capColor = updatedCapColor;
    }

    public String toString() {
        return "A " + color + " marker with a " + capColor + " cap.";
    }

    public static void main (String[] args) {
        Marker redMarker = new Marker("red");
        Marker greenMarker = new Marker ("green");
        System.out.println(redMarker);
        System.out.println(greenMarker);
        redMarker.setCapColor("blue");
        System.out.println(redMarker);
    }
}
