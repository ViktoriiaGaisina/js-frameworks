package cz.eg.hr.rest.exception;

public record ValidationError(String field, String message) {
}
