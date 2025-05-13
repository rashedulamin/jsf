package de.hsm.localisation;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component(value = "localisationPersonBean")
@RequestScope
public class PersonBean implements Serializable {
    private String firstName;
    private String lastName;
    private LocalDate date;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDateAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd. MMM yyyy");
        return date.format(formatter);
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String save() {
        return "showPerson.xhtml";
    }

    public void validateDate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        LocalDate date = (LocalDate) value;

        // Check if date is after now
        if (date.isAfter(LocalDate.now())) {
            FacesMessage msg = GuiUtil.getFacesMessage(context, FacesMessage.SEVERITY_ERROR,
                    "validateDate.MAXIMUM");
            throw new ValidatorException(msg);
        }

        // Check if date is before 1.1.2018
        LocalDate date1 = LocalDate.of(2018, 1, 1);
        if (date.isBefore(date1)) {
            FacesMessage msg = GuiUtil.getFacesMessage(context, FacesMessage.SEVERITY_ERROR,
                    "validateDate.MINIMUM");
            throw new ValidatorException(msg);
        }
    }

}
