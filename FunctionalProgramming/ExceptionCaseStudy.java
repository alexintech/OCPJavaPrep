import java.io.*;
import java.util.*;
import java.util.function.*;

public class ExceptionCaseStudy {
  private static List<String> create() throws IOException {
    throw new IOException();
  }

  private static List<String> createSafe() {
    try {
      return ExceptionCaseStudy.create();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
  public static void main(String[] args) {
    try {
      ExceptionCaseStudy.create()
        .stream()
        .count();
    } catch (IOException e) {
      System.out.println("IOException caught");
    }

    // CE: incompatible thrown types
    //! Supplier<List<String>> s = ExceptionCaseStudy::create;

    Supplier<List<String>> s = () -> {
      try {
        return ExceptionCaseStudy.create();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    };

    Supplier<List<String>> s2 = ExceptionCaseStudy::createSafe;
  }
}

