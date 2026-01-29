public class Course {

    private int id;
    private String name;

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getCourseId() {
        return id;
    }

    public String getCourseName() {
        return name;
    }
}
