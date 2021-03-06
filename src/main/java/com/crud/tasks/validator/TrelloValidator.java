package com.crud.tasks.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class TrelloValidator {

    private final static Logger LOGGER = LoggerFactory.getLogger(TrelloValidator.class);

    public boolean validateCard(final TrelloCard trelloCard) {
        if (trelloCard.getName().equalsIgnoreCase("test")) {
            LOGGER.info("Just testing app - ignore");
            return false;
        } else {
            LOGGER.info("Not test case - carry on");
            return true;
        }
    }

    public List<TrelloBoard> validateTrelloBoards(final List<TrelloBoard> trelloBoards) {
        LOGGER.info("Filtering 'test'");
        List<TrelloBoard> filteredBoards = trelloBoards.stream()
                .filter(trelloBoard -> !trelloBoard.getName().equalsIgnoreCase("test"))
                .collect(toList());
        LOGGER.info("Board filtered, current size: " + filteredBoards.size());
        return filteredBoards;
    }
}

