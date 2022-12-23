package com.example.notekeepingbackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.notekeepingbackend.model.AutogenerateId;

@Service
public class SequenceGeneratorService {
	
	private MongoOperations mongoOperations;
	
	@Autowired
	public SequenceGeneratorService(MongoOperations mongoOperations) {
		this.mongoOperations=mongoOperations;
	}
	public long generateSequence(String seqName) {
		AutogenerateId counter=mongoOperations.findAndModify(query(where("_id").is(seqName)),
				new Update().inc("seq",1), options().returnNew(true).upsert(true),AutogenerateId.class);
		
		return !Objects.isNull(counter)?counter.getSeq():1;
	}

}
