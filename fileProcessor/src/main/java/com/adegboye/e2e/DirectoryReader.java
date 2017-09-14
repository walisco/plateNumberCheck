package com.adegboye.e2e;

import com.adegboye.e2e.models.FileDetails;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class DirectoryReader implements Reader {

    public List<FileDetails> getFileDetailsForPath(String path) {
        List<FileDetails> details = new ArrayList<>();
        if(path == null) {
            return details;
        }
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(path);
        if(url != null) {
            File directory = new File(url.getFile());
            if(directory.isDirectory() && directory.listFiles() != null) {
                for(File file : directory.listFiles()) {
                    details.add(createFileDetails(file));
                }
            }
        }
        return details;
    }

    @Override
    public List<FileDetails> getFileDetailsForPathAndFilter(String path, String... mimetypes) {
        List<FileDetails> details = getFileDetailsForPath(path);
        List<FileDetails> detailsToReturn = new ArrayList<>();
        Set<String> types = new HashSet<>();
        if(mimetypes != null) {
            for(String type : mimetypes) {
                types.add(type);
            }
            for(FileDetails detail : details) {
                if(types.contains(detail.getFileMimeType())) {
                    detailsToReturn.add(detail);
                }
            }
        }
        return detailsToReturn;
    }

    private FileDetails createFileDetails(File file) {
        if(file == null || file.isDirectory())
            return null;
        FileDetails details = new FileDetails();
        details.setFileName(file.getName());
        details.setFileSize(file.length());
        details.setFileExtension(getFileExtension(file));
        details.setFileMimeType(new MimetypesFileTypeMap().getContentType(file));
        return details;
    }

    private String getFileExtension(File file) {
        String fileName = file.getName();
        String extension = "";
        if(fileName.lastIndexOf(".") > 0)
            extension = fileName.substring(fileName.lastIndexOf(".")+1);
        return extension;
    }
}
