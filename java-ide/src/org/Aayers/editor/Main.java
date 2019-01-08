package org.Aayers.editor;

import org.Aayers.editor.tree.TreeCreator;
import org.Aayers.editor.tree.TreeCreatorImpl;

/**
 * 程序的入口
 * @author Aayers-ghw
 *
 */
public class Main {

	public static void main(String[] args) {
		TreeCreator treeCreator = new TreeCreatorImpl();
		//创建EditorFrame，暂时不用设置可见
		EditorFrame editorFrame = new EditorFrame("ide", treeCreator);
		//将editorFrame对象作为SpaceFrame的构造参数
		SpaceFrame spaceFrame = new SpaceFrame(editorFrame);
		//让SpaceFrame可见
		spaceFrame.setVisible(true);
	}

}
