package decoratorPattern;
import javax.swing.*;
import java.awt.*;

public class SpeedometerDisplay extends DisplayDecorator {
    Display displayComponent;
    LabelPanel labelPanel;

    SpeedometerDisplay(Display display, int width, int height) {
        super(display, width, height);
        displayComponent = display;
        labelPanel = new LabelPanel();
    }

    @Override
    public JPanel create() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel subPanel = displayComponent.create();
        panel.add(subPanel);
        panel.add(labelPanel.createPanel(getWidth(), getHeight()));
        panel.setMinimumSize(new Dimension(getWidth(), getHeight()));
        panel.setPreferredSize(new Dimension(getWidth(), getHeight()));
        return panel;
    }

    @Override
    public void show() {
        displayComponent.show();
        labelPanel.updateText("Speed: 50");
    }

    @Override
    public int getHeight() {
        return displayComponent.getHeight() + super.getHeight();
    }
}
