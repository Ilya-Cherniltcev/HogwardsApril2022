package ru.skypro;

public class Main {

    public static void main(String[] args) {
        Hogwards wizard = new Hogwards();
        wizard.addNewGriff("Гарри Поттер", 85, 7,90,90,90);
        wizard.addNewGriff("Гермиона Грейнджер", 55,15,85,100,50);
        wizard.addNewGriff("Рон Уизли", 40,3,70,80,80);
        wizard.addNewSlyth("Драко Малфой",44,9,80,80,90,70,100);
        wizard.addNewSlyth("Грэхэм Монтегю",32,2,53,49,38,20,50);
        wizard.addNewSlyth("Грегори Гойл",28,0,41,58,76,54,70);
        wizard.addNewRaven("Чжоу Чанг",33,5,82,74,69,88);
        wizard.addNewRaven("Падма Патил",35,3,63,45,32,54);
        wizard.addNewRaven("Маркус Белби",23,2,56,65,71,48);
        wizard.addNewHuffle("Захария Смит", 56,6,57,88,90);
        wizard.addNewHuffle("Седрик Диггори", 39,4,67,77,85);
        wizard.addNewHuffle("Джастин Финч-Флетчли", 26,7,45,65,70);
        wizard.printAllStudents();
        System.out.println("=======================================================");
        String student = "Седрик Диггори";
        wizard.printAllAboutStudent(student);
        System.out.println("=======================================================");

        String student1 = "Гермиона Грейнджер";
        String student2 = "Рон Уизли";
        wizard.whoIsTheBestOfGriff(student1, student2);
        student1 = "Драко Малфой";
        student2 = "Грэхэм Монтегю";
        System.out.println("=======================================================");
        wizard.whoIsTheBestOfSlyth(student1,student2);
        System.out.println("=======================================================");
        student1 = "Чжоу Чанг";
        student2 = "Падма Патил";
        wizard.whoIsTheBestOfRaven(student1,student2);
        System.out.println("=======================================================");
        student1 = "Захария Смит";
        student2 = "Джастин Финч-Флетчли";
        wizard.whoIsTheBestOfHuffle(student1,student2);
        System.out.println("=======================================================");
        student1 = "Гарри Поттер";
        student2 = "Драко Малфой";
        wizard.whoIsTheBestOfPowerMagic(student1,student2);
    }
}
