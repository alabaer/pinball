package AbstractFactory;

public interface AbstractFactory<T> {
    T createMessage(String message);
}
