package game;

public class Disk implements IDisk {
    private int radius;
    private char color;
    private int r,c;

    public Disk(char color, int r, int c){
        this.color = color;
        this.r = r;
        this.c = c;
    }

    public Disk(char color){
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("Disk{ radius=" + radius + ", color=" + color + ", r=" + r + ", c=" + c + '}');
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public char getColor() {
        return color;
    }

    @Override
    public void setColor(char color) {
        this.color = color;
    }

    public int getR() {
        return r;
    }

    @Override
    public void setR(int r) {
        this.r = r;
    }

    public int getC() {
        return c;
    }

    @Override
    public void setC(int c) {
        this.c = c;
    }
}
