package com.shivam.blogapplication.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.client.j2se.MatrixToImageConfig;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
public class BarcodeController {

    @GetMapping(value = "/barcode/gs1-code128", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> generateGS1Code128Barcode(@RequestParam String data,
                                                       @RequestParam(required = false, defaultValue = "300") int width,
                                                       @RequestParam(required = false, defaultValue = "100") int height) {
        try {
            String serialNumber = "AB123B3H5J6";
            String barcodeBase64 = generateBarcodeWithSerialNumber(data, serialNumber, width, height);

            decodeAndSaveImage(barcodeBase64, "C:\\Users\\acer\\Downloads\\decoded_image.png");
            System.out.println("Image decoded and saved successfully.");

            Map<String, String> response = new HashMap<>();
            response.put("barcodeBase64", barcodeBase64);
            return ResponseEntity.ok(response);
        } catch (IOException | WriterException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error generating barcode: " + e.getMessage());
        }
    }

    private String generateBarcode(String barcodeData, int width, int height) throws WriterException, IOException {
        Code128Writer writer = new Code128Writer();
        BitMatrix bitMatrix = writer.encode(barcodeData, BarcodeFormat.CODE_128, width, height, null);

        // Set white as background and black as foreground color
        MatrixToImageConfig config = new MatrixToImageConfig(0xFFFFFFFF, 0xFF000000);

        // Convert BitMatrix to BufferedImage
        BufferedImage barcodeImage = MatrixToImageWriter.toBufferedImage(bitMatrix, config);

        // Convert BufferedImage to Base64 string
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", baos);

        byte[] barcodeBytes = baos.toByteArray();
        return Base64.getEncoder().encodeToString(barcodeBytes);
    }


    private String generateBarcodeWithSerialNumber(String barcodeData, String serialNumber, int width, int height) throws WriterException, IOException {
        Code128Writer writer = new Code128Writer();

        // Encode barcode data and serial number separately
        BitMatrix barcodeBitMatrix = writer.encode(barcodeData, BarcodeFormat.CODE_128, width, height / 2, null);
        BitMatrix serialNumberBitMatrix = writer.encode(serialNumber, BarcodeFormat.CODE_128, width, height / 2, null);

        // Create a new BitMatrix with combined dimensions
        BitMatrix combinedBitMatrix = new BitMatrix(barcodeBitMatrix.getWidth(), barcodeBitMatrix.getHeight() + serialNumberBitMatrix.getHeight());

        // Copy barcodeBitMatrix into combinedBitMatrix
        for (int y = 0; y < barcodeBitMatrix.getHeight(); y++) {
            for (int x = 0; x < barcodeBitMatrix.getWidth(); x++) {
                if (barcodeBitMatrix.get(x, y)) { // Check if the bit is set in barcodeBitMatrix
                    combinedBitMatrix.set(x, y); // Set the corresponding bit in combinedBitMatrix
                }
            }
        }

        // Copy serialNumberBitMatrix into combinedBitMatrix below the barcode
        for (int y = 0; y < serialNumberBitMatrix.getHeight(); y++) {
            for (int x = 0; x < serialNumberBitMatrix.getWidth(); x++) {
                if (serialNumberBitMatrix.get(x, y)) { // Check if the bit is set in serialNumberBitMatrix
                    combinedBitMatrix.set(x, y + barcodeBitMatrix.getHeight()); // Set the corresponding bit in combinedBitMatrix
                }
            }
        }

        // Set white as background and black as foreground color
        MatrixToImageConfig config = new MatrixToImageConfig(0xFFFFFFFF, 0xFF000000);

        // Convert combined bit matrix to buffered image
        BufferedImage combinedImage = MatrixToImageWriter.toBufferedImage(combinedBitMatrix, config);

        // Convert buffered image to Base64 string
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(combinedImage, "png", baos);

        byte[] barcodeBytes = baos.toByteArray();
        return Base64.getEncoder().encodeToString(barcodeBytes);
    }






    public static void decodeAndSaveImage(String base64Image, String filePath) throws IOException {
        // Decode Base64 string to byte array
        byte[] imageBytes = Base64.getDecoder().decode(base64Image);

        // Write byte array to file
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(imageBytes);
        }
    }
}
