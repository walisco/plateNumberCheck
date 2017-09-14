package com.adegboye.e2e;

import com.adegboye.e2e.models.FileDetails;

import java.util.List;

public interface Reader {

    List<FileDetails> getFileDetailsForPath(String path);

    List<FileDetails> getFileDetailsForPathAndFilter(String path, String ... mimetypes);
}
