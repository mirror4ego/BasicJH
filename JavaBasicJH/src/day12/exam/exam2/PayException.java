package day12.exam.exam2;

public class PayException extends Exception {
    
    public PayException() {
    }

    public PayException(String message){
        super(message);
    }
}