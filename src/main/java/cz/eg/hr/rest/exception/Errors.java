package cz.eg.hr.rest.exception;

import java.util.List;

public record Errors(List<ValidationError> errors) {
}
