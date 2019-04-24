/**
 * Домашняя работа к уроку 7 Java 1
 *
 * @author Андрей Семенюк
 * @version 20.04.2019
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//1. Расширить задачу про котов и тарелки с едой
//2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды,
// а кот пытается покушать 15-20)
//3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать
// (хватило еды), сытость = true
//4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть не может быть наполовину сыт
// (это сделано для упрощения логики программы)
//5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию
// о сытости котов в консоль
//6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку



public class Homework_7 {
    public static void main(String[] args) {
        Cat[] cats = {
        new Cat("Котя", 20), new Cat("Том", 10), new Cat("Мася", 15)
        };
        Plate plate = new Plate(50, 25);
        System.out.println(plate);

        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat);
        }

        System.out.println(plate);
        plate.add(50);
        System.out.println(plate);

        for (Cat cat : cats) {
            cat.setFullness(false);
            cat.eat(plate);
            System.out.println(cat);
        }
        System.out.println(plate);
    }
}

class Cat {
    protected String name;
    protected int appetite;
    protected boolean fullness;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        fullness = false;
    }

    void setFullness(boolean status) {
        fullness = status;
    }

    void eat(Plate plate) {
        if (!fullness)
            fullness = plate.decreaseFood(appetite);
    }

    @Override
    public String toString() {
        return "Имя = " + name + ", Аппетит = " +
                appetite + ", Сытость = " + fullness;
    }
}

class Plate {
    protected int volume;
    protected int food;

    Plate(int volume, int food) {
        this.volume = volume;
        this.food = food;
    }

    boolean decreaseFood(int portion) {
        if (food < portion) return false;
        food -= portion;
        return true;
    }

    void add(int food) {
        if (this.food + food <= volume)
            this.food += food;
    }

    @Override
    public String toString() {
        return "Тарелка: " + food;
    }
}

//1 Необходимо создать окно с 1 полем (Фамилия, Имя, Отчество) и кнопку
//2 По нажатии кнопки открывается еще 1 окно с тремя полями и кнопкой, в поля вводишь ФИО и нажимаешь кнопку ОК.
//3 Дополнительное окно закрывается и в основном окне в поле оседает ФИО.




public class Homework_7_2 {
    public static void main(String[] args) {
        Window win1 = new Window("Фамилия Имя Отчество");

    }

}


class Window extends JFrame {
    public Window(String text) {


        setTitle("Приветствую");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 200, 400, 200);
        setLayout(new BorderLayout());
        JButton but = new JButton("Продолжить");
        add(but,BorderLayout.SOUTH);
        JLabel lab = new JLabel(text);
        add(lab,BorderLayout.CENTER);
        OpenWin2();

        setVisible(true );
    }

    public void  OpenWin2 (){
        JButton but = new JButton("Продолжить");
        add(but,BorderLayout.SOUTH);
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Window2 win2 = new Window2();
                setVisible(false);

            }
        });

    }

}

class Window2 extends JFrame {
    public static String text = "    ";


    public Window2() {

        setTitle("Тест, введите ФИО");
        setBounds(100, 100, 400, 200);
        JTextField insertText = new JTextField(20);
        JTextField insertText1 = new JTextField(20);
        JTextField insertText2 = new JTextField(20);

        JButton buttonOk = new JButton("Отправить");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(insertText);
        add(insertText1);
        add(insertText2);
        add(buttonOk);
        setVisible(true);
        buttonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text = insertText.getText()+"  "+ insertText1.getText()+"  "+insertText2.getText();
                Window OutWin = new Window(text);
                setVisible(false);

            }
        });

    }
}