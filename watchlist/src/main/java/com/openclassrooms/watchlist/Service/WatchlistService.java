package com.openclassrooms.watchlist.Service;

import com.openclassrooms.watchlist.Domain.WatchlistItem;
import com.openclassrooms.watchlist.Exception.DublicateTileException;
import com.openclassrooms.watchlist.Repository.WatchlistRepository;
import com.openclassrooms.watchlist.Service.impl.MovieRatingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface WatchlistService {
    List<WatchlistItem> getWatchlistItems();

    int getWatchlistSize();

    WatchlistItem findItemById(Integer id);

    void addOrUbdateWatchlistItem(WatchlistItem watchlistItem) throws DublicateTileException;

}
