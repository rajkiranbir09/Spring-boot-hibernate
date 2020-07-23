package com.project.hibernate.utils.binders;


import java.beans.PropertyEditorSupport;
import java.util.Date;

public class DateWithTimePropertyEditor extends PropertyEditorSupport {


    public DateWithTimePropertyEditor() {

    }

    @Override
    public void setAsText(String dateAsString) throws IllegalArgumentException {
        Date date = new Date(Long.valueOf(dateAsString));
        setValue(date);
    }

}