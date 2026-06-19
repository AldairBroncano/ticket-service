package com.broncano.ticket_service.domain.service;

import com.broncano.ticket_service.domain.model.TicketInvoice;

import java.io.InputStream;

/**
 * Servicio de dominio encargado de extraer información relevante desde un ticket en formato PDF.
 *
 * @author Aldair Broncano
 * @version 1.0.0
 * @since 1.0.0
 */

public interface TicketInvoiceExtractor {

    /**
     * Extrae la información de un ticket PDF.
     *
     * @param folderName nombre de la carpeta asociada
     * @param pdfName nombre del archivo PDF
     * @param pdfStream contenido del archivo PDF
     * @return información del ticket extraída
     */

    TicketInvoice extract(String folderName, String pdfName, InputStream pdfStream);

}
