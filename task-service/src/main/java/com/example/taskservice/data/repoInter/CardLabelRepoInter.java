package com.example.taskservice.data.repoInter;

import com.example.taskservice.model.Card;
import com.example.taskservice.model.CardLabel;

public interface CardLabelRepoInter {

    CardLabel addCardLabel(CardLabel cardLabel);

    void deleteCardLabel(CardLabel cardLabel);

    CardLabel changeCardLabel(CardLabel cardLabel);
}
