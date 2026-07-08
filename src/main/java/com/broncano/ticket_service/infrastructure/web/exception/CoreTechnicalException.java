package com.broncano.ticket_service.infrastructure.web.exception;

import com.broncano.ticket_service.infrastructure.web.error.ErrorType;


/**
 * Excepción técnica errores de infraestructura o fallos inesperados.
 *
 * <ul>
 *     <li>Fallos de acceso a Google Drive</li>
 *     <li>Errores al procesar archivos (PDF, Excel)</li>
 *     <li>Problemas de I/O</li>
 * </ul>
 *
 * @author Aldair Broncano
 * @version 1.0.0
 * @since 1.0.0
 */
public class CoreTechnicalException extends CoreException {

    /**
     * Constructor con mensaje y tipo de error técnico.
     *
     * @param message mensaje descriptivo del error
     * @param type tipo de error asociado
     */
    public CoreTechnicalException(String message, ErrorType type)
    {
        super(message, type);
    }

    /**
     * Constructor con causa raíz
     *
     * @param message mensaje descriptivo del error
     * @param type tipo de error asociado
     * @param cause excepción original
     */

     public CoreTechnicalException(String message, ErrorType type, Throwable cause) {super(message, type, cause);}

}
