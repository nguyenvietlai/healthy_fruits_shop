package www.HealthyShop2023.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jakarta.servlet.http.HttpServletRequest;
import www.HealthyShop2023.Model.Product;
import www.HealthyShop2023.collections.SortByName;
import www.HealthyShop2023.collections.SortByPrice;



public class import_fileExcel {
	 static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	public static List<Product> importByExecl( FileInputStream file) {
		List<Product> prodata = new ArrayList<>(); 
		try {
			XSSFWorkbook wb = new XSSFWorkbook (file);
			XSSFSheet sheet = wb.getSheetAt(0);
			
			
			int RowSheet = sheet.getLastRowNum();
			for(int i = 1 ; i <= RowSheet ; i++) {
				Row row = sheet.getRow(i);
//				new DataFormatter().formatCellValue(row.getCell(1));
				Long id = Long.valueOf(new DataFormatter().formatCellValue(row.getCell(1)));
				String name = new DataFormatter().formatCellValue(row.getCell(2));
				Double price = Double.valueOf(new DataFormatter().formatCellValue(row.getCell(3)));
				Date createday = null;
				try {
					 createday = format.parse(new DataFormatter().formatCellValue(row.getCell(4)));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String image = new DataFormatter().formatCellValue(row.getCell(5));
				Boolean available = Integer.valueOf(new DataFormatter().formatCellValue(row.getCell(6)))==1?true:false;
				Long categoryid = Long.valueOf(new DataFormatter().formatCellValue(row.getCell(7)));
				
				Product pro = new Product();
				pro.setId(id);
				pro.setName(name);
				pro.setPrice(price);
				pro.setCreatedate(createday);
				pro.setAvailable(available);
				prodata.add(pro);
			}
			wb.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
//			System.out.println(dao.create(user) == null ?"error":"success");
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		return prodata;
		
	}
	
//	public static void importByExecl(FileInputStream file) {
//		try {
//			XSSFWorkbook wb = new XSSFWorkbook (file);
//			XSSFSheet sheet = wb.getSheetAt(0);
//			
//			
//			int RowSheet = sheet.getLastRowNum();
//			for(int i = 2 ; i <= RowSheet ; i++) {
//				Row row = sheet.getRow(i);
//				
//				Math math  = new Math(new DataFormatter().formatCellValue(row.getCell(0)),
//						new DataFormatter().formatCellValue(row.getCell(1)),
//						new DataFormatter().formatCellValue(row.getCell(2)),
//						new DataFormatter().formatCellValue(row.getCell(3)),
//						new DataFormatter().formatCellValue(row.getCell(4)),
//						new DataFormatter().formatCellValue(row.getCell(5)),
//						new DataFormatter().formatCellValue(row.getCell(6)));
//				System.out.println(math.toString());
//			}
//			wb.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
////			System.out.println(dao.create(user) == null ?"error":"success");
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//			
//		}
//		
//	}
	
	public static void showData(List<Product> data) {
		data.forEach(item ->{
			System.out.println(item);
		});
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		FileInputStream fileInputStream = new FileInputStream(new File("D:\\Java5\\data.xlsx"));
		List<Product> data = importByExecl(fileInputStream);
		
		data.sort(new SortByName());
		showData(data);
		System.out.println("----------------------------------------------------------------------");
		data.sort(new SortByPrice());
		showData(data);
}
}