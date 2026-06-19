package com.broncano.ticket_service.domain.service;

/**
 * Política de dominío para validar archivos de tickets según reglas de negocio.
 *
 * @author Aldair Broncano
 * @version 1.0.0
 * @since 1.0.0
 */
public interface TicketInvoicePolicy {
    /**
     * valida si un archivo cumple con las reglas
     * para ser procesado como ticket.
     *
     * @param fileName nombre del archivo
     * @return true si el archivo es válido
     */

    boolean isValid(String fileName);
}
