
// 7: Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules: 1. Each row must contain the digits 1-9 without repetition. 2: Each column must contain the digits 1-9 without repetition. 3: Each of the nine 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition
import java.util.*;

class ValidSudoku{
    public static boolean isValidSuduko(char[][] board){
        for(int i=0; i<9; i++){
            if(!validGroup(board[i])){
                return false;
            }
        }

        for(int i=0; i<9; i++){
            char[] column = new char[9];
            for(int j=0; j<9; j++){
                column[j] = board[j][i];
            }
            if(!validGroup(column)){
                return false;
            }
        }

        for(int i=0; i<9; i+=3){
            for(int j=0; j<9; j+=3){
                char[] subbox = new char[9];
                int index = 0;
                for(int x=i; x<i+3; x++){
                    for(int y=j; y<j+3; y++){
                        subbox[index++] = board[x][y];
                    }
                }
                if(!validGroup(subbox)){
                    return false;
                } 
            }
        }
        return true;
    }

    private static boolean validGroup(char[] board){
        Set<Character> hash = new HashSet<>();
        for(char c : board){
            if(c != '.'){
                if(hash.contains(c)){
                    return false;
                }
            hash.add(c);
            }
        } 
        return true;
    }

     public static void main(String[] args){
           char[][] arr = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        boolean result = isValidSuduko(arr);
        System.out.println(result); 
    }

}