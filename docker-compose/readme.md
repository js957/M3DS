

## 启动基础服务

mysql、redis、rabbitmq
 
`docker-compose up -d`

rabbitmq默认账号密码：guest/guest
mysql默认账号密码：root/root123

## 启动阿里注册中心和配置中心nacos

`docker-compose -f docker-compose.yml -f docker-compose.nacos.yml up`

默认账号密码：nacos/nacos

## 启动minio
`docker-compose -f docker-compose.yml -f docker-compose.minio.yml up -d minio`

## 启动gateway-web
`docker-compose -f docker-compose.yml -f docker-compose.spring-gateway.yml up -d gateway-web`

## 启动存储管理、采集管理、材料管理服务
`docker-compose -f docker-compose.yml -f docker-compose.system.yml up -d file-service`
`docker-compose -f docker-compose.yml -f docker-compose.system.yml up -d material`
`docker-compose -f docker-compose.yml -f docker-compose.system.yml up -d collection`