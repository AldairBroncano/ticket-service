package com.broncano.ticket_service.domain.classifier;

/**
 * Clasificador de información de tickets.
 *
 * <p>
 *     Define el contrato para extraer y clasificar valores relevantes
 *     (facturas y recibos) a partir del contenido textual de un ticket.
 * </p>
 *
 * @author Aldair Broncano
 * @version 1.0.0
 * @since 1.0.0
 */
public interface TicketInvoiceClassifier {

    /**
     * Clasifica el texto de un ticket y extrae los valores relevantes.
     *
     * @param text contenido textual del ticket
     * @return valores clasificados del ticket
     */
    ClassifiedTicketValues classify(String text);

}
