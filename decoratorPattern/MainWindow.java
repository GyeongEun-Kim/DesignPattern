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
        // ? μ²? ?λ©΄μ λΌλ?λ₯? κ΅¬μ±?¨ (???° ??? λ§λ€?΄μ€?)
        frame = new JFrame(title);
        // ?λ©? ?¬κΈ? μ§??  (???° ?λ©΄μ ?λΉμ? ??΄? λ§€κ° λ³??λ‘? ? ?¬?¨)
        frame.setBounds(x, y, width, height);
        
        // createPanel() ?¨?λ₯? ?ΈμΆν΄? ??Ό?? ?½?? ??€?? ?΄ κ΅¬μ± ??? ?°?Ό ??€?? ?΄λ₯? μ‘°ν©?κ³?, ? μ²? ??€?? ?΄λ₯? κ΅¬μ±?? ?¨?? ?? € λ°μ
        // ?€μ§μ ?Έ ?λ©? κ΅¬μ±?? createPanel()?¨??? ?Ό?΄?¨
        JPanel panel = createPanel(width, height);
        
        // ???°? ? μ²? ?¨?? λΆμ        
        frame.getContentPane().add(panel);
        frame.pack();
        
        // ???°λ₯? ?λ©΄μ λ³΄μ΄κ²? λ§λ¦
        frame.setVisible(true);
        return frame;
    }

    public void closeWindow() {
        frame.setVisible(false);
        frame.dispose();
    }

    public MainWindow(String title, ArrayList<String> list) {
        displayList = list;
        // λ©μΈ ???°? ?¬κΈ°λ μ£Όμ΄μ§? ?λΉμ? ??΄ * (??€?? ?΄ κ΅¬μ± ?? + 1)      
        // ?€?  ?λ©? κ΅¬μ±?? createWindow() ?¨??? μ²λ¦¬?¨
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
        // ? ?Ό λ°ν? ??Ό ?¨? ??±
        JPanel panel = new JPanel();
        // ?¨?? ? ?΄???? BoxLayout.Y_AXIS ??λ‘? μ§?? . ?¨?? ?? ― ?? ?€λ₯? ?¨?? μΆκ??λ©?, ?Έλ‘μΆ λ°©ν₯?Όλ‘? μΆκ?(add)? ????λ‘? ??΄?¨
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        // ?¨?? ? μ²? ?¬κΈ? μ§?? 
        panel.setMinimumSize(new Dimension(width, height));
        panel.setPreferredSize(new Dimension(width, height));

        // κΈ°λ³Έ μ»΄ν¬??Έ ??±. HudDisplay? κ°??₯ κΈ°λ³Έ? ?Έ ??€?? ?΄ κ΅¬μ±??κ°? ?¨
        Display display = new HudDisplay(WIDTH, HEIGHT);
        // λ¦¬μ€?Έ? ?? ?΄?©? λ°ν?Όλ‘? ?₯? μΆκ??κΈ?. ?₯?? μΆκ??? κ²μ? ??¬κΉμ? κ΅¬μ±? ??€?? ?΄ ?¨?? κ°μ? ? ?? ?λ‘μ΄ ?¨?? ??±?κ³?, 
        // κ·? ?? ?¬?κΉμ? λ§λ€?΄μ§? ?¨?κ³? κΈ??¨λ₯? ?Έ ? ?? LabelPanel? μΆκ??¨
        // ?λ‘μ΄ ?₯??΄ μΆκ??  ?λ§λ€ ?λ‘μ΄ ?¨??΄ ??±?κ³?, κ·? ?? κΈ°μ‘΄ ?¨??΄ μΆκ??¨(add)
        for (String name : displayList) {
            if (name.equals("speed")) {
                // display λ³??κ°? μ°Έμ‘°?? κΈ°μ‘΄ ??? ?΄? ??κ³? ??€?? ?΄λ₯? ?§ λΆμ
                display = new SpeedometerDisplay(display, WIDTH, HEIGHT); 
            }
            else if (name.equals("time")) {
                // display λ³??κ°? μ°Έμ‘°?? κΈ°μ‘΄ ??? ?΄? ?κ³? ??€?? ?΄λ₯? ?§ λΆμ
                display = new TimeDisplay(display, WIDTH, HEIGHT);
            }
            else if (name.equals("weather")) {
                // display λ³??κ°? μ°Έμ‘°?? κΈ°μ‘΄ ??? ?΄? ? ?¨ ??€?? ?΄λ₯? ?§ λΆμ
                display = new WeatherDisplay(display, WIDTH, HEIGHT);
            }
        }
        // ?₯??΄ λͺ¨λ ??λ©? μ΅μ’ ??€?? ?΄ ?¨?? ??±??λ‘? ?¨. ?₯? ?¨??€? ?¬?¨?? μ΅μ’ ?¨??΄ λ§λ€?΄μ§?κ³?, ?΄κ²μ ?λ‘μ΄ ?¨?? λΆ?μ°? ??΄
       panel.add(display.create());
        
        // ??΄λ₯? μΆλ ₯
        System.out.println("display.height = " + display.getHeight());
        
        // ??€?? ?΄λ§λ€ κ°κ°? ?΄?©? ?λ©΄μ λ³΄μ
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
