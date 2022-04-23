package ru.skypro;

public class Hogwards {
    private Gryffindor[] griff;
    private Ravenclaw[] rave;
    private Slytherin[] slyth;
    private Hufflepuff[] huffle;
    private int whatFaculty;
    private int powerOfMagic;


    public Hogwards() {                     // Объявляем в начале класса
        this.griff = new Gryffindor[5];     // инициализацию объектов по умолчанию.
        this.rave = new Ravenclaw[5];       // В данном случае в каждом факультете
        this.slyth = new Slytherin[5];      // считаем, что учится не более 5 волшебников.
        this.huffle = new Hufflepuff[5];
    }

    public Hogwards(int numbers) {          //  Либо из main задаем принудительно кол-во
        this.griff = new Gryffindor[numbers];// обучающихся на каждом факультете
        this.rave = new Ravenclaw[numbers];
        this.slyth = new Slytherin[numbers];
        this.huffle = new Hufflepuff[numbers];
    }

    private void printAll(Object[] o) { // внутренний метод печати студентов любого факультета
        for (Object i : o) {
            if (i != null) {
               System.out.println(i);
            }
        }
    }
// ********** альтернативный поиск конкретного студента ************  (внутренний метод)
    private int[] alternatetiveSearchOfStudent(String student) {
        int[] sStud = new int[2];
        for (int i=0; i < griff.length; i++) {
            if (griff[i] != null && griff[i].getName().equals(student)) {
                sStud[0] = 1; // griff
                sStud[1] = i;
                return sStud;
            }
            if (slyth[i] != null && slyth[i].getName().equals(student)) {
                sStud[0] = 2; // slyth
                sStud[1] = i;
                return sStud;
            }
            if (rave[i] != null && rave[i].getName().equals(student)) {
                sStud[0] = 3; // rave
                sStud[1] = i;
                return sStud;
            }
            if (huffle[i] != null && huffle[i].getName().equals(student)) {
                sStud[0] = 4; // huffle
                sStud[1] = i;
                return sStud;
            }
        }
        sStud[0] = 0; // нет совпадений
        sStud[1] = 0;
        return sStud;
    }


    // печатаем всех студентов ----------------------------------------------------
    public void printAllStudents() {
        printAll(griff);
        printAll(slyth);
        printAll(rave);
        printAll(huffle);
    }


    // ********** ищем конкретного студента ************  (внутренний метод)
    private int searchStudent(String student) {
        whatFaculty = 0;
        int id = 0;
        for (int i = 0; i < griff.length; i++) {
            if (griff[i] != null && griff[i].getName().equals(student)) { // ==== это Гриффиндорец?
                whatFaculty = 1;
                id = i;
                break;
            }
            if (slyth[i] != null && slyth[i].getName().equals(student)) { // ==== это Слизеринец?
                whatFaculty = 2;
                id = i;
                break;
            }
            if (rave[i] != null && rave[i].getName().equals(student)) { // ==== это Когтевранец?
                whatFaculty = 3;
                id = i;
                break;
            }
            if (huffle[i] != null && huffle[i].getName().equals(student)) {// ==== это Пуффендуец?
                whatFaculty = 4;
                id = i;
                break;
            }
        }
        return id;
    }

    // ********** печатаем качества конкретного студента ******************************
    public void printAllAboutStudent(String student) {
        int[] sStud = alternatetiveSearchOfStudent(student);
        int whatId = sStud[1];
        int whatFac = sStud[0];
        if (whatFac == 0) {
            return;
        }
        switch (whatFac) {
            case 1:
                System.out.println(griff[whatId]);
                break;
            case 2:
                System.out.println(slyth[whatId]);
                break;
            case 3:
                System.out.println(rave[whatId]);
                break;
            case 4:
                System.out.println(huffle[whatId]);
                break;
        }
    }

