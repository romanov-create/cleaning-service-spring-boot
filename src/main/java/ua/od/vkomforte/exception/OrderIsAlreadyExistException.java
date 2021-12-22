package ua.od.vkomforte.exception;

public class OrderIsAlreadyExistException extends RuntimeException{
    public OrderIsAlreadyExistException() {
        super("Order is already exist");
    }

}
