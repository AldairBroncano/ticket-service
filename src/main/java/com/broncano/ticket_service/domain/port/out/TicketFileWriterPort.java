package com.broncano.ticket_service.domain.port.out;

import com.broncano.ticket_service.domain.model.TicketInvoice;

import java.util.List;

/**
 * Puerto de salida para la generación de archivos a partir de
 * tickets procesados
 *
 * @author Aldair Broncano
 * @version 1.0.0
 * @since 1.0.0
 */

public interface TicketFileWriterPort {

    /**
     * Genera un archivo a partir de una lista de tickets.
     *
     * @param invoices lista de tickets procesados
     * @return archivo generado en formato byte[]
     */
    byte[] export(List<TicketInvoice> invoices);

}
