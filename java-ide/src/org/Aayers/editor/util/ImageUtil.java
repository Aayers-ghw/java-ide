package org.Aayers.editor.util;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * ͼƬ������
 * @author Aayers-ghw
 *
 */
public class ImageUtil {

	//Ŀ¼�ر�ͼƬ
	public static String FOLDER_CLOSE = "images/folder-close.gif";
	//Ŀ¼��ͼƬ
	public static String FOLDER_OPEN = "images/folder-open.gif";
	//���ӽڵ���ļ�ͼƬ
	public static String FILE = "images/file.gif";
	//ʹ��ImageIO����ȡͼƬ
	public static Image getImage(String path) {
		try {
			return ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ImageIcon getImageIcon(String path) {
		return new ImageIcon(getImage(path));
	}
	
	
}
