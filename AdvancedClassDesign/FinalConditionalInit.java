public class FinalConditionalInit {
  final int finalVar1;
  final int finalVar2;
  final int finalVar3;
  FinalConditionalInit(double a, double b) {
    /*!
    if (a > b)
      finalVar1 = 20;
    else if (b >= a)
      finalVar1 = 30;   // error: variable finalVar1 might not have been initialized
    */
    if (a > b)
      finalVar1 = 20;
    else
      finalVar1 = 30;   // OK

    if (1 > 2)
      finalVar2 = 10;
    else if (100 > 10)
      finalVar2 = 20;   // OK

    finalVar3 = 100;
    /*!
    if (a > b)
      finalVar3 = 20;   // error: variable finalVar1 might already have been assigned
    else if (b >= a)
      finalVar3 = 30;   // error: variable finalVar1 might already have been assigned
    */
  }
  public static void main(String[] args) {

  }
}

//! class final ClassBeforeFinalWontCompile { } // error: <identifier> expected
