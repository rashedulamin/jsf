package de.hsm.inputFields;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component(value = "inputFieldsdataBean")
@RequestScope
public class DataBean implements Serializable {
    private String text;
    private BigDecimal number;
    private String password;
    private Date date;
    private String radioLine;
    private String radioPage;
    private String selectOneMenu;
    private String[] selectManyCheckbox;
    private String[] selectCheckboxMenu;
    private boolean selectBooleanCheckbox;

    public String getText() {
        return text;
    }

    public List<String> getCountries(){
        List<String> countries = new ArrayList<>(); 
        countries.add("Germany");       
        countries.add("France");       
        countries.add("Austria");       
        countries.add("Netherlands");       
        countries.add("Australia"); 
        return countries;      
    }

    public void setText(String text) {
        this.text = text;
    }

    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRadioLine() {
        return radioLine;
    }

    public void setRadioLine(String radioLine) {
        this.radioLine = radioLine;
    }

    public String getRadioPage() {
        return radioPage;
    }

    public void setRadioPage(String radioPage) {
        this.radioPage = radioPage;
    }

    public String getSelectOneMenu() {
        return selectOneMenu;
    }

    public void setSelectOneMenu(String selectOneMenu) {
        this.selectOneMenu = selectOneMenu;
    }

    public String getSelectManyCheckboxAsString() {
        StringBuilder sb = new StringBuilder();
        for (String s : selectManyCheckbox) {
            sb.append(s).append(", ");
        }
        if (sb.length() == 0){
            return "";
        }
        return sb.toString().substring(0, sb.length() - 2);
    }

    public void setSelectManyCheckbox(String[] selectManyCheckbox) {
        this.selectManyCheckbox = selectManyCheckbox;
    }

    public String[] getSelectManyCheckbox() {
        return selectManyCheckbox;
    }

    public String getSelectCheckboxMenuAsString() {
        StringBuilder sb = new StringBuilder();
        for (String s : selectCheckboxMenu) {
            sb.append(s).append(", ");
        }
        if (sb.length() == 0){
            return "";
        }
        return sb.toString().substring(0, sb.length() - 2);
    }

    public String[] getSelectCheckboxMenu() {
        return selectCheckboxMenu;
    }

    public void setSelectCheckboxMenu(String[] selectCheckboxManu) {
        this.selectCheckboxMenu = selectCheckboxManu;
    }

    public boolean isSelectBooleanCheckbox() {
        return selectBooleanCheckbox;
    }

    public void setSelectBooleanCheckbox(boolean selectBooleanCheckbox) {
        this.selectBooleanCheckbox = selectBooleanCheckbox;
    }

}