@echo off

set GRID_PORT=4444
set NODE_PORT=5555
set SELENIUM_SERVER_JAR=utils/seleniumGrid/selenium-server-4.21.0.jar
set CHROMEDRIVER_PATH=utils/chromedriver/chromedriver.exe

echo Запуск Selenium Hub...
start cmd /k java -jar %SELENIUM_SERVER_JAR% hub --port %GRID_PORT%

echo Ожидание 10 секунд для запуска Hub...
timeout /t 10

echo Запуск Selenium Node...
start cmd /k java -Dwebdriver.chrome.driver="%CHROMEDRIVER_PATH%" -jar %SELENIUM_SERVER_JAR% node --hub http://localhost:%GRID_PORT% --port %NODE_PORT%