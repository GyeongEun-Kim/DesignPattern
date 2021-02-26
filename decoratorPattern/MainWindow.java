package decoratorPattern;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainWindow extends FrameWindow {
    private static final String MAIN_TITLE = "Main Window";
    private static final String TEXTFIELD_WINDOW_TITLE = "TextField Window";
    private static final String LABEL_WINDOW_TITLE = "Label Window";
    private static final String TEXTFIELD_OBSERVER_BUTTON_TITLE = "Update TextField Window Observer";
    private static final String LABEL_OBSERVER_BUTTON_TITLE = "Update Label Window Observer";
    private static final String STOP_THREAD_BUTTON_TITLE = "Stop Generating Prime Number";
    private static final int X = 250;
    private static final int Y = 100;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 100;
    private static final int GAP = 50;

    private ArrayList<String> displayList;
    private JFrame frame;

    public JFrame createWindow(String title, int x, int y, int width, int height) {
        JFrame frame;
        // ?���? ?��면의 뼈�?�? 구성?�� (?��?��?�� ???�� 만들?���?)
        frame = new JFrame(title);
        // ?���? ?���? �??�� (?��?��?�� ?��면의 ?��비�? ?��?��?�� 매개 �??���? ?��?��?��)
        frame.setBounds(x, y, width, height);
        
        // createPanel() ?��?���? ?��출해?�� ?��?��?��?�� ?��?? ?��?��?��?��?�� 구성 ?��?��?�� ?��?�� ?��?��?��?��?���? 조합?���?, ?���? ?��?��?��?��?���? 구성?��?�� ?��?��?�� ?��?�� 받음
        // ?��질적?�� ?���? 구성?? createPanel()?��?��?��?�� ?��?��?��
        JPanel panel = createPanel(width, height);
        
        // ?��?��?��?�� ?���? ?��?��?�� 붙임        
        frame.getContentPane().add(panel);
        frame.pack();
        
        // ?��?��?���? ?��면에 보이�? 만듦
        frame.setVisible(true);
        return frame;
    }

    public void closeWindow() {
        frame.setVisible(false);
        frame.dispose();
    }

    public MainWindow(String title, ArrayList<String> list) {
        displayList = list;
        // 메인 ?��?��?��?�� ?��기는 주어�? ?��비�? ?��?�� * (?��?��?��?��?�� 구성 ?��?�� + 1)      
        // ?��?�� ?���? 구성?? createWindow() ?��?��?��?�� 처리?��
        frame = createWindow(title, X, Y, WIDTH, HEIGHT * (displayList.size() + 1));
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeWindow();
                System.exit(0);
            }
        });
    }

    public JPanel createPanel(int width, int height) {
        // ?��?�� 바탕?�� ?��?�� ?��?�� ?��?��
        JPanel panel = new JPanel();
        // ?��?��?�� ?��?��?��?��?? BoxLayout.Y_AXIS ?��?���? �??��. ?��?��?�� ?��?�� ?��?�� ?���? ?��?��?�� 추�??���?, ?��로축 방향?���? 추�?(add)?�� ?��?��??�? ?��?��?��
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        // ?��?��?�� ?���? ?���? �??��
        panel.setMinimumSize(new Dimension(width, height));
        panel.setPreferredSize(new Dimension(width, height));

        // 기본 컴포?��?�� ?��?��. HudDisplay?�� �??�� 기본?��?�� ?��?��?��?��?�� 구성?��?���? ?��
        Display display = new HudDisplay(WIDTH, HEIGHT);
        // 리스?��?�� ?��?�� ?��?��?�� 바탕?���? ?��?�� 추�??���?. ?��?��?�� 추�??��?�� 것�? ?��?��까�? 구성?�� ?��?��?��?��?�� ?��?��?�� 감�? ?�� ?��?�� ?��로운 ?��?��?�� ?��?��?���?, 
        // �? ?��?�� ?��?��까�? 만들?���? ?��?���? �??���? ?�� ?�� ?��?�� LabelPanel?�� 추�??��
        // ?��로운 ?��?��?�� 추�??�� ?��마다 ?��로운 ?��?��?�� ?��?��?���?, �? ?��?�� 기존 ?��?��?�� 추�??��(add)
        for (String name : displayList) {
            if (name.equals("speed")) {
                // display �??���? 참조?��?�� 기존 ?��?��?��?��?�� ?��?���? ?��?��?��?��?���? ?�� 붙임
                display = new SpeedometerDisplay(display, WIDTH, HEIGHT); 
            }
            else if (name.equals("time")) {
                // display �??���? 참조?��?�� 기존 ?��?��?��?��?�� ?���? ?��?��?��?��?���? ?�� 붙임
                display = new TimeDisplay(display, WIDTH, HEIGHT);
            }
            else if (name.equals("weather")) {
                // display �??���? 참조?��?�� 기존 ?��?��?��?��?�� ?��?�� ?��?��?��?��?���? ?�� 붙임
                display = new WeatherDisplay(display, WIDTH, HEIGHT);
            }
        }
        // ?��?��?�� 모두 ?��?���? 최종 ?��?��?��?��?�� ?��?��?�� ?��?��?��?���? ?��. ?��?�� ?��?��?��?�� ?��?��?��?�� 최종 ?��?��?�� 만들?���?�?, ?��것을 ?��로운 ?��?��?�� �?�? ?��?��
       panel.add(display.create());
        
        // ?��?���? 출력
        System.out.println("display.height = " + display.getHeight());
        
        // ?��?��?��?��?��마다 각각?�� ?��?��?�� ?��면에 보임
        display.show();
        return panel;
    }

    public static void main(String[] args) {
        final String displayFileName = "displays.txt";
        ArrayList<String> list;
        LoadHudDisplays loadDisplay = new LoadHudDisplays(displayFileName);
        list = loadDisplay.load();
        System.out.printf("display.size() = %d\n", list.size());
        for (String s : list) {
            System.out.println(s);
        }

        MainWindow mainWindow = new MainWindow(MainWindow.MAIN_TITLE, list);
    }
}
