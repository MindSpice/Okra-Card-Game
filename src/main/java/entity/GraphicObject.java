package entity;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;



public class GraphicObject {
    protected GraphicsContext gc;
    protected String name;
    public double posX;
    public double posY;
    protected double width;
    protected double height;



    public Rectangle2D getBounds() {
        return new Rectangle2D(posX, posY, width, height);
    }

    public boolean intersects(GraphicObject go) {
        return go.getBounds().intersects(this.getBounds());
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosXY(double x,double y) {
        posX = x;
        posY = y;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double X) {
        posX = X;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double y) {
        posY = y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }



}
