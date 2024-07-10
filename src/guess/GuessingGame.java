package guess;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	private static final long serialVersionUID = -8921489735448053295L;
	private final JLabel lblNewLabel = new JLabel("Vlad's Guessing Game");
	private JTextField txtGuess;
	private JLabel lblOutput;
	private JButton btnGuess = new JButton("Guess !!");
	private JButton btnPlayAgain = new JButton("Play Again!!");
	private int theNumber;
	private int tries;
	private int numberOfTries;
	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Hi-Lo Guessing Game");
		getContentPane().setLayout(null);
		lblNewLabel.setFont(new Font("Open Sans", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 34, 426, 43);
		getContentPane().add(lblNewLabel);
		
		JLabel lblGuessANumber = new JLabel("Guess a number between 1 and 100");
		lblGuessANumber.setBounds(44, 111, 259, 21);
		getContentPane().add(lblGuessANumber);
		
		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		txtGuess.setBounds(307, 107, 89, 30);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setBounds(170, 166, 117, 25);
		btnGuess.setSize(120,30);
		getContentPane().add(btnGuess);
		
	
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newGame();
			}
		});
		btnPlayAgain.setBounds(167, 166, 117, 25);
		btnPlayAgain.setSize(120,30);
		btnPlayAgain.setVisible(false);
		getContentPane().add(btnPlayAgain);
		
		lblOutput = new JLabel("Enter a number above and click Guess !!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(12, 225, 426, 41);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450,300));
		theGame.setVisible(true);
	}
	
	public void newGame() {
		btnPlayAgain.setVisible(false);
		btnGuess.setVisible(true);
		theNumber = (int)(Math.random() * 100 + 1);
		tries = 7;
		numberOfTries = 0;
	}
	
	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = "";
		try {
			int guess = Integer.parseInt(guessText);
			if (guess < theNumber && tries <= 7 && tries > 0) {
				message = guess + " is too low. Try again.";
				tries--;
				numberOfTries++;
			}
			else if (guess > theNumber && tries <= 7 && tries > 0) {
				message = guess + " is too high, Try again";
				tries--;
				numberOfTries++;
			}
			else {
				if (tries < 7 && tries > 0) {
					message = guess + " is correct. You win after " + numberOfTries + " tries. Let's play again!";
					btnGuess.setVisible(false);
					btnPlayAgain.setVisible(true);
				} else {
					message = "You're lost. Let's play again";
					btnGuess.setVisible(false);
					btnPlayAgain.setVisible(true);
				}
			}
		} catch (Exception e) {
			message = "Enter a whole number between 1 and 100";
		} finally {
			lblOutput.setText(message);
			txtGuess.requestFocus();
			txtGuess.selectAll();
		}
	}
}
