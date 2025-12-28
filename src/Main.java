public class Main {
    public static void main(String[] args) {

        Candidate c1 = new OnlineCandidate(1, "Ali", "Parhul", "CS-2511", 12.5, "ali@gmail.com", "87750689322");
        Candidate c2 = new offlineCondidate(2, "Asik", "Kaldn", "SE2322", 73, "C1.2.362", "25b");
        System.out.println(c1);
        System.out.println(c2);

        Questiom q1 = new Questiom(1, "What is Java?", "Java is a programming language", 12.5);
        Questiom q2 = new Questiom(2, "What is OOP?", "OOP is Object-Oriented Programming", 19);
        Questiom q3 = new Questiom(3, "What is inheritance?", "Inheritance allows a class to acquire properties of another class", 18);
        Questiom q4 = new Questiom(4, "What is polymorphism?", "Polymorphism allows objects to take many forms", 20);
        Questiom q5 = new Questiom(5, "What is encapsulation?", "Encapsulation hides data and provides access via methods", 10);
        Questiom q6 = new Questiom(6, "What is abstraction?", "Abstraction hides complexity and shows essential features", 17);


        Exam e1 = new Exam(1, c1);
        Exam e2= new Exam(2,c2);

        e1.addquations(q1);
        e1.addquations(q3);
        e1.addquations(q4);

        e2.addquations(q2);
        e2.addquations(q5);
        e2.addquations(q6);

        System.out.println("Hard Questions for student 1 (score > 18):");
        for (Questiom q : e1.filterhardScuare(18)) {
            System.out.println(q);
        }
        System.out.println("Hard Questions for student 2 (score > 18):");
        for (Questiom q : e2.filterhardScuare(15)) {
            System.out.println(q);
        }


        System.out.println("Other for student 1 Questions (score <= 18):");
        for (Questiom q : e1.filterotherScuare(18)) {
            System.out.println(q);
        }
        System.out.println("Other student 2 Questions (score <= 15):");
        for (Questiom q : e2.filterotherScuare(15)) {
            System.out.println(q);
        }


        System.out.println("Search for 'Java':");
        for (Questiom q : e1.searching("Java")) {
            System.out.println(q);
        }
        System.out.println("Search for 'OOP':");
        for (Questiom q : e2.searching("OOP")) {
            System.out.println(q);
        }
        e1.sortquestion();
        System.out.println("Questions sorted (high score first):");
        for (Questiom q : e1.getQuestions()) {
            System.out.println(q);
        }
        e2.sortquestion();
        System.out.println("Questions sorted (high score first):");
        for (Questiom q : e2.getQuestions()) {
            System.out.println(q);
        }



    }
}
