# M3DS
Diagnose depression by collecting facial videos stimulated by stimuli materials on mobile phones

### 环境配置
#### 1、工具准备
Java Dev 如Idea等  
Mysql可视化管理工具 如Navicate  
redis可视化管理工具 如RedisDesktopManager  
环境运维管理工具 Docker Desktop
#### 2、 环境准备
确保安装并java8, git, maven 3.6.3并设置好环境变量  
确保安装并docker,docker-compose并设置好环境变量  
使用docker-compose 配置mysql,rabbitmq,redis,nginx,minio,nacos环境  
通过执行
```
  sh install.sh
```
可快速进行环境的安装，但值得注意的是，数据库以及Minio需要在环境生成后手动拷贝数据到docker环境中  
