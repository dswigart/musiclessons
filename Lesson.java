import java.io.Serializable;
import java.time.LocalDateTime;

class Lesson implements Serializable {
 
	private static final long serialVersionUID = 3568962380712994013L;
	Teacher mTeacher;
    Student mStudent;
    
    Long mDuration;
    LocalDateTime mStart;
    LocalDateTime mFinish;
    
    
    Lesson(Teacher teacher, Student student, LocalDateTime start, Long duration) {
    	mTeacher = teacher;
    	mStudent = student;
    	mStart = start;
    	mDuration = duration;
    	mFinish = mStart.plusMinutes(mDuration);
    }
    LocalDateTime getStart() {
    	return mStart;
    }
    
    void advanceOneWeek() {
    	mStart = mStart.plusWeeks(1);
    	mFinish = mFinish.plusWeeks(1);
    }
}

