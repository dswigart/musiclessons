import java.io.Serializable;
import java.time.LocalTime;

class TimeObject implements Serializable {
    
	private static final long serialVersionUID = 2742599134963651642L;
	
	LocalTime mStart;
    LocalTime mFinish;
    
    TimeObject(LocalTime start, LocalTime finish) {
        
        mStart = start;
        mFinish = finish;
        
    }
}