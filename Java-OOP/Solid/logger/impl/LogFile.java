package Solid.logger.impl;

import Solid.logger.interfaces.File;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class LogFile implements File {

    // създаваме си такъв fileName за да може информацията за файла да се запише някъде във file по default
    private static final String DEFAULT_FILE_NAME = "default.txt";
    // когато искаме да append-нем към някой файл, то ще трябва да append-нем към този Stringbuilder
   private StringBuilder text;
   private int size;
   private String fileName;


   public LogFile() {
       this(DEFAULT_FILE_NAME);
   }

   // 2 ри конструктор
    public LogFile(String fileName) {
       this.text = new StringBuilder();
       this.size = 0;
       this.fileName = DEFAULT_FILE_NAME;
    }

    @Override
    public int getSize() {
      // събираме ASCII стойностите на буквите
       return calculateSize();
    }

    private int calculateSize() {
        int size = 0;

        for(char c : this.text.toString().toCharArray()) {
            if (Character.isAlphabetic(c)) {
                size += c;
            }
        }
        return size;
    }

    @Override
    public boolean write(String text) {
        try {
            Files.write(Paths.get(this.fileName), text.getBytes(), StandardOpenOption.APPEND);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void append(String text) {
       text = addLineBreakInFile(text);
        this.text.append(text);
        this.write(text);
    }

    String addLineBreakInFile(String text) {
       StringBuilder sb = new StringBuilder(text);
       sb.append(System.lineSeparator());
       return sb.toString();
    }
}
