package com.ng.springbootawssns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;

@SpringBootApplication
public class SpringBootAwsSnsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAwsSnsApplication.class, args);
		
		System.out.println("++Hello from AWS ++++++++++++");
	
		String ARN ="arn:aws:sns:us-east-1:751485448741:First_Topic";
		String message ="Hello from the improved code";
		String subject="MY AWS SNS test second";
		String accessKey="test";
		String secretKey="test";
		
		AmazonSNS snsClient = AmazonSNSClientBuilder.standard()
                .withRegion(Regions.US_EAST_1)
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)))
                .build();   
		PublishRequest pr = new PublishRequest(ARN, message, subject);
		PublishResult result = snsClient.publish(pr); 
		
	}

	

      
	
	


}


