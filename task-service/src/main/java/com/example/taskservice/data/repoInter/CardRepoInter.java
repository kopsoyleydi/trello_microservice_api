package com.example.taskservice.data.repoInter;

import com.example.taskservice.model.Card;
import com.example.taskservice.model.CardLabel;

import java.util.List;

public interface CardRepoInter {

    Card addCard(Card card);

    void deleteCard(Card card);

    Card changeCard(Card card);

    List<Card> getAllCardsFromTaskListId(Long taskListId);
}
