package org.Aayers.editor.handler.add;

import org.Aayers.editor.AddFrame;
import org.Aayers.editor.EditorFrame;

/**
 * ����¼��Ľӿ�
 * @author Aayers-ghw
 *
 */
public interface AddHandler {

	//���������Ҫ�������飬��Ҫ����������ʵ����ȥʵ��
	//����ΪEditorFrame��AddFrame���������Ϣdata
	void afterAdd(EditorFrame editorFrame, AddFrame addFrame, Object data);
}
