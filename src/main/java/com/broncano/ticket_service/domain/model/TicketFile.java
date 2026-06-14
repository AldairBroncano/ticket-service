package com.broncano.ticket_service.domain.model;

/**
 * Representa un archivo de ticket almacenado en Google Drive.
 *
 * <p>
 *  Contiene únicamente la información necesaria para identificar
 *  y procesar el archivo dentro del dominio.
 * </p>
 *
 * @param id  identificador del archivo en Google Drive
 * @param name nombre del archivo
 *
 * @author Aldair Broncano
 * @version 1.0.0
 * @since 1.0.0
 */
public record TicketFile(
        String id,
        String name) {
}
