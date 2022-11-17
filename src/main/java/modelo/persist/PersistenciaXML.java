package modelo.persist;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import exceptions.ArchivoNoInciliazadoException;

public class PersistenciaXML implements IPersistencia {
	
	private XMLEncoder xmlEncoder;
    private XMLDecoder xmlDecoder;
    private FileOutputStream fileoutput;
    private FileInputStream fileinput;
    
	@Override
	public void openInput(String name) throws IOException, FileNotFoundException {
		// TODO Auto-generated method stub
		fileinput = new FileInputStream(name);
        xmlDecoder = new XMLDecoder(fileinput);
		
	}
	@Override
	public void openOutput(String name) throws IOException, FileNotFoundException {
		// TODO Auto-generated method stub
		fileoutput = new FileOutputStream(name);
        xmlEncoder = new XMLEncoder(fileoutput);
	}
	
	@Override
	public void closeInput() throws IOException, ArchivoNoInciliazadoException {
		// TODO Auto-generated method stub
		if(xmlEncoder != null)
    		this.xmlEncoder.close();
		
	}
	
	@Override
	public void closeOutput() throws IOException, ArchivoNoInciliazadoException {
		// TODO Auto-generated method stub
		if(xmlDecoder != null)
    		this.xmlDecoder.close();
		
		
	}
	
	@Override
	public void writeFile(Object object) throws IOException, ArchivoNoInciliazadoException {
		// TODO Auto-generated method stub
		if(xmlEncoder != null)
        	xmlEncoder.writeObject(object);
		
	}
	
	@Override
	public Object readFile() throws IOException, ClassNotFoundException, ArchivoNoInciliazadoException {
		// TODO Auto-generated method stub
		Object objecto = null;
        if (xmlDecoder != null)
            objecto =  xmlDecoder.readObject();

        return objecto;
	}
    
}
