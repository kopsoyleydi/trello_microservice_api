package com.example.taskservice.data.repoInter;

import com.example.taskservice.model.CardAttachment;

public interface CardAttachmentRepoInter {

    CardAttachment addCardAttachment(CardAttachment cardAttachment);
    void deleteCardAttachment(CardAttachment cardAttachment);
    CardAttachment changeCard(CardAttachment cardAttachment);
}
