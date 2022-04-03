package com.company;

import java.security.SecureRandom;
import java.util.Scanner;

public class Game {
    int money = 20;
    int health = 100;
    double strength = 1;
    int energy = 100;
    int exit = 1;

    Scanner console = new Scanner(System.in);
    SecureRandom random = new SecureRandom();

    public Game() {
        System.out.println("Игра запущена!");
    }

    public void playGame() {
        System.out.println("Приветствуем в нашей игре!");
        System.out.println("Ваш текущий бюджет: " + money);
        System.out.println("Ваше текущее здоровье: " + health);
        System.out.println("Ваша текущая сила: " + strength);
        System.out.println("Ваша текущая энергия: " + energy);
        fightMonster();

        System.out.println("\nВыберите следующее действие: " +
                "\n 1 - Сражаться с монстром(1-6 энергии) " +
                "\n 2 - Просить милостыню(2 энергии)(1-20 монет) " +
                "\n 3 - Посетить магазин(5 энергии)" +
                "\n 4 - Закончить игру");
        System.out.println("############################################\n");
        int choice = console.nextInt();
        switch (choice) {
            case 1:
                fightMonster();
                break;
            case 2:
                panhandle();
                break;
            case 3:
                shop();
                break;
            case 4:
                exit = 0;
                break;
            case 5:
                break;
        }
    }


    public void fightMonster() {                                //void - ничего не возвращает
        System.out.println("Выберите сложность монстра:" +
                " \n 1 - Легкий(1-10 strength) " +
                "\n 2 - Средний(11 - 20 strength) " +
                "\n 3 - Сложный (21-40 strength) " +
                "\n 4 - Босс(41-50 strength)");
        int monsterType = console.nextInt();                            // console считывает с клавиатуры
        switch (monsterType) {
            case 1:
                fightEasyMonster();
                break;
            case 2:
                fightStrongMonster();
                break;
            case 3:
                fightSuperStrongMonster();
                break;
            case 4:
                fightBoss();
                break;
        }
    }

    public void fightEasyMonster() {
        energy -= 10;                                                    //вычитаем энергию
        double monsterStrenght = random.nextInt(21) / 10;
        if (strength > monsterStrenght) {
            System.out.println("Вы ПОБЕДИЛИ!");
            money += 5;

        } else
            System.out.println("Вы проиграли :(");
        System.out.println("Сила монстра была: " + monsterStrenght);
        health -= monsterStrenght;
    }

    public void fightStrongMonster() {
        energy -= 20;                                                    //вычитаем энергию
        double monsterStrenght = random.nextInt(21) / 10;
        if (strength > monsterStrenght) {
            System.out.println("Вы ПОБЕДИЛИ!");
            money += 15;

        } else
            System.out.println("Вы проиграли :(");
        System.out.println("Сила монстра была: " + monsterStrenght);
        health -= monsterStrenght;
    }

    public void fightSuperStrongMonster() {
        energy -= 30;                                                    //вычитаем энергию
        double monsterStrenght = random.nextInt(21) / 10;
        if (strength > monsterStrenght) {
            System.out.println("Вы ПОБЕДИЛИ!");
            money += 30;

        } else
            System.out.println("Вы проиграли :(");
        System.out.println("Сила монстра была: " + monsterStrenght);
        health -= monsterStrenght;
    }

    public void fightBoss() {
        energy -= 40;                                                    //вычитаем энергию
        double monsterStrenght = random.nextInt(21) / 10;
        if (strength > monsterStrenght) {
            System.out.println("Вы ПОБЕДИЛИ!");
            money += 50;

        } else
            System.out.println("Вы проиграли :(");
        System.out.println("Сила монстра была: " + monsterStrenght);
        health -= monsterStrenght;
    }


    public void panhandle() {
        int panh = random.nextInt(21);
        if (energy >= 2) {
            money += panh;
            energy -= 2;
            System.out.println("Пожертвование " + panh + " монет\n");
        } else {
            System.out.println("НЕДОСТАТОЧНО энергии");
        }
    }


    public void shop() {
        if (energy >= 5) {
            energy -= 5;
            System.out.println("Добро пожаловать в магазин!) " +
                    "\n Что вы хотете купить?" +
                    "\n 1 - Кинжал (10 монет, +5 к силе) " +
                    "\n 2 - Мечь (25 монет, +15 к силе)" +
                    "\n 3 - Зелье из коры дерева (40 монет, +10 к силе, +10 к здоровью) " +
                    "\n 4 - Зелье из трав (30 монета, +10 к силе, +5 к энергии, +10 к здоровью) " +
                    "\n 5 - Выйти из магазина ");

            int shopSubject = console.nextInt();

            if (money >= 10) {
                switch (shopSubject) {
                    case 1:
                        money -= 10;
                        strength += 5;
                        System.out.println("Вы преобрели кинжал!");
                        break;
                    case 2:
                        money -= 25;
                        strength += 15;
                        System.out.println("Вы преобрели мечь!");
                        break;
                    case 3:
                        money -= 40;
                        strength += 10;
                        health += 10;
                        System.out.println("Вы преобрели зелье!");
                        break;
                    case 4:
                        money -= 30;
                        strength += 10;
                        energy += 5;
                        health += 10;
                        System.out.println("Вы преобрели зелье из трав!");
                        break;
                    case 5:
                        break;
                }
            } else {
                System.out.println("У вас недостаточно денег");
            }
        } else {
            System.out.println("У вас недостаточно энергии!");
        }

                }
            }



