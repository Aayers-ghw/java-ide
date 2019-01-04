package org.Aayers.editor;

import org.Aayers.editor.tree.TreeCreator;
import org.Aayers.editor.tree.TreeCreatorImpl;

/**
 * ��������
 * @author Aayers-ghw
 *
 */
public class Main {

	public static void main(String[] args) {
		TreeCreator treeCreator = new TreeCreatorImpl();
		//����EditorFrame����ʱ�������ÿɼ�
		EditorFrame editorFrame = new EditorFrame("ide", treeCreator);
		//��editorFrame������ΪSpaceFrame�Ĺ������
		SpaceFrame spaceFrame = new SpaceFrame(editorFrame);
		//��SpaceFrame�ɼ�
		spaceFrame.setVisible(true);
	}

}
