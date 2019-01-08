package a2;
/**
* Attempt class that hold transcript info
*
* @author  Jeongyeon Park
* @version 1.0
* @since   2018-11-27 
*/
import univ.*;
import java.util.Objects;

public class Attempt {
    private String grade;
    private String semester;
    private Course course;
    private String status;
    
    public Attempt(){
        this.grade = null;
        this.semester = null;
        this.course = null;
        this.status = null;
    }
    
    public String getAttemptGrade() { return this.grade; }

    public String getSemesterTaken() { return this.semester; }

    public Course getCourseAttempted() { return this.course; }
    
    public String getStatus() { return this.status; }

    public void setAttemptGrade(String grade) {
        if (grade == null) {
            this.grade = null;
            return;
        }
        int gradeNum;
        try {
            gradeNum = Integer.parseInt(grade);
            if (gradeNum <= 100 && gradeNum >= 0) {
                this.grade = grade;
            }
        } catch (NumberFormatException ignored) {
            if(grade.equals("P") || grade.equals("F") || grade.equals("INC") || grade.equals("MNR"))
            this.grade = grade;
        } catch(Exception e){
            System.out.println(e);
        }
    }

    public void setSemesterTaken(String semester) {
        if (semester != null && !semester.isEmpty()) {
            this.semester = semester;
        }
    }
    
    public void setCourseAttempted(Course theCourse){
        if(theCourse != null){
            this.course = theCourse;
        }
    }
    
    public void setStatus(String status){
        if(status != null && !status.isEmpty()){
            this.status = status;
        }
    }
    
        @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        if (this.grade != null) {
            toString = new StringBuilder(("Grade: " + this.grade + System.getProperty("line.separator")));
        }
        if (this.semester != null) {
            toString.append("Semester: ").append(this.semester).append(System.getProperty("line.separator"));
        }
        if (this.course != null) {
            toString.append("Course: ").append(this.course).append(System.getProperty("line.separator"));
        }
        return toString.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Course)) {
            return false;
        }

        Attempt attempt = (Attempt) o;
        if (attempt.grade == null || !(this.grade.equals(attempt.grade))) {
            return false;
        }
        if (attempt.semester == null || !(this.semester.equals(attempt.semester))) {
            return false;
        }
        return this.course.equals(attempt.course);
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.grade);
        hash = 53 * hash + Objects.hashCode(this.semester);
        hash = 53 * hash + Objects.hashCode(this.course);
        return hash;
    }
}
