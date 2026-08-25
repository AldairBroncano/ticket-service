package com.broncano.ticket_service.infrastructure.classifier.regex;

import com.broncano.ticket_service.domain.classifier.ClassifiedTicketValues;
import com.broncano.ticket_service.domain.classifier.TicketInvoiceClassifier;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Clasificador de tickets basado en expresiones regulares.
 *
 * <p>
 *     Implementa {@link TicketInvoiceClassifier} y utiliza patrones configurables para identificar facturas
 *     y comprobantes dentro del texto extraído de un PDF.
 * </p>
 *
 * @author Broncano Aldair
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
public class RegexTicketInvoiceClassifier implements TicketInvoiceClassifier {

    private final Pattern invoicPattern;
    private final Pattern receipPattern;

    /**
     * Constructor que inicializa los patrones de clasificación
     * a partir de la configuración.
     */
    public RegexTicketInvoiceClassifier(Pattern invoicPattern, Pattern receipPattern) {
        this.invoicPattern = invoicPattern;
        this.receipPattern = receipPattern;
    }

    /**
     * Clasifica el texto recibido identificando facturas
     * y comprobantes mediante expresiones regurales.
     *
     * @param text contenido textual del ticket
     * @return valores clasificados; vacío si el texto es nulo o vacío
     */

    @Override
    public ClassifiedTicketValues classify(String text) {
        return Optional.ofNullable(text)
                .filter(t -> !t.isBlank())
                .map(this::classifyText)
                .orElse(ClassifiedTicketValues.empty());
    }

    /**
     * Ejecuta la clasifición del texto usando los patrones definidos.
     */

    private ClassifiedTicketValues classifyText(String text){
        Set<String> invoices = extract(invoicPattern, text);
        Set<String> receipts = extract(receipPattern, text);

        return new ClassifiedTicketValues(
                String.join(",", invoices),
                String.join(",", receipts)
        );

    }

    /**
     * Extrae coincidencias únicas de un patrón dentro del texto.
     */

    private Set<String> extract(Pattern pattern, String text){
        return pattern.matcher(text)
                .results()
                .map(MatchResult::group)
                .collect(Collectors.toSet());
    }


}
