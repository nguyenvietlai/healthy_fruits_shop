package www.HealthyShop2023.Service;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;



@Service
public class ParamService {
	@Autowired
	HttpServletRequest request;
	
	@Autowired(required = true)
	ServletContext app;
	
	
	/**
	* Đọc chuỗi giá trị của tham số
	* @param name tên tham số
	* @param defaultValue giá trị mặc định
	* @return giá trị tham số hoặc giá trị mặc định nếu không tồn tại
	*/
	public String getString(String name, String defaultValue){
		String value = String.valueOf(request.getParameter(name));
		return value != null ? value:defaultValue;
	}
	public Object getObject(String name, String defaultValue){
		Object value = request.getParameter(name);
		return value != null ? value:defaultValue;
	}
	
	/**
	* Đọc số nguyên giá trị của tham số
	* @param name tên tham số
	* @param defaultValue giá trị mặc định
	* @return giá trị tham số hoặc giá trị mặc định nếu không tồn tại
	*/
	public Integer getInt(String name, Integer defaultValue){
		Integer value = Integer.valueOf(String.valueOf(request.getParameter(name)));
		return value != null ? value:defaultValue;
	}
	
	/**
	* Đọc số thực giá trị của tham số
	* @param name tên tham số
	* @param defaultValue giá trị mặc định
	* @return giá trị tham số hoặc giá trị mặc định nếu không tồn tại
	*/
	public Double getDouble(String name, double defaultValue){
		Double value = Double.valueOf(String.valueOf(request.getParameter(name)));
		return value != null ? value:defaultValue;
	}
	/**
	* Đọc giá trị boolean của tham số
	* @param name tên tham số
	* @param defaultValue giá trị mặc định
	* @return giá trị tham số hoặc giá trị mặc định nếu không tồn tại
	*/
	public Boolean getBoolean(String name, boolean defaultValue){
		Boolean value = Boolean.valueOf(String.valueOf(request.getParameter(name)));
		return value != null ? value:defaultValue;
	}
	/**
	* Đọc giá trị thời gian của tham số
	* @param name tên tham số
	* @param pattern là định dạng thời gian
	* @return giá trị tham số hoặc null nếu không tồn tại
	 * @throws ParseException 
	* @throws RuntimeException lỗi sai định dạng
	*/
	public Date getDate(String name, String pattern) throws ParseException{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date value = dateFormat.parse((String.valueOf(request.getParameter(name))));
		return value != null ? value:dateFormat.parse(pattern);
	}
	/**
	* Lưu file upload vào thư mục
	* @param file chứa file upload từ client
	* @param path đường dẫn tính từ webroot
	* @return đối tượng chứa file đã lưu hoặc null nếu không có file upload
	* @throws RuntimeException lỗi lưu file
	*/
	public String save(MultipartFile file, String path) {
		System.out.println(isFileExisits(file.getOriginalFilename(),path) == true?"ton tai":"chua ton tai");
			File dir = new File(app.getRealPath(path));
			if(!dir.exists()) dir.mkdir();
			File saveFile = new File(dir, file.getOriginalFilename());
			try {
				file.transferTo(saveFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(dir + "/"+file.getOriginalFilename());
			return file.getOriginalFilename();
	}
	
	public boolean removeFile(String fileName, String path) {
		File dir = new File(app.getRealPath(path));
		File linkFile = new File(dir,fileName);
		if(isFileExisits(fileName, path)) {
		    return linkFile.delete();
		}
		return false;
	}
	
	private boolean isFileExisits(String fileName, String path) {
		File dir = new File(app.getRealPath(path));
		if(!dir.exists()) {
			return false;
		}
		File linkFile = new File(dir,fileName);
		if(!linkFile.exists()) {
			return false;
		}
		return true;
	}
	
	
}
