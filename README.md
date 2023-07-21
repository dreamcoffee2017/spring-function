# Spring Cloud Function with aws lambda

* simple
  https://docs.spring.io/spring-cloud-function/docs/current/reference/html/aws-intro.html
* web
  https://github.com/awslabs/aws-serverless-java-container
* dynamodb
  https://spring.io/projects/spring-data

```
java -D'java.library.path=./DynamoDBLocal_lib' -jar DynamoDBLocal.jar -sharedDb
aws dynamodb create-table --endpoint-url http://localhost:8000 `
    --table-name customer `
    --attribute-definitions `
        AttributeName=id,AttributeType=S `
    --key-schema `
        AttributeName=id,KeyType=HASH `
    --provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5
aws dynamodb list-tables --endpoint-url http://localhost:8000
```