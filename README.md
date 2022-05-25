# demo
## 資料庫 Project setup 
1. 執行兩份SQL: /db-SQL/create_script, /db-SQL/insert_script  
2. 設定資料庫連線，設定檔位置 /back-end/demo/src/main/resources/application.properties  
## 前端 Project setup  
1. cd到/front-end/shop-platform  
2. 終端機執行 $npm run serve -- --port 8081  
#### 後端 Project setup  
1. cd到 /back-end/demo  
2. 終端機執行: $mvn clean install -Dmaven.test.skip=true 產生jar檔案. 
3. 再執行: $java -jar  target/demo-0.0.1-SNAPSHOT.jar 



