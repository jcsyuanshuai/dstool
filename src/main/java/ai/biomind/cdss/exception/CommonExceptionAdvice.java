package ai.biomind.cdss.exception;

import com.google.common.collect.Maps;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@ControllerAdvice
@RestController
public class CommonExceptionAdvice {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Object errorHandler(HttpServletRequest request, Exception e) {
        HashMap<Object, Object> result = Maps.newHashMap();
        result.put("status", 100);
        result.put("error", e.getMessage());
        return result;
    }
}
