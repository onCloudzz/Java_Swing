import javax.swing.*;
import java.awt.*;

public class MapPanel extends JPanel {
    Map map;
    int [][] mapArray;
    JPanel [][] mapPanelArray;
    public MapPanel() {
        setPreferredSize(new Dimension(300, 200));
        setLayout(new GridLayout(3,3));

        mapPanelArray = new JPanel[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                mapPanelArray[i][j] = new JPanel();
                mapPanelArray[i][j].setBackground(Color.white);
                add(mapPanelArray[i][j]);
            }
        }

        setVisible(true);
    }
    public void setMap(int[][] map,int currentFloor,int currentRoom){
        mapArray = map;
        for(int i = 0; i<3;i++){
            for(int j = 0; j<3;j++){
                if(currentFloor+i-1 == -1 || currentRoom+j-1 == -1 || currentFloor+i-1 == 100 || currentRoom+j-1 == 3){
                    mapPanelArray[i][j].setBackground(Color.black);
                    continue;
                }
                if(mapArray[currentFloor+i-1][currentRoom+j-1] / 1000 == 1){
                    if(mapArray[currentFloor+i-1][currentRoom+j-1] == 1000){
                        mapPanelArray[i][j].setBackground(Color.GRAY);
                        continue;
                    }
                    mapPanelArray[i][j].setBackground(Color.green);
                } else if (mapArray[currentFloor+i-1][currentRoom+j-1] / 1000 == 2) {
                    mapPanelArray[i][j].setBackground(Color.orange);
                } else if (mapArray[currentFloor+i-1][currentRoom+j-1] / 1000 == 3) {
                    mapPanelArray[i][j].setBackground(Color.red);
                } else if (mapArray[currentFloor+i-1][currentRoom+j-1] / 1000 == 4) {
                    mapPanelArray[i][j].setBackground(Color.magenta);
                }
            }
        }
        mapPanelArray[1][1].setBorder(BorderFactory.createLineBorder(Color.gray, 4));

    }
}
