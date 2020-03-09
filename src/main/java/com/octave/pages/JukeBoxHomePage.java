package com.octave.pages;

import com.octave.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class JukeBoxHomePage extends BaseTest {
	@AndroidFindBy(accessibility = "accessibility_id") private MobileElement hotAtJukeBox;

public HotAtJukeBoxPage selectJukeBox() {
	click(hotAtJukeBox);
	return new HotAtJukeBoxPage();
}

}