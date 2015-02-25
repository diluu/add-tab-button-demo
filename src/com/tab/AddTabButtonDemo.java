package com.tab;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class AddTabButtonDemo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPane = new JTabbedPane();

	public AddTabButtonDemo() {
		JLabel tab1Label = new JLabel("tab1");
		JPanel tab1 = new JPanel();
		tab1.add(tab1Label);
		tabbedPane.addTab("tab1", tab1);
		tabbedPane.addTab("+", new JLabel());
		tabbedPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tabbedPane.getSelectedComponent() instanceof JLabel) {
					int count = tabbedPane.getTabCount();
					JLabel newTabLabel = new JLabel("tab" + count);
					JPanel newTab = new JPanel();
					newTab.add(newTabLabel);
					tabbedPane.add(newTab, count - 1);
					tabbedPane.setTitleAt(count - 1, "tab" + count);
					tabbedPane.setSelectedComponent(newTab);
				}
			}
		});
		this.add(tabbedPane, BorderLayout.CENTER);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setMinimumSize(new Dimension(300, 300));
		this.setVisible(true);

	}

	public static void main(String[] args) {
		new AddTabButtonDemo();
	}

}
