package com.project.hibernate.controller;


import com.project.hibernate.entity.Meetup;
import com.project.hibernate.entity.User;
import com.project.hibernate.repository.IUserRepository;
import com.project.hibernate.repository.MeetupRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/v1/api/meetups")
public class MeetupController {

    @Autowired
    private MeetupRepository meetupRepository;

    @Autowired
    private IUserRepository userRepository;

//    @Autowired
//    private UserRepository userRepository;

    @GetMapping
    public List<Meetup> getAll(){
        //get list of all meetups
        List<Meetup> allMeetups = meetupRepository.findAll();

        //remove meetups in the past
//        allMeetups.removeIf((Meetup meetup) -> meetup.getDate().isBefore(LocalDate.now()));
//        //sort meetups chronologically
//        allMeetups.sort(Comparator.comparing(Meetup::getDate).thenComparing(Meetup::getTopic).thenComparing(Meetup::getTime));
        return allMeetups;
    }


    @PostMapping
    public Meetup saveMeetup(@Valid @RequestBody Meetup meetup){
        //check date entered in correct format
        // get today
        LocalDate dateToStore;
        LocalDate localDate = LocalDate.now();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//            dateToStore = LocalDate.parse(date, dateFormatter);
        } catch (DateTimeParseException ex) {

            ex.printStackTrace();
        }
        //check time entered in correct format
        LocalTime timeToStore;
//        String stringTime = hour + ":" + minute;
        try {
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("kk:mm");
//            timeToStore = LocalTime.parse(stringTime, timeFormatter);
        } catch (DateTimeParseException ex) {
            ex.printStackTrace();
        }

        //get currently logged in user to set as organizer
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String username = auth.getName();
        User organizer = userRepository.findByUserId(1);

        meetup.setOrganizer(organizer);
        meetup.setDate(localDate);
//        meetup.setTime(timeToStore);
        meetupRepository.save(meetup);
        return meetup;

    }
    // FILTER MEETUPS BASED ON SOME FIELDS
//    @PostMapping
//    public List<Meetup> getMeetupsFilter(@RequestParam String location, @RequestParam String startDate, @RequestParam String endDate){
//
//    }





    // POST /
    //process meetup creation
