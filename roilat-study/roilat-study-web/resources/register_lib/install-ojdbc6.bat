cd /d %~dp0
@echo off
echo -------------- eking dataservice framework maven install by jingf_li@hnair.com ---------
echo 安装 ojdbc6......
mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0.1.0 -Dpackaging=jar -Dfile=%~dp0\ojdbc6.jar
pause