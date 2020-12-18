package com.openclassrooms.watchlist;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.openclassrooms.watchlist.Domain.WatchlistItem;
import com.openclassrooms.watchlist.Repository.WatchlistRepository;
import com.openclassrooms.watchlist.Service.MovieRatingService;
import com.openclassrooms.watchlist.Service.WatchlistService;

@RunWith(MockitoJUnitRunner.class)

public class WatchlistServiceTest {
	@Mock
	private WatchlistRepository watchlistRepositorymock;

	@Mock
	private MovieRatingService movieRatingServicemock;
	@InjectMocks
	private WatchlistService watchlistService;

	@Test
	public void testGetWatchlistItemsReturnAllItemsFromRpository() throws Exception {
		// Arrange
		watchlistRepositorymock = Mockito.mock(WatchlistRepository.class);
		watchlistService=Mockito.mock(WatchlistService.class);
		movieRatingServicemock=Mockito.mock(MovieRatingService.class);
		WatchlistItem item1 = new WatchlistItem("Coco", "9.6", "h", "it's nice");

		WatchlistItem item2 = new WatchlistItem("tenet", "7.8", "l", "time travelle");
		
		List<WatchlistItem> mockItems = new ArrayList<WatchlistItem>();
		//System.out.println(mockItems.get(1).getId());

		Mockito.when(watchlistRepositorymock.getList()).thenReturn(mockItems);

		// Act
		List<WatchlistItem> result = watchlistService.getWatchlistItems();
		System.out.println(result.get(1).getId());
		// Assert
		Assert.assertTrue(result.size() == 2);
		Assert.assertTrue(result.get(0).getTitle().equals("Coco"));
		Assert.assertTrue(result.get(1).getTitle().equals("Tenet"));
	}
}
