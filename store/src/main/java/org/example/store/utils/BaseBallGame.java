package org.example.store.utils;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class BaseBallGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] goal = makeNumberNotDuplicate();
        boolean success = false;

        for (int i = 0; i < 10; i++) {

            System.out.println("숫자 3개를 입력하시오. (공백으로 구분)");

            int[] inputNum = new int[3];

            try {
                for (int j = 0; j < 3; j++) {
                    inputNum[j] = scanner.nextInt();
                }

                for (int j = 0; j < 3; j++) {
                    if (inputNum[j] > 9 || inputNum[j] < 0) {
                        throw new Exception();
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("올바른 형식의 입력이 아닙니다. 숫자를 입력해주세요.");
                scanner.nextLine();
                i = -1;
                continue;

            } catch (Exception e) {
                System.out.println("0 ~ 9 범위의 숫자만 입력해주세요. 처음부터 다시 입력해주세요");
                i = -1;
                continue;
            }
            success = game(goal, inputNum);

            if (success) {
                break;
            }
        }

        if (success) {
            System.out.println("게임에서 승리하셨습니다.");
        } else {
            System.out.println("게임에서 패하셨습니다");
        }

        printGoal(goal);
    }

    private static void printGoal(int[] goal) {
        for (int i = 0; i < 3; i++) {
            System.out.print(goal[i] + " ");
        }
    }

    private static boolean game(int[] goal, int[] inputNum) {
        int strike = 0;
        int ball = 0;
        int out = 0;

        for(int i = 0; i < inputNum.length; i++){
            boolean isOut = true;
            for(int j = 0; j < inputNum.length; j++){
                if(inputNum[i] == goal[j]){
                    if(i == j){
                        strike++;
                        isOut = false;
                    } else {
                        ball++;
                        isOut = false;
                    }
                }
            }
            if(isOut){
                out++;
            }
        }
        System.out.println("strike: " + strike + " ball: " + ball + " out: " + out);

        if(strike == 3){
            return true;
        } else {
            return false;
        }
    }

    public static int[] makeNumberNotDuplicate() {

        int[] numbers = new int[3];
        Random random = new Random();

        do {
            for (int i = 0; i < 3; i++) {
                numbers[i] = random.nextInt(10);
            }
        } while (numbers[0] == numbers[1] || numbers[1] == numbers[2] || numbers[2] == numbers[0]);

        return numbers;
    }
}
