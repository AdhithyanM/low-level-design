package cache;

public interface Cache {
    void add(String key, String value);
    String remove(String key);
    String get(String key);
    void display(); // To display cache contents for debugging
}
