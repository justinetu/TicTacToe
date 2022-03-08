import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
public class TicTacToe {

    static ArrayList<Integer> userPlays = new ArrayList<>();
    static ArrayList<Integer> cpuPlays = new ArrayList<>();
    static String[][] gameBoard = {{" "," ", " ", "|", " "," ", " ", "|", " ", " ", " "},
                              {" "," ", " ", "|", " ", " ", " ", "|", " ", " ", " "},
                              {"-","-", "-", "+", "-", "--", "+","---"},
                              {" "," ", " ", "|", " ", " "," ", "|", " ", " ", " "},
                              {" "," ", " ", "|", " ", " "," ", "|", " ", " ", " "},
                              {"-","-", "-", "+", "-", "--", "+","---"},
                              {" "," ", " ", "|", " ", " "," ", "|", " ", " ", " "},
                              {" "," ", " ", "|", " ", " "," ", "|", " ", " ", " "}};
    public static boolean bool = true;

    public static void main(String[] args) {
        // TODO code application logic here
        
        displayGameBoard();
    }
    
    
        public static void displayGameBoard() {
        
            System.out.println("Welcome to Tic Tac Toe!");
            String symbol;
            Scanner sc = new Scanner(System.in);
            System.out.print("Choose your preferred symbol X or O >> ");               
            symbol = sc.next();
            while(!symbol.equals("X") && !symbol.equals("x") && !symbol.equals("O") && !symbol.equals("o")) {       //Ensuring correct input
                System.out.print("Must choose either X or O. Try again >> ");
                symbol = sc.next();
            }
            symbol = symbol.toUpperCase();
            char sym = symbol.charAt(0);
        
            System.out.println();
            for(int i = 0; i < gameBoard.length; i++) {
                for(int j = 0; j < gameBoard.length; j++) { 
                    System.out.print(gameBoard[i][j]);
                }
                   System.out.println();
            }  
            userPosition(gameBoard, sym, bool);
        }       
        public static void userPosition(String[][] board, char s, boolean b) {
            int userPosition;
            Scanner keyboard = new Scanner(System.in);
            int counter = 0;
            String strUserSymb = "" + s;
            
            while(bool) {
                
                
                if(bool == false)
                    break;
                
                System.out.print("Enter your position >> (1-9)");
                userPosition = keyboard.nextInt();
                
   
                
                while(userPlays.contains(userPosition) || cpuPlays.contains(userPosition)) {
                      System.out.print("Spot taken. Enter a valid position. Try again >> ");
                      userPosition = keyboard.nextInt();
                      
                }
                userPlays.add(userPosition);
                if(Winner(strUserSymb).length() > 0) {
                    System.out.println(Winner(strUserSymb));
                    bool = false;
                    userPosition(board, s, bool);
                }
   
                switch(userPosition) {
                    case 1:
                        board[1][1] = "" +s;
                        break;
                
                    case 2:
                        board[1][5] = "" +s;
                        break;
                
                    case 3:                    
                        board[1][7] = board[1][7] + "" +s;
                        break;
                    
                    case 4:
                        board[3][1] = "" +s;
                        break;
                    
                    case 5:
                        board[3][5] = "" +s;
                        break;
                    
                    case 6:
                        board[3][7] = board[4][7] + "" +s;
                        break;
                    
                    case 7:
                        board[6][1] = "" +s;
                        break;
                    
                    case 8:
                        board[6][5] = "" +s;
                        break;
                    
                    case 9:
                        board[6][7] = board[6][7] + "" +s;
                        break;
                }            
                for(int count = 0; count < board.length; count++) {
                    for(int count2 = 0; count2 < board.length; count2++) {
                    
                        System.out.print(board[count][count2]);
                    }
                    System.out.println();
                }
 
            if(bool == false)
                break;
            if(bool == true)
                CPUPosition(gameBoard, s, bool);
            
            }
            
        }
        
        public static void CPUPosition(String[][] board, char userSymbol, boolean boolVal) {
            String userSymbolStr = "" + userSymbol;
            String cpuSymbol = "";
            if(userSymbolStr.equals("x") || userSymbolStr.equals("X"))
                cpuSymbol = "O";
            if(userSymbolStr.equals("o") || userSymbolStr.equals("O"))
                cpuSymbol = "X";
            Random rand = new Random();
            char c = ' ';
            System.out.println();
            int cpuChoice = 1 + rand.nextInt(9);
                
            
            while(cpuPlays.contains(cpuChoice) || userPlays.contains(cpuChoice)) {  
                cpuChoice = 1 + rand.nextInt(9);
                if(Winner(userSymbolStr).length() > 0) {
                    System.out.println(Winner(userSymbolStr));
                    boolVal = false;
                    userPosition(board, c, boolVal);          
            }                
         }
            cpuPlays.add(cpuChoice);
            
            
                switch(cpuChoice) {
                case 1:
                    board[1][1] = cpuSymbol;
                    break;
                
                case 2:
                    board[1][5] = cpuSymbol;
                    break;
                
                case 3:                    
                    board[1][7] = board[1][7] + cpuSymbol;
                    break;
                    
                case 4:
                    board[3][1] = cpuSymbol;
                    break;
                    
                case 5:
                    board[3][5] = cpuSymbol;
                    break;
                    
                case 6:
                    board[3][7] = board[4][7] + cpuSymbol;
                    break;
                    
                case 7:
                    board[6][1] = cpuSymbol;
                    break;
                    
                case 8:
                    board[6][5] = cpuSymbol;
                    break;
                    
                case 9:
                    board[6][7] = board[6][7] + cpuSymbol;
                    break;
                    
                default:
                    break;
            }
            
            // Print the CPU choice on the gameboard
            System.out.println();
            for(int r = 0; r < board.length; r++) {
                for(int w = 0; w < board.length; w++) {
                    System.out.print(board[r][w]);
                    
                }
                System.out.println();
            }
            
            if(Winner(userSymbolStr).length() > 0) {
                System.out.println(Winner(userSymbolStr)); 
                boolVal = false;
                userPosition(board, c, boolVal);
            }
            }

        
        static String Winner(String userSym) {
            HashSet<List> winner = new HashSet<>();
            List firstRow = Arrays.asList(1,2,3);
            List secondRow = Arrays.asList(4,5,6);
            List thirdRow = Arrays.asList(7,8,9);
            List firstCol = Arrays.asList(1,4,7);
            List secondCol = Arrays.asList(2,5,8);
            List thirdCol = Arrays.asList(3,6,9);
            List leftDiagnol = Arrays.asList(1,5,9);
            List rightDiagnol = Arrays.asList(3,5,7);
            
            winner.add(firstRow);
            winner.add(secondRow);
            winner.add(thirdRow);
            winner.add(firstCol);
            winner.add(secondCol);
            winner.add(thirdCol);
            winner.add(leftDiagnol);
            winner.add(rightDiagnol);
            
            
            char ch = ' ';
            for(List x: winner)
                if(userPlays.containsAll(x)) 
                    return "Congrats!! We have a winner!";
                
                else if(cpuPlays.containsAll(x)) {
                    bool = false;
                    userPosition(gameBoard,ch, bool);
                    return "Computer Wins!! Woot, Woot";
                }
            String draw = "";
            if(userPlays.size() + cpuPlays.size() == 9)
                draw = "TIE!";
            return draw;
        }

}