    // ********** (1) сравниваем Гриффинорцев ******************************
    public void whoIsTheBestOfGriff(String student1, String student2) {
        int id1 = searchStudent(student1);
        if (whatFaculty == 0) {
            return;
        }
        int id2 = searchStudent(student2);
        if (whatFaculty == 0) {
            return;
        }
        int sum1 = griff[id1].getNobility() + griff[id1].getHonor() + griff[id1].getBravery();
        int sum2 = griff[id2].getNobility() + griff[id2].getHonor() + griff[id2].getBravery();
        if (sum1 > sum2) {
            System.out.println(student1 + " лучший Гриффиндорец, чем " + student2);
        } else {
            if (sum1 < sum2) {
                System.out.println(student2 + " лучший Гриффиндорец, чем " + student1);
            } else {
                System.out.println("И " + student1 + ", и " + student2 + " одинаково равны!");
            }
        }
    }

    // ********** (2) сравниваем  Слизеринцев ******************************
    public void whoIsTheBestOfSlyth(String student1, String student2) {
        int id1 = searchStudent(student1);
        if (whatFaculty == 0) {
            return;
        }
        int id2 = searchStudent(student2);
        if (whatFaculty == 0) {
            return;
        }
        int sum1 = slyth[id1].getAmbition() + slyth[id1].getDetermination() +
                slyth[id1].getIngenuity() + slyth[id1].getLustForPower() + slyth[id1].getTrick();
        int sum2 = slyth[id2].getAmbition() + slyth[id2].getDetermination() +
                slyth[id2].getIngenuity() + slyth[id2].getLustForPower() + slyth[id2].getTrick();

        if (sum1 > sum2) {
            System.out.println(student1 + " лучший Слизеринец, чем " + student2);
        } else {
            if (sum1 < sum2) {
                System.out.println(student2 + " лучший Слизеринец, чем " + student1);
            } else {
                System.out.println("И " + student1 + ", и " + student2 + " одинаково равны!");
            }
        }
    }

    // ********** (3) сравниваем  Когтевранцев ******************************
    public void whoIsTheBestOfRaven(String student1, String student2) {
        int id1 = searchStudent(student1);
        if (whatFaculty == 0) {
            return;
        }
        int id2 = searchStudent(student2);
        if (whatFaculty == 0) {
            return;
        }
        int sum1 = rave[id1].getCreativity() + rave[id1].getMind() + rave[id1].getWisdom() + rave[id1].getWit();
        int sum2 = rave[id2].getCreativity() + rave[id2].getMind() + rave[id2].getWisdom() + rave[id2].getWit();

        if (sum1 > sum2) {
            System.out.println(student1 + " лучший Когтевранец, чем " + student2);
        } else {
            if (sum1 < sum2) {
                System.out.println(student2 + " лучший Когтевранец, чем " + student1);
            } else {
                System.out.println("И " + student1 + ", и " + student2 + " одинаково равны!");
            }
        }
    }

    // ********** (4) сравниваем  Пуффендуйцев  ******************************
    public void whoIsTheBestOfHuffle(String student1, String student2) {
        int id1 = searchStudent(student1);
        if (whatFaculty == 0) {
            return;
        }
        int id2 = searchStudent(student2);
        if (whatFaculty == 0) {
            return;
        }
        int sum1 = huffle[id1].getDiligence() + huffle[id1].getHonesty() + huffle[id1].getLoyalty();
        int sum2 = huffle[id2].getDiligence() + huffle[id2].getHonesty() + huffle[id2].getLoyalty();

        if (sum1 > sum2) {
            System.out.println(student1 + " лучший Пуффендуец, чем " + student2);
        } else {
            if (sum1 < sum2) {
                System.out.println(student2 + " лучший Пуффендуец, чем " + student1);
            } else {
                System.out.println("И " + student1 + ", и " + student2 + " одинаково равны!");
            }
        }
    }

