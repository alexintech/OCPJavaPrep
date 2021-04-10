module zoo.staff {
  requires zoo.animal.feeding;
  requires zoo.animal.care;
  requires zoo.animal.talks;

  // requires transitive zoo.animal.talks;  // CE: duplicate requires
}

