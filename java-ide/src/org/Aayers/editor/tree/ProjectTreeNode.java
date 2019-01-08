package org.Aayers.editor.tree;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * ��Ŀ���Ľڵ����
 * @author Aayers-ghw
 *
 */
public class ProjectTreeNode extends DefaultMutableTreeNode{

	//�ýڵ��Ӧ���ļ�
	private File file;
	
	//�ýڵ��µ��ӽ��
	private List<ProjectTreeNode> children;
	
	//ProjectTreeNode�Ĺ������������ֱ��Ǹýڵ��Ӧ���ļ����Ƿ��������ӽ��
	public ProjectTreeNode(File file, boolean allowsChildren) {
		super(file.getName(), allowsChildren);
		this.file = file;
		//��ʼ���ýڵ��µ��ӽ�㼯��
		children = new ArrayList<ProjectTreeNode>();
	}
	
	public File getFile() {
		return file;
	}
	
	public void setFile(File file) {
		this.file = file;
	}
	
	public List<ProjectTreeNode> getChilddren() {
		//���children,�����»�ȡһ��
		children.removeAll(children);
		for(int i = 0; i < getChildCount(); i++) {
			children.add((ProjectTreeNode)getChildAt(i));
		}
		return this.children;
	}
	
	
	
	
}
