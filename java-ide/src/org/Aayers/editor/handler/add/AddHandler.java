package org.Aayers.editor.handler.add;

import org.Aayers.editor.AddFrame;
import org.Aayers.editor.EditorFrame;

/**
 * 添加事件的接口
 * @author Aayers-ghw
 *
 */
public interface AddHandler {

	//新增完后需要做的事情，需要做的事情由实现类去实现
	//参数为EditorFrame，AddFrame，输入的信息data
	void afterAdd(EditorFrame editorFrame, AddFrame addFrame, Object data);
}
