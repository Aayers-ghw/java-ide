package org.Aayers.editor.tree;

import java.io.File;

import javax.swing.JTree;

import org.Aayers.editor.EditorFrame;

/**
 * �������ӿ�
 * @author Aayers-ghw
 *
 */
public interface TreeCreator {

	/**
	 * ���ݱ༭��EditorFrame���󴴽���Ŀ��
	 * @param editorFrame
	 * @return
	 */
	JTree createTree(EditorFrame editorFrame);
	
	/**
	 * ����һ��Ŀ¼�������Ľڵ�
	 * @param folder
	 * @return
	 */
	ProjectTreeNode createNode(File folder);
}
