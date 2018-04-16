
package com.timetable.core.main;

import java.util.ArrayList;
import java.util.HashMap;

import com.timetable.core.classes.LabActivity;
import com.timetable.core.classes.LectureActivity;
import com.timetable.core.classes.Room;
import com.timetable.core.classes.SortActivities;
import com.timetable.core.classes.Student;
import com.timetable.core.classes.Subject;
import com.timetable.core.classes.Teacher;
import com.timetable.core.classes.TimeSlot;


/**
 * @author Naresh
 *
 */
public class Data {
	private int subjectCount = 0;
	

	private int roomKey = 0;
	private int timeSlotKey = 0;
	private static  Data instance = null;
    private ArrayList<Teacher> teachers;
    private ArrayList<Student> students;
    private ArrayList<Subject> subjects;
    private HashMap<Integer,Room> rooms;
    private ArrayList<LectureActivity> lectureActivities;
    private ArrayList<LabActivity> labActivities;
    private HashMap<Integer, TimeSlot> timeslots;
    private HashMap<Integer,LectureActivity> sortedLectureActivities;
    private HashMap<Integer,LabActivity> sortedLabActivities;

        
    private Data(){
        initialize();
    }
    
    private void initialize(){
        teachers = new ArrayList<>();
        students = new ArrayList<>();
        subjects = new ArrayList<>();
        lectureActivities = new ArrayList<>();
        labActivities = new ArrayList<>();
        timeslots = new HashMap<>();
        
    }
    
    public static Data getInstance() {
    	if(instance == null) {
    		instance = new Data();
    	}
    	return instance;
    }
    
    public int getSubjectCount() {
		return subjectCount;
	}

	public void setSubjectCount(int subjectCount) {
		this.subjectCount = subjectCount;
	}
    
    public void addTimeSlot(TimeSlot ts) {
    	timeslots.put(timeSlotKey++, ts);
    }
    
    public HashMap<Integer, TimeSlot> getTimeSlots() {
    	return timeslots;
    }
    
    public void addLectureActivity(LectureActivity activity){
        lectureActivities.add(activity);
    }
    public void addLabActivity(LabActivity activity){
        labActivities.add(activity);
    }
    
    public void addSubject(Subject subject){
        subjects.add(subject);
    }
    
    public void addStudent(Student student){
        
        students.add(student);
    }
    
    public void addTeacher(Teacher teacher){
        
        teachers.add(teacher);
    }
    
    public void addRoom(Room room){
        rooms.put(roomKey++, room);
    }


	public ArrayList<Teacher> getTeachers() {
		return teachers;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public ArrayList<Subject> getSubjects() {
		return subjects;
	}

	public HashMap<Integer, Room> getRooms() {
		return rooms;
	}

	public ArrayList<LabActivity> getLabActivities() {
		return labActivities;
	}
	public ArrayList<LectureActivity> getLectureActivities() {
		return lectureActivities;
	}
	

	public HashMap<Integer,LabActivity> getSortedLabActivities(){
		return sortedLabActivities;
	}
	
	public HashMap<Integer,LectureActivity> getSortedLectureActivities(){
		return sortedLectureActivities;
	}
	
	public LabActivity getLabActivity(int key) {
		
		return getSortedLabActivities().get(key);
		
	}
	public LectureActivity getLectureActivity(int key) {
		
		return getSortedLectureActivities().get(key);
		
	}
	
	public  void sortActivities() {
		sortedLectureActivities = SortActivities.sortLectureActivitiesWithWeightage(getLectureActivities());
		sortedLabActivities = SortActivities.sortLabActivitiesWithWeightage(getLabActivities());
		
	}
    
    
    
}
