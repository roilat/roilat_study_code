cd /d %~dp0
@echo off
echo -------------- eking dataservice framework maven install by jingf_li@hnair.com ---------
echo °²×° gen......
mvn install:install-file -DgroupId=com.bpnet -DartifactId=gen -Dversion=0.0.3-SNAPSHOT -Dpackaging=jar -Dfile=%~dp0\gen-0.0.3-SNAPSHOT.jar
pause