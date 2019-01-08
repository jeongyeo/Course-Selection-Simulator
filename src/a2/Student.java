package a2;
/**
* Class that holds student info
*
* @author  Jeongyeon Park
* @version 1.0
* @since   2018-11-27 
*/

import univ.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Student {
    private String first;
    private String last;
    private int studentNum;
    private ArrayList<Attempt> transcript;
    private ArrayList<Course> pos;
    private Degree deg;
    
    public Student() {
        this.first = null;
        this.last = null;
        this.studentNum = 0;
        this.transcript = new ArrayList<>();
        this.pos = new ArrayList<>();
        this.deg = null;
    }
    
    public void removeAttempt(String courseCode, String semester){
        ArrayList<Attempt> temp = getFullAttempts();
        for(Iterator<Attempt> iterator = temp.iterator(); iterator.hasNext();){
            Attempt a = iterator.next();
            if(a.getCourseAttempted().getCourseCode().equals(courseCode)){
                iterator.remove();
            }
        }
    }
    
    public void removeCourse(String courseCode){
        ArrayList<Course> temp = getFullPlanOfStudy();
        for(Iterator<Course> iterator = temp.iterator(); iterator.hasNext();){
            Course c = iterator.next();
            if(c.getCourseCode().equals(courseCode)){
                iterator.remove();
            }
        }
    }
    
    public void addAttempt(Attempt a){
        if(a != null){
            this.transcript.add(a);
        }
    }
    
    public void addCourse(Course c){
        
        if(c != null){
            this.pos.add(c);
        }
    }
    
    public void setTranscript(ArrayList<Attempt> transcript){
        if(transcript != null && !transcript.isEmpty()){
            this.transcript = transcript;
        }
    }
    
    public void setPlanOfStudy(ArrayList<Course> pos){
        if(pos != null && !pos.isEmpty()){
            this.pos = pos;
        }
    }
    
    public void setFirstName(String first) {
        if (first != null && !first.isEmpty())
            this.first = first;
    }

    public void setLastName(String last) {
        if (last != null && !last.isEmpty())
            this.last = last;
    }

    public void setStudentNumber(Integer studentNum) { this.studentNum = studentNum; }
    
    public void setDegree(Degree deg){ this.deg = deg; }
    
    public String getFullName() {
        String fullName;
        if (this.first == null && this.last == null) {
            return null;
        } else if (this.first == null) {
            fullName = this.last;
        } else if (this.last == null) {
            fullName = this.first;
        } else {
            fullName = this.first + " " + this.last;
        }
        return fullName;
    }

    public String getFirstName() { return this.first; }

    public String getLastName() { return this.last; }

    public Integer getStudentNumber() { return this.studentNum; }
    
    public ArrayList<Attempt> getFullAttempts(){ return this.transcript; }
    
    public ArrayList<Course> getFullPlanOfStudy(){ return this.pos; }
    
    public Attempt findAttempt(String courseCode, String semester){
        for(Attempt a : this.transcript){
            if(a.getCourseAttempted().getCourseCode().equals(courseCode) && a.getSemesterTaken().equals(semester)){
                return a;
            }
        }
        return null;
    }
    public Attempt findAttempt(String courseCode){
        for(Attempt a : this.transcript){
            if(a.getCourseAttempted().getCourseCode().equals(courseCode)){
                return a;
            }
        }
        return null;
    }
    
    public Course findCourse(String courseCode){
        for(Course c : this.pos){
            if(c.getCourseCode().equals(courseCode)){
                return c;
            }
        }
        return null;
    }
    
    public Degree getDegree(){
        return this.deg;
    }

    @Override
    public String toString() {
        String toString = "";
        if (this.first != null) {
            toString = ("First name: " + this.first + System.getProperty( "line.separator" ));
        }
        if (this.last != null) {
            toString += ("Last name: " + this.last + System.getProperty( "line.separator" ));
        }
        toString += ("Student number: " + this.studentNum + System.getProperty( "line.separator" ));

        return toString;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Student)) {
            return false;
        }

        Student student = (Student) o;
        if (!(this.first.equals(student.first))){
            return false;
        }
        if (!(this.last.equals(student.last))){
            return false;
        }
        return this.studentNum == student.studentNum;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.first);
        hash = 37 * hash + Objects.hashCode(this.last);
        hash = 37 * hash + Objects.hashCode(this.studentNum);
        return hash;
    }
}
