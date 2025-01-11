import java.util.Scanner;
import java.util.Random;

public class tictactoe {

    static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char player = 'X';
        char computer = 'O';

        System.out.println("Welcome to Tic-Tac-Toe!");
        printBoard();

        while (true) {
            playerMove(scanner);
            if (isGameFinished(player)) {
                break;
            }
            printBoard();

            computerMove();
            if (isGameFinished(computer)) {
                break;
            }
            printBoard();
        }

        scanner.close();
    }

    private static boolean isGameFinished(char player) {
        if (hasContestantWon(player)) {
            printBoard();
            System.out.println(player + " wins!");
            return true;
        }

        if (isBoardFull()) {
            printBoard();
            System.out.println("The game is a tie!");
            return true;
        }
        return false;
    }

    private static boolean hasContestantWon(char symbol) {
        // Rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true;
            }
        }

        // Columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) {
                return true;
            }
        }

        // Diagonals
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return true;
        }
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            return true;
        }

        return false;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private static void playerMove(Scanner scanner) {
        String userInput;
        while (true) {
            System.out.println("Enter your move (1-9):");
            userInput = scanner.nextLine();
            if (isValidMove(userInput)) {
                break;
            } else {
                System.out.println(userInput + " is not a valid move.");
            }
        }

        placeMove(userInput, 'X');
    }

    private static boolean isValidMove(String position) {
        switch (position) {
            case "1":
                return (board[0][0] == ' ');
            case "2":
                return (board[0][1] == ' ');
            case "3":
                return (board[0][2] == ' ');
            case "4":
                return (board[1][0] == ' ');
            case "5":
                return (board[1][1] == ' ');
            case "6":
                return (board[1][2] == ' ');
            case "7":
                return (board[2][0] == ' ');
            case "8":
                return (board[2][1] == ' ');
            case "9":
                return (board[2][2] == ' ');
            default:
                return false;
        }
    }

    private static void placeMove(String position, char symbol) {
        switch (position) {
            case "1":
                board[0][0] = symbol;
                break;
            case "2":
                board[0][1] = symbol;
                break;
            case "3":
                board[0][2] = symbol;
                break;
            case "4":
                board[1][0] = symbol;
                break;
            case "5":
                board[1][1] = symbol;
                break;
            case "6":
                board[1][2] = symbol;
                break;
            case "7":
                board[2][0] = symbol;
                break;
            case "8":
                board[2][1] = symbol;
                break;
            case "9":
                board[2][2] = symbol;
                break;
            default:
                System.out.println("Invalid position!");
                break;
        }
    }

    private static void computerMove() {
        Random rand = new Random();
        int computerMove;
        String position;
        while (true) {
            computerMove = rand.nextInt(9) + 1;
            position = Integer.toString(computerMove);
            if (isValidMove(position)) {
                break;
            }
        }
        System.out.println("Computer chose " + computerMove);
        placeMove(position, 'O');
    }

    private static void printBoard() {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }
}

//HERE IS THE CODE FOR TIC TAC TOE GAME
//LETS RUN THE CODE
//THANK YOU
