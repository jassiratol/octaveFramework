package com.octave.pages;

import com.octave.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HotAtJukeBoxPage extends BaseTest {
	@AndroidFindBy(accessibility = "accessibility_id") private MobileElement firstArtist;
	@AndroidFindBy(accessibility = "accessibility_id") private MobileElement hotArtists;

public String extractHotArtists() {
	return getAttribute(hotArtists, "text");
}

public HotArtistsPage selectArtist() {
	click(firstArtist);
	return new HotArtistsPage();
}

}
