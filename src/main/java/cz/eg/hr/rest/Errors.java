package cz.eg.hr.rest;

import java.util.List;

public record Errors(List<ValidationError> errors) {
}
