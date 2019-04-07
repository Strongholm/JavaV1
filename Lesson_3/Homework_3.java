/**
 * Java_1 Lesson 3
 *
 * @author Semenyuk Andrey
 * @version 06.04.2019
 */

//    1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки
//    угадать это число. При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем
//    загаданное, или меньше. После победы или проигрыша выводится запрос – «Повторить игру еще раз?
//    1 – да / 0 – нет»(1 – повторить, 0 – нет).

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

    public class Homework_3 {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            do {
                Random r = new Random();
                int x = r.nextInt(10);
                int f;
                System.out.println("Загадайте число! От 0 до 9");

                for (int i = 1; i <= 3; i++) {
                    f = Integer.parseInt(br.readLine());

                    if (f == x) {
                        System.out.println(f + " = " + x + " Вы победили!!!");
                        break;
                    }
                    else if (f > x) System.out.println(f + " Загаданное число меньше");
                    else if (f < x) System.out.println(f + " Загаданное число больше");

                    if (i == 3) System.out.println("Вы проиграли, правильный ответ: " + x);
                }

                System.out.println("Хотите сыграть снова?? 1 - Да / 0 - Нет");

                int repeat = Integer.parseInt(br.readLine());
                while ((repeat < 0) || (repeat > 1)) {
                    System.out.println("Введите правильное число: 1 - Да / 0 - Нет");
                    repeat = Integer.parseInt(br.readLine());
                }

                if (repeat == 1) {
                    System.out.println("Начинаем новую игру");
                }
                else {
                    System.out.println("Всего хорошего и удачи)!");
                    return;
                }
            } while (true);
        }
    }



//    2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
//    "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut",
//    "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
//    При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
//    сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано,
//    компьютер показывает буквы которые стоят на своих местах.
//    apple – загаданное
//    apricot - ответ игрока
//    ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
//    Для сравнения двух слов посимвольно, можно пользоваться:
//    String str = "apple";
//    str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
//    Играем до тех пор, пока игрок не отгадает слово
//    Используем только маленькие буквы

public class Homework_3 {
    public static void main(String[] args) throws IOException {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
                "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin",
                "potato","0"};
        String guess = getRandomWord(words);
        String maskedGuess = maskWord(guess);
        System.out.println("Угадайте слово!");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String myWord = br.readLine();
            myWord = maskWord(myWord);
            if (maskedGuess.equals(myWord)) {
                System.out.println("Вы выиграли, слово: " + guess);
                break;
            } else {
                String maskedResult = "";
                for (int i = 0; i < maskedGuess.length() - 1; i++) {
                    if (maskedGuess.charAt(i) == myWord.charAt(i)) maskedResult += maskedGuess.charAt(i);
                    else maskedResult += "#";
                }
                System.out.println(maskedResult);
                System.out.println("Не правильно, попробуйте снова");
            }
        }

    }

    static String getRandomWord(String[] s) {
        Random r = new Random();
        return s[r.nextInt(s.length - 1)];
    }

    static String maskWord(String s) {
        String mask = "###############";
        for (int i = s.length() - 1; i < mask.length() - 1; i++) {
            s += mask.charAt(i);
        }
        return s;
    }
}
