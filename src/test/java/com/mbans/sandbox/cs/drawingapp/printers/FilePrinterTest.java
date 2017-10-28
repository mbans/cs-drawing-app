package com.mbans.sandbox.cs.drawingapp;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


/**
 * Created by lumarmacy on 28/10/2017.
 */
public class FilePrinterTest {

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    @Test
    public void shouldCreateAndPrintToFile() throws Exception {
        //Given
        String path = testFolder.getRoot().getAbsolutePath() + File.separator + "canvas.txt";
        System.out.println(path);

        FilePrinter fp = new FilePrinter(path);

        //When
        fp.print(new StringBuilder("Some content"));

        //Then
        File canvasFile = new File(path);
        assertTrue(canvasFile.exists());
        assertContent(canvasFile, "Some content");


    }

    private void assertContent(File file, String expectedContent) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String content = reader.lines().collect(Collectors.joining());
        System.out.println("Retrieved content = " + content);
        reader.close();
        assertThat(content, is(expectedContent));
    }


}
