package com.openclassrooms.watchlist.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.openclassrooms.watchlist.Domain.WatchlistItem;

@Service
public class WatchlistRepository {
	List<WatchlistItem> watchlistItems = new ArrayList<WatchlistItem>();
	static int index = 1;

	 
	public List<WatchlistItem> getList() {
		return watchlistItems;
	}

	public void addItem(WatchlistItem watchlistItem) {
		watchlistItem.setId(index++);
		watchlistItems.add(watchlistItem);
	}

	public WatchlistItem findItemBYId(Integer id) {
		for (WatchlistItem watchlistItem : watchlistItems) {
			if (watchlistItem.getId() == id) {
				return watchlistItem;
			}
		}
		return null;

	}

	public WatchlistItem findItemBYTitle(String title) {
		for (WatchlistItem watchlistItem : watchlistItems) {
			if (watchlistItem.getTitle().equals(title)) {
				return watchlistItem;
			}
		}
		return null;

	}
}
