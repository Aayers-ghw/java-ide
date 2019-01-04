package org.Aayers.editor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.tree.TreePath;

import org.Aayers.editor.commons.AddInfo;
import org.Aayers.editor.commons.WorkSpace;
import org.Aayers.editor.handler.add.AddProjectHandler;
import org.Aayers.editor.tree.ProjectTreeNode;
import org.Aayers.editor.tree.TreeCreator;

/**
 * �༭����
 * @author Aayers-ghw
 *
 */
public class EditorFrame extends JFrame {

	//���ļ���tab����
	private JTabbedPane tabPane;
	
	//���tabPane��desk
	private Box box;
	
	//����һ�����ĵ�����������
	private JDesktopPane desk;
	
	//���ڷָ����༭������Ϣ��ʾ��������
	private JSplitPane editorSplitPane;
	
	//���Թ�����JScrollPane�������ڷ�infoArea
	private JScrollPane infoPane;
	
	//������ʾ��Ϣ���ı���
	private JTextArea infoArea;
	
	//������Ŀɹ�������
	private JScrollPane treePane;
	
	//��������ķָ����������
	private JSplitPane mainSplitPane;
	
	//��Ŀ������
	private JTree tree;
	
	//�˵�������
	private JMenuBar menuBar;
	
	//�༭�˵�����
	private JMenu editMenu;
	
	//�ļ��˵�
	private JMenu fileMenu;
	
	//������
	private JToolBar toolBar;
	
	private WorkSpace workSpace;
	
	private TreeCreator treeCreator;
	
	//��ӵĽ���
	private AddFrame addFrame;
	
	//�ļ�ѡ����
	private FileChooser fileChooser;
	
