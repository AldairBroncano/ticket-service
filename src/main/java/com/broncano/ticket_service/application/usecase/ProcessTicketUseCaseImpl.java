package com.broncano.ticket_service.application.usecase;

import com.broncano.ticket_service.application.service.FolderTicketProcessor;
import com.broncano.ticket_service.domain.model.TicketInvoice;
import com.broncano.ticket_service.domain.port.in.ProcessTicketUseCase;
import com.broncano.ticket_service.domain.port.out.TicketFileWriterPort;
import com.broncano.ticket_service.domain.port.out.TicketFolderReaderPort;
import com.broncano.ticket_service.infrastructure.web.error.ErrorType;
import com.broncano.ticket_service.infrastructure.web.exception.CoreBusinessException;
import com.broncano.ticket_service.infrastructure.web.exception.CoreTechnicalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

/**
 * Implementación del caso de uso {@link ProcessTicketUseCase}.
 *
 * <p>
 *  Orquesta el procesamiento de tickets a partir de un archivo Excel:
 *  lee las carpetas, procesa los tickets asociados y genera
 *  el archivo Excel de salida.
 * </p>
 *
 * @author Aldair Broncano
 * @version 1.0.0
 * @since 1.0.0
 */

@Slf4j
@Service
public class ProcessTicketUseCaseImpl implements ProcessTicketUseCase {

    private final TicketFolderReaderPort ticketFolderReaderPort;
    private final TicketFileWriterPort ticketFileWriterPort;
    private final FolderTicketProcessor folderTicketProcessor;

    /**
     *
     * Constructor con inyección de dependencias.
     */

    public ProcessTicketUseCaseImpl(TicketFolderReaderPort ticketFolderReaderPort, TicketFileWriterPort ticketFileWriterPort, FolderTicketProcessor folderTicketProcessor) {
        this.ticketFolderReaderPort = ticketFolderReaderPort;
        this.ticketFileWriterPort = ticketFileWriterPort;
        this.folderTicketProcessor = folderTicketProcessor;
    }

    /**
     * Ejecuta el procesamiento completo de tickets.
     *
     * @param inputStream archivo Excel de entrada
     * @return archivo Excel generado
     */

    @Override
    public byte[] process(InputStream inputStream) {

        log.info("▶ Inicio del procesamiento de tickets");

        List<String> folders = readFolders(inputStream);

        if (folders.isEmpty()) {
            log.warn("El archivo Excel no contiene carpetas a procesar");
            throw new CoreBusinessException(
                    "No se encontraron carpetas para procesar",
                    ErrorType.NO_FOLDERS_FOUND
            );
        }

        List<TicketInvoice> invoices = folders.stream()
                .flatMap(folder -> folderTicketProcessor.process(folder).stream())
                .toList();

        log.info("Procesamiento finalizado. Total de tickets generados: {}", invoices.size());

        try {
            return ticketFileWriterPort.export(invoices);
        } catch (Exception ex) {
            log.error("Error generando el archivo Excel de salida", ex);
            throw new CoreTechnicalException("Error generando el archivo de salida", ErrorType.FILE_GENERATION_ERROR,
                  ex  );
        }
    }
        /**
         * Lee los nombres de carpetas desde el archivo Excel.
         *
         * @Param inputStream archivo Excel de entrada
         * @return lista de carpetas
         */

        private List<String> readFolders(InputStream inputStream){

            try {

                List<String> folders = ticketFolderReaderPort.readFolderNames(inputStream);
                log.debug("Carpetas leidas desde Excel: {}", folders.size());
                return folders;
            } catch (Exception ex){

                log.error("Error leyendo el archivo Excel de entrada", ex);
                throw new CoreTechnicalException("El archivo Excel de carpetas no es válido", ErrorType.EXCEL_INVALID, ex);
        }








    }







}
