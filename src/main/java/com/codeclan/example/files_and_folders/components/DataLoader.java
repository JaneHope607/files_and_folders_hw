package com.codeclan.example.files_and_folders.components;

import com.codeclan.example.files_and_folders.models.File;
import com.codeclan.example.files_and_folders.models.Folder;
import com.codeclan.example.files_and_folders.models.User;
import com.codeclan.example.files_and_folders.repositories.FileRepository;
import com.codeclan.example.files_and_folders.repositories.FolderRepository;
import com.codeclan.example.files_and_folders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {

        User user1 = new User("Toby");
        userRepository.save(user1);

        Folder folder1 = new Folder("Profile", user1);
        folderRepository.save(folder1);
        Folder folder2 = new Folder("Tests", user1);
        folderRepository.save(folder2);

        File file1 = new File("Big File", "pdf", 34, folder1);
        File file2 = new File("Small File", "txt", 44, folder2);
        File file3 = new File("Huge File", "md", 24, folder1);
        fileRepository.save(file1);
        fileRepository.save(file2);
        fileRepository.save(file3);
    }
}
