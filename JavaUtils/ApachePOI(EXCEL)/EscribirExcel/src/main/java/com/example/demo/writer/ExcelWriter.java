package com.example.demo.writer;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.demo.rims.CabecerasRIMS;
import com.example.demo.rims.RIMS_DTO;


public class ExcelWriter { 

	public XSSFWorkbook init(XSSFWorkbook workbook, List<RIMS_DTO> listaRims) {
		
		
		XSSFSheet sheet = workbook.getSheet("DISCREPANCIAS");
	      
	    Map<String, Object[]> data = new TreeMap<String, Object[]>();
	
		Object[] objetoCabeceras=new Object[CabecerasRIMS.values().length];
		for (int i = 0; i < CabecerasRIMS.values().length; i++) {
			objetoCabeceras[i] = CabecerasRIMS.values()[i].name();
        }

	    if(sheet.getPhysicalNumberOfRows()==0) {
	    	data.put("1", objetoCabeceras); 
		    for(int n=0; n<(listaRims.size()); n++) {
		    	data.put(String.valueOf(n+2), devolverObjetoRIMScomoArrayObjectos(listaRims.get(n))); //n+2 porque necesitamos escribir en la 2 fila.
		    }
	    }else {
		    for(int n=0; n<(listaRims.size()); n++) {
		    	data.put(String.valueOf(n+sheet.getPhysicalNumberOfRows()+1), devolverObjetoRIMScomoArrayObjectos(listaRims.get(n)));  //+1 porque necesitamos escribir en la siguiente fila a el numero de filas que exista
		    }
	    }
	    
	      
	    //Iterate over data and write to sheet
	    Set<String> keyset = data.keySet();
	    int rownum = 0;

	    if(sheet.getPhysicalNumberOfRows()!=0) {
	    	 rownum = sheet.getPhysicalNumberOfRows();
	    }

	    for (String key : keyset){
	        Row row = sheet.createRow(rownum++);
	        Object [] objArr = data.get(key);
	        int cellnum = 0;
	        for (Object obj : objArr){
	        	
	           Cell cell = row.createCell(cellnum++);
	           	           
	           if(obj instanceof String) {
	                cell.setCellValue((String)obj);
	           }else if(obj instanceof Integer) {
	                cell.setCellValue((Integer)obj);
	           }

	        }
	    }
	    try{
	        return workbook; // contex-path
	       
	    } 
	    catch (Exception e){
	        e.printStackTrace();
	    }
	    return null; // quitarlo
	}
	
	private Object[] devolverObjetoRIMScomoArrayObjectos(RIMS_DTO dtoRims) {
		return new Object[]{dtoRims.getMotivo(),dtoRims.getDiscrepancia(),dtoRims.getTrade(),dtoRims.getSentido(),dtoRims.getIsin(),dtoRims.getEri(),dtoRims.getFecha(),dtoRims.getHora(),dtoRims.getCci(),dtoRims.getTitulos(),dtoRims.getBolsa(),dtoRims.getMiembro(),dtoRims.getCuenta(),dtoRims.getCcc(),dtoRims.getPlataforma(),dtoRims.getSegmento(),dtoRims.getOrdenante(),dtoRims.getRefext(),dtoRims.getTrade_tag(),dtoRims.getCoi(),dtoRims.getMercado(), dtoRims.getEstado(), dtoRims.getTitular()};
	}
	

}
