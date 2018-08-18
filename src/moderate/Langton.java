package moderate;


/*
An ant is sitting on an infinite grid of white and black squares.
It initially faces right.
At each step, it does the following:
(1) At a white square, flip the color of the square, turn 90 degrees right (clockwise), and move forward one unit.
(2) At a black square, flip the color of the square, turn 90 degrees left (counter-clockwise).
and move forward one unit.
Write a program to simulate the first K moves that the ant makes and print the final board as a grid.
Note that you are not provided with the data structure to represent the grid.
This is something you must design yourself.
The only input to your method is K. You should print the final grid and return nothing.
The method signature might be something like void printKMoves(int K).*/

import java.util.*;


class Ant {
    public Position position = new Position(0, 0);
    public Orientation orientation = Orientation.right;

    public void turn(boolean clockwise) {
        orientation = orientation.getTurn(clockwise);
    }

    public void move() {
        if (orientation == Orientation.left) {
            position.column--;
        } else if (orientation == Orientation.right) {
            position.column++;
        } else if (orientation == Orientation.up) {
            position.row--;
        } else if (orientation == Orientation.down) {
            position.row++;
        }
    }

    public void adjustPosition(int shiftRow, int shiftColumn) {
        position.row += shiftRow;
        position.column += shiftColumn;
    }
}

class Board {
    private HashSet<Position> whites = new HashSet<Position>();
    private Ant ant = new Ant();
    private Position topLeftCorner = new Position(0, 0);
    private Position bottomRightCorner = new Position(0, 0);

    public Board() { }

    /* Move ant. */
    public void move() {
        ant.turn(isWhite(ant.position)); // Turn
        flip(ant.position); // flip
        ant.move(); // move
        ensureFit(ant.position);
    }

    /* Flip color of cells. */
    private void flip(Position position) {
        if (whites.contains(position)) {
            whites.remove(position);
        } else {
            whites.add(position.clone());
        }
    }

    /* "Grow" the grid by tracking the most top-left and
     * bottom-right position that we've seen. */
    private void ensureFit(Position position) {
        int row = position.row;
        int column = position.column;

        topLeftCorner.row = Math.min(topLeftCorner.row, row);
        topLeftCorner.column = Math.min(topLeftCorner.column, column);

        bottomRightCorner.row = Math.max(bottomRightCorner.row, row);
        bottomRightCorner.column = Math.max(bottomRightCorner.column, column);
    }

    /* Check if cell is white. */
    public boolean isWhite(Position p) {
        return whites.contains(p);
    }

    /* Check if cell is white. */
    public boolean isWhite(int row, int column) {
        return whites.contains(new Position(row, column));
    }

    /* Print board. */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int rowMin = topLeftCorner.row;
        int rowMax = bottomRightCorner.row;
        int colMin = topLeftCorner.column;
        int colMax = bottomRightCorner.column;
        for (int r = rowMin; r <= rowMax; r++) {
            for (int c = colMin; c <= colMax; c++) {
                if (r == ant.position.row && c == ant.position.column) {
                    sb.append(ant.orientation);
                } else if (isWhite(r, c)) {
                    sb.append("X");
                } else {
                    sb.append("_");
                }
            }
            sb.append("\n");
        }
        sb.append("Ant: " + ant.orientation + ". \n");
        return sb.toString();
    }
}

public class Langton{
    public static void main(String[] args) {
        Board board = new Board();
        System.out.println(board.toString());
        for (int i = 0; i < 100; i++) {
            System.out.println("\n\n---- MOVE " + i + " ----");
            board.move();
            String bs = board.toString();
            System.out.println(bs);

        }
    }
}

class Position{
    int row;
    int column;
    Position(int row, int column){
        this.row = row;
        this.column = column;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Position) {
            Position p = (Position) o;
            return p.row == this.row && p.column == this.column;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return (row * 31) ^ column;
    }

    public Position clone() {
        return new Position(row, column);
    }
}

enum Orientation {
    left, up, right, down;

    public Orientation getTurn(boolean clockwise) {
        if (this == left) {
            return clockwise ? up : down;
        } else if (this == up) {
            return clockwise ? right : left;
        } else if (this == right) {
            return clockwise ? down : up;
        } else { // down
            return clockwise ? left : right;
        }
    }

    @Override
    public String toString() {
        if (this == left) {
            //<-
            return "\u2190";
        } else if (this == up) {
            //^
            return "\u2191";
        } else if (this == right) {
            //->
            return "\u2192";
        } else {
            // down
            return "\u2193";
        }
    }
}