package ru.javaops.bootjava.electronicsstore.exception;

public class HardDriveNotFoundException extends RuntimeException{

    public HardDriveNotFoundException(String message) {
        super(message);
    }

}
