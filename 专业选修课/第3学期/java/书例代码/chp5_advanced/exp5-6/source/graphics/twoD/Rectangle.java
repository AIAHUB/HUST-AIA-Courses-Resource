package graphics.twoD;

public class Rectangle {
    public int width = 0;
    public int height = 0;
    public Point origin;

    // �������ĸ����췽����
 /*   public Rectangle() {
		origin = new Point(0, 0);
    }
    public Rectangle(Point p) {
		origin = p;
    }
    public Rectangle(int w, int h) {
		this(new Point(0, 0), w, h);
    }*/
 public Rectangle(Point p, int w, int h) {
		origin = p;
		width = w;
		height = h;
    }

    // �ƶ����εķ�����
    public void move(int x, int y) {
		origin.x = x;
		origin.y = y;
    }

    // �����������ķ�����
    public int area() {
		return width * height;
    }
}
