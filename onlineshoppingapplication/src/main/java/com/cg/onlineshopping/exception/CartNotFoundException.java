package com.cg.onlineshopping.exception;

public class CartNotFoundException extends RuntimeException {

	String msg;
	public CartNotFoundException(String msg)
	{
		this.msg=msg;
	}
    @Override
    public String getMessage()
    {
    	return msg;
    }
}
