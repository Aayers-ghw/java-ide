package org.Aayers.editor.handler.add;

import java.io.File;

import javax.swing.JOptionPane;

import org.Aayers.editor.AddFrame;
import org.Aayers.editor.EditorFrame;
import org.Aayers.editor.config.CompileConfig;
import org.Aayers.editor.exception.FileException;

/**
 * 添加项目处理类
 * @author Aayers-ghw
 *
 */
public class AddProjectHandler implements AddHandler {

	@Override
	public void afterAdd(EditorFrame editorFrame, AddFrame addFrame, Object data) {
		try {
			//获取工作空间所在的目录
			File spaceFolder = editorFrame.getWorkSpace().getFolder();
			//创建.project文件
			File projectFile = new File(spaceFolder.getAbsoluteFile() +
					File.separator + data + ".project");
			//创建项目目录
			File projectFolder = new File(spaceFolder.getAbsoluteFile() + File.separator + data);
			//项目已经存在，弹出警告并返回
			if (projectFile.exists() && projectFolder.exists()) {
				JOptionPane.showMessageDialog(addFrame, "项目已经存在");
				return;
			}
			//项目文件不存在， 创建项目文件
			if (!projectFile.exists()) projectFile.createNewFile();
			//项目目录不存在， 创建项目文件目录
			if (!projectFolder.exists()) projectFolder.mkdir();
			//创建项目的src目录和编译目录
			File src = new File(projectFolder.getAbsoluteFile() + 
					File.separator + CompileConfig.SRC_DIR);
			//Java文件编译的输入目录
			File output = new File(projectFolder.getAbsoluteFile() + 
					File.separator + CompileConfig.OUTPUT_DIR);
			//创建src和output两个目录
			src.mkdir();
			output.mkdir();
			
			
			//让EditorFrame变得可用
			editorFrame.setEnabled(true);
			//让添加的frame不可见
			addFrame.setVisible(false);
			
		} catch (Exception e) {
			throw new FileException("create project error: " + e.getMessage());
		}
	}

}