	//�½��ļ���Action����
	private Action fileNew = new AbstractAction("�½��ļ�", new ImageIcon("images/newFile.gif")) {
		public void actionPerformed(ActionEvent e) {
			newFile();
		}
	};
	//�½�Ŀ¼��Action����
	private Action folerNew = new AbstractAction("�½�Ŀ¼", new ImageIcon("images/newFile.gif")) {
		public void actionPerformed(ActionEvent e) {
			newFolder();
		}
	};
	//�½���Ŀ��Action����
	private Action projectNew = new AbstractAction("�½���Ŀ", new ImageIcon("images/newFile.gif")) {
		public void actionPerformed(ActionEvent e) {
			newProject();
		}
	};
	//���ļ���Action����
	private Action open = new AbstractAction("��     ��", new ImageIcon("images/open.gif")) {
		public void actionPerformed(ActionEvent e) {
			selectFile();
		}
	};
	//�����ļ���Action����
	private Action save = new AbstractAction("��     ��", new ImageIcon("images/save.gif")) {
		public void actionPerformed(ActionEvent e) {
//			saveFile(getCurrentFile());
		}
	};
	//ˢ������Action����
	private Action refresh = new AbstractAction("ˢ     ��", new ImageIcon("images/refresh.gif")) {
		public void actionPerformed(ActionEvent e) {
//			reloadNode(getSelectNode());
		}
	};
	//�����ļ���Action����
	private Action run = new AbstractAction("��     ��", new ImageIcon("images/run.gif")) {
		public void actionPerformed(ActionEvent e) {
			run();
		}
	};
	//�˳���Action����
	private Action exit = new AbstractAction("��     ��") {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);//ֱ���˳�
		}
	};
	//�����ı���Action����
	private Action copy = new AbstractAction("��     ��", new ImageIcon("images/copy.gif")) {
		public void actionPerformed(ActionEvent e) {
//			if (getCurrentFile() != null) {
//				getCurrentFile().getEditPane().copy();
//			}
		}
	};
	//�����ı���Action����
	private Action cut = new AbstractAction("��     ��", new ImageIcon("images/cut.gif")) {
		public void actionPerformed(ActionEvent e) {
//			if (getCurrentFile() != null) {
//				getCurrentFile().getEditPane().cut();
//			}
		}
	};
	//ճ���ı���Action����
	private Action paste = new AbstractAction("ճ     ��", new ImageIcon("images/paste.gif")) {
		public void actionPerformed(ActionEvent e) {
//			if (getCurrentFile() != null) {
//				getCurrentFile().getEditPane().paste();
//			}
		}
	};
	
	public EditorFrame(String title, TreeCreator treeCreator) {
		super(title); //���ñ���
		this.treeCreator = treeCreator;
//		this.iframeListener = new IFrameListener(this);
//		this.saveMediator = new SaveMediatorConcrete();
//		this.runHandler = new JavaRunHandler();
	}
	
	public void initFrame(WorkSpace space) {
		this.workSpace = space;
		//���ô��ڹرգ��˳�����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//�������༭����tabPane
		tabPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT );
		//����JDesktopPane����
		desk = new JDesktopPane();
		//����desk�ı�����ɫΪ��ɫ
		desk.setBackground(Color.GRAY);
		//����box�Ĳ���		BoxLayout.Y_AXISָ�����ϵ��´�ֱ��������� 
		box = new Box(BoxLayout.Y_AXIS);
		box.add(tabPane);
		box.add(desk);
		//������Ϣ��ʾ�����ı���
		infoArea = new JTextArea("", 5, 50);
		//��infoArea�ı�����Ϊ����ŵ�infoPane��
		infoPane = new JScrollPane(infoArea);
		//������Ϣ�����ɱ༭
		infoArea.setEditable(false);
		//��������ָ����������������box�����infoPane��������
		//JSplitPane.VERTICAL_SPLIT ʹ����ϵ�������
		editorSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, box, infoPane);
		//���÷ָ����Ĵ�С��
		editorSplitPane.setDividerSize(3);
		//���÷ָ�����λ��Ϊ JSplitPane ��С��һ���ٷֱȡ�
		editorSplitPane.setDividerLocation(500);
		//������
		tree = treeCreator.createTree(this);
		//�����ɹ�������������
		treePane = new JScrollPane(tree);
		//�����������JSplitPane���������ΪtreePane���ұ�ΪeditorSplitPane
		mainSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treePane, 
				editorSplitPane);
		//���÷ָ�����λ��
		mainSplitPane.setDividerLocation(200);
		//���÷ָ����Ĵ�ϸ
		mainSplitPane.setDividerSize(3);
		add(mainSplitPane);
		
		//�����˵�������
		menuBar = new JMenuBar();
		//�����༭�˵�����
		editMenu = new JMenu("�༭");
		//�����ļ��˵�
		fileMenu = new JMenu("�ļ�");
		//���ļ��˵���ӵ��˵�����
		menuBar.add(fileMenu);
		//���༭�˵���ӵ��˵�����
		menuBar.add(editMenu);
		//����JFrame�Ĳ˵���
		setJMenuBar(menuBar);
		
		toolBar = new JToolBar();
		toolBar.setFloatable(false);//���ù����������ƶ�
		toolBar.setMargin(new Insets(0, 10, 5, 5));//���ù������ı߾�
		add(toolBar, BorderLayout.NORTH);//����������ӵ�EditorFrame��
		
		pack();//ʹJFrame������Ѵ�С
		addListeners();
	}
	
	
	//ΪEditorFrame�е������Ӽ�����
	public void addListeners() {
		//�½��ļ��ļ�����
		fileMenu.add(fileNew).setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_MASK));
		//�½�Ŀ¼�ļ�����
		fileMenu.add(folerNew).setAccelerator(KeyStroke.getKeyStroke('F', InputEvent.CTRL_MASK));
		//�½���Ŀ�ļ�����
		fileMenu.add(projectNew).setAccelerator(KeyStroke.getKeyStroke('P', InputEvent.CTRL_MASK));
		//�򿪲˵���Ӽ�����
		fileMenu.add(open).setAccelerator(KeyStroke.getKeyStroke('O', InputEvent.CTRL_MASK));
		//Ϊ����˵���Ӽ�����
		fileMenu.add(save).setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_MASK));
		//Ϊˢ�²˵���Ӽ�����
		fileMenu.add(refresh).setAccelerator(KeyStroke.getKeyStroke("F5"));
		//Ϊ���в˵���Ӽ�����
		fileMenu.add(run).setAccelerator(KeyStroke.getKeyStroke('R', InputEvent.CTRL_MASK));
		fileMenu.add(exit);
		//��Ӹ��Ƽ�����
		editMenu.add(copy).setAccelerator(KeyStroke.getKeyStroke('C', InputEvent.CTRL_MASK));
		//��Ӽ��м�����
		editMenu.add(cut).setAccelerator(KeyStroke.getKeyStroke('X', InputEvent.CTRL_MASK));
		//���ճ��������
		editMenu.add(paste).setAccelerator(KeyStroke.getKeyStroke('V', InputEvent.CTRL_MASK));
	
		//Ϊ��������Ӹ�������
		toolBar.add(fileNew).setToolTipText("�½��ļ�");
		toolBar.add(open).setToolTipText("��");
		toolBar.add(save).setToolTipText("����");
		toolBar.add(refresh).setToolTipText("ˢ��");
		toolBar.add(run).setToolTipText("����");
		toolBar.add(copy).setToolTipText("����");
		toolBar.add(cut).setToolTipText("����");
		toolBar.add(paste).setToolTipText("ճ��");
	}
	
	//��ȡ�༭����������Ŀ������ѡ�еĽڵ�
	public ProjectTreeNode getSelectNode() {
		//��õ�ǰ��ѡ��Ľڵ������е�·��
		TreePath path = tree.getSelectionPath();
		//�����ǰѡ���˽ڵ�
		if (path != null) {
			//����һ��ProjectTreeNode�������ڷ���
			ProjectTreeNode selectNode = (ProjectTreeNode)path.getLastPathComponent();
			return selectNode;
		}
		//��ǰû��ѡ��ھͷ���null
		return null;
	}
	
	//���ļ��ķ���
	public void openFile(File file) {
		//���µ��ļ�
		openNewFile(file);
	}
	
	//��һ�����ļ������ļ������ڱ༭�б��У�
	public void openNewFile(File file) {
		//����EditorFrame�ı���Ϊ���ļ���ȫ·��
		setTitle(file.getAbsolutePath());
		//����һ��JInternalFrame����titleΪ�ļ��ľ���·��
		JInternalFrame iframe = new JInternalFrame(file.getAbsolutePath(), true, true, true, true);
		
		desk.add(iframe);
		iframe.show();
		iframe.reshape(0, 0, 400, 300);
		tabPane.addTab(file.getName(), null, null, file.getAbsolutePath());
	}
	
	public void selectFile() {
		fileChooser = new FileChooser(this);
	}
	
	//�½��ļ��ķ���
	public void newFile() {
//		//��û��ѡ��һ���ڵ���½�Ŀ¼��ʱ����Ҫ����
//		if (getSelectNode() == null) {
//			JOptionPane.showMessageDialog(this, "��ѡ��Ŀ¼"); 
//			return;
//		}
//		AddInfo info = new AddInfo("�ļ����ƣ�", this, new AddFileHandler());
//		showAddFrame(info);
	}
	
	//��ʾ�����Ľ���
	private void showAddFrame(AddInfo info) {
		//ʹEditorFrame��Ϊ������
		setEnabled(false);
		addFrame = new AddFrame(info);
		addFrame.pack();
		addFrame.setVisible(true);
	}
	
	//ˢ�����ڵ�
	public void reloadNode() {
		
	}
