package org.Aayers.editor.tree;

import java.io.File;

import javax.swing.JTree;

import org.Aayers.editor.EditorFrame;

/**
 * 树创建接口
 * @author Aayers-ghw
 *
 */
public interface TreeCreator {

	/**
	 * 根据编辑的EditorFrame对象创建项目树
	 * @param editorFrame
	 * @return
	 */
	JTree createTree(EditorFrame editorFrame);
	
	/**
	 * 根据一个目录创建它的节点
	 * @param folder
	 * @return
	 */
	ProjectTreeNode createNode(File folder);
}
