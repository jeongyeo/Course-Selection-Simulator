package univ;
/**
* Class to initialize course catalog
*
* @author  Jeongyeon Park
* @version 1.0
* @since   2018-11-27 
*/

import a2.MyConnection;
import java.util.*;

public class CourseCatalog {

    private ArrayList<Course> courseCatalog;

    public CourseCatalog() {
        this.courseCatalog = new ArrayList<>();
    }
    
    public CourseCatalog(CourseCatalog that){
        this.courseCatalog = that.courseCatalog;
    }

    protected void setCourseCatalog(ArrayList<Course> courseCatalog) {
        this.courseCatalog = courseCatalog;
    }

    protected ArrayList<Course> getCourseCatalog() { return this.courseCatalog; }

    public void addCourse(Course toAdd) {
        for (Course c : this.courseCatalog) {
            if (c.equals(toAdd)) {
                return;
            }
        }
        courseCatalog.add(toAdd);
    }

    public void removeCourse(Course toRemove) {
        for (Course c : this.courseCatalog) {
            if (c.equals(toRemove)) {
                this.courseCatalog.remove(c);
                return;
            }
        }
    }

    public Course findCourse(String courseCode) {
        for (Course c : this.courseCatalog) {
            if (c.getCourseCode().equals(courseCode)) {
                return c;
            }
        }
        return null;
    }

    public Boolean isEmpty() { return courseCatalog.isEmpty(); }

    public void initializeCatalog() {
        MyConnection c = new MyConnection();
        ArrayList<String> list = c.getAllCourses();
        for(int i = 0; i < list.size(); i++){
            String[] parts = list.get(i).split(",");
            if(findCourse(parts[0]) == null){ //if course not in cc
                Course temp = new Course();
                temp.setCourseCode(parts[0]);
                try{
                    temp.setCourseCredit(Double.parseDouble(parts[1]));
                }
                catch(NumberFormatException e){
                    System.out.println("Error: credit value is not int");
                }
                temp.setCourseTitle(parts[2]);
                temp.setSemesterOffered(parts[3]);
                if(parts.length == 5){ //if there is prereq
                    String[] pr = parts[4].split(":");
                    ArrayList<Course> prereqs = new ArrayList<>();
                    for(int j = 0; j < pr.length; j++){ //for number of prereqs 
                        if(findCourse(pr[j]) == null){ //if prereq is not in cc
                            Course tempPrereq = new Course();
                            tempPrereq.setCourseCode(pr[j]);
                            courseCatalog.add(tempPrereq);
                            prereqs.add(findCourse(pr[j]));
                        }
                        else{ //if there already is a course in cc
                            prereqs.add(findCourse(pr[j]));
                        }
                    }
                    temp.setPrerequisites(prereqs);
                }
                courseCatalog.add(temp);
            }
            else if(findCourse(parts[0]).getCourseTitle() == null){ //means this course was temp created by a prereq 
                Course temp = findCourse(parts[0]);
                temp.setCourseCode(parts[0]);
                temp.setCourseCredit(Double.parseDouble(parts[1]));
                temp.setCourseTitle(parts[2]);
                temp.setSemesterOffered(parts[3]);
                if(parts.length == 5){ //if there is prereq
                    String[] pr = parts[4].split(":");
                    ArrayList<Course> prereqs = new ArrayList<>();
                    for(int j = 0; j < pr.length; j++){ //for number of prereqs 
                        if(findCourse(pr[j]) == null){ //if prereq is not in cc
                            Course tempPrereq = new Course();
                            tempPrereq.setCourseCode(pr[j]);
                            courseCatalog.add(tempPrereq);
                            prereqs.add(findCourse(pr[j]));
                        }
                        else{ //if there already is a course in cc
                            prereqs.add(findCourse(pr[j]));
                        }
                    }
                    temp.setPrerequisites(prereqs);
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        if (this.courseCatalog != null) {
            toString.append("Course Catalog: ");
            for (Course c : this.courseCatalog) {
                toString.append(c.toString());
            }
            toString.append(System.getProperty("line.separator"));
        }
        return toString.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof CourseCatalog)) {
            return false;
        }

        ArrayList<Course> courseCat = ((CourseCatalog) o).courseCatalog;

        return this.courseCatalog.equals(courseCat);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.courseCatalog);
        return hash;
    }

}
