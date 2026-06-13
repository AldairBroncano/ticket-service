package com.broncano.ticket_service.domain.model;

public record TicketInvoice(
        String sourceFileName,
        String processedFileName,
        String facturaContent,
        String comprobanteContent) {
}
