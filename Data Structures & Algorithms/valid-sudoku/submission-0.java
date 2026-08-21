class Solution {
    boolean checkSubBox(char[][] board, int x, int y){
        boolean[] present = new boolean[9];
        for(int i = x; i < x + 3; i++){
            for(int j = y; j < y + 3; j++){
                if(board[i][j] == '.') continue;
                int character = board[i][j] - '1';
                if(present[character]){
                    return false;
                }
                else{
                    present[character] = true;
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        boolean subBoxCheck = true;
        for(int i = 0; i < 9; i++){
            boolean[] col = new boolean[9];
            boolean[] row = new boolean[9];
            for(int j = 0; j < 9; j++){
                if(i % 3 == 0 && j % 3 == 0){
                    if(!checkSubBox(board, i, j)){
                        return false;
                    }
                }
                if(board[i][j] != '.'){
                    int temp = board[i][j] - '1';
                    if(col[temp]){
                        return false;
                    }
                    else{
                        col[temp] = true;
                    }
                }
                if(board[j][i] != '.'){
                    int temp = board[j][i] - '1';
                    if(row[temp]){
                        return false;
                    }
                    else{
                        row[temp] = true;
                    }
                }
            }
        }
        return true;
    }
}
