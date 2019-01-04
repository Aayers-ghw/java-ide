package org.Aayers.editor.handler.add;

import java.io.File;

import javax.swing.JOptionPane;

import org.Aayers.editor.AddFrame;
import org.Aayers.editor.EditorFrame;
import org.Aayers.editor.config.CompileConfig;
import org.Aayers.editor.exception.FileException;

/**
 * �����Ŀ������
 * @author Aayers-ghw
 *
 */
public class AddProjectHandler implements AddHandler {

	@Override
	public void afterAdd(EditorFrame editorFrame, AddFrame addFrame, Object data) {
		try {
			//��ȡ�����ռ����ڵ�Ŀ¼
			File spaceFolder = editorFrame.getWorkSpace().getFolder();
			//����.project�ļ�
			File projectFile = new File(spaceFolder.getAbsoluteFile() +
					File.separator + data + ".project");
			//������ĿĿ¼
			File projectFolder = new File(spaceFolder.getAbsoluteFile() + File.separator + data);
			//��Ŀ�Ѿ����ڣ��������沢����
			if (projectFile.exists() && projectFolder.exists()) {
				JOptionPane.showMessageDialog(addFrame, "��Ŀ�Ѿ�����");
				return;
			}
			//��Ŀ�ļ������ڣ� ������Ŀ�ļ�
			if (!projectFile.exists()) projectFile.createNewFile();
			//��ĿĿ¼�����ڣ� ������Ŀ�ļ�Ŀ¼
			if (!projectFolder.exists()) projectFolder.mkdir();
			//������Ŀ��srcĿ¼�ͱ���Ŀ¼
			File src = new File(projectFolder.getAbsoluteFile() + 
					File.separator + CompileConfig.SRC_DIR);
			//Java�ļ����������Ŀ¼
			File output = new File(projectFolder.getAbsoluteFile() + 
					File.separator + CompileConfig.OUTPUT_DIR);
			//����src��output����Ŀ¼
			src.mkdir();
			output.mkdir();
			
			
			//��EditorFrame��ÿ���
			editorFrame.setEnabled(true);
			//����ӵ�frame���ɼ�
			addFrame.setVisible(false);
			
		} catch (Exception e) {
			throw new FileException("create project error: " + e.getMessage());
		}
	}

}
