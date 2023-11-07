package com.example.taskservice.data.impl;

import com.example.taskservice.data.repo.CardLabelRepository;
import com.example.taskservice.data.repoInter.CardLabelRepoInter;
import com.example.taskservice.model.CardLabel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardLabelRepoInterImpl implements CardLabelRepoInter {

    private final CardLabelRepository cardLabelRepository;
    @Override
    public CardLabel addCardLabel(CardLabel cardLabel) {
        return cardLabelRepository.save(cardLabel);
    }

    @Override
    public void deleteCardLabel(CardLabel cardLabel) {
        cardLabelRepository.delete(cardLabel);
    }

    @Override
    public CardLabel changeCardLabel(CardLabel cardLabel) {
        return cardLabelRepository.save(cardLabel);
    }
}
