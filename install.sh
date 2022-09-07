#!/usr/bin/env bash
echo '==================1.开发环境准备================================'
echo '1.1请确保安装并java8, git, maven并设置好环境变量'
echo '1.2请确保安装并docker,docker-compose并设置好环境变量'

#确认环境信息准备就绪
read -r -p "开发环境准备好了吗? [Y/n] " envConfirm
case $envConfirm in
    [yY][eE][sS]|[yY])
		echo "Yes 继续执行"
		;;
    [nN][oO]|[nN])
		echo "No 终止执行"
		exit 1
       	;;
    *)
		echo "Invalid input... 终止执行"
		exit 1
		;;
esac

echo '==================1.1清理当前脚本启动的容器和产生的镜像(可选的)=============='
#清理当前脚本启动的容器和产生的镜像(可选的)
docker stop mddds-redis mddds-rabbitmq mddds-mysql
#docker rm mddds-redis mddds-rabbitmq mddds-mysql
#docker image rm rabbitmq:management-alpine redis mysql

docker stop mddds-material mddds-file-service mddds-collection mddds-gateway-web
#docker rm mddds-material mddds-file-service mddds-collection mddds-gateway-web
#docker image rm m3ds/material-service:latest m3ds/file-service:latest m3ds/collection-service:latest m3ds/gateway-web:latest

echo '==================2.安装认证公共包到本地maven仓库=================='
#安装认证公共包到本地maven仓库
cd common && mvn install
echo '当前目录:' && pwd

#回到根目录
cd -


echo '==================3.docker-compose启动公共服务==================='
#去docker-compose目录
cd docker-compose
echo '==================3.1显示环境变量: docker-compose/.env =========='
#显示环境变量
cat ./.env
echo ''

#按需要开启公共服务
echo '==================3.2启动 mysql or redis or rabbitmq ========'
docker-compose -f docker-compose.yml up -d mysql
docker-compose -f docker-compose.yml up -d redis
docker-compose -f docker-compose.yml up -d rabbitmq

echo '当前目录:' && pwd

#回到根目录
cd -

echo '==================3.3.启动注册中心, minio============'
#去docker-compose目录
cd docker-compose

#启动注册中心
docker-compose -f docker-compose.yml -f docker-compose.nacos.yml up -d nacos
docker-compose -f docker-compose.yml -f docker-compose.minio.yml up -d minio

#确认进行minio数据迁移
echo '你可以立即去minio源服务器进行数据迁移,然后回来继续...'
read -r -p "确认对象存储迁移完毕？ [Y/n] " authDbConfirm
case $authDbConfirm in
    [yY][eE][sS]|[yY])
		echo "Yes 继续执行"
		;;
    [nN][oO]|[nN])
		echo "No 终止执行"
		exit 1
       	;;
    *)
		echo "Invalid input... 终止执行"
		exit 1
		;;
esac
#回到根目录
cd -

echo '==================4.构建镜像并启动网关(gateway)相关服务==============='
#构建镜像:网关服务
cd ./gateway/gateway-web
mvn package && mvn docker:build

#回到根目录
cd -


#去docker-compose目录
cd docker-compose

#启动网关服务
docker-compose -f docker-compose.yml -f docker-compose.spring-gateway.yml up -d gateway-web
docker-compose -f docker-compose.yml up -d nginx


#回到根目录
cd -

echo '==================5.构建镜像并启动文件存储相关服务=================='
#构建镜像:组织服务
cd ./object-storage/file-service
mvn package && mvn docker:build

#回到根目录
cd -


#去docker-compose目录
cd docker-compose

#启动文件存储服务
docker-compose -f docker-compose.yml -f docker-compose.system.yml up -d file-service

#回到根目录
cd -

echo '==================6.构建镜像并启动材料管理相关服务=================='
#构建镜像:材料管理相关服务
cd ./material/material-service
mvn package && mvn docker:build
#确认初始化材料管理相关服务的DB:./material/db
echo '你可以立即去部署材料管理相关服务的DB(脚本路径:./material/db),然后回来继续...'
read -r -p "确认部署材料管理相关服务的DB部署好了吗? [Y/n] " authDbConfirm
case $authDbConfirm in
    [yY][eE][sS]|[yY])
		echo "Yes 继续执行"
		;;
    [nN][oO]|[nN])
		echo "No 终止执行"
		exit 1
       	;;
    *)
		echo "Invalid input... 终止执行"
		exit 1
		;;
esac

#回到根目录
cd -

#去docker-compose目录
cd docker-compose

#启动材料管理服务
docker-compose -f docker-compose.yml -f docker-compose.system.yml up -d material-service


#回到根目录
cd -

echo '==================7.构建镜像并启动数据采集管理相关服务=================='
#构建镜像:数据采集管理相关服务
cd ./collection/collection-service
mvn package && mvn docker:build
#确认初始化数据采集管理相关服务的DB:./collection/db
echo '你可以立即去部署数据采集管理相关服务的DB(脚本路径:./collection/db),然后回来继续...'
read -r -p "确认部署数据采集管理相关服务的DB部署好了吗? [Y/n] " authDbConfirm
case $authDbConfirm in
    [yY][eE][sS]|[yY])
		echo "Yes 继续执行"
		;;
    [nN][oO]|[nN])
		echo "No 终止执行"
		exit 1
       	;;
    *)
		echo "Invalid input... 终止执行"
		exit 1
		;;
esac

#回到根目录
cd -

#去docker-compose目录
cd docker-compose

#启动材料管理服务
docker-compose -f docker-compose.yml -f docker-compose.system.yml up -d collection-service
#回到根目录
cd -