    // --------- внутренний метод, определяющий сумму магии и трансгрессии ---------
    private int sumOfApparition(int whatId) {
        powerOfMagic = 0;
        switch (whatFaculty) {
            case 1:
                powerOfMagic = griff[whatId].getMagic();
                return griff[whatId].getApparition();
            case 2:
                powerOfMagic = slyth[whatId].getMagic();
                return slyth[whatId].getApparition();
            case 3:
                powerOfMagic = rave[whatId].getMagic();
                return rave[whatId].getApparition();
            case 4:
                powerOfMagic = huffle[whatId].getMagic();
                return huffle[whatId].getApparition();
        }
        return 0;
    }


    // ===================  сравниваем  2-х разных учеников по силе магии и расстоянию трансгрессии  ===================
    public void whoIsTheBestOfPowerMagic(String student1, String student2) {
        int id1 = searchStudent(student1);
        if (whatFaculty == 0) {
            return;
        }
        int apparition1 = sumOfApparition(id1);
        int magicPower1 = powerOfMagic;
        int id2 = searchStudent(student2);
        if (whatFaculty == 0) {
            return;
        }
        int apparition2 = sumOfApparition(id2);
        int magicPower2 = powerOfMagic;
        if (magicPower1 > magicPower2) {
            System.out.println(student1 + " обладает бОльшей мошностью магии, чем " + student2);
        } else {
            if (magicPower1 < magicPower2) {
                System.out.println(student2 + " обладает бОльшей мошностью магии, чем " + student1);
            } else {
                System.out.println("И " + student1 + ", и " + student2 + " обладает одинаковой мошностью магии!");
            }
        }
            if (apparition1 > apparition2) {
                System.out.println(student1 + " трансгрессирует на бОльшее расстояние, чем " + student2);
            } else {
                if (apparition1 < apparition2) {
                    System.out.println(student2 + " трансгрессирует на бОльшее расстояние, чем " + student1);
                } else {
                    System.out.println("И " + student1 + ", и " + student2 + " одинаково трансгрессируют!");
                }

            }
        }


        // +++++ Добавляем нового Гриффинорца +++++
        public void addNewGriff (String name,int magic, int apparition, int nobility, int honor, int bravery){
            boolean isEmptyCell = false;
            for (int i = 0; i < griff.length; i++) {
                if (griff[i] == null) {
                    griff[i] = new Gryffindor(name, magic, apparition, nobility, honor, bravery);
                    isEmptyCell = true;
                    break;
                }
            }
        }

        // +++++ Добавляем нового Слизеринца +++++
        public void addNewSlyth (String name,int magic, int apparition, int trick, int determination, int ambition,
        int ingenuity, int lustForPower){
            boolean isEmptyCell = false;
            for (int i = 0; i < slyth.length; i++) {
                if (slyth[i] == null) {
                    slyth[i] = new Slytherin(name, magic, apparition, trick, determination, ambition, ingenuity, lustForPower);
                    isEmptyCell = true;
                    break;
                }
            }
        }

        // +++++ Добавляем нового Когтевранца +++++
        public void addNewRaven (String name,int magic, int apparition, int mind, int wisdom, int wit, int creativity){
            boolean isEmptyCell = false;
            for (int i = 0; i < rave.length; i++) {
                if (rave[i] == null) {
                    rave[i] = new Ravenclaw(name, magic, apparition, mind, wisdom, wit, creativity);
                    isEmptyCell = true;
                    break;
                }
            }
        }

        // +++++ Добавляем нового Пуффендуйца +++++
        public void addNewHuffle (String name,int magic, int apparition, int diligence, int loyalty, int honesty){
            boolean isEmptyCell = false;
            for (int i = 0; i < huffle.length; i++) {
                if (huffle[i] == null) {
                    huffle[i] = new Hufflepuff(name, magic, apparition, diligence, loyalty, honesty);
                    isEmptyCell = true;
                    break;
                }
            }

        }
    }
