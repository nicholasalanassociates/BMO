package org.bmo_nick.com;
import cucumber.api.testng.*;
import cucumber.api.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scenario1
{	
	
    @Given("I want food in {String}")
    public void i_want_food_in_postalcodeUK(WebDriver driver, String postalCodeUK) {
    	driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys(postalCodeUK);
    	
        }
    
    @When("I search for Resturants")
    public void i_search_for_resturants(WebDriver driver, String postalCodeUK) {
    	driver.findElement(By.xpath("//button[@data-test-id='find-restaurants-button']")).click();

    }
    
    @Then("Then I should see some restaurants in {string}")
    public void then_i_should_see_some_restaurants_in_postalCodeUK(WebDriver driver, String postalCodeUK) {
    	//Verify in the DOM that we have the section elements of the page
    	//that represents the restaurants on the page.
    	driver.findElements(By.xpath("//section[@data-test-id='restaurant']"));
    	//Verify that a count exists for this page or if this page returns zero results.
    	//Finding this element we can extract the data and assert it.
    	driver.findElement(By.xpath("//span[@data-search-count='openrestaurants']"));
    }
    
    public static void main(String[] args) {
    	Scenario1 sc = new Scenario1();
    	//Set System property for launching Chrome driver
		System.setProperty("webdriver.chrome.driver", "..//bmo-nick.com//src//main//java//org//bmo_nick//com//chromedriver.exe");
		// Create new ChromeDriver object for controlling the browser.
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.just-eat.co.uk");
		//Maximize window for testing the above URL.
		driver.manage().window().maximize();
		String postalCodeUK = "AR511AA";
    	sc.i_want_food_in_postalcodeUK(driver, postalCodeUK);
    	sc.i_search_for_resturants(driver, postalCodeUK);
    	sc.then_i_should_see_some_restaurants_in_postalCodeUK(driver, postalCodeUK);
    	driver.close();
    	
    }
        
 }
