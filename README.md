# Test

# Avast Security Automation Framework

This project is an automation testing framework built with:
- **Java 11+**
- **TestNG (7.x)**
- **Appium (mobile automation)**
- **ExtentReports (HTML reporting)**

---

## 📂 Project Structure

com.avastsecurity
├── Base
│ └── BaseTest.java # Common setup & teardown (Appium driver, reports)
│
├── Test
│ └── Validating_The_Toast_Message_After_Scanning.java # Example test case
│
├── utilities
│ └── ExtentReportUtil.java # ExtentReports utility
│ └── ExtentReportListener.java # TestNG listener for reporting
│
└── resources
└── testng.xml # TestNG suite file


---

## ⚙️ Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/<your-repo>/avast-automation.git
   cd avast-automation


Install dependencies

Make sure you have:

Java 11+

Maven 3.6+

Appium server running

Android SDK or emulator / real device connected

Install Maven dependencies:

mvn clean install


Device / App configuration

Update BaseTest.java with desired capabilities (App package, App activity, Device name, etc.)

Example:

caps.setCapability("platformName", "Android");
caps.setCapability("deviceName", "emulator-5554");
caps.setCapability("appPackage", "com.avast.android.mobilesecurity");
caps.setCapability("appActivity", "com.avast.android.mobilesecurity.ui.SplashActivity");

▶️ Running Tests

Run via Maven

mvn clean test


Run specific suite

mvn clean test -DsuiteXmlFile=testng.xml


Run from IDE

Right-click on testng.xml → Run As → TestNG Suite

📊 Reports

Reports are generated in the reports/ folder after execution.

Open the Extent HTML report:

reports/extent-report.html
