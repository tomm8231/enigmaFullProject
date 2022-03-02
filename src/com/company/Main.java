package com.company;

import java.util.Scanner;

public class Main {

    Scanner sc = new Scanner(System.in);

    char[] letters = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
        'I', 'J', 'K', 'L', 'M' , 'N', 'O', 'P', 'Q', 'R', 'S',
        'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'Æ', 'Ø', 'Å'};


    public void mainMenu(){
        System.out.println("Which encryption/decryption method would you like to use?");
        int method = sc.nextInt();
        switch (method) {
            case 1 -> ceasarMethod();
           // case 2 -> vitionaireMethod(); //LAVES MÅSKE
           // case 3 -> exitProgramme(); //LAVES MÅSKE
        }
        newLine();
    }

    public void newLine() {
        System.out.println();
    }


    public void ceasarMethod() {
        int shift = enterShift();
        newLine();
        String text = enterText();
        newLine();
        System.out.println("Encrypted text:");
        StringBuilder encryptedText = caesarEncrypt(text, shift);
        newLine();
        System.out.println(encryptedText);

    }

    private StringBuilder caesarEncrypt(String text, int shift) {
        StringBuilder sb = new StringBuilder();

        char newLetter;

        for(int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            int letterValue = letterToNumber(letter);
            if (letterValue != 0) {
                int newLetterValue = shiftNumber(letterValue, shift);
                newLetter = numberToLetter(newLetterValue);
            }
            else {
                newLetter = ' ';
            }

            sb.append(newLetter);

        }
        return sb;
    }

    public int enterShift() {
        System.out.println("Enter your shift value:");
        int shiftValue = sc.nextInt();
        sc.nextLine(); // SCANNER BUG

        System.out.println("Your shift value is " + shiftValue);

        return shiftValue;
    }

    public String enterText() {
        System.out.println("Enter the text you'd like to encrypt");

        String input = sc.nextLine();

        System.out.println("You are about to encrypt the following text: "  + input);

        return input;
    }
    public int letterToNumber(char letter) {
        int numberTemp = 0;

        for(int i = 0; i < letters.length; i++) {
            if (letters[i] == letter) {
                numberTemp = i;
            }
        }
        return numberTemp;
    }

    public int shiftNumber(int numberTemp, int shift) {
            int encryptNumberValue = numberTemp + shift;

            if (encryptNumberValue > 29) {
                encryptNumberValue -= 29;
            }

            return encryptNumberValue;

        }


    public char numberToLetter(int newNumber) {
        char newLetter = letters[newNumber];

        return newLetter;
    }




    public static void main(String[] args) {
        Main obj = new Main();

        obj.mainMenu();



    }
}
