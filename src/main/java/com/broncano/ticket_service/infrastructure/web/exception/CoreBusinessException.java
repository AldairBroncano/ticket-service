package com.broncano.ticket_service.infrastructure.web.exception;

import com.broncano.ticket_service.infrastructure.web.error.ErrorType;

/**
 * Excepción de negocio uilizada para representar errores derivados de reglas, validaciones o estados inválidos
 * del dominio expuestos por la API.
 *
 *
 * @author Aldair Broncano
 * @version 1.0.0
 * @since 1.0.0
 */

public class CoreBusinessException extends CoreException {

  /**
   * Crea una excepción de negocio con un mesaje y tipo de error.
   *
   * @param message mensaje descriptivo del error
   * @param type tipo de error asociado
   */

    public CoreBusinessException(String message, ErrorType type) {
        super(message, type);
    }

  /**
   * Crea una excepción de negocio con causa raiz.
   *
   * @param message mensaje descriptivo del error
   * @param type tipo de error asociado
   * @param cause excepción original
   */
   public CoreBusinessException(String message, ErrorType type, Throwable cause) {super(message,type, cause);}

}
