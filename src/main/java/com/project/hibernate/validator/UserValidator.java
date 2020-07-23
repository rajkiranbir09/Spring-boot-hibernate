package com.project.hibernate.validator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.project.hibernate.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;



//@Component
public class UserValidator {
//    public class UserValidator implements Validator {

//    @Override
//    public boolean supports(Class<?> clazz) {
//        return User.class.equals(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        UserForm userForm = (UserForm) target;
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.firstname.registration");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.lastname.registration");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.username.registration");
//        passwordValidator(userForm, errors);
//        mailValidator(userForm, errors);
//    }
//
//    private void passwordValidator(UserForm userForm, Errors err) {
//        String password = userForm.getPassword();
//        if (StringUtils.isEmpty(password)) {
//            err.rejectValue("password", "error.password.empty.registration");
//        }else if ( !(password.length() > 8 && password.length() < 20) ) {
//            err.rejectValue("password", "error.password.length.registration");
//        }
//    }
//
//    private void mailValidator(UserForm userForm, Errors errors) {
//        String email = userForm.getEmail();
//        if ( StringUtils.isEmpty(email) ) {
//            errors.rejectValue("email", "error.email.empty.registration");
//        }else {
//            Pattern mailPatter = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
//            Matcher matcher = mailPatter.matcher(email);
//            if (!matcher.find()) {
//                errors.rejectValue("email", "error.email.notvalid");
//            }
//        }
//    }
//@Override
//public boolean supports(Class<?> aClass) {
//    return aClass.isAssignableFrom(Sequence.class);
//}
//
//    @Override
//    public void validate(Object object, Errors errors) {
//        Sequence sequence = (Sequence) object;
//
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "sequence.author.empty", "Field \"Author\" cannot be empty!");
//
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "purpose", "sequence.purpose.empty", "Field \"Purpose\" cannot be empty!");
//    }
}