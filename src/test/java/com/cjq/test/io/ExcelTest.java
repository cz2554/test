package com.cjq.test.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ExcelTest {
	   private POIFSFileSystem fs;
	    private HSSFWorkbook wb;
	    private HSSFSheet sheet;
	    private HSSFRow row;
	    private List textlist;
	    /**
	     * 读取Excel数据内容
	     * @param InputStream
	     * @return Map 包含单元格数据内容的Map对象
	     */
	    public void writeText(InputStream is,List list) {
	        Map<Integer, String> content = new HashMap<Integer, String>();
	        StringBuffer stbuffer=new StringBuffer();
	    
	        String str = "";
	        try {
	        	FileWriter fw = new FileWriter("D:\\rightGoods.txt",false);
	            fs = new POIFSFileSystem(is);
	            wb = new HSSFWorkbook(fs);
	       
	        sheet = wb.getSheetAt(0);
	        // 得到总行数
	        int rowNum = sheet.getLastRowNum();
	        row = sheet.getRow(0);
	        int colNum = row.getPhysicalNumberOfCells();
	        // 正文内容应该从第二行开始,第一行为表头的标题
	        for (int i = 1; i <= rowNum; i++) {
	            row = sheet.getRow(i);
	            GoodsVo goodsvo=getGood(row,list);
	          if(goodsvo.getLocal().equals("right")) {
	        	  stbuffer.append(goodsvo.getName()+" "+goodsvo.getArea()+" "+goodsvo.getPrice()+"\r\n");
	          }
	        }
	        fw.write(stbuffer.toString().toCharArray());   
	        fw.close();  
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	       
	    }
	    /**
	     * 根据HSSFCell类型设置数据
	     * @param cell
	     * @return
	     */
	    private String getCellFormatValue(HSSFCell cell) {
	        String cellvalue = "";
	        if (cell != null) {
	            // 判断当前Cell的Type
	            switch (cell.getCellType()) {
	            // 如果当前Cell的Type为NUMERIC
	            case HSSFCell.CELL_TYPE_NUMERIC:
	            case HSSFCell.CELL_TYPE_FORMULA: {
	                // 判断当前的cell是否为Date
	                if (HSSFDateUtil.isCellDateFormatted(cell)) {
	                    // 如果是Date类型则，转化为Data格式
	                    
	                    //方法1：这样子的data格式是带时分秒的：2011-10-12 0:00:00
	                    //cellvalue = cell.getDateCellValue().toLocaleString();
	                    
	                    //方法2：这样子的data格式是不带带时分秒的：2011-10-12
	                    Date date = cell.getDateCellValue();
	                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	                    cellvalue = sdf.format(date);
	                    
	                }
	                // 如果是纯数字
	                else {
	                    // 取得当前Cell的数值
	                    cellvalue = String.valueOf((int)cell.getNumericCellValue());
	                }
	                break;
	            }
	            // 如果当前Cell的Type为STRIN
	            case HSSFCell.CELL_TYPE_STRING:
	                // 取得当前的Cell字符串
	                cellvalue = cell.getRichStringCellValue().getString();
	                break;
	            // 默认的Cell值
	            default:
	                cellvalue = " ";
	            }
	        } else {
	            cellvalue = "";
	        }
	        return cellvalue;

	    }
	
		@SuppressWarnings("finally")
		public GoodsVo getGood(HSSFRow row,List list) {
	    	GoodsVo good=new GoodsVo();
	    	  int price=-1;
	    	  good.setName(getCellFormatValue(row.getCell((short) 0)).trim().replace("&", ""));
	    	  good.setArea(getCellFormatValue(row.getCell((short) 1)).trim());
	    	  good.setPrice(getCellFormatValue(row.getCell((short) 2)).trim());
	    	  try {
				price=Integer.valueOf(good.getPrice());
				if(price>100) {
					good.setLocal("right");
				}
				else {
					good.setLocal("error");
				}
				String[] arr=null;
				for(int i=0;i<list.size();i++) {
					arr=(String[]) list.get(i);
					if(good.getName().equals(arr[0])) {
						good.setLocal("repeat");
					}
				}
			} catch (Exception e) {
				good.setLocal("error");
			}finally {
				return good;
			}

	    }
		public static void main(String[] args) {
			ExcelTest exceltest=new ExcelTest();
			File file=new File("D:\\test.txt");
			List list=WriteText.txt2String(file);
			InputStream is;
			try {
				is = new FileInputStream("d:\\test2.xls");
				exceltest.writeText(is,list);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}
