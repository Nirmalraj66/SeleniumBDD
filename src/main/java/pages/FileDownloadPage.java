package pages;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileDownloadPage {

	private WebDriver driver;

	public FileDownloadPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='samplePDF.pdf']")
	private WebElement lnkFileDownload;

	public void clickOnElement() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(lnkFileDownload));
		lnkFileDownload.click();
	}

	public boolean validateFileContent(String expectedText) {
		String pdfText = "";
		try {
			// Download the PDF file
			URL url = new URL(lnkFileDownload.getAttribute("href"));
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			InputStream inputStream = connection.getInputStream();
			// Load and parse the PDF document
			PDDocument document = PDDocument.load(inputStream);
			PDFTextStripper pdfStripper = new PDFTextStripper();
			
			inputStream.close();
			
			pdfText = pdfStripper.getText(document);
			document.close();
			// Validate PDF content

		} catch (Exception e) {
			e.printStackTrace();
		}
		// Validate PDF content
		if (pdfText.contains(expectedText)) {
			System.out.println("PDF validation successful!");
			return true;
		} else {
			System.out.println("PDF validation failed.");
			return false;
		}
	}
}
