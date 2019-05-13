import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Main implements ActionListener {

    static JLabel color;
    static JTextField textField;
    static ArrayList<Color> colors;
    static ArrayList<String> words;
    static Color chosenColor;
    static int score = 0;
    static JLabel start;
    static Random random = new Random(new Date().getTime());
    static Timer timer;

    static void initColors() {
        colors = new ArrayList<>();
        colors.add(Color.WHITE);
        colors.add(Color.BLUE);
        colors.add(Color.ORANGE);
        colors.add(Color.BLACK);
        colors.add(Color.GRAY);
        colors.add(Color.YELLOW);
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        colors.add(Color.PINK);
    }

    static void initWords() {
        words = new ArrayList<>();
        words.add("White");
        words.add("Blue");
        words.add("Orange");
        words.add("Black");
        words.add("Gray");
        words.add("Yellow");
        words.add("Red");
        words.add("Green");
        words.add("Pink");
        words.add("Purple");
    }

    public static void main(String[] args) {
        initColors();
        initWords();

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        frame.getContentPane().add(panel);

        JLabel label = new JLabel(" Type in the colour of the words, and not the word text!");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(500,25));
        label.setFont(new Font("Serfis",Font.BOLD,14));
        label.setForeground(Color.WHITE);
        panel.add(label);
        start = new JLabel(" Press enter to start");
        start.setHorizontalAlignment(SwingConstants.CENTER);
        start.setPreferredSize(new Dimension(400,25));
        start.setFont(new Font("Start",Font.ITALIC,15));
        start.setForeground(Color.WHITE);
        panel.add(start);
        JLabel time = new JLabel(" Time left: ");
        time.setHorizontalAlignment(SwingConstants.CENTER);
        time.setPreferredSize(new Dimension(400,25));
        time.setFont(new Font("Time",Font.ITALIC,15));
        time.setForeground(Color.white);
        panel.add(time);
        color = new JLabel("Red") ;
        color.setPreferredSize(new Dimension(400, 200));
        color.setFont(new Font("ColorDisplayer", Font.BOLD, 50));
        color.setHorizontalAlignment(SwingConstants.CENTER);
        color.setVerticalAlignment(SwingConstants.CENTER);
        color.setVisible(false);
        panel.add(color);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(300, 20));
        textField.addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) {
            }
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    checkAnswer();
                    color.setVisible(true);
                    nextColor();
                }
            }
            public void keyReleased(KeyEvent e) {}
        });
        panel.add(textField);


//setting the frame size
        frame.setSize(new Dimension(600, 400));
//set the start position
        frame.setLocationRelativeTo(null);
//set a default close action
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//set a title
        frame.setTitle("ColourGame");
//Disable resize
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void nextColor() {
        color.setText(words.get(random.nextInt(10)));
        chosenColor = colors.get(random.nextInt(9));
        color.setForeground(chosenColor);
        try {
            if (timer.isRunning()) {
                timer.stop();
            }
        } catch (Exception ignored) {

        }
    }

    private static void checkAnswer() {
        String usersColor = textField.getText().toLowerCase();
        System.out.println(usersColor + " " + chosenColor);
        if (chosenColor == Color.WHITE && usersColor.equals("white") ||
                chosenColor == Color.BLACK && usersColor.equals("black") ||
                chosenColor == Color.RED && usersColor.equals("red") ||
                chosenColor == Color.ORANGE && usersColor.equals("orange") ||
                chosenColor == Color.GRAY && usersColor.equals("gray") ||
                chosenColor == Color.GREEN && usersColor.equals("green") ||
                chosenColor == Color.BLUE && usersColor.equals("blue") ||
                chosenColor == Color.YELLOW && usersColor.equals("yellow") ||
                chosenColor == Color.PINK && usersColor.equals("pink")){
            score ++;
        }

        start.setText("Score " + score);
        textField.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
