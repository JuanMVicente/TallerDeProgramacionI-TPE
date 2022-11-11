package main;

import modelo.configEmpresa.Operario;
import modelo.configEmpresa.OperarioAdmin;

public class Main {

    public static void main(String[] args){
    	
    	OperarioAdmin ope = new OperarioAdmin();
    	Operario ope2 = new OperarioAdmin();
    	Operario ope3= new Operario();
        System.out.println(ope.getClass().toString());
        System.out.println(ope2.getClass().toString());
        System.out.println(ope3.getClass().toString());
        System.out.println(ope.getClass().toString().equals("class modelo.configEmpresa.OperarioAdmin"));
        System.out.println(ope2.getClass().toString().equals("class modelo.configEmpresa.OperarioAdmin"));
        System.out.println(ope3.getClass().toString().equals("class modelo.configEmpresa.OperarioAdmin"));
        System.out.println(ope.puedeGestionarMesas());
        System.out.println(ope2.puedeGestionarMesas());
        System.out.println(ope3.puedeGestionarMesas());
    }
}
