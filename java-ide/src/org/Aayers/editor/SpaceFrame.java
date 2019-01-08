package org.Aayers.editor;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.Aayers.editor.commons.WorkSpace;

/**
 * 工作空间界面
 * @author Aayers-ghw
 *
 */
public class SpaceFrame extends JFrame{

	private JPanel mainPanel;
	
	private JLabel infoLabel;
	
	private JPanel chosePanel;
	
	private JLabel workTextLabel;
	
	//工作空间中显示用户选择文件目录的JTextField
	private JTextField pathText;
	
	private JButton choseButton;
	
	private JPanel buttonPanel;
	
	//工作空间中的确定按钮
	private JButton confirmButton;
	
	private JButton cancelButton;
	
	private SpaceChooser chooser;
	
	//用户选择的文件目录对象
	private File folder;
	
	public SpaceFrame(EditorFrame editorFrame) {
		mainPanel = new JPanel();
		infoLabel = new JLabel("请选择工作空间");
		chosePanel = new JPanel();
		workTextLabel = new JLabel("工作空间");
		pathText = new JTextField("", 40);
		choseButton = new JButton("选择");
		buttonPanel = new JPanel();
		confirmButton = new JButton("确定");
		cancelButton = new JButton("取消");
		chooser = new SpaceChooser(this);
		
		//设置Panel的布局
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(infoLabel);
		//设置选择区的布局
		chosePanel.setLayout(new BoxLayout(chosePanel, BoxLayout.X_AXIS));
		choseButton.addActionListener(new ChoseButtonListener(chooser));
		pathText.setEditable(false);
		chosePanel.add(workTextLabel);
		chosePanel.add(pathText);
		chosePanel.add(choseButton);
		mainPanel.add(chosePanel);
		
		confirmButton.setEnabled(false);
		//为确定按钮添加确定的事件, 即创建一个WorkSpace对象
		confirmButton.addActionListener(new ConfirmButtonListener(this, editorFrame));
		buttonPanel.add(confirmButton);
		buttonPanel.add(new Label("    "));
		buttonPanel.add(cancelButton);
		//为取消按钮添加退出事件
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mainPanel.add(buttonPanel);
		add(mainPanel);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(600, 400);
		setResizable(false);
		
	}
	
	public File getFolder() {
		return folder;
	}

	public void setFolder(File folder) {
		this.folder = folder;
	}
		
	public JTextField getPathText() {
		return pathText;
	}

	public JButton getConfirmButton() {
		return confirmButton;
	}
	
}

/**
 * 确定按钮的监听器
 * @author Aayers-ghw
 *
 */
class ConfirmButtonListener implements ActionListener {
	
	private SpaceFrame spaceFrame;
	
	private EditorFrame editorFrame;
	
	public ConfirmButtonListener(SpaceFrame spaceFrame, EditorFrame editorFrame) {
		this.spaceFrame = spaceFrame;
		this.editorFrame = editorFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//调EditorFrame的initFrame方法初始化界面
		editorFrame.initFrame(new WorkSpace(spaceFrame.getFolder(), editorFrame));
		//将EditorFrame设为可见
		editorFrame.setVisible(true);
		editorFrame.setSize(900, 600);
		//让工作选择空间界面不可见
		spaceFrame.setVisible(false);
	}
	
}

/**
 * 选择按钮的监听器
 * @author Aayers-ghw
 *
 */
class ChoseButtonListener implements ActionListener {

	private JFileChooser chooser;
	
	public ChoseButtonListener(SpaceChooser chooser) {
		this.chooser = chooser;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.showOpenDialog(null);
	}
	
}

/**
 * 文件选择器
 * @author Aayers-ghw
 *
 */
class SpaceChooser extends JFileChooser {
	
	private SpaceFrame spaceFrame;
	
	//需要将SpaceFrame作为构造参数
	public SpaceChooser(SpaceFrame spaceFrame) {
		//设置选择器打开时的目录
		super("/");
		this.spaceFrame = spaceFrame;
	}
	
	
	//重写父类的选择文件方法
	public void approveSelection() {
		//获取用户选择的文件
		File folder = getSelectedFile();
		//设置SpaceFrame的属性folder的值
		spaceFrame.setFolder(folder);
		//设置SpaceFrame文本框
		spaceFrame.getPathText().setText(folder.getAbsolutePath());
		//设置确定按钮可用
		spaceFrame.getConfirmButton().setEnabled(true);
		//调用父类的选择文件方法
		super.approveSelection();
	}
}