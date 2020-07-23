package com.project.hibernate.file;



import com.project.hibernate.entity.File;
import com.project.hibernate.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;


@Component
public class FileService {

    private final FileRepository fileRepository;

    @Autowired
    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }


    @Async
    @Scheduled(cron = "0 0 4 * * ?")
    public void deleteOldFile() {

        List<File> dataSet = fileRepository.findAll();

        for (int i = 0; i <dataSet.size() ; i++) {
            Date date = new Date(System.currentTimeMillis() - 518400000l);

            if (date.after(dataSet.get(i).getDate())){
                fileRepository.delete(dataSet.get(i).getId());
            }
        }

    }
}