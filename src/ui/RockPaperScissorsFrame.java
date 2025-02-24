package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame {
    private int playerWins = 0;
    private int computerWins = 0;
    private int ties = 0;

    private JTextArea resultsArea;
    private JTextField playerWinsField, computerWinsField, tiesField;
    private JTextArea textArea;

    // Create the frame
    public RockPaperScissorsFrame() {
        setTitle("Rock Paper Scissors Game");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for Rock, Paper, Scissors, Quit buttons
        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(1, 4));
        gamePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Buttons for Rock, Paper, Scissors, Quit
        JButton rockButton = new JButton("Rock");
        JButton paperButton = new JButton("Paper");
        JButton scissorsButton = new JButton("Scissors");
        JButton quitButton = new JButton("Quit");

        // Add icons
        rockButton.setIcon(new ImageIcon("src/ui/rock.png"));
        paperButton.setIcon(new ImageIcon("src/ui/paper.png"));
        scissorsButton.setIcon(new ImageIcon("src/ui/scissor.png"));


        gamePanel.add(rockButton);
        gamePanel.add(paperButton);
        gamePanel.add(scissorsButton);
        gamePanel.add(quitButton);

        // Stats panel (Player Wins, Computer Wins, Ties)
        JPanel statsPanel = new JPanel();
        statsPanel.setLayout(new GridLayout(3, 2));

        statsPanel.add(new JLabel("Player Wins:"));
        playerWinsField = new JTextField("0");
        statsPanel.add(playerWinsField);

        statsPanel.add(new JLabel("Computer Wins:"));
        computerWinsField = new JTextField("0");
        statsPanel.add(computerWinsField);

        statsPanel.add(new JLabel("Ties:"));
        tiesField = new JTextField("0");
        statsPanel.add(tiesField);

        // Panel for displaying results of the game
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Add panels to frame
        add(gamePanel, BorderLayout.NORTH);
        add(statsPanel, BorderLayout.WEST);
        add(scrollPane, BorderLayout.CENTER);

        // Action Listeners for buttons
        rockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playGame("Rock");
            }
        });

        paperButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playGame("Paper");
            }
        });

        scissorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playGame("Scissors");
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    // Method to play a single round of the game
    private void playGame(String playerChoice) {
        String computerChoice = getComputerChoice();
        String result = getResult(playerChoice, computerChoice);

        // Update results area
        textArea.append(playerChoice + " vs " + computerChoice + " -> " + result + "\n");

        // Update stats
        if (result.equals("Player wins")) {
            playerWins++;
        } else if (result.equals("Computer wins")) {
            computerWins++;
        } else {
            ties++;
        }

        // Update text fields
        playerWinsField.setText(String.valueOf(playerWins));
        computerWinsField.setText(String.valueOf(computerWins));
        tiesField.setText(String.valueOf(ties));
    }

    // Method to determine the computer's choice
    private String getComputerChoice() {
        Random random = new Random();
        int choice = random.nextInt(3);
        if (choice == 0) return "Rock";
        else if (choice == 1) return "Paper";
        else return "Scissors";
    }

    // Method to determine the result of the game
    private String getResult(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            return "Tie";
        }
        if ((playerChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                (playerChoice.equals("Paper") && computerChoice.equals("Rock")) ||
                (playerChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
            return "Player wins";
        } else {
            return "Computer wins";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RockPaperScissorsFrame().setVisible(true);
            }
        });
    }
}
