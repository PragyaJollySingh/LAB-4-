import java.util.Date;
import java.util.EventObject;

@SuppressWarnings("serial")
public class CourseEvent extends EventObject {
	public Date midtermDate;
	
	public CourseEvent(Date date, Object source) {
		super(source);
		this.midtermDate = date;
	}
	
}
