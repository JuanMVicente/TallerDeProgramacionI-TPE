
package modelo.empresa;

public abstract class Promocion {
 private int idprom;
 private int dias; // 1 Lunes - 2 Martes - 3 Miercoles - 4 Jueves - 5 Viernes - 6 Sabado - 7 Domingo
 private boolean activa;

 

 public Promocion(int idprom, int dias) {
	super();
	this.idprom = idprom;
	this.dias = dias;
	this.activa = true;
}
public void DesactivarPromocion() {
	this.activa=false;
	 
 }
public void ActivarPromocion() {
	 this.activa=true;
 }



public int getIdprom() {
	return idprom;
}
public int getDias() {
	return dias;
}
public boolean isActiva() {
	return activa;
}
 
 
}