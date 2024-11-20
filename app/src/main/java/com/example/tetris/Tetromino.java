package com.example.tetris;

import android.graphics.Color;


import android.graphics.Color;

public class Tetromino {
    private int[][] shape;
    private int color;

    public Tetromino(int[][] shape, int color) {
        this.shape = new int[shape.length][shape[0].length];
        for (int i = 0; i < shape.length; i++) {
            System.arraycopy(shape[i], 0, this.shape[i], 0, shape[i].length);
        }
        this.color = color;
    }

    public int[][] getShape() {
        return shape;
    }

    public int getColor() {
        return color;
    }

    public Tetromino rotate() {
        int rows = shape.length;
        int cols = shape[0].length;
        int[][] newShape = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                newShape[j][rows - 1 - i] = shape[i][j];
            }
        }
        return new Tetromino(newShape, color);
    }

    public static Tetromino createLine() {
        return new Tetromino(new int[][]{{1,1,1,1}}, Color.CYAN);
    }

    public static Tetromino createSquare() {
        return new Tetromino(new int[][]{{1,1},{1,1}}, Color.YELLOW);
    }

    public static Tetromino createTShape() {
        return new Tetromino(new int[][]{
                {0,1,0},
                {1,1,1}
        }, Color.MAGENTA);
    }

    public static Tetromino createLShape() {
        return new Tetromino(new int[][]{
                {1,0},
                {1,0},
                {1,1}
        }, Color.BLUE);
    }

    public static Tetromino createZShape() {
        return new Tetromino(new int[][]{
                {1,1,0},
                {0,1,1}
        }, Color.RED);
    }
}