package com.project.hibernate.scheduling;

import com.project.hibernate.entity.Post;
import com.project.hibernate.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


// add one schedule task
@Component
public class ScheduledTask {
    @Autowired
    private PostRepository postRepository;

    private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    // This runs every 5 seconds.
//    @Scheduled(fixedRate = 5000)
//    public void reportCurrentTime() {
//        log.info("The time is now {}", dateFormat.format(new Date()));
//    }

    // this runs everyday at 5:18 pm
    @Scheduled(cron = "0 18 15 * * *")
    public void checkPostsCreated() {

        List<Post> posts = postRepository.postsInReverse();
        // Bring a list of all the posts created today.
        log.info("The time executed", dateFormat.format(new Date())+"and the list of posts created"+ posts);

    }


}