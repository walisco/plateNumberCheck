package com.adegboye.e2e;

import com.adegboye.e2e.models.FileDetails;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DirectoryReaderTest {

    private Reader directoryReader = new DirectoryReader();

    @Test
    public void testNoPathReturnsEmptyList() {
        List<FileDetails> fileDetailsList = directoryReader.getFileDetailsForPath(null);
        assertEquals(0, fileDetailsList.size());
    }

    @Test
    public void testInvalidPathReturnsEmptyList() {
        List<FileDetails> fileDetailsList = directoryReader.getFileDetailsForPath("bla");
        assertEquals(0, fileDetailsList.size());
    }

    @Test
    public void testFileInsteadOfDirectoryReturnsEmptyList() {
        List<FileDetails> fileDetailsList = directoryReader.getFileDetailsForPath("files/bla.json");
        assertEquals(0, fileDetailsList.size());
    }

    @Test
    public void testPathReturnsFileDetails() {
        List<FileDetails> fileDetailsList = directoryReader.getFileDetailsForPath("files");
        assertEquals(2, fileDetailsList.size());
    }

    @Test
    public void testPathReturnsFilteredFileDetails() {
        List<FileDetails> fileDetailsList = directoryReader.getFileDetailsForPathAndFilter("files", "application/octet-stream");
        assertEquals(1, fileDetailsList.size());
        FileDetails details = fileDetailsList.get(0);
        assertEquals("application/octet-stream",details.getFileMimeType() );
        assertEquals("json", details.getFileExtension());
        assertEquals("bla.json", details.getFileName());
        assertEquals(15, details.getFileSize());
    }

    @Test
    public void testPathReturnsNothingWhenFilteredWithInvalidType() {
        List<FileDetails> fileDetailsList = directoryReader.getFileDetailsForPathAndFilter("boo");
        assertEquals(0, fileDetailsList.size());
    }

    @Test
    public void testPathReturnsNothingWhenFilteredWithNothing() {
        List<FileDetails> fileDetailsList = directoryReader.getFileDetailsForPathAndFilter("files");
        assertEquals(0, fileDetailsList.size());
    }
}
