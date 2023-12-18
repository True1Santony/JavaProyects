package tarea;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
//import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
 * Esta clase, con metodo main, desarrolla toda la lógica del programa. 
 * Usa las clases: DatosCenso<Ayuntamiento. Lee el .xml con DOM las etiquetas, elementos y posteriormente
 * almacena su contenido en las clases y atributos correspondientes.
 * Posteriormente se lee con JAXB las clases que almacenan los param. del .xml
 * para almacenarlos en un .xml nuevo.
 * JAXB necesita de una version JAVA compatible y su libreria
 * UsadoJava SE 1.5 y agregado jaxb-api
 * 
 * @author espar
 * @version 3
 */
public class Logica {

	public static void main(String[] args) {
		
		
		DatosCenso datosCenso=new DatosCenso();
		ArrayList<Ayuntamientos> ayuntamientos = new ArrayList<Ayuntamientos>();
		
		int totalVotantes=0, totalConcejales=0;
		
		try {
			
			// Java DOM
	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder;
			builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("escrutinio_municipales_2015.xml"));
			
			 NodeList escrutinioSitioNodes = document.getElementsByTagName("escrutinio_sitio");
			 
			 for (int i = 0; i < escrutinioSitioNodes.getLength(); i++) {
				 
				 Element escrutinioSitioElement = (Element) escrutinioSitioNodes.item(i);
				 
				 String numAElegir = escrutinioSitioElement.getElementsByTagName("num_a_elegir").item(0).getTextContent();
				 totalConcejales+=Integer.parseInt(numAElegir);
				 
				 String ts = escrutinioSitioElement.getElementsByTagName("ts").item(0).getTextContent();
				 String nombreSitio = escrutinioSitioElement.getElementsByTagName("nombre_sitio").item(0).getTextContent();
				 
				 Ayuntamientos ayuntamiento= new Ayuntamientos();
				 ayuntamiento.setConcejales(numAElegir);
				 ayuntamiento.setTs(ts);
				 ayuntamiento.setNombre(nombreSitio);
				 
				 NodeList contabilizadosNodes = escrutinioSitioElement.getElementsByTagName("contabilizados");
				 NodeList abstencionesNodes = escrutinioSitioElement.getElementsByTagName("abstenciones");
				 
				 Element contabilizadosElement = (Element) contabilizadosNodes.item(0);
				 Element abstencionesElement = (Element) abstencionesNodes.item(0);
				 int contabilizados = Integer.parseInt(contabilizadosElement.getElementsByTagName("cantidad").item(0).getTextContent());
				 int abstenciones = Integer.parseInt(abstencionesElement.getElementsByTagName("cantidad").item(0).getTextContent());
				 
				 totalVotantes+=(contabilizados+abstenciones);
				 String sTotalVotantes = String.valueOf(contabilizados+abstenciones);
				 
				 
				 ayuntamiento.setVotantes(sTotalVotantes);
				 
				 
				 ayuntamientos.add(ayuntamiento);
			 }
			 
			 datosCenso.setTitulo("datos censo ayuntamientos comunidad madrid");
			 datosCenso.setAyuntamientos(ayuntamientos);
			 datosCenso.setTotal_votantes(String.valueOf(totalVotantes));
			 datosCenso.setTotal_concejales(String.valueOf(totalConcejales));
			 
			//impresion temporal para pruebas
			 
			 //System.out.println(datosCenso.getTitulo());
			 //System.out.println(datosCenso.getTotal_votantes());
			 /*for(Ayuntamientos a:ayuntamientos) {
				 
				 System.out.println(a);
			 }*/
			 
			 //Java JAXB
			 
			 JAXBContext context =JAXBContext.newInstance(DatosCenso.class);
			 
			 Marshaller marshaller=context.createMarshaller();
			 marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);//formateo
			 marshaller.marshal(datosCenso, new File("censo.xml"));// cambiar la salida a un file
			 
			 System.out.println(" 'censo.xml', con los datos, ha sido creado con éxito en la raiz del proyecto");
			 
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
		
		
		//lectura del xml y almacenamiento en las sig. cases EscrutinioSitios<Votos<Abstenciones,Contabilizados
		/*try {
			
			JAXBContext context = JAXBContext.newInstance(Elecciones.class);
			
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Elecciones elecciones = (Elecciones)unmarshaller.unmarshal(new File("escrutinio_municipales_2015.xml"));
			
			//System.out.println(elecciones.getEscrutinioSitios());
			
			ArrayList<EscrutinioSitios> escrutinios = elecciones.getEscrutinioSitios();
			
			for(EscrutinioSitios e: escrutinios) {
				
				System.out.println(e);
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		

	}

}
