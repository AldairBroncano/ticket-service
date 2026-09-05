package com.broncano.ticket_service.infrastructure.policy.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.util.Set;

/**
 * Configuración de la política de validación de tickets.
 *
 * @author Aldair Broncano
 * @version 1.0.0
 * @since 1.0.0
 */

@Validated
@ConfigurationProperties(prefix = "ticket.invoice.policy")
public record TicketInvoicePolicyProperties(
        /**
         * Conjunto de palabras clave obligatoria para validar un ticket.
         */
        Set<String> keywords
){}
