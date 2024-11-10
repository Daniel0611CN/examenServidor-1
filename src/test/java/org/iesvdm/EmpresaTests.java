package org.iesvdm;

import jakarta.persistence.EntityManager;
import org.iesvdm.repository.DepartamentoRepository;
import org.iesvdm.modelo.Departamento;
import org.iesvdm.repository.EmpleadoRepository;
import org.iesvdm.modelo.Empleado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static java.util.Comparator.*;
import java.util.*;
import java.util.function.Function;
import static java.util.stream.Collectors.*;

@SpringBootTest
class EmpresaTests {

    @Autowired
    DepartamentoRepository depRepo;
    @Autowired
    EmpleadoRepository empRepo;

    @Test
    void testAllDepartamento() {
        var listDeps = depRepo.findAll();

        listDeps.forEach(d -> {
            System.out.println(">>"+d+ ":");
            d.getEmpleados().forEach(System.out::println);
        });

    }

    @Test
    void testAllEmpleado() {
        var listEmps = empRepo.findAll();

        listEmps.forEach( e -> {
            System.out.println(">>"+e+":"+"\nEmpleados mismo departamento "+ e.getDepartamento());
            var dep = e.getDepartamento();
            if ( dep != null)
                dep.getEmpleados().forEach(eD -> System.out.println(">>>>"+eD));
        });

    }

    /**
     * 1. Lista el código de los departamentos de los empleados, 
     * eliminando los códigos que aparecen repetidos.
     */
    @Test
    void test1() {
        var listEmps = empRepo.findAll();
        System.out.println("Lista de códigos de los departamentos de los Empleados que no se repiten\n");

        listEmps.forEach(e -> { if (e.getDepartamento() != null && e.getDepartamento().getEmpleados().size() == 1) System.out.println(">>" + e + ":\n>>>>" + e.getDepartamento().getCodigo()); });
    }

    /**
     * 2. Lista el nombre y apellidos de los empleados en una única columna, convirtiendo todos los caracteres en mayúscula 
     *
     */
    @Test
    void test2() {
        var listEmp = empRepo.findAll();
        System.out.println("Nombre y Apellidos de los Empleados en Mayúscula\n");

        listEmp.forEach(e -> { if (e.getApellido2() != null)
            System.out.println(">>" + e + ":\n>>>>" + e.getNombre().toUpperCase() + " " + e.getApellido1().toUpperCase() + " " + e.getApellido2().toUpperCase()); });
    }

    /**
     * 3. Lista el código de los empleados junto al nif, pero el nif deberá aparecer en dos columnas, 
     * una mostrará únicamente los dígitos del nif y la otra la letra.
     */
    @Test
    void test3() {
        var listEmp = empRepo.findAll();
        System.out.println("Código y Nif (Separado) de los Empleados\n");

        listEmp.forEach(e -> System.out.println(">>" + e + ":\n>>>>" + e.getCodigo() + " -> " + e.getNif().substring(0, e.getNif().length() - 1)  + " - " + e.getNif().substring(e.getNif().length() - 1)));
    }

    /**
     * 4. Lista el nombre de cada departamento y el valor del presupuesto actual del que dispone. 
     * Para calcular este dato tendrá que restar al valor del presupuesto inicial (columna presupuesto) los gastos que se han generado (columna gastos).
     *  Tenga en cuenta que en algunos casos pueden existir valores negativos.
     */
    @Test
    void test4() {
        var listDep = depRepo.findAll();
        System.out.println("Nombre y Valor del Presupuesto Actual de cada Departamento\n");

        listDep.forEach(d -> { if (d.getPresupuesto() - d.getGastos() >= 0) System.out.println(">>" + d + ":\n" + ">>>>" + d.getNombre() + " -> " + (d.getPresupuesto() - d.getGastos())); });
    }

    /**
     * 5. Lista el nombre de los departamentos y el valor del presupuesto actual ordenado de forma ascendente.
     */
    @Test
    void test5() {
        var listDep = depRepo.findAll();
        System.out.println("Nombres y Presupuesto de los Departamentos de forma Ascendente\n");

        listDep.stream()
                .sorted(comparing(Departamento::getPresupuesto))
                .forEach(d -> System.out.println(">>" + d + ":\n>>>>" + d.getNombre() + " -> " + d.getPresupuesto()));
     }

