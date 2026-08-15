package com.broncano.ticket_service.infrastructure.extractor;

import com.broncano.ticket_service.domain.classifier.ClassifiedTicketValues;
import com.broncano.ticket_service.domain.classifier.TicketInvoiceClassifier;
import com.broncano.ticket_service.domain.model.TicketInvoice;
import com.broncano.ticket_service.domain.service.TicketInvoiceExtractor;
import com.broncano.ticket_service.infrastructure.web.error.ErrorType;
import com.broncano.ticket_service.infrastructure.web.exception.CoreTechnicalException;
import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
 * Extractor de información de tickets a partir de archivos PDF.
 *
 * <p>Implementa {@link TicketInvoiceExtractor} utilizando Apache PDFBox
 * para extraer el texto del documento y delegar la clasificación
 * del contenido al {@link TicketInvoiceExtractor }
 * </p>
 *
 * @author Aldair Broncano
 * @version 1.0.0
 * @since 1.0.0
 */

@Slf4j
@Component
public class PdfTicketInvoiceExtractor implements TicketInvoiceExtractor {

    private final TicketInvoiceClassifier classifier;

    /**
     * Constructor con inyección del clasificador de tickets.
     */
    public PdfTicketInvoiceExtractor(TicketInvoiceClassifier classifier) {
        this.classifier = classifier;
    }

    /**
     * Extrae y clasifica la información de un ticket desde un archivo PDF.
     *
     * @param folderName nombre de la carpeta asociada
     * @param pdfName nombre del archivo PDF
     * @param pdfStream contenido del archivo PDF
     * @return ticket procesado
     */

    @Override
    public TicketInvoice extract(String folderName, String pdfName, InputStream pdfStream) {

        log.debug("Iniciando extracción de ticket desde PDF: {}", pdfName);

        try (PDDocument document = PDDocument.load(pdfStream)){

            String text = new PDFTextStripper().getText(document);

            ClassifiedTicketValues values = classifier.classify(text);

            return new TicketInvoice(
                    folderName,
                    pdfName,
                    values.invoices(),
                    values.receipts()
            );



        } catch (Exception ex){
            log.error("Error procesando PDF {}", pdfName, ex);
            throw new CoreTechnicalException(
                    "Error procesando archivo PDF: " + pdfName,
                    ErrorType.DRIVE_ACCESS_ERROR,
                    ex
            );
        }

    }




}
