	package application;

import java.time.LocalDate;
import java.time.Period;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;

public class Person {
	private SimpleStringProperty firstName, lastName;
	private LocalDate birthday;
	private Image photo;
	
	public Person(String firstName, String lastName, LocalDate birthday) {
		this.firstName = new SimpleStringProperty(firstName);;
		this.lastName = new SimpleStringProperty(lastName);;
		this.birthday = birthday;
		this.photo = new Image("file:///C:/Users/Stanley/eclipse-workspace/JavaFX_GUI_PROJECT_JARET_WRIGHT/src/application/defaultImage.png");
	}
	
	public Person(String firstName, String lastName, LocalDate birthday, Image photo) {
		this.firstName = new SimpleStringProperty(firstName);;
		this.lastName = new SimpleStringProperty(lastName);;
		this.birthday = birthday;
		this.photo = photo;
	}

	public final String  getFirstName() {
		return firstName.get();
	}
    public void setFirstName(String firstName) {
        this.firstName = new SimpleStringProperty(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }
    public void setLastName(String lastName) {
        this.lastName = new SimpleStringProperty(lastName);
    }

	public final LocalDate getBirthday() {
		return birthday;
	}
	public final void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public int getAge() {
        return Period.between(birthday, LocalDate.now()).getYears();
	}
	
    public Image getImage() {
        return photo;
    }
    public void setImage(Image newPicture) {
        this.photo = newPicture;
    }
}