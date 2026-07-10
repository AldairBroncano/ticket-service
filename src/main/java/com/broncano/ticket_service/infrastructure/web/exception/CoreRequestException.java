package com.broncano.ticket_service.infrastructure.web.exception;

import com.broncano.ticket_service.infrastructure.web.error.ErrorType;

/**
 * Excepción para representar errores de entrada HTTP inválida.
 *
 * @author Aldair Broncano
 * @version 1.0.0
 * @since 1.0.0
 */

public class CoreRequestException extends CoreException {

  /**
   * Crea una excepción de request inválido.
   *
   * @param message mensaje descriptivo del error
   * @param type tipo de error expuesto por la API
   */

  public CoreRequestException(String message, ErrorType type) {
        super(message, type);
    }

  public CoreRequestException(String message, ErrorType type, Throwable cause)
  {super(message, type, cause);}

}
