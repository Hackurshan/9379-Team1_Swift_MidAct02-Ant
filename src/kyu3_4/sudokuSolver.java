package kyu3_4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class sudokuSolver {

    public static int[][] sudoku(int[][] puzzle) {
        Sudoku solver = new Sudoku(puzzle);
        solver.solve();
        return solver.getBoard();
    }

    static class Sudoku {
        private int[][] board;
        private List<Integer>[][] possibleAnswers;

        public Sudoku(int[][] board) {
            this.board = board;
            this.possibleAnswers = new ArrayList[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    possibleAnswers[i][j] = new ArrayList<>();
                }
            }
        }

        public void setPossibleAnswers(int r, int c) {
            List<Integer> row = getRow(r);
            List<Integer> col = getCol(c);
            List<Integer> square = getSquare(r, c);
            Set<Integer> possSet = new HashSet<>();
            for (int i = 1; i <= 9; i++) {
                possSet.add(i);
            }
            Set<Integer> removeSet = new HashSet<>(row);
            removeSet.addAll(col);
            removeSet.addAll(square);
            possSet.removeAll(removeSet);
            possibleAnswers[r][c] = new ArrayList<>(possSet);
        }

        public void solve() {
            while (!isComplete()) {
                for (int row = 0; row < 9; row++) {
                    for (int col = 0; col < 9; col++) {
                        if (board[row][col] == 0) {
                            setPossibleAnswers(row, col);
                            if (possibleAnswers[row][col].size() == 1) {
                                board[row][col] = possibleAnswers[row][col].remove(0);
                            }
                        }
                    }
                }
            }
        }

        public boolean isComplete() {
            for (int[] row : board) {
                for (int num : row) {
                    if (num == 0) {
                        return false;
                    }
                }
            }
            return true;
        }

        public List<Integer> getRow(int r) {
            List<Integer> row = new ArrayList<>();
            for (int num : board[r]) {
                if (num != 0) {
                    row.add(num);
                }
            }
            return row;
        }

        public List<Integer> getCol(int c) {
            List<Integer> col = new ArrayList<>();
            for (int[] row : board) {
                if (row[c] != 0) {
                    col.add(row[c]);
                }
            }
            return col;
        }

        public List<Integer> getSquare(int r, int c) {
            List<Integer> sq = new ArrayList<>();
            int i = r / 3;
            int j = c / 3;
            for (int ni = i * 3; ni < (i * 3) + 3; ni++) {
                for (int nj = j * 3; nj < (j * 3) + 3; nj++) {
                    int n = board[ni][nj];
                    if (n != 0) {
                        sq.add(n);
                    }
                }
            }
            return sq;
        }

        public int[][] getBoard() {
            return board;
        }
    }
}
