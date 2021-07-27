package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

public class ReadUtil {
	private static MultipartFile multipartFile;
	private static InputStream is;
	private static XSSFWorkbook xssfWorkbook = null;
	private static XSSFSheet xssfSheet = null;
	private static XSSFRow xssfRow = null;
	private static List<String> listUser = new ArrayList<>();

	public static Object getListofUserName(MultipartFile multipartFile) {
		try {
			is = multipartFile.getInputStream();
			xssfWorkbook = new XSSFWorkbook(is);
			if (xssfWorkbook != null) {
				System.out.println(true);
			} else {
				System.out.println(false);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			return nameofList();
		}

	}

	private static Object nameofList() {
		List<String> list = new ArrayList<String>();
		if (xssfWorkbook != null) {
			xssfSheet = xssfWorkbook.getSheetAt(0);

			for (int i = 0; i <=xssfSheet.getLastRowNum(); i++) {
				String name = xssfSheet.getRow(i).getCell((int) 'H' - 65).toString();
				if (name.trim().length() > 0) {
					list.add(name.trim());
				}
			}
		}
		else
		{
			System.out.println(xssfWorkbook);
		}
		return list;
	}

}
