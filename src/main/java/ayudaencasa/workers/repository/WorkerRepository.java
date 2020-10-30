package ayudaencasa.workers.repository;


import ayudaencasa.workers.entity.Worker;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class WorkerRepository {
    @Autowired
    private DynamoDBMapper mapper;

    public Worker addWorker (Worker worker){
        mapper.save(worker);
        return worker;
    }

    public  Worker findWorkerById(String uId){
        return mapper.load(Worker.class,uId);
    }

    public  String deleteWorker (Worker worker){
        mapper.delete(worker);
        return "El trabajador fue eliminado";
    }

    public  String editWorker(Worker worker){
        mapper.save(worker,buildExpression(worker));
        return "Cambios realizados";
    }

    private DynamoDBSaveExpression buildExpression(Worker worker){
        DynamoDBSaveExpression dynamoDBSaveExpression=new DynamoDBSaveExpression();
        Map<String, ExpectedAttributeValue>expectedMap= new HashMap<>();
        expectedMap.put("uId",new ExpectedAttributeValue(new AttributeValue().withS(worker.getuId())) );
        dynamoDBSaveExpression.setExpected(expectedMap);
        return dynamoDBSaveExpression;
    }
}
