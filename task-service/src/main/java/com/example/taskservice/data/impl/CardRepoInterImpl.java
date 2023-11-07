package com.example.taskservice.data.impl;

import com.example.taskservice.data.repo.CardRepository;
import com.example.taskservice.data.repoInter.CardRepoInter;
import com.example.taskservice.model.Card;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardRepoInterImpl implements CardRepoInter {

    private final CardRepository cardRepository;
    @Override
    public Card addCard(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public void deleteCard(Card card) {
        cardRepository.delete(card);
    }

    @Override
    public Card changeCard(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public List<Card> getAllCardsFromTaskListId(Long taskListId) {
        return cardRepository.findAllByTaskListId(taskListId);
    }
}
