package decoratorPattern;
import javax.swing.*;
import java.awt.*;

public class TimeDisplay extends DisplayDecorator {
    LabelPanel labelPanel;
    Display displayComponent;

    TimeDisplay(Display display, int width, int height) {
        super(display, width, height);
        displayComponent = display;
        labelPanel = new LabelPanel();
    }

    @Override
    public JPanel create() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel subPanel = displayComponent.create();
        //HudDisplay¿« create»£√‚
        panel.add(subPanel);
        panel.add(labelPanel.createPanel(getWidth(), getHeight()));
        panel.setMinimumSize(new Dimension(getWidth(), getHeight()));
        panel.setPreferredSize(new Dimension(getWidth(), getHeight()));
        return panel;
    }

    @Override
    public void show() {
        displayComponent.show();
        labelPanel.updateText("Date: " +java.time.LocalDateTime.now().toString() );
    }

    @Override
    public int getHeight() {
        return displayComponent.getHeight() + super.getHeight();
    }
}
