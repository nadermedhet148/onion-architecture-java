package demoTest.infrastructure.SpringApp.RestServices.Handlers;

import demoTest.DomianServices.exceptions.student.ExceptionBase;
import demoTest.DomianServices.exceptions.student.StudentNotExistsException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.stream.Stream;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ExceptionBase.class})
    protected ResponseEntity<Object> handleError(ExceptionBase ex, WebRequest request) {
        ResponseBody bodyOfResponse;
        try {
            bodyOfResponse = new ResponseBody(ErrorMaping.getByClass(ex.getClass()).getCode(), ex.getMessage());
        } catch (UnhandledBaseException e) {
            bodyOfResponse = new ResponseBody("300", ex.getMessage());
        }
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @Getter
    @AllArgsConstructor
    private class ResponseBody {

        private String code;
        private String msg;
    }

    @Getter
    private static enum ErrorMaping {
        STUDENT_DONT_EXISTS(StudentNotExistsException.class, "400");


        private final Class clazz;
        private final String code;

        private ErrorMaping(Class clazz, String code) {
            this.clazz = clazz;
            this.code = code;
        }

        public static ErrorMaping getByClass(Class clazz) throws UnhandledBaseException {
            return Stream.of(ErrorMaping.values()).filter((errorMaping) -> errorMaping.getClazz().equals(clazz)).findFirst().orElseThrow(() -> new UnhandledBaseException());
        }
    }

    private static class UnhandledBaseException extends Exception {
    }
}
