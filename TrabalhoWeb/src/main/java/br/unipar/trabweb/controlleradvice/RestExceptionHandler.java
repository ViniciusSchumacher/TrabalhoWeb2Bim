package br.unipar.trabweb.controlleradvice;

import br.unipar.trabweb.exceptions.MedicoPacienteInativoException;
import br.unipar.trabweb.model.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//Classe criada para tratar as exceções via Swagger
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MedicoPacienteInativoException.class)
    public ResponseEntity<ExceptionDTO> handleInactiveDoctorException(MedicoPacienteInativoException e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(e.getMessage());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }
}
