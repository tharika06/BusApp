package com.wipro.bus.util;

public class InvalidInputException extends Exception{
public InvalidInputException() {
	super();
}

@Override
public String toString() {
	return "INVALID INPUT";
}
}
