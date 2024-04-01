package com.campus.spring.youropinion.domain.excepciones;
import java.util.Objects;


public class ErrorResponse {
    private String error;
    private String message;    

    public ErrorResponse() {
    }

    public ErrorResponse(String error, String message) {
        this.error = error;
        this.message = message;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorResponse error(String error) {
        setError(error);
        return this;
    }

    public ErrorResponse message(String message) {
        setMessage(message);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ErrorResponse)) {
            return false;
        }
        ErrorResponse errorResponse = (ErrorResponse) o;
        return Objects.equals(error, errorResponse.error) && Objects.equals(message, errorResponse.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(error, message);
    }

    @Override
    public String toString() {
        return "{" +
            " error='" + getError() + "'" +
            ", message='" + getMessage() + "'" +
            "}";
    }
}
