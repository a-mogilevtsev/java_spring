package org.example.web.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by a.sosnina on 12/8/2022.
 */
public class FileToUpload {
    MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
