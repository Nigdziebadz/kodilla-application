package com.crud.tasks.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.domain.TrelloList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidatorTestSuite {

    @Test
    public void shouldValidateCard() {
        //Given
        TrelloValidator trelloValidator = new TrelloValidator();

        TrelloCard trelloCard = new TrelloCard(
                "card",
                "description",
                "position",
                "1",
                new ArrayList<>());
        TrelloCard trelloCard1 = new TrelloCard(
                "test",
                "description",
                "position",
                "2",
                new ArrayList<>());

        //When
        Boolean testedCard = trelloValidator.validateCard(trelloCard);
        Boolean testedSecondCard = trelloValidator.validateCard(trelloCard1);

        //Then
        assertTrue(testedCard);
        assertFalse(testedSecondCard);
    }

    @Test
    public void shouldValidateBoard() {
        //Given
        TrelloValidator trelloValidator = new TrelloValidator();

        List<TrelloList> lists = new ArrayList<>();
        TrelloBoard trelloBoard1 = new TrelloBoard("1", "name", lists);
        TrelloBoard trelloBoard2 = new TrelloBoard("2", "test", lists);
        TrelloBoard trelloBoard3 = new TrelloBoard("3", "TESTED-board", lists);
        TrelloBoard trelloBoard4 = new TrelloBoard("4", "TEST", lists);
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(trelloBoard1);
        trelloBoards.add(trelloBoard2);
        trelloBoards.add(trelloBoard3);
        trelloBoards.add(trelloBoard4);

        //When
        List<TrelloBoard> validatedList = trelloValidator.validateTrelloBoards(trelloBoards);

        //Then
        assertEquals(2, validatedList.size());
    }
}