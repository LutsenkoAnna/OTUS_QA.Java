package data;

public enum MenuName {
  CHAT(0),
  EXERCISE(1),
  GRAMMAR(2),
  STATS(3);

  private int id;

  MenuName(int id) {
    this.id = id;
  }

  public int getID() {
    return id;
  }
}
