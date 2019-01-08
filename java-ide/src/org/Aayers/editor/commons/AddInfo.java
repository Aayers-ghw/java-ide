package org.Aayers.editor.commons;

import org.Aayers.editor.EditorFrame;
import org.Aayers.editor.handler.add.AddHandler;

/**
 * ��ӵ���Ϣ����
 * @author Aayers-ghw
 *
 */
public class AddInfo {

	//�ַ����������������textǰ��ʾ�����磺�ļ�����
	private String info;
	
	//����������Ӱ�����frame
	private EditorFrame editorFrame;
	
	//�������Ĵ�����
	private AddHandler handler;

	public AddInfo(String info, EditorFrame editorFrame, AddHandler handler) {
		super();
		this.info = info;
		this.editorFrame = editorFrame;
		this.handler = handler;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public EditorFrame getEditorFrame() {
		return editorFrame;
	}

	public void setEditorFrame(EditorFrame editorFrame) {
		this.editorFrame = editorFrame;
	}

	public AddHandler getHandler() {
		return handler;
	}

	public void setHandler(AddHandler handler) {
		this.handler = handler;
	}
	
	
}
