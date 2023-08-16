package application;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Flashcards extends Application {

	@Override
	public void start(Stage primaryStage) {

		// Instantiate node objects and set properties

		// Top Center Section - Intro and Name
		Label lWelcome = new Label("Welcome to 3312 Flashcards!");
		Label lName = new Label("Name");
		TextField tName = new TextField();
		Label lErrName = new Label("");
		Label lErrLowest = new Label("");
		Label lErrHighest = new Label("");
		Label lErrNumProb = new Label("");
		Label lErrUserAns = new Label("");
		Label lHistory = new Label("");

		// Top Left Section - Operation Section

// 		Added labels to radio buttons instead
//		Label lAddition = new Label("Addition");
//		Label lSubtraction = new Label("Subtraction");
//		Label lMultiplication = new Label("Multiplication");
//		Label lDivision = new Label("Division");

		Label lOperation = new Label("Operation");
		RadioButton rbA = new RadioButton("Addition");
		RadioButton rbS = new RadioButton("Subtraction");
		RadioButton rbM = new RadioButton("Multiplication");
		RadioButton rbD = new RadioButton("Division");

		ToggleGroup tgOper = new ToggleGroup();

		rbA.setToggleGroup(tgOper);
		rbS.setToggleGroup(tgOper);
		rbM.setToggleGroup(tgOper);
		rbD.setToggleGroup(tgOper);

		// Bottom/Middle Left Section - Range of factor values
		Label lRange = new Label("Range of factor values");

		Label lLow = new Label("Lowest");
		TextField tLowest = new TextField();

		Label lHigh = new Label("Highest");
		TextField tHighest = new TextField();

		// Bottom Left Section - Number of Problems & Begin
		Label lNumProb = new Label("Number of problems");
		TextField tNumProb = new TextField();

		Button bBegin = new Button("Begin");

		// Top Right Section - Equation & Answer
		Label lEquation = new Label("");
		TextField tUserAns = new TextField();
		tUserAns.setVisible(false);
		Label lCorrect = new Label("");

		// Bottom Right Section - Score & Play Again
		Label lScore = new Label("Score");
		Label lScorePct = new Label("ScorePct");
		Button bPlayAgain = new Button("Play Again");
		bPlayAgain.setVisible(false);
		lScore.setVisible(false);
		lScorePct.setVisible(false);

		// Instantiate root
		Pane pane = new Pane(lWelcome, lName, tName);
		pane.getChildren().addAll(bBegin, lOperation);
//		pane.getChildren().addAll(lAddition, lSubtraction, lMultiplication, lDivision);
		pane.getChildren().addAll(rbA, rbS, rbM, rbD);
		pane.getChildren().addAll(lRange, lLow, lHigh, lNumProb, tLowest, tHighest, tNumProb);
		pane.getChildren().addAll(lEquation, tUserAns, lCorrect, lErrName, lErrLowest, lErrHighest);
		pane.getChildren().addAll(lScore, lScorePct, bPlayAgain, lHistory);
		pane.getChildren().addAll(lErrNumProb, lErrUserAns);

		// Position nodes and size nodes

		// Top Center Section - Intro and Name
		lWelcome.setLayoutX(300);
		lWelcome.setLayoutY(50);

		lName.setLayoutX(300);
		lName.setLayoutY(100);

		lErrName.setLayoutX(360);
		lErrName.setLayoutY(130);

		tName.setLayoutX(360);
		tName.setLayoutY(100);
		tName.setMaxWidth(100);

		// Top Left Section - Operation Section
		lOperation.setLayoutX(150);
		lOperation.setLayoutY(150);

		rbA.setLayoutX(100);
		rbA.setLayoutY(175);
		rbS.setLayoutX(100);
		rbS.setLayoutY(200);
		rbM.setLayoutX(100);
		rbM.setLayoutY(225);
		rbD.setLayoutX(100);
		rbD.setLayoutY(250);

//		lAddition.setLayoutX(100);
//		lAddition.setLayoutY(175);
//		lSubtraction.setLayoutX(100);
//		lSubtraction.setLayoutY(200);
//		lMultiplication.setLayoutX(100);
//		lMultiplication.setLayoutY(225);
//		lDivision.setLayoutX(100);
//		lDivision.setLayoutY(250);

		// Bottom/Middle Left Section - Range of factor values
		lRange.setLayoutX(100);
		lRange.setLayoutY(275);

		lLow.setLayoutX(100);
		lLow.setLayoutY(300);
		tLowest.setLayoutX(100);
		tLowest.setLayoutY(325);
		tLowest.setMaxWidth(75);

		lErrLowest.setLayoutX(100);
		lErrLowest.setLayoutY(360);

		lHigh.setLayoutX(200);
		lHigh.setLayoutY(300);
		tHighest.setLayoutX(200);
		tHighest.setLayoutY(325);
		tHighest.setMaxWidth(75);

		lErrHighest.setLayoutX(200);
		lErrHighest.setLayoutY(360);

		// Bottom Left Section - Number of Problems & Begin
		int temp = 20; // adjusting layout for new labels/textfields
		lNumProb.setLayoutX(100);
		lNumProb.setLayoutY(375 + temp);

		tNumProb.setLayoutX(250);
		tNumProb.setLayoutY(375 + temp);
		tNumProb.setMaxWidth(75);

		lErrNumProb.setLayoutX(250);
		lErrNumProb.setLayoutY(400 + temp);

		bBegin.setLayoutX(100);
		bBegin.setLayoutY(425 + temp);

		// Top Right Section - Equation & Answer
		lEquation.setLayoutX(450);
		lEquation.setLayoutY(225);

		tUserAns.setLayoutX(500);
		tUserAns.setLayoutY(220);
		tUserAns.setMaxWidth(50);

		lCorrect.setLayoutX(500);
		lCorrect.setLayoutY(250);

		lErrUserAns.setLayoutX(500);
		lErrUserAns.setLayoutY(270);
		// Bottom Right Section - Score & Play Again
		lScore.setLayoutX(400);
		lScore.setLayoutY(300);

		lScorePct.setLayoutX(400);
		lScorePct.setLayoutY(325);

		lHistory.setLayoutX(400);
		lHistory.setLayoutY(350);

		bPlayAgain.setLayoutX(500);
		bPlayAgain.setLayoutY(300);

		// Required statements for JavaFX
		Scene scene = new Scene(pane, 700, 700);
		primaryStage.setScene(scene);
		primaryStage.show();

		// EVENT HANDLING BEGINS HERE ******************

		// Instantiate objects
		Cards cards = new Cards();
		Session session = new Session();
		ExceptionHandler eh = new ExceptionHandler();

		// Enter name
		tName.setOnAction(e -> {
			lErrName.setText("");
			if (tName.getText().isEmpty() == false) {
				String tempName = tName.getText();
				System.out.println("User has entered " + tempName + " for name");
				session.setName(tempName); // created new session.setName(String str) to use the passed value
											// from GUI
				System.out.println("Session name is: " + session.getName());
				rbA.requestFocus();
			} else {
				System.out.println("Name field is empty");
				lErrName.setText("Enter a name"); // ** does not show up on console
				tName.requestFocus();
			}
		});

		// Select operation
		tgOper.selectedToggleProperty().addListener(e -> {
			RadioButton rb = (RadioButton) tgOper.getSelectedToggle();
			System.out.println("Operation: " + rb.getText());
			char ch1 = rb.getText().charAt(0);
			System.out.println("Ch1: " + ch1);
			String str1 = Character.toString(ch1);
			System.out.println("Str1: " + str1);
			session.setProbType(str1);
			tLowest.requestFocus();
		});

		// Enter the lowest factor value - tLowest
		tLowest.setOnAction(e -> {
			if (tLowest.getText().isEmpty() == false) { // Run code when there is data there
				String strLowest = tLowest.getText();
				// Exception handling > invoke your ExceptionHandling methods
				int validCode = eh.ckLoFactor(strLowest);

				if (validCode == 0) {
					// print on console - "Invalid entry"
					System.out.println("Invalid entry");

					// print on GUI - "Invalid entry" (you will need to create an lErrLowest Label
					lErrLowest.setText("Invalid entry");

				} else {
					// assign the intLowest to the cards LoFactor value
					System.out.println("LoFactor: " + strLowest);

					cards.setLoFactor(Integer.parseInt(strLowest));

					// clear the message labels
					lErrLowest.setText("");

					// advance focus to tHighest
					tHighest.requestFocus();
				}
			} else {
				System.out.println("Lowest Factor field entry is empty");
				lErrLowest.setText("Enter value");
				tHighest.requestFocus();
			}
		});

		// Enter the highest factor value - tHighest
		tHighest.setOnAction(e -> {
			if (tHighest.getText().isEmpty() == false) {
				String strHighest = tHighest.getText();
				// Exception handling > invoke your ExceptionHandling methods
				int validCode = eh.ckLoFactor(strHighest);

				if (validCode == 0) {
					// print on console - "Invalid entry"
					System.out.println("Invalid entry");

					// print on GUI - "Invalid entry"
					lErrHighest.setText("Invalid entry");

				} else {
					// assign the intLowest to the cards LoFactor value
					System.out.println("HiFactor: " + strHighest);

					cards.setHiFactor(Integer.parseInt(strHighest));

					// clear the message labels
					lErrHighest.setText("");

					// advance focus to tHighest
					tNumProb.requestFocus();
				}
			} else {
				System.out.println("Highest Factor field entry is empty");
				lErrHighest.setText("Enter value");
				tHighest.requestFocus();
			}
		});

		// Enter number of problems

		tNumProb.setOnAction(e -> {
			if (tNumProb.getText().isEmpty() == false) {
				String strNumProb = tNumProb.getText();
				// Exception handling > invoke your ExceptionHandling methods
				int validCode = eh.ckNumProb(strNumProb);

				if (validCode == 0) {
					// print on console - "Invalid entry"
					System.out.println("Invalid entry");

					// print on GUI - "Invalid entry"
					lErrNumProb.setText("Invalid entry");

				} else {
					// assign the intLowest to the cards LoFactor value
					System.out.println("NumProb: " + strNumProb);

					session.setNumProb(Integer.parseInt(strNumProb));

					// clear the message labels
					lErrNumProb.setText("");

					// advance focus to tHighest
					bBegin.requestFocus();
				}
			} else {
				System.out.println("Highest Factor field entry is empty");
				lErrHighest.setText("Enter value");
				tNumProb.requestFocus();
			}
		});

		// Press Begin button, generate problems
		bBegin.setOnAction(e -> {
			// set random factors
			// set the problem
			cards.setProb(session);

			// display the problem
			lEquation.setText(cards.getHistoryProblem());

			// display blank text field
			tUserAns.setVisible(true);

			// advance focus
			tUserAns.requestFocus();

		});

		// Enter responses to problems
		tUserAns.setOnAction(e -> {

			// get response from user
			String strUserAns = tUserAns.getText();

			// clear user answer box
			tUserAns.setText("");

			// check if user answer is valid
			int validCode = eh.ckResponse(strUserAns);

			// if invalid, show error msg
			if (validCode == 0) {
				lErrUserAns.setText("Invalid Entry");
			}
			// if valid answer, process
			else {
				lErrUserAns.setText("");

				// evaluate and save answer
				cards.setResponse(session, strUserAns);

				// save problem and answer
				session.setHistory(cards, session.getCount());

				// display correct/incorrect
				lCorrect.setText(cards.getCorInc() + "!");

				if (session.getCount() + 1 < session.getNumProb()) {

					// increment count
					session.count++;

					bBegin.fire();
				} else {
					// kickoff end of system processing
					session.prtSummary();

					lScore.setText("Score: " + String.valueOf(session.getScore()));
					lScorePct.setText("Score Pct: " + String.valueOf(session.getScorePct()));
					lHistory.setText(session.prtHistoryAndOutro());

					lScore.setVisible(true);
					lScorePct.setVisible(true);

					bPlayAgain.setVisible(true);
					bPlayAgain.requestFocus();

				}
			}
		});

		// Calculate and show score, show PlayAgain button

		// Press PlayAgain button
		bPlayAgain.setOnAction(e -> {
			// reset all fields and go to name
			tName.requestFocus();
			tName.setText("");
			tLowest.setText("");
			tHighest.setText("");
			tNumProb.setText("");
			lScore.setText("");
			lScorePct.setText("");
			lHistory.setText("");
			tUserAns.setText("");
			lEquation.setText("");
			lCorrect.setText("");

			session.resetCount();

			tUserAns.setVisible(false);
			bPlayAgain.setVisible(false);
		});

		// EVENT HANDLING ENDS HERE ********************

	}

//=================================================================
// Session
// =================================================================

	public class Session {

		// Instantiate objects
		Scanner input = new Scanner(System.in);
		ExceptionHandler exception_handler = new ExceptionHandler();

		// Declare vars
		private String name;
		private String probType;
		private String longProbType;
		private String oper;
		private int numProb;
		private int count = 0;
		private int score = 0;
		private double scorePct;
		private String[] history;
		private String str = "";
		private char cStr;
		private int validCode = 0;

		// Define constructors

		// Define methods
		public void setInputs(Cards c) {
			System.out.print("Enter your name: ");
			name = input.nextLine();
//
//			setProbType();
//
//			c.setLoFactorRange();
//
//			c.setHiFactorRange();

			// Calculate longProbType
			switch (probType) {
			case "A":
				longProbType = "Addition";
				break;
			case "S":
				longProbType = "Subtraction";
				break;
			case "M":
				longProbType = "Multiplication";
				break;
			case "D":
				longProbType = "Division";
				break;
			}

			// initialize history array
			history = new String[numProb];
		}

		public void setName(String text) {
			name = text;
		}

		public void setProbType(String str) {
			probType = str;
		}

		// fcn for text based game
//		public void setNumProb() {
//			validCode = 0;
//			while (validCode == 0) {
//				// Get number of problems
//				System.out.print("Enter the number of problems you wish to work: ");
//				str = input.next();
//				input.nextLine();
//
//				validCode = exception_handler.ckNumProb(str);
//			} // end of while loop
//			numProb = Integer.parseInt(str);
//		}

		public void setNumProb(int intNumProb) {
			numProb = intNumProb;

			// initialize history array
			history = new String[numProb];
		}

		public String getName() {
			return name;
		}

		public String getProbType() {
			return probType;
		}

		public String getLongProbType() {
			return longProbType;
		}

		public String getOper() {
			switch (probType) {
			case "A":
				return "+";
			case "S":
				return "-";
			case "M":
				return "*";
			case "D":
				return "/";
			default:
				return "";
			}
		}

		public int getNumProb() {
			return numProb;
		}

		public void prtIntro(Cards c) {
			System.out.println();

			System.out.printf(
					"        Hi %s, and welcome to the 3312 FlashCard System!\n"
							+ "              You have chosen the operation %s.\n"
							+ "    The range of factors you have chosen is from %d to %d, inclusive.\n"
							+ "                You have chosen to work %d problems.\n"
							+ "              Wait 5 seconds for the program to begin.",
					name, longProbType, c.getLoFactor(), c.getHiFactor(), numProb);

//			Removed so program starts automatically
//			input.nextLine(); 
			System.out.println();
			System.out.println();

			// Pauses the program for 5 seconds then begins flashcards
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException ie) {
				Thread.currentThread().interrupt();
			}

		}

		public int incScore() {
			return score++;
		}

		public void setHistory(Cards c, int i) {
			history[i] = String.format("%s %s", c.getHistoryProblem(), c.getHistoryAnswer());
		}

		public void setScorePct() {
			scorePct = Double.valueOf(score) * 100 / Double.valueOf(numProb);
		}

		public double getScorePct() {
			return scorePct;
		}

		public int getScore() {
			return score;
		}

		public int getCount() {
			return count;
		}

		public void resetCount() {
			count = 0;
		}

		public void prtSummary() {
			setScorePct();

			System.out.printf("\nSession Summary\n" + "%d problems, %d correct\n" + "Score is %.1f%%\n" + "\n", numProb,
					getScore(), getScorePct());
		}

		public String prtHistoryAndOutro() {
			String strHistory = "Problems\n";

			for (int i = 0; i < getNumProb(); i++) {
				strHistory = strHistory.concat(history[i] + "\n");
			}

			String thanks = "\n\nThank you for using the 3312 Flashcard System, " + getName()
					+ "\n Come back and play again real soon!";

			strHistory = strHistory.concat(thanks);

			System.out.println(strHistory);

			return strHistory;
		}
	} // END OF SESSION

