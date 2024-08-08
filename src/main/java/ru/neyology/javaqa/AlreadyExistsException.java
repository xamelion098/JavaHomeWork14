package ru.neyology.javaqa;
public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String q) {
        super(q);
    }
}
