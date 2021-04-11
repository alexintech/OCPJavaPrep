import java.lang.annotation.*;
import java.lang.reflect.Field;

// @Retention(RetentionPolicy.CLASS)  // default retention policy
@interface Plumber {
  String value() default "Mario";
}

public class Team {
  @Plumber("") private String foreman = "Mario";
  @Plumber private String worker = "Kelly";
  @Plumber("Kelly") private String trainee;

  public static void main(String[] args) {
    var t = new Team();
    var fields = t.getClass().getDeclaredFields();
    for (Field field : fields) {
      if (field.isAnnotationPresent(Plumber.class))
        System.out.print(field.getAnnotation(Plumber.class).value()); // prints nothing
    }

  }
}

