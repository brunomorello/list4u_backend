package br.com.l4u.shoppinglist.shared.exceptions;

public class ResourceNotFoundException extends IllegalArgumentException {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String s) {
        super(s);
    }
}
