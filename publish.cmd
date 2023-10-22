cd ./fabric
powershell -Command "./gradlew githubRelease";
powershell -Command "./gradlew curseforge";
powershell -Command "./gradlew modrinth";
pause
