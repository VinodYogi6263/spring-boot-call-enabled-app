package com.rajguru;

import java.net.URI;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;

@SpringBootApplication
public class SpringBootCallEnabledAppApplication implements ApplicationRunner {

	private final static String TO_NUMBER = "916263815568";
	private final static String ACCOUNT_SID = "ACb55e57ead98b83bc79bb30f9a73e49f1";

	private final static String AUTH_ID = "92fde7aaa9c47d35ad6bb52e1060f201";

	private final String FROM_NUMBER = "+12296096783";

	static {
		Twilio.init(ACCOUNT_SID, AUTH_ID);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCallEnabledAppApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Call create = Call.creator(new PhoneNumber(TO_NUMBER), new PhoneNumber(FROM_NUMBER),
				new URI("http://demo.twilio.com/docs/voice.xml")).create();
		System.out.println(create);

	}

}
