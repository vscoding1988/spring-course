package com.vscoding.tutorial.spring.control;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class LogReader {
  private final String filepath;

  public LogReader(@Value("${logparser.filereader.filepath}") String filepath) {
    this.filepath = filepath;
  }

  @PostConstruct
  public void read() throws IOException {
    var file = new File(filepath);
    FileUtils.readLines(file, StandardCharsets.UTF_8)
            .forEach(System.out::println);
  }
}
