package factory;

interface App { }
class WordProcessor implements App { }
class TextEditor implements App { }

interface Font { }
class RichFont implements Font { }
class RegularFont implements Font { }

abstract class AppFactory {
  protected abstract App getApp();
  protected abstract Font getFont();

  public App getAppInstance() {
    App appIn = getApp();
    return appIn;
  }
  public Font getFontInstance() {
    Font font = getFont();
    return font;
  }
}

class WordAppFactory extends AppFactory {
  protected App getApp() {
    return new WordProcessor();
  }
  protected Font getFont() {
    return new RichFont();
  }
}

class TextEditAppFactory extends AppFactory {
  protected App getApp() {
    return new TextEditor();
  }
  protected Font getFont() {
    return new RegularFont();
  }
}

public class ClientAbstractFactoryMethod {
  public static void main(String[] args) {
    AppFactory factory1 = new WordAppFactory();
    App app1 = factory1.getAppInstance();
    Font font1 = factory1.getFontInstance();
    System.out.println(app1 + ":" + font1);
    // factory.WordProcessor@7852e922:factory.RichFont@4e25154f

    AppFactory factory2 = new TextEditAppFactory();
    App app2 = factory2.getAppInstance();
    Font font2 = factory2.getFontInstance();
    System.out.println(app2 + ":" + font2);
    // factory.TextEditor@70dea4e:factory.RegularFont@5c647e05
  }
}

