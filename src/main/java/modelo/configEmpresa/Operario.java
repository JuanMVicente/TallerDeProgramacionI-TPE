package modelo.configEmpresa;

import enums.TipoOperario;
import modelo.persist.OperarioDTO;

public class Operario {
    private static int nroOperario = 0;
    private int id;
    private String nombreApellido;
    private String nombreUsuario;
    private String password;
    private boolean activo;

    
    /**
     * Se encarga de crear un opeario nuevo si la contraseña es valida, este operario es activo
     * @param nombreApellido : nombre y apellido
     * @param nombreUsuario : nombre de usuario
     * @param password : contraseña
     * pre: nombreApellido != null && nombreApellido != ""
     *      nombreUsuario != null && nombreUsuruaio != "" && nombreUsuario.length <= 10
     *      password != null && password.length <= 12 && password.length > 6
     *      password debe contener al menos una letra mayuscula
     *      password debe contener al menos un numero
     * post: se retorna un operario nuevo activo
     */
    public Operario(String nombreApellido, String nombreUsuario, String password) {
    	this.nombreApellido = nombreApellido;
    	this.nombreUsuario = nombreUsuario;
    	this.password = password;
    	this.activo = false;
    	this.id = Operario.nroOperario;
    	Operario.setNroOperario(Operario.nroOperario + 1);
    }
    	
    
    public Operario() {}//borrar despues, lo hice para hacer pruebas
    
    
    /**
     * Retorna el Id del operario
     * @return id Operario
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna el nombre completo del operario
     * @return nombre completo
     */
    public String getNombreApellido() {
        return nombreApellido;
    }

    /**
     * Retorna el nombre de usuario del operario
     * @return nombre de usuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Retorna si el operario esta activo
     * @return si esta activo el operario
     */
    public Boolean isActivo() {
        return activo;
    }

    /**
     * Define un numero de operarios
     * @param nroOperario
     */
    protected static void setNroOperario(int nroOperario){
    	Operario.nroOperario = nroOperario;
    }
    

    /**
     * Retorna el numero de operarios
     * @return Numero de operarios
     */
    protected static int getNroOperario(){
    	return Operario.nroOperario;
    }

    
    /**
     * Informa si el operario esta calificado para gestionar mesas
     * @return posibilidad de gestionar mesas
     */
    public boolean puedeGestionarMesas(){
    	return false;
    }

    
    /**
     * Informa si el operario esta calificado para gestioanr mozos
     * @return posibilidad de gestionar mozos
     */
    public boolean puedeGestionarMozos(){
    	return false;
    }

    
    /**
     * Informa si el operario esta calificado para gestionar productos
     * @return posibilidad de gestinar productos
     */
    public boolean puedeGestionarProductos(){
    	return false;
    }

    
    /**
     * Informa si el operario esta calificado para gestionar sueldo
     * @return posibilidad de gestionar sueldo
     */
    public boolean puedeGestionarSueldo(){
    	return false;
    }

    
    /**
     * Informa si el operario esta claificado para gestionar operarios
     * @return posibilidad de gestionar operarios
     */
    public boolean puedeGestionarOperarios(){
    	return false;
    }

    
    /**
     * Retorna un operarioDTO, para su transferencia de informacion
     * @return OperarioDTO correspondiente
     */
    protected OperarioDTO getOperarioDTO(){
    	return new OperarioDTO(TipoOperario.COMUN, this);
    }
    
    public String getPassword() {
    	return this.password;
    }
    
    public boolean getActivo() {
    	return this.activo;
    }

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}


	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setActivo(boolean activo) {
		this.activo = activo;
	}
    
    
    
}
