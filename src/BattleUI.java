import javax.swing.*;
import java.awt.*;

public class BattleUI extends JPanel {
    JPanel[] enamyPanel;
    Map map;
    MainStat mainStat;
    public BattleUI() {
        setLayout(new GridLayout(1,3));
        setBounds(300, 0, 1000, 700);

        setBackground(new Color(100,0,0));
    }

}