    /**
     * 6. Devuelve una lista con el nombre y el presupuesto, de los 3 departamentos que tienen mayor presupuesto
     */
    @Test
    void test6() {
        var listDep = depRepo.findAll();
        System.out.println("Nombre y Presupuesto de los 3 Departamentos con mayor Presupuesto\n");

        listDep.stream()
                .sorted(comparing(Departamento::getPresupuesto, reverseOrder()))
                .limit(3)
                .forEach(d -> System.out.println(">>" + d + ":\n>>>>" + d.getNombre() + " -> " + d.getPresupuesto()));
     }

    /**
     * 7. Devuelve una lista con el nombre de los departamentos y el presupesto, de aquellos que tienen un presupuesto entre 100000 y 200000 euros
     */
    @Test
    void test7() {
        var listDep = depRepo.findAll();
        System.out.println("Nombre y Presupuesto de los Departamentos con Presupuesto entre 100000 y 200000 euros\n");

        listDep.forEach(d -> { if (d.getPresupuesto() >= 100000 && d.getPresupuesto() <= 200000) System.out.println(">>" + d + ":\n>>>>" + d.getNombre() + " -> " + d.getPresupuesto()); });
     }

    /**
     * 8. Devuelve una lista con 5 filas a partir de la tercera fila de empleado ordenado por código de empleado. La tercera fila se debe incluir en la respuesta.
     */
    @Test
    void test8() {
        var listEmp = empRepo.findAll();
        System.out.println("Lista con 5 filas a partir de la 3 por código empleado\n");

        listEmp.stream()
                .sorted(comparing(Empleado::getCodigo))
                .skip(2)
                .limit(5)
                .forEach(e -> System.out.println(">>" + e + ":"));
    }

    /**
     * 9. Devuelve una lista con el nombre de los departamentos y el gasto, de aquellos que tienen menos de 5000 euros de gastos.
     * Ordenada de mayor a menor gasto.
     */
    @Test
    void test9() {
        var listDep = depRepo.findAll();
        System.out.println("Nombres de los Departamentos y Gasto Menor de 5000\n");

        listDep.stream().
                sorted(comparing(Departamento::getGastos, reverseOrder()))
                .forEach(d -> { if (d.getGastos() < 5000) System.out.println(">>" + d + ":\n>>>>" + d.getNombre() + " -> " + d.getGastos()); });
    }

    /**
     * 10. Lista todos los datos de los empleados cuyo segundo apellido sea Díaz o Moreno
     */
    @Test
    void test10() {
        var listEmp = empRepo.findAll();
        System.out.println("Lista todos los datos de los Empleados con segundo apellido Díaz o Moreno\n");

        Set<String> apellidos = Set.of("Díaz", "Moreno");
        listEmp.forEach(e -> { if (e.getApellido2() != null && apellidos.contains(e.getApellido2())) System.out.println(">>" + e + ":"); });
    }

    /**
     * 11. Lista los nombres, apellidos y nif de los empleados que trabajan en los departamentos 2, 4 o 5
     */
    @Test
    void test11() {
        var listEmp = empRepo.findAll();
        System.out.println("Lista de nombres, apellidos y nif de los empleados con código 2, 4 o 5\n");

        Set<Integer> codigos = Set.of(2, 4, 5);
        listEmp.forEach(e -> { if (e.getDepartamento() != null && codigos.contains(e.getDepartamento().getCodigo()))
            System.out.println(">>" + e + ":\n>>>>" + e.getNombre() + " " + e.getApellido1() + " " + e.getApellido2() + " " + e.getNif()); });
    }

    /**
     * 12. Devuelve el nombre del departamento donde trabaja el empleado que tiene el nif 38382980M
     */
    @Test
    void test12() {
        var listEmp = empRepo.findAll();
        System.out.println("Nombre del Departamento trabaja Nif 38382980M\n");

        listEmp.forEach(e -> { if (e.getDepartamento() != null && e.getNif().equals("38382980M")) System.out.println(">>" + e + ":\n>>>>" + e.getDepartamento().getNombre()); });
    }

