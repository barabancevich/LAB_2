import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class ShapeFactory {
    public Shape shape;  
    public BasicStroke stroke = new BasicStroke(3.0f); // по умолчания цвет и  толщина контура 3п. 
    public Paint paint; 
    public int width = 25; // Ширина
    public int height = 25; // Высота 

    public ShapeFactory(int shape_type) {
        switch (shape_type / 10) {   // Выбор геометрических параметров фигуры 
            case 1: {
                this.shape = ShapeFactory.createStar(3, new Point(0, 0), (double)this.width / 2.0, (double)this.width / 2.0); // шестиугольник 
                break;
            }
            case 3: {
                this.shape = ShapeFactory.createStar(5, new Point(0, 0), (double)this.width / 2.0, (double)this.width / 4.0); // Пятиконечная звезда 
                break;
            }
            case 5: {
                this.shape = new Rectangle2D.Double((double)(-this.width) / 2.0, (double)(-this.height) / 2.0, this.width, this.height); // Квадраты
                break;
            }
            case 7: { // Треугольнии
                GeneralPath path = new GeneralPath();
                double tmp_height = Math.sqrt(2.0) / 2.0 * (double)this.height;
                path.moveTo((double)(-this.width / 2), -tmp_height);
                path.lineTo(0.0, -tmp_height);
                path.lineTo((double)(this.width / 2), tmp_height);
                path.closePath();
                this.shape = path;
                break;
            }
            case 9: { // PACKMAN
                this.shape = new Arc2D.Double((double)(-this.width) / 2.0, (double)(-this.height) / 2.0, this.width, this.height, 30.0, 300.0, 2);
                break;
            }
            default: {
                throw new Error("type is nusupported");
            }
        }
        switch (shape_type % 10) { // Выбор цвета, тольщины, или градиент 
            case 1: {
                this.stroke = new BasicStroke(3.0f);  //Толщина контура 3п. цвет по умолчанию 
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                this.stroke = new BasicStroke(7.0f); //Толщина контура  7п. цвет по умолчанию 
                break;
            }
            case 7: {
                this.paint = new GradientPaint(-this.width, -this.height, Color.white, this.width, this.height, Color.gray, true); //Толщина контура  3п. цвет по умолчанию, заливка градиентом 
                break;
            }
            case 8: {
                this.paint = Color.red; //Толщина контура  3п. цвет по крастный 
                break;
            }
            default: {
                throw new Error("type is nusupported");
            }
        }
    }

    private static Shape createStar(int arms, Point center, double rOuter, double rInner) {  // Вывод фигуры на экран
        double angle = 3.141592653589793 / (double)arms;
        GeneralPath path = new GeneralPath();
        for (int i = 0; i < 2 * arms; ++i) {
            double r = (i & 1) == 0 ? rOuter : rInner;
            Point2D.Double p = new Point2D.Double((double)center.x + Math.cos((double)i * angle) * r, (double)center.y + Math.sin((double)i * angle) * r);
            if (i == 0) {
                path.moveTo(p.getX(), p.getY());
                continue;
            }
            path.lineTo(p.getX(), p.getY());
        }
        path.closePath();
        return path;
    }
}