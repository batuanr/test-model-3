package service;

import model.Card;

import java.util.List;

public interface ICard {
    List<Card> getAll();
    List<Card> getCardTrue();
    List<Card> getAllCardFalse();
    Card findById(int id);
    void save(Card card);
    void edit(Card card);
    void delete(int id);
}
