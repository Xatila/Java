package xmlexercise.config;

public interface Validate {

    <T> boolean isValid(T entity);
}
