/** SYSC 2101 - Prof-Student-TA Example
 * 
 *
 */

import java.util.ArrayList;
import java.util.Date;

public class Prof {
	private String name;
	private Date midtermDate;
	private ArrayList<CourseListener> courseListeners = new ArrayList<CourseListener>();

	public Prof(String aName) {
		this.name = aName;
	}

	public Date getMidterm() {
		return this.midtermDate;
	}

	public String getName() {
		return this.name;
	}

	public void setMidterm(Date date) {
		this.midtermDate = date;
		
		for (CourseListener listener: courseListeners) {
			listener.midtermSet(new CourseEvent(date, this));
		}
	}
	
	public void postponeMidterm(Date date){
		this.midtermDate = date;
		
		for (CourseListener listener: courseListeners) {
			listener.midtermPostponed(new CourseEvent(date, this));
		}
	}
	
	public static void main(String[] args) {

		Prof p = new Prof("Babak");
		Student s = new Student("Homer");
		Student s2 = new Student("Bart");
		TeachingAssistant ta = new TeachingAssistant("Michael");
			
		p.courseListeners.add(s);
		p.courseListeners.add(s2);
		p.courseListeners.add(ta);
	
		Date midterm = new Date();
		p.setMidterm(midterm);
	
		p.postponeMidterm(new Date(midterm.getTime() + 1000000000));
	}

}
