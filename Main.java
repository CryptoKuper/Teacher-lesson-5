import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Класс, представляющий преподавателя
class Teacher {
    private int teacherId;
    private String name;

    public Teacher(int teacherId, String name) {
        this.teacherId = teacherId;
        this.name = name;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public String getName() {
        return name;
    }
}

// Класс, представляющий студента
class Student {
    private int studentId;
    private String name;

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }
}

// Класс, представляющий учебную группу
class StudyGroup {
    private Teacher teacher;
    private List<Student> students;

    public StudyGroup(Teacher teacher, List<Student> students) {
        this.teacher = teacher;
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Student> getStudents() {
        return students;
    }
}

// Сервисный класс для работы с учебной группой
class StudyGroupService {
    // Метод для формирования учебной группы
    public static StudyGroup formStudyGroup(Teacher teacher, List<Student> students) {
        return new StudyGroup(teacher, students);
    }
}

// Контроллер для агрегации данных и формирования учебной группы
class Controller {
    // Метод для агрегации данных и формирования учебной группы
    public StudyGroup aggregateData(Teacher teacher, List<Student> students) {
        return StudyGroupService.formStudyGroup(teacher, students);
    }
}

// Класс с методом main для запуска программы
public class Main {
    public static void main(String[] args) {
        // Создаем объекты преподавателя и студентов
        Teacher teacher = new Teacher(1, "John Doe");
        List<Student> students = new ArrayList<>();
        students.add(new Student(101, "Alice"));
        students.add(new Student(102, "Bob"));
        students.add(new Student(103, "Charlie"));

        // Вызываем метод контроллера для агрегации данных и формирования учебной группы
        Controller controller = new Controller();
        int teacherId;
        List<Integer> studentIds;
        StudyGroup studyGroup = controller.aggregateData(teacher, students);
        teacherId = studyGroup.getTeacher().getTeacherId();
        studentIds = studyGroup.getStudents().stream().map(Student::getStudentId).collect(Collectors.toList());

        // Выводим информацию о преподавателе и студентах
        System.out.println("Преподаватель: " + teacherId);
        System.out.println("Студенты: " + studentIds);
    }
}
