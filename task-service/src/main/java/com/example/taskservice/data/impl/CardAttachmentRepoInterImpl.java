package com.example.taskservice.data.impl;

import com.example.taskservice.data.repo.CardAttachmentRepository;
import com.example.taskservice.data.repoInter.CardAttachmentRepoInter;
import com.example.taskservice.model.CardAttachment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardAttachmentRepoInterImpl implements CardAttachmentRepoInter {

    private final CardAttachmentRepository cardAttachmentRepository;
    @Override
    public CardAttachment addCardAttachment(CardAttachment cardAttachment) {
        return cardAttachmentRepository.save(cardAttachment);
    }

    @Override
    public void deleteCardAttachment(CardAttachment cardAttachment) {
        cardAttachmentRepository.delete(cardAttachment);
    }

    @Override
    public CardAttachment changeCard(CardAttachment cardAttachment) {
        return cardAttachmentRepository.save(cardAttachment);
    }
}
