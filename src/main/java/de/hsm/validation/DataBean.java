package de.hsm.validation;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component(value = "validationdataBean")
@RequestScope
public class DataBean implements Serializable {
    private String text;
    private int number;
    private LocalDate date;
    private String ccType;
    private String ccNumber;

    public LocalDate getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCcType() {
        return ccType;
    }

    public void setCcType(String ccType) {
        this.ccType = ccType;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDateAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        return date.format(formatter);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void validateDate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        LocalDate date = (LocalDate) value;

        // Check if date is after now
        if (date.isAfter(LocalDate.now())) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Date is in future", null);
            throw new ValidatorException(msg);
        }

        // Check if date is before 1.1.2018
        LocalDate date1 = LocalDate.of(2018, 1, 1);
        if (date.isBefore(date1)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Date is before Jan 1st 2018", null);
            throw new ValidatorException(msg);
        }
    }

    private SelectOneMenu creditCardTypeInput = null;

    public SelectOneMenu getCreditCardTypeInput() {
        return creditCardTypeInput;
    }

    public void setCreditCardTypeInput(SelectOneMenu creditCardTypeInput) {
        this.creditCardTypeInput = creditCardTypeInput;
    }

    public void validateCreditCard(FacesContext context, UIComponent component, Object value)
            throws ValidatorException {
        String ccType = (String) creditCardTypeInput.getValue();
        // Check credit card number
        String ccNumber = (String) value;
        String regex = "[0-9]*";
        if (!ccNumber.matches(regex)){
            String errorText = "Credit card number may have digits only";
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    errorText, null);
            throw new ValidatorException(msg);
        }
        int length;
        if (ccType.equals("Type A")) {
            length = 4;
        } else {
            length = 5;
        }
        if (!(ccNumber.length() == length)) {
            String errorText = "Credit card number must have " + length + " digits";
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    errorText, null);
            throw new ValidatorException(msg);
        }
    }

}
