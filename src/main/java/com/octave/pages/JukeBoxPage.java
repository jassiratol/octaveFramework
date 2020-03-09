package com.octave.pages;

import com.octave.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class JukeBoxPage extends BaseTest {
	@AndroidFindBy(accessibility = "accessibility_id") private MobileElement firstJukeBox;
	@AndroidFindBy(accessibility = "accessibility_id") private MobileElement pageTitle;


public JukeBoxHomePage selectJukeBox() {
	click(firstJukeBox);
	return new JukeBoxHomePage();
}

public String getTitle() {
	return getAttribute(pageTitle, "text");
}


}

