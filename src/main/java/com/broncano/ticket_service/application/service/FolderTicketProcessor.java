package com.broncano.ticket_service.application.service;

import com.broncano.ticket_service.domain.model.TicketInvoice;
import java.util.List;

/**
 * Servicio de aplicación encargada de procesar una carpeta de tickets
 * y retornar los tickets válidos extraidos.
 *
 * @author Aldair Broncano
 * @version 1.0.0
 * @since 1.0.0
 */

public interface FolderTicketProcessor {

    /**
     * Procesa una carpeta identificada por su nombre.
     *
     * @param folderName nombre de la carpeta a procesar
     * @return lista de tickets extraídos
     */

    List<TicketInvoice> process(String folderName);

}
