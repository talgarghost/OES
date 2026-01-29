public class Main {
    public static void main(String[] args) {

        UniversityDatabase db = new UniversityDatabaseImpl();

        try {
            db.connect();

            Student s1 = new Student("Aslam", 18, 5);
            Course c1 = new Course(104, "OOP ");

            db.addStudent(s1);
            db.addCourse(c1);

            db.enrollStudentInCourse(1, 102);

            System.out.println("Student enrolled successfully");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                db.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
