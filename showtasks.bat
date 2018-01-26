call runcrud.bat
if "%ERRORLEVEL%" == "0" goto runchrome

echo.
echo RunCrud.bat have errors, stopping work
goto fail

:runchrome
start "C:\Program Files (x86)\Google\Chrome\Application\chrome.exe" http://localhost:8080/crud/v1/task/getTasks
echo.
echo Error - no specified browser found
goto fail


:fail
echo.
echo There were errors