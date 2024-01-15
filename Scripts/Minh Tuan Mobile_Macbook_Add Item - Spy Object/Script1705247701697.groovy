import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

WebUI.maximizeWindow()

WebUI.delay(5)

WebUI.waitForElementVisible(findTestObject('Page_Homepage Minh Tuan Mobile/span_Mac'), 10)

WebUI.mouseOver(findTestObject('Page_Homepage Minh Tuan Mobile/span_Mac'))

WebUI.mouseOver(findTestObject('Page_Homepage Minh Tuan Mobile/a_MacBook'))

WebUI.click(findTestObject('Page_Homepage Minh Tuan Mobile/a_MacBook Pro'))

WebUI.waitForElementClickable(findTestObject('Page_Macbook/h3_MacBook Pro 14 inch 2023 M3 8CPU 10GPU 8GB 512GB SSD'), 10)

WebUI.click(findTestObject('Page_Macbook/h3_MacBook Pro 14 inch 2023 M3 8CPU 10GPU 8GB 512GB SSD'))

WebUI.click(findTestObject('Page_Child Macbook item/btn_Add item'))

WebUI.verifyElementPresent(findTestObject('Page_Child Macbook item/popup_Item added'), 3)

