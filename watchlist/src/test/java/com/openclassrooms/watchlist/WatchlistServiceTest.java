package com.openclassrooms.watchlist;

import com.openclassrooms.watchlist.Domain.WatchlistItem;
import com.openclassrooms.watchlist.Repository.WatchlistRepository;
import com.openclassrooms.watchlist.Service.impl.MovieRatingServiceImpl;
import com.openclassrooms.watchlist.Service.impl.WatchlistServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class WatchlistServiceTest {
	@Mock
	private WatchlistRepository watchlistRepository;
	@Mock
	private MovieRatingServiceImpl movieRatingService;
	@InjectMocks
	private WatchlistServiceImpl watchlistService;

	@Test
	public void testGetWatchlistItemsReturnAllItemsFromRpository() throws Exception {
		// Arrange
		WatchlistItem item1 = new WatchlistItem("Coco", "9.6", "h", "it's nice");

		WatchlistItem item2 = new WatchlistItem("Tenet", "7.8", "l", "time travelle");

		List<WatchlistItem> mockItems = Arrays.asList(item1, item2);
		//System.out.println(mockItems.get(1).getId());

		Mockito.when(watchlistRepository.getList()).thenReturn(mockItems);

		// Act
		List<WatchlistItem> result = watchlistService.getWatchlistItems();
		// Assert
		Assert.assertTrue(result.size() == 2);
		Assert.assertTrue(result.get(0).getTitle().equals("Coco"));
		Assert.assertTrue(result.get(1).getTitle().equals("Tenet"));
	}
}
