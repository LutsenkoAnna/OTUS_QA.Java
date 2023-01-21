package data;

public enum CategoryData {
  PROGRAMMER("Программирование"),
  OPERATIONS("Инфраструктура"),
  BUSINESS("Управление");

  private String name;

  CategoryData(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
