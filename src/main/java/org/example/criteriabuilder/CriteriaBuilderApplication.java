package org.example.criteriabuilder;

import org.example.criteriabuilder.service.IDeptService;
import org.example.criteriabuilder.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Logger;

@SpringBootApplication
public class CriteriaBuilderApplication implements CommandLineRunner {

	IDeptService deptService;
	IEmpService empService;
	private static final BufferedReader oInput = new BufferedReader(new InputStreamReader(System.in));
	Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	public CriteriaBuilderApplication(IDeptService deptService, IEmpService empService){
		this.deptService = deptService;
		this.empService = empService;
	}

	public static void main(String[] args) {
		SpringApplication.run(CriteriaBuilderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		int valore;
		do {
			logger.info("Inserisci numero esercizio: ");
			valore = Integer.parseInt(oInput.readLine());
			switch(valore)
			{
				case 1: this.empService.esercizio1(); break;
			}
		} while (valore != 0);
	}
}
