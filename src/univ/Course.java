package univ;

/**
* Class that hold course information
*
* @author  Jeongyeon Park
* @version 1.0
* @since   2018-11-27 
*/

import java.util.ArrayList;
import java.util.Objects;

public class Course {
    private String courseCode;
    private String courseTitle;
    private String courseStatus;
    private String semester;
    private double credit;
    private ArrayList<Course> preReqList;

    public Course() {
        this.courseCode = null;
        this.courseTitle = null;
        this.courseStatus = null;
        this.semester = null;
        this.credit = 0;
        this.preReqList = new ArrayList<>();
    }

    /*  Deep Copy Constructor for Course */
    public Course(Course course) {
        this.courseCode = course.getCourseCode();
        this.courseTitle = course.getCourseTitle();
        this.courseStatus = course.getCourseStatus();
        this.semester = course.getSemesterOffered();
        this.credit = course.getCourseCredit();
        this.preReqList = course.getPrerequisites();
    }

    protected void setCourseCode(String courseCode) {
        if (courseCode != null && !courseCode.isEmpty()) {
            this.courseCode = courseCode;
        }
    }

    protected void setCourseTitle(String courseTitle) {
        if (courseTitle != null && !courseTitle.isEmpty()) {
            this.courseTitle = courseTitle;
        }
    }
    
    protected void setSemesterOffered(String semesterOffered){
        if (semesterOffered != null && !semesterOffered.isEmpty()) {
            this.semester = semesterOffered;
        }
    }

    protected void setCourseStatus(String courseStatus) {
        if (courseStatus != null && !courseStatus.isEmpty()) {
            this.courseStatus = courseStatus;
        }
    }

    protected void setCourseCredit(Double credit) {
        if (credit != null && credit >= 0 && credit <= 1.0) {
            this.credit = credit;
        }
    }

    protected void setPrerequisites(ArrayList<Course> preReqList) {
        if (preReqList == null) {
            this.preReqList = null;
        } else {
            this.preReqList = preReqList;
        }
    }

    public String getCourseCode() { return this.courseCode; }

    public String getCourseTitle() { return this.courseTitle; }

    public String getCourseStatus() { return this.courseStatus; }

    public String getSemesterOffered() { return this.semester; }
    
    public double getCourseCredit() { return this.credit; }
    
    public ArrayList<Course> getPrerequisites() { return this.preReqList; }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        if (this.courseCode != null) {
            toString = new StringBuilder(("Code: " + this.courseCode + System.getProperty("line.separator")));
        }
        if (this.courseTitle != null) {
            toString.append("Title: ").append(this.courseTitle).append(System.getProperty("line.separator"));
        }
        if (this.courseStatus != null) {
            toString.append("Status: ").append(this.courseStatus).append(System.getProperty("line.separator"));
        }

        if (this.semester != null) {
            toString.append("Semester Taken: ").append(this.semester).append(System.getProperty("line.separator"));
        }
        if (this.credit > 0) {
            toString.append("Credit: ").append(this.getCourseCredit()).append(System.getProperty("line.separator"));
        }
        if (this.preReqList != null) {
            toString.append("Prerequisites: ");
            for (Course c : this.preReqList) {
                toString.append(c.getCourseCode());
            }
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

        Course course = (Course) o;
        if (course.courseCode == null || !(this.courseCode.equals(course.courseCode))) {
            return false;
        }
        if (course.courseTitle == null || !(this.courseTitle.equals(course.courseTitle))) {
            return false;
        }
        if (course.courseStatus == null || !(this.courseStatus.equals(course.courseStatus))) {
            return false;
        }
        if (this.semester != null && course.semester != null) {
            if (!(this.semester.equals(course.semester))) {
                return false;
            }
        }
        return this.preReqList.equals(course.preReqList);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.courseCode);
        hash = 53 * hash + Objects.hashCode(this.courseTitle);
        hash = 53 * hash + Objects.hashCode(this.courseStatus);
        hash = 53 * hash + Objects.hashCode(this.semester);
        hash = 53 * hash + Objects.hashCode(this.preReqList);
        return hash;
    }
}
