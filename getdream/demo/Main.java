package com.getdream.demo;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] scores = {12, 23, 344, 54353, 532542};
        int[] scores2 = scores;
        Score s = new Score(scores);
        s.PrintScores();
        scores[0] = 666;
        s.PrintScores();

        StringBuilder sb = new StringBuilder(1024);
        System.out.println(sb);
        for (int i = 0; i < 1000; i++) {
            if (!sb.toString().isEmpty()) {
                sb.append(',');
            }
            sb.append(i);
        }

        String s1 = sb.toString();
        System.out.println(s1);
        System.out.println(Arrays.toString(scores2));
    }
}


class Score {
    private int[] scores;

    public Score(int[] scores) {
        //this.scores = Arrays.copyOf(scores, scores.length);
        this.scores = scores;
    }

    public void PrintScores() {
        System.out.println(Arrays.toString(this.scores));
    }
}
