package com.shivam.blogapplication.services;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;

@Service
public class BarcodeService {
    public byte[] generateCode128Barcode(String text) throws WriterException, IOException {
        int barcodeWidth = 300;
        int barcodeHeight = 150;

        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.MARGIN, 1);

        BitMatrix bitMatrix = new MultiFormatWriter().encode(
                text,
                BarcodeFormat.CODE_128,
                barcodeWidth,
                barcodeHeight,
                hints
        );

        BufferedImage barcodeImage = MatrixToImageWriter.toBufferedImage(bitMatrix);

        int totalHeight = barcodeHeight + 20;
        BufferedImage imageWithText = new BufferedImage(barcodeWidth, totalHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = imageWithText.createGraphics();

        graphics.drawImage(barcodeImage, 0, 0, null);

        graphics.setColor(Color.BLACK);
        Font font = new Font("Arial", Font.PLAIN, 18);
        graphics.setFont(font);

        FontMetrics fontMetrics = graphics.getFontMetrics(font);
        int textWidth = fontMetrics.stringWidth(text);
        int textXPosition = (barcodeWidth - textWidth) / 2;
        int textYPosition = barcodeHeight + fontMetrics.getAscent();

        graphics.drawString(text, textXPosition, textYPosition);

        graphics.dispose();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        javax.imageio.ImageIO.write(imageWithText, "png", baos);
        return baos.toByteArray();
    }
}
