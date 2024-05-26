package question;

// The TaskManager class extends the Publisher abstract class and represents a subject in the Observer Pattern.
public class TaskManager extends Publisher {

    public void assignTask(Long taskId, Long userId) {
        notifyObservers(taskId, userId); // Assigns a task and notifies all observers
    }
}

/*
    In this code, the Observer interface defines operations that all concrete observers must implement.
    The AppService, EmailService, and SlackService classes are concrete observers that send push, email, and Slack notifications, respectively, when a task is assigned.
    They implement the Observer interface and provide their own implementations of the notifyObserver method.
    The ObserverRegistry interface defines operations for managing observers.
    The Publisher abstract class implements the ObserverRegistry interface and provides a default implementation for managing observers.
    The TaskManager class extends the Publisher abstract class and represents a subject in the Observer Pattern.
    It maintains a list of observers and notifies them when a task is assigned.

    This is a classic implementation of the Observer Pattern.
    It is a behavioral design pattern that enables an object, called the subject, to maintain a list of its dependents, called observers, and notify them automatically of any state changes.
 */