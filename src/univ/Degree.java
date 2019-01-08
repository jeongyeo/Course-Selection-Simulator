package univ;

/**
* Abstract class that holds all degrees
*
* @author  Jeongyeon Park
* @version 1.0
* @since   2018-11-27 
*/

import a2.Student;
import java.io.FileWriter;
import java.util.ArrayList;

public abstract class Degree {
    String title;
    ArrayList<Course> listOfRequiredCourseCodes;  
    
    public Degree() {
        this.title = null;
        this.listOfRequiredCourseCodes = new ArrayList<>();
    }

    public void setDegreeTitle(String title){
        if(title != null && !title.isEmpty()){
            this.title = title;
        }
    }
    public String getDegreeTitle(){
        return this.title;
    }

    public void setRequiredCourses(ArrayList<Course> listOfRequiredCourseCodes){
        if (listOfRequiredCourseCodes != null && !listOfRequiredCourseCodes.isEmpty()){
            this.listOfRequiredCourseCodes = listOfRequiredCourseCodes;
        }
    }

    public ArrayList<Course> getRequiredCourses(){
        return this.listOfRequiredCourseCodes; 
    } 

    public abstract boolean meetsRequirements(ArrayList<Course> allTheCoursesPlannedAndTaken);
    public abstract double numberOfCreditsRemaining(ArrayList<Course> allTheCoursesPlannedAndTaken);
    public abstract ArrayList<Course> remainingRequiredCourses(ArrayList<Course> allTheCoursesPlannedAndTaken);
    @Override
    public abstract String toString();
    @Override
    public abstract boolean equals(Object o);
    @Override
    public abstract int hashCode();

}
