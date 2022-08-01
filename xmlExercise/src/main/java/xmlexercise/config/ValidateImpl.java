package xmlexercise.config;

import org.springframework.stereotype.Component;

import javax.validation.Validation;
import javax.validation.Validator;

@Component
public class ValidateImpl implements Validate {

    private final Validator validator;

    public ValidateImpl() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();

    }

    @Override
    public <T> boolean isValid(T entity) {
        return validator.validate(entity).isEmpty();
    }
}
