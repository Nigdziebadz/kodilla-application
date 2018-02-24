package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TrelloMapperTest {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void testMapToBoard() {
        //Given
        List<TrelloListDto> listDtos = new ArrayList<>();
        List<TrelloBoardDto> boardDtos = new ArrayList<>();
        boardDtos.add(new TrelloBoardDto("Id",
                "Test Board",
                listDtos));

        //When
        List<TrelloBoard> trelloBoard = trelloMapper.mapToBoard(boardDtos);

        //Then
        assertEquals(1, trelloBoard.size());
        assertEquals("Test Board", trelloBoard.get(0).getName());
        assertEquals("Id", trelloBoard.get(0).getId());
    }

    @Test
    public void testMapToBoardDto() {
        //Given
        List<TrelloList> list = new ArrayList<>();
        List<TrelloBoard> board = new ArrayList<>();
        board.add(new TrelloBoard("Id", "Testing Board", list));

        //When
        List<TrelloBoardDto> trelloBoardDto = trelloMapper.mapToBoardDto(board);

        //Then
        assertEquals(1, trelloBoardDto.size());
        assertEquals("Testing Board", trelloBoardDto.get(0).getName());
        assertEquals("Id", trelloBoardDto.get(0).getId());
    }

    @Test
    public void testMapToList() {
        //Given
        List<TrelloListDto> listDto = new ArrayList<>();
        listDto.add(new TrelloListDto("Id", "Test List", true));

        //When
        List<TrelloList> lists = trelloMapper.mapToList(listDto);

        //Then
        assertEquals(1, lists.size());
        assertEquals("Id", lists.get(0).getId());
        assertEquals("Test List", lists.get(0).getName());
        assertTrue(lists.get(0).isClosed());
    }

    @Test
    public void testMapToListDto() {
        //Given
        List<TrelloList> list = new ArrayList<>();
        list.add(new TrelloList("Id", "Test List", false));

        //When
        List<TrelloListDto> listDto = trelloMapper.mapToListDto(list);

        //Then
        assertEquals(1, listDto.size());
        assertEquals("Id", listDto.get(0).getId());
        assertEquals("Test List", listDto.get(0).getName());
        assertFalse(listDto.get(0).isClosed());
    }

    @Test
    public void testMapToCardDto() {
        //Given
        TrelloCard card = new TrelloCard(
                "Test create card",
                "Tested card descr",
                "whatever",
                "1",
                new ArrayList<>());

        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(card);

        //Then
        assertEquals("Test create card", trelloCardDto.getName());
        assertEquals("Tested card descr", trelloCardDto.getDescription());
        assertEquals("whatever", trelloCardDto.getPos());
        assertEquals("1", trelloCardDto.getListId());
    }

    @Test
    public void testMapToCard() {
        //Given
        TrelloCardDto cardDto = new TrelloCardDto(
                "Test create card",
                "Tested card descr",
                "whatever",
                "1",
                new ArrayList<>());
        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(cardDto);

        //Then
        assertEquals("Test create card", trelloCard.getName());
        assertEquals("Tested card descr", trelloCard.getDescription());
        assertEquals("whatever", trelloCard.getPos());
        assertEquals("1", trelloCard.getListId());
    }
}
