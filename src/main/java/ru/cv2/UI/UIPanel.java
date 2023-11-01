package ru.cv2.UI;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class UIPanel extends JPanel {
    private boolean state;
    private Image img;
    private ImageObserver observer;

    public UIPanel() {
        state = false;
        setPreferredSize(new Dimension(100, 100));
    }

    public void setImg(String ing) throws IOException {
        try {
            switch (ing){
                case "Liquid" -> img = ImageIO.read(new File("src/main/java/ru/cv2/images/liquid.png"));
                case "Coil" -> img = ImageIO.read(new File("src/main/java/ru/cv2/images/coil.png"));
                case "Charger" -> img = ImageIO.read(new File("src/main/java/ru/cv2/images/charger.jpg"));
                case "Free" -> img = ImageIO.read(new File("src/main/java/ru/cv2/images/free.png"));
                case "Vape" -> img = ImageIO.read(new File("src/main/java/ru/cv2/images/vaping.png"));
            }
        } catch (IOException ex){
            System.out.println("Where da heck is my images?!");
            ex.printStackTrace();
        }

    }
    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        graphics.drawImage(img, 0, 0, 100, 100, observer);
    }
}
