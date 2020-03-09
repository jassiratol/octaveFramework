package com.octave.pages;

import com.octave.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BaseTest {
	@AndroidFindBy(accessibility = "accessibility_id") private MobileElement skipButton;
	@AndroidFindBy(accessibility = "accessibility_id") private MobileElement errorText;


public JukeBoxPage clickSkipButton() {
	click(skipButton);
	return new JukeBoxPage();
}

public String getErrorText() {
	return getAttribute(errorText, "text");
	
}

}