//	public void reloadNode(ProjectTreeNode selectNode) {
//		if (selectNode == null) return; 
//		//ˢ�����Ľڵ�
//		ProjectTreeModel model = (ProjectTreeModel)getTree().getModel();
//		//���¼�����ѡ��Ľڵ�
//		model.reload(selectNode, treeCreator);
//	}
	
	public WorkSpace getWorkSpace() {
		return workSpace;
	}
	
	//�½�Ŀ¼�ķ���
	public void newFolder() {
//		//��û��ѡ��һ���ڵ���½�Ŀ¼��ʱ����Ҫ����
//		if (getSelectNode() == null) {
//			JOptionPane.showMessageDialog(this, "��ѡ��Ŀ¼"); 
//			return;
//		}
//		AddInfo info = new AddInfo("Ŀ¼���ƣ�", this, new AddFolderHandler());
//		showAddFrame(info);
	}
	
	public JTree getTree() {
		return this.tree;
	}
	
	//�½���Ŀ�ķ���
	public void newProject() {
		AddInfo info = new AddInfo("��Ŀ���ƣ�", this, new AddProjectHandler());
		showAddFrame(info);
	}
	
	//���ڱ��浱ǰ���򿪵��ļ�
	public void saveFile() {
		
	}
//	public void saveFile(EditFile file) {
//		if (file == null) return;
//		//�����н��߶���ķ���ȥ�����ļ�
//		String result = saveMediator.doSave(this);
//		//������ŵ���Ϣ��ʾ�����ı�����
//		infoArea.setText(result);
//		//д���ļ������õ�ǰ�ļ��ı���״̬Ϊtrue����ʾ�Ѿ�����
//		file.setSaved(true);
//	}
	
	//�����ļ��ķ���
	public void run() {
//		//����ǰ�ȱ���
//		saveFile(getCurrentFile());
//		//�������ʾ
//		String result = runHandler.run(this);
//		infoArea.setText(result);
	}
	
	
}

class FileChooser extends JFileChooser {
	
	private EditorFrame editorFrame;
	
	public FileChooser(EditorFrame editorFrame){
		//���ø���Ĺ�����
		//����editorFrame�Ĺ����ռ���Ϊ�ļ�ѡ������ʱ��Ĭ��Ŀ¼
		super(editorFrame.getWorkSpace().getFolder());
		this.editorFrame = editorFrame;
		showOpenDialog(editorFrame);
	}
	
	public void approveSelection() {
		File file = getSelectedFile();
		//��������ǰѡ��Ľڵ�Ϊnull, ����û�б�ѡ��
		this.editorFrame.getTree().setSelectionPath(null);
		this.editorFrame.openFile(file);
		super.approveSelection();
	}	
	
}



