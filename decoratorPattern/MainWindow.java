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
        // ? „ì²? ?™”ë©´ì˜ ë¼ˆë?ë¥? êµ¬ì„±?•¨ (?œˆ?„?š° ???„ ë§Œë“¤?–´ì¤?)
        frame = new JFrame(title);
        // ?™”ë©? ?¬ê¸? ì§?? • (?œˆ?„?š° ?™”ë©´ì˜ ?„ˆë¹„ì? ?†’?´?Š” ë§¤ê°œ ë³??ˆ˜ë¡? ? „?‹¬?¨)
        frame.setBounds(x, y, width, height);
        
        // createPanel() ?•¨?ˆ˜ë¥? ?˜¸ì¶œí•´?„œ ?ŒŒ?¼?—?„œ ?½?? ?””?Š¤?”Œ? ˆ?´ êµ¬ì„± ?š”?†Œ?— ?”°?¼ ?””?Š¤?”Œ? ˆ?´ë¥? ì¡°í•©?•˜ê³?, ? „ì²? ?””?Š¤?”Œ? ˆ?´ë¥? êµ¬ì„±?•˜?Š” ?Œ¨?„?„ ?Œ? ¤ ë°›ìŒ
        // ?‹¤ì§ˆì ?¸ ?™”ë©? êµ¬ì„±?? createPanel()?•¨?ˆ˜?—?„œ ?¼?–´?‚¨
        JPanel panel = createPanel(width, height);
        
        // ?œˆ?„?š°?— ? „ì²? ?Œ¨?„?„ ë¶™ì„        
        frame.getContentPane().add(panel);
        frame.pack();
        
        // ?œˆ?„?š°ë¥? ?™”ë©´ì— ë³´ì´ê²? ë§Œë“¦
        frame.setVisible(true);
        return frame;
    }

    public void closeWindow() {
        frame.setVisible(false);
        frame.dispose();
    }

    public MainWindow(String title, ArrayList<String> list) {
        displayList = list;
        // ë©”ì¸ ?œˆ?„?š°?˜ ?¬ê¸°ëŠ” ì£¼ì–´ì§? ?„ˆë¹„ì? ?†’?´ * (?””?Š¤?”Œ? ˆ?´ êµ¬ì„± ?š”?†Œ + 1)      
        // ?‹¤? œ ?™”ë©? êµ¬ì„±?? createWindow() ?•¨?ˆ˜?—?„œ ì²˜ë¦¬?•¨
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
        // ? œ?¼ ë°”íƒ•?— ?†“?¼ ?Œ¨?„ ?ƒ?„±
        JPanel panel = new JPanel();
        // ?Œ¨?„?˜ ? ˆ?´?•„?›ƒ?? BoxLayout.Y_AXIS ?˜•?ƒœë¡? ì§?? •. ?Œ¨?„?— ?œ„? ¯ ?˜?Š” ?‹¤ë¥? ?Œ¨?„?„ ì¶”ê??•˜ë©?, ?„¸ë¡œì¶• ë°©í–¥?œ¼ë¡? ì¶”ê?(add)?•œ ?ˆœ?„œ??ë¡? ?‚˜?—´?¨
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        // ?Œ¨?„?˜ ? „ì²? ?¬ê¸? ì§?? •
        panel.setMinimumSize(new Dimension(width, height));
        panel.setPreferredSize(new Dimension(width, height));

        // ê¸°ë³¸ ì»´í¬?„Œ?Š¸ ?ƒ?„±. HudDisplay?Š” ê°??¥ ê¸°ë³¸? ?¸ ?””?Š¤?”Œ? ˆ?´ êµ¬ì„±?š”?†Œê°? ?¨
        Display display = new HudDisplay(WIDTH, HEIGHT);
        // ë¦¬ìŠ¤?Š¸?— ?ˆ?Š” ?‚´?š©?„ ë°”íƒ•?œ¼ë¡? ?¥?‹ ì¶”ê??•˜ê¸?. ?¥?‹?„ ì¶”ê??•˜?Š” ê²ƒì? ?˜„?¬ê¹Œì? êµ¬ì„±?œ ?””?Š¤?”Œ? ˆ?´ ?Œ¨?„?„ ê°ì? ?ˆ˜ ?ˆ?Š” ?ƒˆë¡œìš´ ?Œ¨?„?„ ?ƒ?„±?•˜ê³?, 
        // ê·? ?•ˆ?— ?—¬?ƒœê¹Œì? ë§Œë“¤?–´ì§? ?Œ¨?„ê³? ê¸??”¨ë¥? ?“¸ ?ˆ˜ ?ˆ?Š” LabelPanel?„ ì¶”ê??•¨
        // ?ƒˆë¡œìš´ ?¥?‹?´ ì¶”ê??  ?•Œë§ˆë‹¤ ?ƒˆë¡œìš´ ?Œ¨?„?´ ?ƒ?„±?˜ê³?, ê·? ?•ˆ?— ê¸°ì¡´ ?Œ¨?„?´ ì¶”ê??¨(add)
        for (String name : displayList) {
            if (name.equals("speed")) {
                // display ë³??ˆ˜ê°? ì°¸ì¡°?•˜?Š” ê¸°ì¡´ ?””?”Œ? ˆ?´?— ?†?„ê³? ?””?Š¤?”Œ? ˆ?´ë¥? ?§ ë¶™ì„
                display = new SpeedometerDisplay(display, WIDTH, HEIGHT); 
            }
            else if (name.equals("time")) {
                // display ë³??ˆ˜ê°? ì°¸ì¡°?•˜?Š” ê¸°ì¡´ ?””?”Œ? ˆ?´?— ?‹œê³? ?””?Š¤?”Œ? ˆ?´ë¥? ?§ ë¶™ì„
                display = new TimeDisplay(display, WIDTH, HEIGHT);
            }
            else if (name.equals("weather")) {
                // display ë³??ˆ˜ê°? ì°¸ì¡°?•˜?Š” ê¸°ì¡´ ?””?”Œ? ˆ?´?— ?‚ ?”¨ ?””?Š¤?”Œ? ˆ?´ë¥? ?§ ë¶™ì„
                display = new WeatherDisplay(display, WIDTH, HEIGHT);
            }
        }
        // ?¥?‹?´ ëª¨ë‘ ??‚˜ë©? ìµœì¢… ?””?Š¤?”Œ? ˆ?´ ?Œ¨?„?„ ?ƒ?„±?•˜?„ë¡? ?•¨. ?¥?‹ ?Œ¨?„?“¤?„ ?¬?•¨?•˜?Š” ìµœì¢… ?Œ¨?„?´ ë§Œë“¤?–´ì§?ê³?, ?´ê²ƒì„ ?ƒˆë¡œìš´ ?Œ¨?„?— ë¶?ì°? ?‹œ?‚´
       panel.add(display.create());
        
        // ?†’?´ë¥? ì¶œë ¥
        System.out.println("display.height = " + display.getHeight());
        
        // ?””?Š¤?”Œ? ˆ?´ë§ˆë‹¤ ê°ê°?˜ ?‚´?š©?„ ?™”ë©´ì— ë³´ì„
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
