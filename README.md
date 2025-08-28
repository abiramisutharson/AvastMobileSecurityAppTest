# Test


Test Name: Validating_The_Toast_Message_After_Scanning

Test Description: This test validates the toast message displayed after scanning the device for threats.

Setup Instructions:

1. Install the Avast Mobile Security app on the test device.
2. Set up the test environment with the required dependencies (e.g., Appium, TestNG).
3. Update the DesiredCapabilities in the test code to match the test device's configuration.

Prerequisites:

- The test device should have the Avast Mobile Security app installed.
- The test device should be connected to the test environment.
- The test environment should have the required dependencies installed.

Test Logic:

1. Launch the Avast Mobile Security app.
2. Click on the "Get Started" button and navigate through the onboarding process.
3. Start a scan and wait for the scan to complete.
4. Verify that a toast message is displayed after the scan is complete.
5. Validate the text of the toast message.

Assumptions:

- The test device is in a clean state before running the test.
- The Avast Mobile Security app is properly configured and functioning as expected.

Notes:

- This test assumes that the toast message is displayed immediately after the scan is complete. If the toast message is displayed after a delay, the test may need to be modified accordingly.
- This test only validates the presence and text of the toast message. Additional tests may be needed to validate other aspects of the feature.
