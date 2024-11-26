package com.tatf.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HomeTestE2ETest {

	private WebDriver driver;

	@BeforeEach
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--disable-gpu");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.setBinary("/usr/bin/chromium");
		driver = new ChromeDriver(options);
	}

	@Test
	public void testHomePage() {
		driver.get("http://localhost:8080");
		assertTrue(driver.findElement(By.tagName("h2")).getText().contains("Bienvenido"));
	}

	@Test
	public void testVetsPage() {
		driver.get("http://localhost:8080");
		driver.findElement(By.xpath("//*[@id=\"main-navbar\"]/ul/li[3]/a")).click();
		assertTrue(driver.getPageSource().contains("Veterinarians"));
	}

	@Test
	public void testOwnersPage() {
		driver.get("http://localhost:8080");
		driver.findElement(By.xpath("//*[@id=\"main-navbar\"]/ul/li[2]/a")).click();
		assertTrue(driver.getPageSource().contains("Owners"));
	}

	@AfterEach
	public void tearDown() {
		driver.quit();
	}

}