    /**
     * 13. Devuelve una lista con el nombre de los empleados que tienen los departamentos 
     * que no tienen un presupuesto entre 100000 y 200000 euros.
     */
    @Test
    void test13() {
        var listEmp = empRepo.findAll();
        System.out.println("Nombre Empleados con Departamentos sin Presupuesto Entre 100000 y 200000\n");

        listEmp.forEach(e -> { if (e.getDepartamento() != null && (e.getDepartamento().getPresupuesto() < 100000 || e.getDepartamento().getPresupuesto() > 200000))
            System.out.println(">>" + e + ":\n>>>>" + e.getNombre()); });
    }

    /**
     * 14. Calcula el valor mínimo del presupuesto de todos los departamentos.
     */
    @Test
    void test14() {
        var listDep = depRepo.findAll();
        System.out.println("Valor mínimo del presupuesto de los departamentos\n");

        System.out.println(">>" + listDep.stream().min(comparing(Departamento::getPresupuesto))
                + ":\n>>>>" + listDep.stream().min(comparing(Departamento::getPresupuesto)).map(Departamento::getPresupuesto));
     }

    /**
     * 15. Calcula el número de empleados que hay en cada departamento. 
     * Tienes que devolver dos columnas, una con el nombre del departamento 
     * y otra con el número de empleados que tiene asignados.
     */
    @Test
    void test15() {
        var listDep = depRepo.findAll();
        System.out.println("Número de empleados en cada departamento\n");

        listDep.forEach(d -> System.out.println(">>" + d + ":\n>>>>" + d.getNombre() + " -> " + d.getEmpleados().size()));
     }

    /**
     * 16. Calcula el número total de empleados que trabajan en cada unos de los departamentos que tienen un presupuesto mayor a 200000 euros.
     */
    @Test
    void test16() {
        var listDep = depRepo.findAll();
        System.out.println("Total de empleados en cada departamento con presupuesto mayor a 200000\n");

        listDep.forEach(d -> { if (d.getPresupuesto() > 200000) System.out.println(">>" + d + ":\n>>>>" + d.getEmpleados().size()); });
     }

    /**
     * 17. Calcula el nombre de los departamentos que tienen más de 2 empleados. 
     * El resultado debe tener dos columnas, una con el nombre del departamento y
     *  otra con el número de empleados que tiene asignados
     */
    @Test
    void test17() {
        var listDep = depRepo.findAll();
        System.out.println("Nombre de los departamentos con más de 2 Empleados\n");

        listDep.forEach(d -> { if (d.getEmpleados().size() > 2) System.out.println(">>" + d + ":\n>>>>" + d.getNombre() + " - " + d.getEmpleados().size()); });
     }

    /** 18. Lista todos los nombres de departamentos junto con los nombres y apellidos de los empleados. 
     *
     */
    @Test
    void test18() {
        var listDep = depRepo.findAll();
        System.out.println("Nombres de departamentos y Nombres y Apellidos de Empleados\n");

        listDep.forEach(d -> System.out.println(">>" + d + ":\n>>>>" + d.getNombre() + ", " + d.getEmpleados().stream()
                .map(e -> e.getNombre() + " " +  e.getApellido1() + " " + e.getApellido2()).toList()));
     }

    /**
     * 19. Devuelve la media de empleados que trabajan en los departamentos
     */
     @Test
    void test19() {
        var listDep = depRepo.findAll();
        System.out.println("Media de empleados que trabajan en los Departamentos\n");

        System.out.println(">>>>" + listDep.stream()
                .mapToDouble(d -> d.getEmpleados().size()).average());
   }

    /**
     * 20. Calcula el presupuesto máximo, mínimo  y número total de departamentos con un solo stream.
     */
    @Test
    void test20() {
        var listDep = depRepo.findAll();
        System.out.println("Presupuesto máximo, mínimo y total de departamentos en un solo stream\n");

        System.out.println(Arrays.toString(listDep.stream()
                                .map(p -> new Double[]{p.getPresupuesto(), p.getPresupuesto(), 1.0})
                                .reduce((doubles, doubles2) -> new Double[]{
                                        Math.max(doubles[0], doubles2[0]), Math.min(doubles[1], doubles2[1]), doubles[2] + doubles2[2]})
                                .orElse(new Double[]{})));
    }

}
