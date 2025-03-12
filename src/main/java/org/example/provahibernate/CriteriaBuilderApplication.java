package org.example.provahibernate;

import org.example.provahibernate.service.IDeptService;
import org.example.provahibernate.service.IEmpService;
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

				case 2: this.empService.esercizio2(); break;

				case 3: this.empService.esercizio3(); break;

				case 4: this.empService.esercizio4(); break;

				case 5: this.empService.esercizio5(); break;

				case 6: this.empService.esercizio6(); break;

				case 7: this.empService.esercizio7(); break;

				case 8: this.empService.esercizio8(); break;

				case 9: this.empService.esercizio9(); break;

				case 10: this.empService.esercizio10(); break;

				case 11: this.empService.esercizio11(); break;

				case 12: this.empService.esercizio12(); break; //Function usata in maniera impropria?

				case 13: this.empService.esercizio13(); break;

				case 14: this.empService.esercizio14(); break;

				case 15: this.empService.esercizio15(); break;

				case 16: this.empService.esercizio16(); break;

				case 17: this.empService.esercizio17(); break;

				case 18: this.empService.esercizio18(); break;

				case 19: this.empService.esercizio19(); break;

				case 20: this.empService.esercizio20(); break;

				case 21: this.empService.esercizio21(); break;

				case 22: this.empService.esercizio22(); break;

				case 23: this.empService.esercizio23(); break;

				case 24: this.empService.esercizio24(); break;

				case 25: this.empService.esercizio25(); break;

				case 26: this.empService.esercizio26(); break;

				case 27: this.empService.esercizio27(); break;

				case 28: this.empService.esercizio28(); break;

				case 29: this.empService.esercizio29(); break;

				case 30: this.empService.esercizio30(); break;

				case 31: this.empService.esercizio31(); break;

				case 32: this.empService.esercizio32(); break;

				case 33: this.empService.esercizio33(); break;

				case 34: this.empService.esercizio34(); break;

				case 35: this.empService.esercizio35(); break;

				case 36: this.empService.esercizio36(); break;

				case 37: this.empService.esercizio37(); break;

				case 38: this.empService.esercizio38(); break;

				case 39: this.empService.esercizio39(); break;

				case 40: this.empService.esercizio40(); break;

				case 41: this.empService.esercizio41(); break;

				case 42: this.empService.esercizio42(); break;

				case 43: this.deptService.esercizio43(); break;

				case 44: this.empService.esercizio44(); break; //Modificare temporaneamente FetchType.EAGER per subordinati in Emp oppure spring.jpa.show-sql=false in properties per formattazione corretta

				case 45: this.empService.esercizio45(); break;

				case 46: this.empService.esercizio46(); break;

				case 47: this.empService.esercizio47(); break;

				case 48: this.empService.esercizio48(); break;

				case 49: this.empService.esercizio49(); break;

				case 50: this.empService.esercizio50(); break;

				case 51: this.deptService.esercizio51(); break;

				case 52: this.deptService.esercizio52(); break;

				case 53: this.empService.esercizio53(); break;

				case 54: this.empService.esercizio54(); break;

				case 55: this.empService.esercizio55(); break;

				case 56: this.empService.esercizio56(); break;

				case 57: this.empService.esercizio57(); break;

				case 58: this.empService.esercizio58(); break;

				case 59: this.empService.esercizio59(); break;

				case 60: this.empService.esercizio60(); break;

				case 61: this.empService.esercizio61(); break; //spring.jpa.hibernate.ddl-auto=update nelle properties per far creare la tabella Emp1 a Hibernate

				case 62: break; //stesso concetto del 61

				case 63: this.empService.esercizio63(); break;

				case 64: this.empService.esercizio64(); break;

				case 65: this.empService.esercizio65(); break;

				case 66: this.empService.esercizio66(); break;

				case 67: this.empService.esercizio67(); break;

				case 68: this.empService.esercizio68(); break;  //Modificare temporaneamente FetchType.EAGER per subordinati in Emp oppure spring.jpa.show-sql=false in properties per migliore output in console

				case 69: this.empService.esercizio69(); break;

				case 70: this.empService.esercizio70(); break;

				case 71: this.empService.esercizio71(); break;

				case 72: this.empService.esercizio72(); break;

				case 73: this.empService.esercizio73(); break;

				case 74: this.empService.esercizio74(); break;

				case 75: this.empService.esercizio75(); break;

				case 76: this.empService.esercizio76(); break;

				case 77: this.empService.esercizio77(); break;

				case 78: this.empService.esercizio78(); break;

				case 79: this.empService.esercizio79(); break;

				case 80: this.empService.esercizio80(); break;

				case 81: this.empService.esercizio81(); break;

				case 82: this.empService.esercizio82(); break; //Function usata in maniera impropria?

				case 83: break; //saltato

				case 84: this.empService.esercizio84(); break;

				case 85: this.empService.esercizio85(); break;

				case 86: break; //this.empService.esercizio86();

				case 87: this.empService.esercizio87(); break;

				case 88: this.deptService.esercizio88(); break;

				case 89: this.empService.esercizio89(); break;

				case 90: this.empService.esercizio90(); break;

				case 91: this.empService.esercizio91(); break;

				case 92: this.empService.esercizio92(); break;

				case 93: this.empService.esercizio93(); break;

				case 94: this.empService.esercizio94(); break; //Function usata in maniera impropria?

				case 95: this.empService.esercizio95(); break;

				case 96: this.empService.esercizio96(); break;

				case 97: this.empService.esercizio97(); break;

				case 98: this.empService.esercizio98(); break;

				case 99: this.empService.esercizio99(); break;

				case 100: this.empService.esercizio100(); break;

				case 101: this.empService.esercizio101(); break;
			}
		} while (valore != 0);





	}

}