//=================================================================
//Cards
//=================================================================

	public class Cards {

		// Instantiate objects
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		ExceptionHandler exception_handler = new ExceptionHandler();

		// Declare vars
		private int loFactor;
		private int hiFactor;
		private int factor1;
		private int factor2;
		private int answer;
		private int response;
		private int minuend;
		private int dividend;
		private String historyProblem;
		private String historyAnswer;
		private String corInc = "Incorrect";
		private String problem;
		private String str;
		private int validCode;

		// Define constructors

		public void setLoFactor(int lowest) {
			loFactor = lowest;
		}

		public void setHiFactor(int highest) {
			hiFactor = highest;
		}

		// Define methods
//		public void setLoFactorRange() {
//			validCode = 0;
//			while (validCode == 0) {
//				System.out.print("Enter the lowest factor value for your flashcard problems: ");
//				str = input.next();
//				validCode = exception_handler.ckLoFactor(str);
//
//			} // end of while loop
//
//			loFactor = Integer.parseInt(str);
//		}

//		public void setHiFactorRange() {
//			validCode = 0;
//			while (validCode == 0) {
//				System.out.print("Enter the highest factor value for your flashcard problems: ");
//				str = input.next();
//				validCode = exception_handler.ckHiFactor(str, loFactor);
//
//			} // end of while loop
//
//			hiFactor = Integer.parseInt(str);
//		}

		public void setFactors() {
			factor1 = random.nextInt(hiFactor - loFactor + 1) + loFactor;
			factor2 = random.nextInt(hiFactor - loFactor + 1) + loFactor;
		}

		public void setFactor1() {
			factor1 = random.nextInt(hiFactor - loFactor + 1) + loFactor;
			if (factor1 == 0) {
				factor1 += 1;
			}
		}

		public int getFactor1() {
			return factor1;
		}

		public int getFactor2() {
			return factor2;
		}

		public int getLoFactor() {
			return loFactor;
		}

		public int getHiFactor() {
			return hiFactor;
		}

		public String getHistoryProblem() {
			return historyProblem;
		}

		public String getHistoryAnswer() {
			return historyAnswer;
		}

		public void setProb(Session s) {
			setFactors();

			switch (s.getProbType()) {
			case "A":
				answer = factor1 + factor2;

				historyProblem = String.format("%d %s %d = ", factor1, s.getOper(), factor2);
				System.out.print(historyProblem);
				break;

			case "S":
				minuend = factor1 + factor2;
				answer = minuend - factor1;

				historyProblem = String.format("%d %s %d = ", minuend, s.getOper(), factor1);
				System.out.print(historyProblem);
				break;

			case "M":
				answer = factor1 * factor2;

				historyProblem = String.format("%d %s %d = ", factor1, s.getOper(), factor2);
				System.out.print(historyProblem);
				break;

			case "D":
				setFactor1();

				dividend = factor1 * factor2;
				answer = dividend / factor1;

				historyProblem = String.format("%d %s %d = ", dividend, s.getOper(), factor1);
				System.out.print(historyProblem);
				break;
			}
		}

		public void setResponse(Session s, String strUserAns) {

			// save user input
			response = Integer.parseInt(strUserAns);

			// check for correctness
			if (answer == response) {
				s.incScore();
				corInc = "Correct";

				System.out.println(String.format("%s!", getCorInc()));

				// save history answer
				historyAnswer = String.format("%d, %s, correct answer is %d", response, getCorInc(), answer);
			} else {
				corInc = "Incorrect";

				// save history answer
				historyAnswer = String.format("%d, %s, correct answer is %d", response, getCorInc(), answer);

				System.out.println(String.format("%s, correct answer is %d", getCorInc(), answer));

			}

			System.out.println();

		}

		public int getResponse() {
			return response;
		}

		public String getCorInc() {
			return corInc;
		}
	} // END OF CARDS

