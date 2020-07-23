package com.project.hibernate.formatters;


import java.text.ParseException;
import java.util.Locale;
import java.util.UUID;

import org.springframework.format.Formatter;

public class UUIDFormater implements Formatter<UUID> {

    @Override
    public String print(UUID object, Locale locale) {
        return object.toString();
    }

    @Override
    public UUID parse(String text, Locale locale) throws ParseException {
        return UUID.fromString(text);
    }
}