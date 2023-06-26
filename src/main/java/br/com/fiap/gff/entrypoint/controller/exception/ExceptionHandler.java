package br.com.fiap.gff.entrypoint.controller.exception;

import br.com.fiap.gff.domain.exception.RecursoJaExisteException;
import br.com.fiap.gff.domain.exception.RecursoNaoEncontradoException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ControllerAdvice
@EnableWebMvc
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<MensagemErro> notFoundError(RecursoNaoEncontradoException e, HttpServletRequest request) {
        MensagemErro error = new MensagemErro(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(RecursoJaExisteException.class)
    public ResponseEntity<MensagemErro> recursoJaExisteError(RecursoJaExisteException e, HttpServletRequest request) {
        MensagemErro error = new MensagemErro(HttpStatus.UNPROCESSABLE_ENTITY.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(error);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MensagemErro> validacao(MethodArgumentNotValidException e, HttpServletRequest request, HttpServletResponse response) {
        MensagemErro error = new MensagemErro(HttpStatus.BAD_REQUEST.value(), e.getFieldError().getDefaultMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
