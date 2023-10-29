
package hotelideal.Entidades;


public enum EnumColor {
    
    DEFAULT(75, 110, 175), 
    BLUE(10, 132, 255), 
    PURPLE(191, 90, 242), 
    RED(255, 69, 58), 
    ORANGE(255, 159, 10), 
    YELLOW(255, 204, 0), 
    GREEN(50,215,75);
    
    private final int r;
    private final int g;
    private final int b;

    private EnumColor(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }

    
    
}
