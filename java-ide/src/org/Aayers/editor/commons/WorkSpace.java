package org.Aayers.editor.commons;

import java.io.File;

import org.Aayers.editor.EditorFrame;

/**
 * 工作空间对象
 * @author Aayers-ghw
 *
 */
public class WorkSpace {

	//工作空间对应的目录
	private File folder;
	
	//工作空间中的主编辑区对象
	private EditorFrame editorFrame;
	
	public WorkSpace(File folder, EditorFrame editorFrame) {
		this.folder = folder;
		this.editorFrame = editorFrame;
	}

	public EditorFrame getEditorFrame() {
		return editorFrame;
	}

	public void setEditorFrame(EditorFrame editorFrame) {
		this.editorFrame = editorFrame;
	}


	public File getFolder() {
		return folder;
	}

	public void setFolder(File folder) {
		this.folder = folder;
	}
}
