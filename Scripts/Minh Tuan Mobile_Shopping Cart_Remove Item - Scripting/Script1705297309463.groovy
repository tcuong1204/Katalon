import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

def iScreenshotID = 1

TestObject testObj = new TestObject()

// Open and Close browser was defined in testsuite setup and teardown
// WebUI.openBrowser(GlobalVariable.base_url)

'Wait for the page loaded'
def xMinhTuanLogo = '//img[contains(@alt, "Hệ thống cửa hàng điện thoại Minh Tuấn Mobile")]'

WebUI.waitForElementVisible(testObj.addProperty('xpath', ConditionType.EQUALS, xMinhTuanLogo), 10)

'Maximize window'
WebUI.maximizeWindow()

WebUI.takeScreenshot(('/home/ltcuong/Katalon Studio/Demo Project/Screenshots/Screenshot' + iScreenshotID++) + '.png')

'Go to Macbook Pro'
WebUI.mouseOver(findTestObject('Object Repository/Page_Homepage Minh Tuan Mobile/span_Mac'))

WebUI.mouseOver(findTestObject('Object Repository/Page_Homepage Minh Tuan Mobile/a_MacBook'))

WebUI.click(findTestObject('Object Repository/Page_Homepage Minh Tuan Mobile/a_MacBook Pro'))

WebUI.takeScreenshot(('/home/ltcuong/Katalon Studio/Demo Project/Screenshots/Screenshot' + iScreenshotID++) + '.png')

'Add some Macbook to shopping cart'
def lMacbooks = ['MacBook Pro 14 inch 2023 M3 8CPU 10GPU 8GB 512GB SSD', 'MacBook Pro 14 inch 2023 M3 8CPU 10GPU 8GB 1TB SSD']

for (def sMacbook : lMacbooks) {
    'Click on item' + sMacbook

    def xMacbook = ('//h3[text()="' + sMacbook) + '"]'

    TestObject tMacbookObj = testObj.addProperty('xpath', ConditionType.EQUALS, xMacbook)

    WebUI.click(tMacbookObj)

    WebUI.takeScreenshot(('/home/ltcuong/Katalon Studio/Demo Project/Screenshots/Screenshot' + iScreenshotID++) + '.png')

    'Click on Add To Cart button to add item' + sMacbook

    def xAddToCartBtn = '(//button[@value="addtocart"])[1]'

    TestObject tAddToCart = testObj.addProperty('xpath', ConditionType.EQUALS, xAddToCartBtn)

    WebUI.click(tAddToCart)

    WebUI.takeScreenshot(('/home/ltcuong/Katalon Studio/Demo Project/Screenshots/Screenshot' + iScreenshotID++) + '.png')

    'Verify item has been added'
    WebUI.verifyElementPresent(findTestObject('Page_Child Macbook item/popup_Item added'), 3)

    WebUI.back()

    WebUI.takeScreenshot(('/home/ltcuong/Katalon Studio/Demo Project/Screenshots/Screenshot' + iScreenshotID++) + '.png')
}

'Go to shopping cart'
def xShoppingCart = '//b[text()="Giỏ hàng"]'

TestObject tShoppingCartObj = testObj.addProperty('xpath', ConditionType.EQUALS, xShoppingCart)

WebUI.click(tShoppingCartObj)

WebUI.takeScreenshot(('/home/ltcuong/Katalon Studio/Demo Project/Screenshots/Screenshot' + iScreenshotID++) + '.png')

// Note that there are some issue with the page under test so may be the test is incorrect, we just refer for the code
'Increase and descrease value'
for (def sMacbook : lMacbooks) {
    
	// Define xpath locators
    def xIncreseQuantity = '//a[normalize-space(text())="' + sMacbook + '"]//ancestor::div[contains(@class, "cartitem")]//button[@value="plus"]'
	def xDescreseQuantity = '//a[normalize-space(text())="' + sMacbook + '"]//ancestor::div[contains(@class, "cartitem")]//button[@value="minus"]'
	def xInputQuantity = '//a[normalize-space(text())="' + sMacbook + '"]//ancestor::div[contains(@class, "cartitem")]//input'
	
	// Define test objects
	TestObject tInputQuantity = testObj.addProperty('xpath', ConditionType.EQUALS, xInputQuantity)
	TestObject tIncreseQuantity = testObj.addProperty('xpath', ConditionType.EQUALS, xIncreseQuantity)
	TestObject tDescreseQuantity = testObj.addProperty('xpath', ConditionType.EQUALS, xDescreseQuantity)
	
	// Get current value to calculate the expected
	def sOriValue = WebUI.getAttribute(tInputQuantity, 'value')
	WebUI.comment("Original quantity: " + sOriValue)
	
	'Increase quantity for item ' + sMacbook
	def sExpIncreaseValue = sOriValue++
	WebUI.click(tIncreseQuantity)
	
	'Validate the the quantity is increased as expected'
	def sQuantityAfterIncr = WebUI.getAttribute(tInputQuantity, 'value')
	WebUI.verifyEqual(sQuantityAfterIncr == sExpIncreaseValue, true)
	WebUI.comment("After incresing: " + sQuantityAfterIncr + ", expected value: " + sExpIncreaseValue)
	WebUI.takeScreenshot(('/home/ltcuong/Katalon Studio/Demo Project/Screenshots/Screenshot' + iScreenshotID++) + '.png')
	
	'Descrease quantity for item ' + sMacbook
	def sExpDescreaseValue = sQuantityAfterIncr--
	WebUI.click(tDescreseQuantity)
	
	'Validate the the quantity is descreased as expected'
	def sQuantityAfterDesc = WebUI.getAttribute(tInputQuantity, 'value')
	WebUI.verifyEqual(sQuantityAfterDesc == sExpDescreaseValue, true)
	WebUI.comment("After descreasing: " + sQuantityAfterDesc + ", expected value: " + sExpDescreaseValue)
    WebUI.takeScreenshot(('/home/ltcuong/Katalon Studio/Demo Project/Screenshots/Screenshot' + iScreenshotID++) + '.png')
}

//'End test, close browser'
//WebUI.closeBrowser()