//    @PostMapping
//    public Meetup processCreate(@RequestBody @Valid Meetup newMeetup, @RequestParam String date,
//                                    @RequestParam String hour, @RequestParam String minute, Model model) {
//
//        //check date entered in correct format
//        LocalDate dateToStore;
//        try {
//            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//            dateToStore = LocalDate.parse(date, dateFormatter);
//        } catch (DateTimeParseException ex) {
//            ex.printStackTrace();
//        }
//
//        //check time entered in correct format
//        LocalTime timeToStore;
//
//        String stringTime = hour + ":" + minute;
//        try {
//            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("kk:mm");
//            timeToStore = LocalTime.parse(stringTime, timeFormatter);
//        } catch (DateTimeParseException ex) {
//            ex.printStackTrace();
//        }
//        newMeetup.setDate(dateToStore);
//        //get currently logged in user to set as organizer
////        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
////        String username = auth.getName();
////        User organizer = userRepository.findByEmail(username);
//        // find current user
//        // dump for testing the user / later user is get from securityContextHolder
//        User organizer = userRepository.findByUserName("hien");
//
//        newMeetup.setOrganizer(organizer);
//
//        newMeetup.setTime(timeToStore);
//        meetupRepository.save(newMeetup);
//        return newMeetup;
//
//
//    }
//
//
//
//    //displays filtered meetup results
//    @RequestMapping(value = "filter", method = RequestMethod.POST)
//    public String filterMeetupResults(Model model, @RequestParam String location, @RequestParam String startDate, @RequestParam String endDate) {
//
//        //get all meetups
//        List<Meetup> allMeetups = meetupRepository.findAll();
//
//        //remove meetups in the past
//        allMeetups.removeIf((Meetup meetup) -> meetup.getDate().isBefore(LocalDate.now()));
//
//        //create new list to display filtered results
//        ArrayList<Meetup> filteredMeetups = new ArrayList<>();
//        filteredMeetups.addAll(allMeetups);
//
//        //filter meetups by location
//        if (!location.equals("No Preference")) {
//            filteredMeetups.removeIf((Meetup meetup) -> !meetup.getLocation().equals(location));
//        }
//
//        //filter meetups by start date
//        LocalDate startDateToFilter;
//        if (!startDate.equals("")) {
//            try {
//                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//                startDateToFilter = LocalDate.parse(startDate, dateFormatter);
//            } catch (DateTimeParseException ex) {
//                model.addAttribute("title", "Filter Meetups");
//                model.addAttribute("startError", "Date must be in the format MM/DD/YYYY");
//                return "/calendar/filter";
//            }
//        } else {
//            startDateToFilter = LocalDate.MIN;
//        }
//        filteredMeetups.removeIf((Meetup meetup) -> meetup.getDate().isBefore(startDateToFilter));
//
//        //filter meetups by end date
//        LocalDate endDateToFilter;
//        if (!endDate.equals("")) {
//            try {
//                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//                endDateToFilter = LocalDate.parse(endDate, dateFormatter);
//            } catch (DateTimeParseException ex) {
//                model.addAttribute("title", "Filter Meetups");
//                model.addAttribute("endError", "Date must be in the format MM/DD/YYYY");
//                return "/calendar/filter";
//            }
//        } else {
//            endDateToFilter = LocalDate.MAX;
//        }
//        filteredMeetups.removeIf((Meetup meetup) -> meetup.getDate().isAfter(endDateToFilter));
//
//        //display filtered meetups in chronological order
//        filteredMeetups.sort(Comparator.comparing(Meetup::getDate).thenComparing(Meetup::getAmpm).thenComparing(Meetup::getTime));
//
//        model.addAttribute("title", "Filter Results");
//        model.addAttribute("meetups", filteredMeetups);
//        return "/calendar/meetups";
//    }
//
//    //allows a user to sign up for a meetup
//    @RequestMapping(value = "addme/{meetupId}", method = RequestMethod.GET)
//    public String addAttendee(Model model, @PathVariable Long meetupId) {
//
//        //get currently logged in user to set as attendee
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String username = auth.getName();
//        User attendee = userRepository.findByEmail(username);
//
//        //find meetup user wants to sign up for
//        Meetup meetup = meetupRepository.findOne(meetupId);
//
//        //find organizer for that meetup
//        User organizer = meetup.getOrganizer();
//
//        //find list of current attendees for that meetup
//        List<User> currentAttendees = meetup.getAttendees();
//
//        //if user is the organizer or already attending, reload page
//        if (attendee.equals(organizer) || currentAttendees.contains(attendee)) {
//            return "redirect:/calendar";
//        }
//
//        //else add user to meetup
//        currentAttendees.add(attendee);
//        meetup.setAttendees(currentAttendees);
//        meetupRepository.save(meetup);
//        return "redirect:/calendar";
//    }
//
//    // DISPLAY LIST OF USER MEETUP
//    @RequestMapping(value = "mymeetups", method = RequestMethod.GET)
//    public String displayUsersMeetups(Model model) {
//
//        //get currently logged in user
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String username = auth.getName();
//        User currentUser = userRepository.findByEmail(username);
//
//        //get list of all meetups organized by user, remove meetups that already occurred, then sort by date and time
//        List<Meetup> organized = currentUser.getMeetupsOrganized();
//        organized.removeIf((Meetup meetup) -> meetup.getDate().isBefore(LocalDate.now()));
//        organized.sort(Comparator.comparing(Meetup::getDate).thenComparing(Meetup::getAmpm).thenComparing(Meetup::getTime));
//
//        //get list of all meetups attended by user, remove meetups that already occurred, then sort by date and time
//        List<Meetup> attending = currentUser.getMeetupsAttending();
//        attending.removeIf((Meetup meetup) -> meetup.getDate().isBefore(LocalDate.now()));
//        attending.sort(Comparator.comparing(Meetup::getDate).thenComparing(Meetup::getAmpm).thenComparing(Meetup::getTime));
//
//        model.addAttribute("title", "My Meetups");
//        model.addAttribute("meetupsOrganized", organized);
//        model.addAttribute("meetupsAttending", attending);
//        return "/calendar/mymeetups";
//    }
//
//    //allow a user to remove themselves from attending a meetup
//    @RequestMapping(value = "mymeetups/removeme/{meetupId}", method = RequestMethod.GET)
//    public String removeAttendee(Model model, @PathVariable Long meetupId) {
//
//        //get currently logged in user to set as attendee
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String username = auth.getName();
//        User attendee = userRepository.findByEmail(username);
//
//        //find meetup user wants to be removed from
//        Meetup meetup = meetupRepository.findOne(meetupId);
//
//        //find list of current attendees for that meetup
//        List<User> currentAttendees = meetup.getAttendees();
//
//        //remove user from meetup
//        currentAttendees.remove(attendee);
//        meetup.setAttendees(currentAttendees);
//        meetupRepository.save(meetup);
//        return "redirect:/calendar/mymeetups";
//
//    }
//
//    //displays form for a user to edit a meetup they organized
//    @RequestMapping(value = "mymeetups/edit/{meetupId}", method = RequestMethod.GET)
//    public String displayEditMeetupForm(Model model, @PathVariable Long meetupId) {
//
//        //get currently logged in user
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String username = auth.getName();
//        User currentUser = userRepository.findByEmail(username);
//
//        //find meetup user wants to edit
//        Meetup meetup = meetupRepository.findOne(meetupId);
//
//        //find organizer for that meetup
//        User organizer = meetup.getOrganizer();
//
//        //if user is not the organizer, reload page
//        if (!currentUser.equals(organizer)) {
//            return "redirect:/calendar/mymeetups";
//        }
//        model.addAttribute("title", "Edit Meetup");
//        model.addAttribute("meetup", meetup);
//        return "/calendar/edit";
//    }
//
//    //processes form to edit a user's meetup
//    @RequestMapping(value = "mymeetups/edit/{meetupId}", method = RequestMethod.POST)
//    public String processEditMeetupForm(@ModelAttribute @Valid Meetup validatedMeetup, Errors errors, @RequestParam String date,
//                                        @RequestParam String hour, @RequestParam String minute, @PathVariable Long meetupId, Model model) {
//
//        //find meetup user wants to edit
//        Meetup meetup = meetupRepository.findOne(meetupId);
//
//        //check date entered in correct format
//        LocalDate dateToStore;
//        try {
//            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//            dateToStore = LocalDate.parse(date, dateFormatter);
//        } catch (DateTimeParseException ex) {
//            model.addAttribute("title", "Edit Meetup");
//            model.addAttribute("dateError", "Date must be in the format MM/DD/YYYY");
//            model.addAttribute("meetup", meetup);
//            return "/calendar/edit";
//        }
//
//        //check that date has not already passed
//        if (dateToStore.isBefore(LocalDate.now())) {
//            model.addAttribute("title", "Edit Meetup");
//            model.addAttribute("dateError", "New meetups must have a future date");
//            model.addAttribute("meetup", meetup);
//            return "/calendar/edit";
//        }
//
//        //check time entered in correct format
//        LocalTime timeToStore;
//        String stringTime = hour + ":" + minute;
//        try {
//            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("kk:mm");
//            timeToStore = LocalTime.parse(stringTime, timeFormatter);
//        } catch (DateTimeParseException ex) {
//            model.addAttribute("title", "Edit Meetup");
//            model.addAttribute("timeError", "Time must be in the format HH:MM");
//            model.addAttribute("meetup", meetup);
//            return "/calendar/edit";
//        }
//
//        meetup.setLocation(validatedMeetup.getLocation());
//        meetup.setDate(dateToStore);
//        meetup.setTime(timeToStore);
//        meetup.setAmpm(validatedMeetup.getAmpm());
//        meetup.setDescription(validatedMeetup.getDescription());
//
//        meetupRepository.save(meetup);
//
//        return "redirect:/calendar/mymeetups";
//    }
//
//    //processes delete meetup request
//    @RequestMapping(value = "mymeetups/delete/{meetupId}", method = RequestMethod.GET)
//    public String deleteMeetup(Model model, @PathVariable Long meetupId) {
//
//        //get currently logged in user
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String username = auth.getName();
//        User currentUser = userRepository.findByEmail(username);
//
//        //find meetup user wants to delete
//        Meetup meetup = meetupRepository.findOne(meetupId);
//
//        //find organizer for that meetup
//        User organizer = meetup.getOrganizer();
//
//        //if user is not the organizer, reload page
//        if (!currentUser.equals(organizer)) {
//            return "redirect:/calendar/mymeetups";
//        }
//
//        meetupRepository.delete(meetupId);
//        return "redirect:/calendar/mymeetups";
//    }
//

}
