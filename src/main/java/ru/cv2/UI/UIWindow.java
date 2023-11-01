package ru.cv2.UI;

import javax.swing.*;
import java.awt.*;

public class UIWindow extends JFrame {

    private UIPanel[] images;
    public UIWindow(){
        setTitle("Vaping club");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        images = new UIPanel[3];

        for(int i = 0; i < 3; i++){
            images[i] = new UIPanel();
            add(images[i]);
        }

        pack();
        setVisible(true);
    }

    public UIPanel[] getImages(){
        return images;
    }
}
