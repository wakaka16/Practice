package design.single;

public class Threads implements Runnable {

  private String name;

  public Threads(String name) {
    this.name = name;
  }

  @Override
  public void run() {

    Demo.getInstance().i += 1;
    System.out.println("线程=" + name + " | 此时的i=" + Demo.getInstance().i);
  }
}
