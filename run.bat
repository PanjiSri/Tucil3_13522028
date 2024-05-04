@echo off
set SRC_DIR=src
set BIN_DIR=bin

:: Buat folder bin jika belum ada
if not exist %BIN_DIR% mkdir %BIN_DIR%

:: Compile semua file Java ke dalam folder bin
javac -d %BIN_DIR% %SRC_DIR%\*.java

if %ERRORLEVEL% NEQ 0 (
  echo Error: Java program exited with an error code.
  exit /b %ERRORLEVEL%
)

java -cp %BIN_DIR% Main

pause
