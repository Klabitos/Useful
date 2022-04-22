package com.example.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.SpringApplication;

import com.example.demo.rims.CabecerasRIMS;
import com.example.demo.rims.RIMS_DTO;
import com.example.demo.writer.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EscribirExcelApplication {
	
	

	public static void main(String[] args) throws IOException {
		SpringApplication.run(EscribirExcelApplication.class, args);
		
		ExcelWriter writer = new ExcelWriter();
	    RIMS_DTO ejemploDTO = new RIMS_DTO("A AN Discrepa en RIMS","cuentaRM: ","TRADE","V","ES0113211835",914285896,20220414,142858,"",8093430,9575,"","EQ2","0414012286862337","XMAD","EQ","AAAAAAAAAAAAAAAA",0000002,83927538,"BBVAESMMXXX20220414142858930RS","XMAD", "", "");
	    RIMS_DTO ejemploDTO2 = new RIMS_DTO("B AN Discrepa en RIMS","cuentaRM: ","TRADE","V","ES0113211835",914285896,20220414,142858,"",8093430,9575,"","EQ2","0414012286862337","XMAD","EQ","AAAAAAAAAAAAAAAA",0000002,83927538,"BBVAESMMXXX20220414142858930RS","XMAD", "", "");
	    List<RIMS_DTO> listaRims = new ArrayList<RIMS_DTO>();
	    listaRims.add(ejemploDTO);
	    listaRims.add(ejemploDTO2);
		
	    //EN EL LOAD ROUTES
	    XSSFWorkbook workbook = new XSSFWorkbook(); 
	    XSSFSheet sheet = workbook.createSheet("DISCREPANCIAS"); 
	    
		writer.init(workbook, listaRims); //en el context-path EL WORKBOOK
		writer.init(workbook, listaRims);
		writer.init(workbook, listaRims);
		writer.init(workbook, listaRims);
		writer.init(workbook, listaRims);
		writer.init(workbook, listaRims);
		

    	String ruta = "C:\\Users\\pcruzrod\\Desktop\\tarea\\"; //CONSTANTES
    	String nombreFichero = "discrepanciasRIMS";	
    	for (int i = 0; i < CabecerasRIMS.values().length; i++) {
    		sheet.autoSizeColumn(i);
        }
    	FileOutputStream out = new FileOutputStream(new File(ruta+nombreFichero+".xlsx")); //en un tasklet final
        workbook.write(out);
	    out.close();
	    workbook.close();  
	    System.out.println(nombreFichero+".xlsx written successfully on disk."); //TODO Cambiar a logger

	}

}
