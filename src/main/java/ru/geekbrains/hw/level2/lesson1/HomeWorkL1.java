package ru.geekbrains.hw.level2.lesson1;

public class HomeWorkL1 {
    public static void main(String[] args) {

        Member[] members = {
                new Human(),
                new Cat(),
                new Robot()
        };
        Let[] lets = {
                new Treadmill(),
                new Wall()
        };
        for (Member member : members) {
            for (Let let : lets) {
                if (let instanceof Treadmill) member.run();
                if (let instanceof Wall) member.jump();
            }
        }
    }
}
