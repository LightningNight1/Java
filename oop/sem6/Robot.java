package oop.sem6;

public interface Robot {
    public void changeDirection(Direction direction);

    public void move();

    public long getId();

    public Point getPoint();
}