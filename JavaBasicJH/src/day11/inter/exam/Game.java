package day11.inter.exam;

import java.util.Random;
import java.util.Scanner;

public interface Game {
	Scanner sc = new Scanner(System.in);
	Random r = new Random();
	int startGame(int you);
}