// =================================================================
// Exception Handler
// =================================================================

	public class ExceptionHandler {
		// Instantiate objects
		Scanner input = new Scanner(System.in);

		// Declare vars
		private String str;
		private int iStr;
		private int validCode = 0;

		// Define constructors

		// Define methods
		private int ckProbType(String str) {
			switch (str) {
			case ("A"):
			case ("S"):
			case ("M"):
			case ("D"):
				validCode = 1;
				break;
			default:
				System.out.println("Entry must be A, S, M, or D.");
			}

			return validCode;

		}

		private int ckLoFactor(String str) {
			try {
				iStr = Integer.parseInt(str); // Failure auto throws to NFE catch block

				if (iStr < 0 || iStr > 19) { // if test fails, need to throw IAE to the IAE catch block
					throw new IllegalArgumentException();
				}
				validCode = 1;
			} catch (NumberFormatException nfe) {
				System.out.println("Entry must be a number.");
				validCode = 0;
			} catch (IllegalArgumentException iae) {
				System.out.println("Entry must be between 0 and 19, inclusive.");
				validCode = 0;
			}

			return validCode;
		}

		private int ckHiFactor(String str, int loFactor) {
			try {
				iStr = Integer.parseInt(str); // Failure auto throws to NFE catch block

				if (iStr < loFactor || iStr > 20) { // if test fails, need to throw IAE to the IAE catch block
					throw new IllegalArgumentException();
				}
				validCode = 1;
			} catch (NumberFormatException nfe) {
				System.out.println("Entry must be a number.");
				validCode = 0;
			} catch (IllegalArgumentException iae) {
				System.out.println("Entry must be between lowest factor +1 and 20, inclusive.");
				validCode = 0;
			}

			return validCode;
		}

		private int ckNumProb(String str) {
			try {
				iStr = Integer.parseInt(str); // Failure auto throws to NFE catch block

				if (iStr < 1 || iStr > 20) { // if test fails, need to throw IAE to the IAE catch block
					throw new IllegalArgumentException();
				}
				validCode = 1;
			} catch (NumberFormatException nfe) {
				System.out.println("Entry must be a number.");
				validCode = 0;
			} catch (IllegalArgumentException iae) {
				System.out.println("Entry must be between 1 and 20, inclusive.");
				validCode = 0;
			}

			return validCode;
		}

		private int ckResponse(String str) {
			try {
				iStr = Integer.parseInt(str); // Failure auto throws to NFE catch block

				validCode = 1;
			} catch (NumberFormatException nfe) {
				System.out.println("Entry must be a number.");
				validCode = 0;
			}

			return validCode;
		}

	} // END OF EXCEPTIONHANDLER CLASS (P3)

}
