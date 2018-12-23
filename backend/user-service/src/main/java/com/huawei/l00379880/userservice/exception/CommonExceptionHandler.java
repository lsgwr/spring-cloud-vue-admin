package com.huawei.l00379880.userservice.exception;

import com.huawei.l00379880.common.dto.RespDTO;
import com.huawei.l00379880.common.exception.CommonException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
@ResponseBody
public class CommonExceptionHandler {

    @ExceptionHandler(CommonException.class)
    public ResponseEntity<RespDTO> handleException(Exception e) {
        RespDTO resp = new RespDTO();
        CommonException taiChiException = (CommonException) e;
        resp.code = taiChiException.getCode();
        resp.error = e.getMessage();

        return new ResponseEntity(resp, HttpStatus.OK);
    }

}
