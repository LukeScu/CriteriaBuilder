package org.example.criteriabuilder.service;

import jakarta.persistence.Tuple;
import org.example.criteriabuilder.entity.Emp;
import org.example.criteriabuilder.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class EmpService implements IEmpService{

    EmpRepository empRepository;
    private static final BufferedReader oInput = new BufferedReader(new InputStreamReader(System.in));

    @Autowired
    public EmpService(EmpRepository empRepository) {
        this.empRepository = empRepository;
    }

    @Override
    public void esercizio1() {
        List<Emp> lista = this.empRepository.esercizio1();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio2() {
        List<Emp> lista = this.empRepository.esercizio2();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio3() {
        List<Emp> lista = this.empRepository.esercizio3();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio4() {
        Long count = this.empRepository.esercizio4();
        System.out.println(count);
    }

    @Override
    public void esercizio5() {
        List<Emp> lista = this.empRepository.esercizio5();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio6() {
        List<Emp> lista = this.empRepository.esercizio6();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio7() {
        List<Emp> lista = this.empRepository.esercizio7();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio8() {
        List<Emp> lista = this.empRepository.esercizio8();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio9() {
        List<Tuple> lista = this.empRepository.esercizio9();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio10() {
        List<Emp> lista = this.empRepository.esercizio10();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio11() {
        List<Emp> lista = this.empRepository.esercizio11();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio12() {
        List<Tuple> lista = this.empRepository.esercizio12();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio13() {
        List<Emp> lista = this.empRepository.esercizio13();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio14() {
        List<Emp> lista = this.empRepository.esercizio14();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio15() {
        List<Emp> lista = this.empRepository.esercizio15();
        lista.forEach(System.out::println);
    }
    @Transactional
    @Override
    public void esercizio16() {
        List<Tuple> lista = this.empRepository.esercizio16();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio17() {
        List<Emp> lista = this.empRepository.esercizio17();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio18() {
        List<Emp> lista = this.empRepository.esercizio18();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio19() {
        List<Tuple> lista = this.empRepository.esercizio19();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio20() {
        List<Tuple> lista = this.empRepository.esercizio20();
        lista.forEach(System.out::println);
    }
    //Dual
    @Override
    public void esercizio21() {
        List lista = this.empRepository.esercizio21();
        lista.forEach(System.out::println);
    }
    //Dual
    @Override
    public void esercizio22() {
        List<Tuple> lista = this.empRepository.esercizio22();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio23() {
        List<Tuple> lista = this.empRepository.esercizio23();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio24() {
        List<Emp> lista = this.empRepository.esercizio24();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio25() {
        List<Tuple> lista = this.empRepository.esercizio25();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio26() {
        List<Tuple> lista = this.empRepository.esercizio26();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio27() {
        List<Tuple> lista = this.empRepository.esercizio27();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio28() {
        List<Tuple> lista = this.empRepository.esercizio28();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio29() {
        List<Tuple> lista = this.empRepository.esercizio29();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio30() {
        List<Tuple> lista = this.empRepository.esercizio30();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio31() {
        List<Tuple> lista = this.empRepository.esercizio31();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio32() {
        List<Tuple> lista = this.empRepository.esercizio32();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio33() {
        List<Emp> lista = this.empRepository.esercizio33();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio34() {
        List<Emp> lista = this.empRepository.esercizio34();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio35() {
        List<Emp> lista = this.empRepository.esercizio35();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio36() {
        List<Emp> lista = this.empRepository.esercizio36();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio37() {
        List<Tuple> lista = this.empRepository.esercizio37();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio38() {
        List<Tuple> lista = this.empRepository.esercizio38();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio39() {
        List<Emp> lista = this.empRepository.esercizio39();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio40() {
        List<Emp> lista = this.empRepository.esercizio40();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio41() {
        List<Emp> lista = this.empRepository.esercizio41();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio42() {
        List<Tuple> lista;
        try {
            System.out.println("Vuoi selezionare l'esercizio42A(1) oppure l'esercizio42B(2) ?");
            int valore = Integer.parseInt(oInput.readLine());
            if(valore == 1) { //Salario + alto
                lista = this.empRepository.esercizio42A();
                lista.forEach(System.out::println);
            } else if(valore == 2) { //Salario + basso
                lista = this.empRepository.esercizio42B();
                lista.forEach(System.out::println);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Modificare temporaneamente FetchType.EAGER per subordinati in Emp oppure spring.jpa.show-sql=false in properties per formattazione corretta
    @Override
    @Transactional
    public void esercizio44() {
        List<Emp> lista = this.empRepository.esercizio44();
        for (Emp manager : lista) {
            stampaGerarchia(manager, 0);
        }
    }
    //Per esercizio44
    public void stampaGerarchia(Emp employee, int level) {
        String indentazione = " ".repeat(level + 12);
        System.out.println(indentazione + employee.getEname());

        if (employee.getSubordinati() != null) {
            for (Emp subordinato : employee.getSubordinati()) {
                stampaGerarchia(subordinato, level + 1);
            }
        }
    }

    @Override
    public void esercizio45() {
        List<Tuple> lista = this.empRepository.esercizio45();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio46() {
        List<Tuple> lista = this.empRepository.esercizio46();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio47() {
        List<Tuple> lista = this.empRepository.esercizio47();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio48() {
        List<Tuple> lista = this.empRepository.esercizio48();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio49() {
        List<Tuple> lista = this.empRepository.esercizio49();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio50() {
        List<Tuple> lista = this.empRepository.esercizio50();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio53() {
        List<Tuple> lista = this.empRepository.esercizio53();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio54() {
        List<Tuple> lista = this.empRepository.esercizio54();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio55() {
        List<Tuple> lista = this.empRepository.esercizio55();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio56() {
        List<Tuple> lista = this.empRepository.esercizio56();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio57() {
        List<Tuple> lista = this.empRepository.esercizio57();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio58() {
        List<Emp> lista = this.empRepository.esercizio58();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio59() {
        List<Emp> lista = this.empRepository.esercizio59();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio60() {
        List<Emp> lista = this.empRepository.esercizio60();
        Double previousSal = 0D;
        for (Emp emp : lista) {
            Double salDiff = emp.getSal() - previousSal;
            System.out.println("Empno: " + emp.getEmpId() +
                    ", Ename: " + emp.getEname() +
                    ", Job: " + emp.getJob() +
                    ", Sal: " + emp.getSal() +
                    ", Sal_prev: " + previousSal +
                    ", Sal_diff: " + salDiff);

            previousSal = emp.getSal();
        }
    }

    @Override
    @Transactional
    public void esercizio61() {
        this.empRepository.esercizio61();
    }

    @Override
    @Transactional
    public void esercizio63() {
        this.empRepository.esercizio63();
    }

    @Override
    public void esercizio64() {
        List<Emp> lista = this.empRepository.esercizio64();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio65() {
        List<Emp> lista = this.empRepository.esercizio65();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio66() {
        List<Emp> lista = this.empRepository.esercizio66();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio67() {
        List<Emp> lista = this.empRepository.esercizio67();
        lista.forEach(System.out::println);
    }

    //Modificare temporaneamente FetchType.EAGER per subordinati in Emp oppure spring.jpa.show-sql=false in properties per migliore output in console
    @Override
    @Transactional
    public void esercizio68() {
        List<Emp> lista = this.empRepository.esercizio68();
        for (Emp emp : lista) {
            stampaGerarchia68(emp);
        }
    }

    //Per esercizio68
    public void stampaGerarchia68(Emp employee) {
        System.out.println(employee.getEname());
        if (employee.getSubordinati() != null) {
            for (Emp subordinato : employee.getSubordinati()) {
                stampaGerarchia68(subordinato);
            }
        }
    }

    @Override
    public void esercizio69() {
        List<Emp> lista = this.empRepository.esercizio69();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio70() {
        List<Emp> lista = this.empRepository.esercizio70();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio71() {
        List<Emp> lista = this.empRepository.esercizio71();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio72() {
        List<Emp> lista = this.empRepository.esercizio72();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio73() {
        List<Emp> lista = this.empRepository.esercizio73();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio74() {
        List<Emp> lista = this.empRepository.esercizio74();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio75() {
        List<Tuple> lista = this.empRepository.esercizio75();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio76() {
        List<Tuple> lista = this.empRepository.esercizio76();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio77() {
        List<Tuple> lista = this.empRepository.esercizio77();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio78() {
        List<Tuple> lista = this.empRepository.esercizio78();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio79() {
        List<Tuple> lista = this.empRepository.esercizio79();
        lista.forEach(System.out::println);
    }

    @Override
    @Transactional
    public void esercizio80() {
        this.empRepository.esercizio80();
    }

    @Override
    @Transactional
    public void esercizio81() {
        this.empRepository.esercizio81();
    }

    @Override
    @Transactional
    public void esercizio82() {
        this.empRepository.esercizio82();
    }

    @Override
    @Transactional
    public void esercizio84() {
        this.empRepository.esercizio84();
    }

    @Override
    @Transactional
    public void esercizio85() {
        this.empRepository.esercizio85();
    }

    /*
    @Override
    @Transactional
    public void esercizio86() {
        this.empRepository.esercizio86();
    }
    */

    @Override
    @Transactional
    public void esercizio87() {
        this.empRepository.esercizio87();
    }

    @Override
    @Transactional
    public void esercizio89() {
        this.empRepository.esercizio89();
    }

    @Override
    @Transactional
    public void esercizio90() {
        this.empRepository.esercizio90();
    }

    @Override
    @Transactional
    public void esercizio91() {
        this.empRepository.esercizio91();
    }

    @Override
    @Transactional
    public void esercizio92() {
        this.empRepository.esercizio92();
    }

    @Override
    @Transactional
    public void esercizio93() {
        this.empRepository.esercizio93();
    }

    @Override
    @Transactional
    public void esercizio94() {
        this.empRepository.esercizio94();
    }

    @Override
    @Transactional
    public void esercizio95() {
        this.empRepository.esercizio95();
    }

    @Override
    @Transactional
    public void esercizio96() {
        this.empRepository.esercizio96();
    }

    @Override
    @Transactional
    public void esercizio97() {
        this.empRepository.esercizio97();
    }

    @Override
    @Transactional
    public void esercizio98() {
        this.empRepository.esercizio98();
    }

    @Override
    @Transactional
    public void esercizio99() {
        this.empRepository.esercizio99();
    }

    @Override
    @Transactional
    public void esercizio100() {
        this.empRepository.esercizio100();
    }

    @Override
    @Transactional
    public void esercizio101() {
        this.empRepository.esercizio101();
    }
}
