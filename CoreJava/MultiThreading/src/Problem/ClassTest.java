package Problem;

class Classroom
{


    public synchronized void waitForTeacher() throws InterruptedException {
        System.out.println("Student:waiting for teacher....");
        wait();

        System.out.println("Student: Joining Class!");
    }

    public synchronized void startClass()
    {
        System.out.println("Teacher : starting class");

        notify();
    }
}

class StudentThread extends Thread
{
    private Classroom classroom;

    public StudentThread(Classroom classroom)
    {
        this.classroom=classroom;
    }

    @Override
    public void run() {
        try {
            classroom.waitForTeacher();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class TeacherThread extends Thread
{
    private Classroom classroom;

    public TeacherThread(Classroom classroom)
    {
        this.classroom=classroom;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        classroom.startClass();
    }
}


public class ClassTest {
    public static void main(String[] args) {
        Classroom classroom= new Classroom();

        StudentThread studentThread=new StudentThread(classroom);
        TeacherThread teacherThread=new TeacherThread(classroom);

        studentThread.start();
        teacherThread.start();

    }
}
