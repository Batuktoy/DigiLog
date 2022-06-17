package subFrame;

import java.nio.file.Paths;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class CodesforQR {
	
		public static void main(String[] args) throws  Exception {
			
			String data = "http://localhost/phpmyadmin/index.php?route=/sql&db=qr_generator&table=aloy_aloy&pos=0";
			String path = "D:\\QRcode\\1stQR.jpg";
	
			BitMatrix matrix = new MultiFormatWriter()
					.encode(data, BarcodeFormat.QR_CODE, 220, 186);
			
			MatrixToImageWriter.writeToPath(matrix, "jpg", Paths.get(path));
			 
		}
			
}
