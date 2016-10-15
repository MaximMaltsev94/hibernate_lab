package entity;

import javax.persistence.*;
import java.io.Serializable;


@Embeddable
public class StudentResultKey implements Serializable {
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "training_course_id", referencedColumnName = "id", nullable = false)
    private TrainingCourse trainingCourse;

    public StudentResultKey() {
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public TrainingCourse getTrainingCourse() {
        return trainingCourse;
    }

    public void setTrainingCourse(TrainingCourse trainingCourse) {
        this.trainingCourse = trainingCourse;
    }
}
