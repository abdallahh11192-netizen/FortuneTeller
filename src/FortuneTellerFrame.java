import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {

    JPanel topPanel;
    JPanel middlePanel;
    JPanel bottomPanel;

    JLabel titleLabel;
    JTextArea fortuneArea;
    JScrollPane scrollPane;

    JButton fortuneButton;
    JButton quitButton;

    String[] fortunes = {
            "You will have a great day!",
            "Something exciting is coming your way.",
            "Good news will arrive soon.",
            "You will learn something new today.",
            "A surprise is waiting for you.",
            "Your hard work will pay off.",
            "You will make someone smile today.",
            "A new opportunity will appear soon.",
            "You will find something you thought was lost.",
            "Today is a good day to try something new.",
            "Someone will give you good advice.",
            "You will achieve one of your goals soon."
    };

    Random random = new Random();
    int lastFortune = -1;

    public FortuneTellerFrame() {

        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        createTopPanel();
        createMiddlePanel();
        createBottomPanel();

        add(topPanel, BorderLayout.NORTH);
        add(middlePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        setSize(
                (int) (screenSize.width * 0.75),
                (int) (screenSize.height * 0.75)
        );

        setLocationRelativeTo(null);
    }

    private void createTopPanel() {

        topPanel = new JPanel();

        ImageIcon originalIcon = new ImageIcon("fortune.png");

        Image scaledImage = originalIcon.getImage().getScaledInstance(
                300, 188, Image.SCALE_SMOOTH
        );

        ImageIcon fortuneIcon = new ImageIcon(scaledImage);

        titleLabel = new JLabel(
                "Fortune Teller",
                fortuneIcon,
                JLabel.CENTER
        );

        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);

        Font titleFont = new Font(
                "Serif",
                Font.BOLD,
                42
        );

        titleLabel.setFont(titleFont);

        topPanel.add(titleLabel);
    }

    private void createMiddlePanel() {

        middlePanel = new JPanel(new BorderLayout());

        fortuneArea = new JTextArea();

        fortuneArea.setEditable(false);
        fortuneArea.setLineWrap(true);
        fortuneArea.setWrapStyleWord(true);

        Font fortuneFont = new Font(
                "Serif",
                Font.PLAIN,
                20
        );

        fortuneArea.setFont(fortuneFont);

        scrollPane = new JScrollPane(fortuneArea);

        middlePanel.add(
                scrollPane,
                BorderLayout.CENTER
        );
    }

    private void createBottomPanel() {

        bottomPanel = new JPanel();

        fortuneButton = new JButton(
                "Read My Fortune!"
        );

        quitButton = new JButton(
                "Quit"
        );

        Font buttonFont = new Font(
                "SansSerif",
                Font.BOLD,
                18
        );

        fortuneButton.setFont(buttonFont);
        quitButton.setFont(buttonFont);

        fortuneButton.addActionListener(
                e -> showFortune()
        );

        quitButton.addActionListener(
                e -> System.exit(0)
        );

        bottomPanel.add(fortuneButton);
        bottomPanel.add(quitButton);
    }

    private void showFortune() {

        int newFortune;

        do {
            newFortune =
                    random.nextInt(fortunes.length);

        } while (newFortune == lastFortune);

        lastFortune = newFortune;

        fortuneArea.append(
                fortunes[newFortune] + "\n"
        );
    }
}