package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class TrelloAttachmentsByTypeDto {

    @JsonProperty("trello")
    private List<TrelloAttachementsByTypeTrello> trello;
}
