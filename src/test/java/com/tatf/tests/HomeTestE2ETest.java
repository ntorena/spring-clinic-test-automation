package com.tatf.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;

public class HomeTestE2ETest {

	private WebDriver driver;

	@BeforeEach
	public void setUp() throws Exception {
		ChromeOptions options = new ChromeOptions();
		driver = new RemoteWebDriver(new URL("http://172.17.0.2:4444/wd/hub"), options);
	}

	@Test
	public void testVetsPage() {
		driver.get("http://host.docker.internal:8080");
		driver.findElement(By.xpath("//*[@id=\"main-navbar\"]/ul/li[3]/a")).click();
		assertTrue(driver.getPageSource().contains("Veterinarians"));
	}

	@Test
	public void testOwnersPage() {
		driver.get("http://host.docker.internal:8080");
		driver.findElement(By.xpath("//*[@id=\"main-navbar\"]/ul/li[2]/a")).click();
		assertTrue(driver.getPageSource().contains("Owners"));
	}

	@AfterEach
	public void tearDown() {
		driver.quit();
	}

}