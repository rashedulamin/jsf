package de.hsm.converter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component(value = "converterdataBean")
@RequestScope
public class DataBean implements Serializable {
    private LocalDate date;
    private int number;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDateAsString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        return date.format(formatter);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
 
}
 /*    public void validateABC(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        System.out.println("validator called");
        if (value != null) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Date is in future.", "Birthday is in future.");
                throw new ValidatorException(msg);

        }
    }*/