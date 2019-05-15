
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Yegor
 */
public class TitlesFrame
extends JFrame {

    /**
     *
     */
    public TitlesFrame() {
        this.initUI();
    }

    private void initUI() {
        this.setTitle("\u041a\u0440\u0438\u0432\u044b\u0435 \u0444\u0438\u0433\u0443\u0440\u044b");
        this.setDefaultCloseOperation(3);
        this.add(new TitlesPanel(11)); // Замена значения TItlePanel() для дальнейшего использования в SWICH-CASE , для построения требуемых для задания фигур. Вариант 1 шестиугольник толщина границы 3.0F
        this.setSize(350, 350);
        this.setLocationRelativeTo(null);
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
                TitlesFrame ps = new TitlesFrame();
                ps.setVisible(true);
            }
        });
    }

}
