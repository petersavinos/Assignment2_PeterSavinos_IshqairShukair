package oop350.action;

public interface Action {
    String description();// explains the action to the user
    void execute();  // performs the actual logic (like move, pick, fight)
}
