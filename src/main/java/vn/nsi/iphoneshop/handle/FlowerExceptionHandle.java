package vn.nsi.iphoneshop.handle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import vn.nsi.iphoneshop.exception.GeneralException;
import vn.nsi.iphoneshop.model.response.Response;


@ControllerAdvice
@Slf4j
public class FlowerExceptionHandle {



    @ExceptionHandler(value = {GeneralException.class})
    protected ResponseEntity<Response> generalException(GeneralException ex, WebRequest re){
        final  Response responseDTO = Response.builder()
                .map(ex.getValue())
                .code(ex.getCode())
                .message(ex.getMessage())
                .build();
        log.error("[FlowerExceptionControlHandler.GeneralException: {}]", ex.getMessage());
        return  new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


}
