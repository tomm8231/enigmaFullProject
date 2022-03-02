package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    Scanner sc = new Scanner(System.in);

    char[] letters = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
        'I', 'J', 'K', 'L', 'M' , 'N', 'O', 'P', 'Q', 'R', 'S',
        'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'Æ', 'Ø', 'Å'};


    public void mainMenu(){
        System.out.println("Which cipher method would you like to use?");
        System.out.println("1) Ceasar");
        System.out.println("2) Exit");
        int method = sc.nextInt();
        newLine();
        switch (method) {
            case 1 -> ceasarEncryptOrDecrypt();
            case 2 -> System.exit(0);
        }
    }

    public void finalOption() {
        System.out.println("Would you like to:");
        System.out.println("1) Do another encryption/decryption");
        System.out.println("2) Exit");
        int number = sc.nextInt();
        switch(number) {
            case 1 -> mainMenu();
            case 2 -> System.exit(0);
        }
    }

    public void newLine() {
        System.out.println();
    }

    public void ceasarEncryptOrDecrypt() {
        System.out.println("Please choose one of the cipher methods below followed by Enter:");
        System.out.println("1) Encrypt");
        System.out.println("2) Decrypt");
        int number = sc.nextInt();
        newLine();
        switch(number) {
            case 1 -> ceasarMethodEncrypt();
            case 2 -> ceasarMethodDecrypt();
        }
        finalOption();
    }

    public void ceasarMethodDecrypt() {
        int shift = enterShift();
        newLine();
        String text = enterText();
        StringBuilder decryptedText = caesarDecrypt(text, shift);
        newLine();
        System.out.println(decryptedText);
        newLine();
    }


    public void ceasarMethodEncrypt() {
        int shift = enterShift();
        newLine();
        String text = enterText();
        StringBuilder encryptedText = caesarEncrypt(text, shift);
        newLine();
        System.out.println(encryptedText);
        newLine();

    }

    public StringBuilder caesarDecrypt(String text, int shift) {
        StringBuilder sb = new StringBuilder();

        char newLetter;

        for(int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            int letterValue = letterToNumber(letter);
            if (letterValue != 0) {
                int newLetterValue = shiftNumberDecrypt(letterValue, shift);
                newLetter = numberToLetter(newLetterValue);
            }
            else {
                newLetter = ' ';
            }

            sb.append(newLetter);

        }
        return sb;
    }

    public StringBuilder caesarEncrypt(String text, int shift) {
        StringBuilder sb = new StringBuilder();

        char newLetter;

        for(int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            int letterValue = letterToNumber(letter);
            if (letterValue != 0) {
                int newLetterValue = shiftNumberEncrypt(letterValue, shift);
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
        newLine();
        System.out.println("Your shift value is " + shiftValue);

        return shiftValue;
    }

    public String enterText() {
        System.out.println("Enter the text you'd like to encrypt");

        String input = sc.nextLine().toUpperCase(Locale.ROOT);
        newLine();

        System.out.println("'" + input + "' encrypted is:");

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

    public int shiftNumberEncrypt(int numberTemp, int shift) {
            int encryptNumberValue = numberTemp + shift;

            if (encryptNumberValue > 29) {
                encryptNumberValue -= 29;
            }

            return encryptNumberValue;

        }

    public int shiftNumberDecrypt(int numberTemp, int shift) {
        int decryptNumberValue = numberTemp - shift;

        if (decryptNumberValue < 0) {
            decryptNumberValue += 29;
        } else if (decryptNumberValue == 0) {
            decryptNumberValue = 29;
        }

        return decryptNumberValue;

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
