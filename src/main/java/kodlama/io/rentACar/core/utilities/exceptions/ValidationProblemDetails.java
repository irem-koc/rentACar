package kodlama.io.rentACar.core.utilities.exceptions;

import java.util.Map;

public class ValidationProblemDetails extends ProblemDetails {
    private Map<String, String> validationErrors;
    public ValidationProblemDetails() {
    }
    public ValidationProblemDetails(Map<String, String> validationErrors) {
        this.validationErrors = validationErrors;
    }

    public ValidationProblemDetails(String message, Map<String, String> validationErrors) {
        super(message);
        this.validationErrors = validationErrors;
    }

    public Map<String, String> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(Map<String, String> validationErrors) {
        this.validationErrors = validationErrors;
    }
}
